package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalTime;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import beans.Coordenador;
import beans.Disciplina;
import beans.HorarioDisciplina;
import beans.Professor;
import controller.Fachada;
import exceptions.DisciplinaExistenteException;
import exceptions.IdDisciplinaExistenteException;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.Semana;

/**
	@Author: rique
*/

public class Test extends Application {

	public static void main(String[] args) throws DisciplinaExistenteException, IdDisciplinaExistenteException {
		
		Disciplina disc1 = new Disciplina(1,"Inteligencia Artificial2","IA","34B",60,"2018.1");
		Disciplina disc2 = new Disciplina(2,"Tópicos Avançados em Inteligencia Artificial","IA","32B",60,"2018.2");
		
		LocalTime [] horario1 = new LocalTime[2];
		disc1.setOfertada(true);
		horario1[0] = LocalTime.parse("14:00");
		horario1[1] = LocalTime.parse("16:00");
		
		LocalTime [] horario2 = new LocalTime[2];
		
		horario2[0] = LocalTime.parse("16:00");
		horario2[1] = LocalTime.parse("18:00");
		
		disc1.setHorarioDisciplina1(new HorarioDisciplina(horario1,Semana.SEGUNDA));
		disc1.setHorarioDisciplina2(new HorarioDisciplina(horario2,Semana.QUINTA));
		
		disc2.setHorarioDisciplina1(new HorarioDisciplina(horario2,Semana.QUINTA));
		disc2.setHorarioDisciplina2(new HorarioDisciplina(horario1,Semana.SEGUNDA));
		
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc1);
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc2);
		
		Professor prof2 = new Professor(1,"Henrique Nunes","123","123","IA");
		Coordenador coord = new Coordenador("José Martins","123","123");
		
		
		prof2.setDisciplina1(disc1);
		prof2.setDisciplina2(disc2);
		
		Fachada.getInstance().contProfessor().addProfessor(prof2);
		Fachada.getInstance().contCoordenador().cadastrarCoordenador(coord);
		
		
		Test.launch(args);
		
	}
	
	
	 public List<List<PdfPCell>> getData(List<Professor> profs) {
		 	
			PdfPCell professor = new PdfPCell(new Phrase("Professor"));
	 		professor.setBackgroundColor(BaseColor.GRAY);
	 		
	 		PdfPCell cpf = new PdfPCell(new Phrase("CPF"));
	 		cpf.setBackgroundColor(BaseColor.GRAY);
	 		
	 		PdfPCell hor1Disc = new PdfPCell(new Phrase("Disciplinas"));
	 		hor1Disc.setBackgroundColor(BaseColor.GRAY);
//	 		
//	 		PdfPCell sala = new PdfPCell(new Phrase("Sala"));
//	 		sala.setBackgroundColor(BaseColor.GRAY);
		 
		 	List<List<PdfPCell>> data = new ArrayList<List<PdfPCell>>();
	        
	        PdfPCell[] tableTitleList = {professor, cpf,hor1Disc};
	        
	        data.add(Arrays.asList(tableTitleList));
	        
	        for (Professor aux : profs) {
	            
	        	List<PdfPCell> dataLine = new ArrayList<PdfPCell>();
	            
	        	PdfPCell cell1 = new PdfPCell(new Phrase(aux.getNome())); 
     		PdfPCell cell2 = new PdfPCell(new Phrase(aux.getCpf()));
     		PdfPCell cell3 = new PdfPCell(new Phrase((aux.getDisciplina1() == null && aux.getDisciplina2() == null) ? "Sem disciplina." : 
     			(aux.getDisciplina1() != null && aux.getDisciplina2() == null)? aux.getDisciplina1().getNome() + " / Sem disciplina.":
     			(aux.getDisciplina1() == null && aux.getDisciplina2() != null)?	"Sem disciplina / "+aux.getDisciplina2().getNome()+"." : aux.getDisciplina1().getNome() + " / " + aux.getDisciplina2().getNome()));
     		//PdfPCell cell4 = new PdfPCell(new Phrase(aux == null ? "Sem sala definida." : aux.getDisciplina1().getSala() + " ; "+ aux.getDisciplina2().getSala()));
	        	
     		PdfPCell [] cell = {cell1,cell2,cell3};
     		
	            for (int j = 0; j < tableTitleList.length; j++) {
	            	
	            	dataLine.add(cell[j]);
	            }
	            data.add(dataLine);
	        }
	        return data;
	    }


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Document documentoGerado = new Document();
    	
    	try {
    		
    		FileChooser fileChooser = new FileChooser();
        	FileChooser.ExtensionFilter extFilter = 
                    new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        	fileChooser.getExtensionFilters().add(extFilter);
        	
        	Stage fileChooserScene = new Stage();
        	fileChooser.setTitle("Salvar PDF");
        	File file = fileChooser.showSaveDialog(fileChooserScene);
        	
            	
        	PdfWriter.getInstance(documentoGerado, new FileOutputStream(file.getParent()+"/"+file.getName()+LocalTime.now().toDateTimeToday().toString()+".pdf"));
            
    		Image img = Image.getInstance("img/Brasão_UFRPE.png");
    		img.scaleToFit(50, 50);
    		img.setAlignment(Element.ALIGN_RIGHT);
    		documentoGerado.open();
    		documentoGerado.addTitle("Lista de Disciplina e Professor");
    		documentoGerado.addAuthor("@loc System");
    		documentoGerado.add(img);
    		Paragraph nomeUfrpe = new Paragraph("\nUniversidade Federal Rural de Pernambuco",FontFactory.getFont(FontFactory.TIMES,7)); 
    		nomeUfrpe.setAlignment(Element.ALIGN_RIGHT);
    		documentoGerado.add(nomeUfrpe);
    		documentoGerado.add(new Paragraph("@loc System",FontFactory.getFont(FontFactory.TIMES,35,Font.BOLDITALIC,BaseColor.RED)));
    		documentoGerado.add(new Paragraph(" "));
    		documentoGerado.add(new Paragraph("Data: "+LocalTime.now().toDateTimeToday().toString("dd/MM/yyyy"),FontFactory.getFont(FontFactory.TIMES, 6)));
    		documentoGerado.add(new Paragraph("Hora: "+LocalTime.now().toString("HH:mm"),FontFactory.getFont(FontFactory.TIMES, 6)));
    		documentoGerado.add(new Paragraph("______________________________________________________________________________"));
    		documentoGerado.add(new Paragraph(50,"Lista de Professores vinculados as disciplinas:\n\n",FontFactory.getFont(FontFactory.TIMES,15,Font.BOLD,BaseColor.BLACK)));
    		
    		PdfPTable table = new PdfPTable(3);
    		table.setWidthPercentage(110);
    		
    		List<List<PdfPCell>> dataSet = getData(Fachada.getInstance().contProfessor().getProfessorList());
    		for(List<PdfPCell> record : dataSet) {
    			for(PdfPCell field : record) {
    				table.addCell(field);
    			}
    		}
    		
    		documentoGerado.add(table);
        	
    	}catch(DocumentException|IOException e) {
    		e.printStackTrace();
    	}finally {
    		documentoGerado.close();
    	}
	}

	

}

