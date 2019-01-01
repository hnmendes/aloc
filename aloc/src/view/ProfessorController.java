package view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

import beans.Disciplina;
import beans.Professor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



/**
	@Author: rique
*/

public class ProfessorController {
	
	private Professor professorLogado;
	
	@FXML
	private Tab tabHome;
	
	@FXML
	private Button btnSair;
	
    @FXML
    private TableView<Disciplina> tbvDisciplinas;
    
    @FXML
    private TableColumn<Disciplina,String> tcNomeHome;
    
    @FXML
    private TableColumn<Disciplina, String> tcHorario1Home;
    
    @FXML
    private TableColumn<Disciplina, String> tcHorario2Home;
    
    @FXML
    private TableColumn<Disciplina, String> tcSalaHome;
    
    @FXML
    private TableColumn<Disciplina, String> tcAreaHome;

    @FXML
    private Button btnSalvar;

    @FXML
    private Tab tabHistorico;

    @FXML
    private TableView<Disciplina> tbvHistorico;
    
    @FXML
    private TableColumn<Disciplina, String> tcNomeHist;
    
    @FXML
    private TableColumn<Disciplina, String> tcCHHist;
    
    @FXML
    private TableColumn<Disciplina, String> tcSemestreHist;

    @FXML
    private Button btnSalvarHistorico;

    @FXML
    private Tab tabMeusDados;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCpf;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private PasswordField txtRepetirSenha;

    @FXML
    private Button btnEditar;
    
    @FXML
    private Button btnFinalizarSemestre;
    
    @FXML
    private TabPane tabPane;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private AnchorPane anchorHome;
    
    @FXML
    private AnchorPane anchorMeusDados;
    
    @FXML
    private AnchorPane anchorHistorico;
    
    
    @FXML
    protected void initialize() {
    	anchorPane.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    	anchorHome.getStyleClass().add("anchorLogin");
    	anchorMeusDados.getStyleClass().add("anchorLogin");
    	anchorHistorico.getStyleClass().add("anchorLogin");
    	tabPane.getStyleClass().add("anchorLogin");
    	
    }
    
    @FXML
    void carregarHome() {
    	
    	if(tbvDisciplinas.getItems().size() == 0 || tbvDisciplinas.getItems() == null || tbvDisciplinas == null || professorLogado == null) {
    		tbvDisciplinas.setPlaceholder(new Label("Você não tem disciplinas."));
    	}
    	
    	if(professorLogado != null && professorLogado.getSenha().equals("123")) {
    		Alert msg = new Alert(AlertType.INFORMATION);
        	msg.setHeaderText("");
        	msg.setTitle("Você deve alterar sua senha!");
        	msg.setContentText("Por favor, altere sua senha para sua segurança.");
        	msg.show();
    	}
    	
    	if(tbvDisciplinas != null) {
    		
    		tcAreaHome.setCellValueFactory(new PropertyValueFactory<>("areaAtuacao"));
        	
        	tcHorario1Home.setCellValueFactory(horario -> {
        		
                        SimpleStringProperty property = new SimpleStringProperty();
                        
                        if(horario == null || horario.getValue() == null || horario.getValue().getHorario1Disciplina() == null) {
                        	property.setValue(" ");
                        }else {
                        	property.setValue(horario.getValue().getHorario1Disciplina().getHorariosToString()+", "+
                            horario.getValue().getHorario1Disciplina().getDia());
                        }
                        
                        return property;
            });
        	
        	tcHorario2Home.setCellValueFactory(horario -> {
        		
                        SimpleStringProperty property = new SimpleStringProperty();
                        
                        if(horario == null || horario.getValue() == null || horario.getValue().getHorario1Disciplina() == null) {
                        	property.setValue(" ");
                        }else {
                        	property.setValue(horario.getValue().getHorario2Disciplina().getHorariosToString()+", "+
                            horario.getValue().getHorario2Disciplina().getDia());
                        }
                        
                        return property;
            });
        	
        	tcNomeHome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        	
        	tcSalaHome.setCellValueFactory(sala -> {
        		SimpleStringProperty property = new SimpleStringProperty();
        		
        		if(sala == null || sala.getValue() == null || sala.getValue().getSala() == null) {
        			 property.setValue(" ");
        		}else {
        			property.setValue(sala.getValue().getSala());
        		}
        		
        		return property;
        	});
    	}
                    
    }
    
    @FXML
    void carregarHistorico() {
    	
    	updateHist();
    	
    	if(tbvHistorico.getItems().size() == 0 || tbvHistorico.getItems() == null || tbvHistorico == null || professorLogado == null) {
    		tbvHistorico.setPlaceholder(new Label("Você não tem disciplinas alocadas."));
    	}
    	
    	tcCHHist.setCellValueFactory(ch -> {
    		SimpleStringProperty property = new SimpleStringProperty();
    		property.setValue(String.valueOf(ch.getValue().getCargaHoraria()));
    		return property;
    	});
    	
    	tcNomeHist.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	tcSemestreHist.setCellValueFactory(new PropertyValueFactory<>("semestre"));
    	
    }
    
    @FXML
    void carregarDados() {
    	
    	if(professorLogado != null) {
    		txtCpf.setText(professorLogado.getCpf());
    		txtNome.setText(professorLogado.getNome());
    	}
    }
    
    @FXML
    void finalizarSemestre(ActionEvent event) {
    	Alert msg = new Alert(AlertType.CONFIRMATION);
		msg.setHeaderText("");
		msg.setTitle("Confirmação.");
		msg.setContentText("Você tem certeza que o semestre foi finalizado?");
		
		Optional<ButtonType> result = msg.showAndWait();
		
		if(result.get() == ButtonType.OK) {
			
			List<Disciplina> ds = tbvDisciplinas.getItems();
			
			if(ds.get(0) != null) {
				ds.get(0).setOfertada(false);
			}
			
			if(ds.get(1) != null) {
				ds.get(1).setOfertada(false);
			}
				
			String novoSemestreProf = null;
				
			if(professorLogado.getSemestre().endsWith("1")) {
				novoSemestreProf = Character.toString(professorLogado.getSemestre().charAt(0)) + Character.toString(professorLogado.getSemestre().charAt(1)) + Character.toString(professorLogado.getSemestre().charAt(2)) + Character.toString(professorLogado.getSemestre().charAt(3)) + Character.toString(professorLogado.getSemestre().charAt(4)) + "2";
			}else if(professorLogado.getSemestre().endsWith("2")) {
				int anoAux = Integer.parseInt(Character.toString(professorLogado.getSemestre().charAt(0)) + Character.toString(professorLogado.getSemestre().charAt(1)) + Character.toString(professorLogado.getSemestre().charAt(2)) + Character.toString(professorLogado.getSemestre().charAt(3)));
				anoAux = anoAux + 1;
				novoSemestreProf = String.valueOf(anoAux) + ".1";
			}
			
			if(professorLogado.getDisciplina1() != null) {
				professorLogado.getDisciplina1().setOfertada(false);
				professorLogado.getDisciplina1().setProfessorLeciona(false);
				professorLogado.getDisciplinasAlocadas().getDisciplinasLecionadas().add(professorLogado.getDisciplina1());
				professorLogado.setDisciplina1(null);
			}
			
			if(professorLogado.getDisciplina2() != null) {
				professorLogado.getDisciplina2().setOfertada(false);
				professorLogado.getDisciplina2().setProfessorLeciona(false);
				professorLogado.getDisciplinasAlocadas().getDisciplinasLecionadas().add(professorLogado.getDisciplina2());
				professorLogado.setDisciplina2(null);
			}
			
			professorLogado.setSemestre(novoSemestreProf);
			
			tbvDisciplinas.getItems().clear();
			
			updateHist();
		}
    }
    
    public void updateDisc() {
    	
    	if(professorLogado != null) {
    		ObservableList<Disciplina> observableDiscList = FXCollections.observableArrayList();
        	List<Disciplina> discs = Arrays.asList(professorLogado.getDisciplinas());
        	observableDiscList.addAll(discs);
        	tbvDisciplinas.setItems(observableDiscList);
        	tbvDisciplinas.refresh();
    	}
    	
    }
    
    public void updateHist() {
    	
    	if(professorLogado != null) {
    		ObservableList<Disciplina> observableDiscList = FXCollections.observableArrayList();
        	List<Disciplina> discs = professorLogado.getDisciplinasAlocadas().getDisciplinasLecionadas();
        	observableDiscList.addAll(discs);
        	tbvHistorico.setItems(observableDiscList);
        	tbvHistorico.refresh();
    	}
    	
    }
    
    public void setProfessorLogado(Professor prof) {
    	this.professorLogado = prof;
    	
    	if(professorLogado != null && professorLogado.getDisciplinas() != null) {
    		updateDisc();
    	}
    	
    	if(professorLogado != null && professorLogado.getDisciplinasAlocadas() != null && professorLogado.getDisciplinasAlocadas().getDisciplinasLecionadas() != null && professorLogado.getDisciplinasAlocadas().getDisciplinasLecionadas().size() > 0) {
    		updateHist();
    	}
    	
    	//
    }
    
    @FXML
    void editar(ActionEvent event) {
    	
    	Alert msg = new Alert(AlertType.ERROR);
    	msg.setHeaderText("");
    	msg.setTitle("Campos incorretos.");
    	
    	if(!txtSenha.getText().equals(txtRepetirSenha.getText())) {
    		msg.setContentText("As senhas não combinam.");
    		msg.show();
    	}else if(txtSenha.getText() == null || txtRepetirSenha.getText() == null) {
    		msg.setContentText("Por favor preencha a senha e a sua confirmação.");
    		msg.show();
    	}else if(txtNome.getText().equals("")) {
    		msg.setContentText("Nome vazio.");
    		msg.show();
    	}else {
    		
    		professorLogado.setNome(txtNome.getText());
    		professorLogado.setSenha(txtSenha.getText());
    		
    		txtSenha.setText("");
    		txtRepetirSenha.setText("");
    		
    		msg.setAlertType(AlertType.INFORMATION);
    		msg.setTitle("Dados editados.");
    		msg.setContentText("Dados editados com sucesso!");
    		msg.show();
    	}
    }
    
    @FXML
    void sair(ActionEvent event) {
    	
    	Alert msg = new Alert(AlertType.CONFIRMATION);
    	msg.setTitle("");
    	msg.setHeaderText("Sair");
    	msg.setContentText("Você realmente deseja sair?");

    	Optional<ButtonType> result = msg.showAndWait();
    	
    	if (result.get() == ButtonType.OK){
    		
    		((Stage) this.btnSair.getScene().getWindow()).close();
  
    		Stage login = new Stage();
    		login.setTitle("@loc System");
    		login.setScene(ScreenManager.getInstance().getLoginScene());
    		login.show();
    	}
    }
    
    public List<Disciplina> getListDisciplinaProfessor(){
    	return Arrays.asList(professorLogado.getDisciplinas());
    }
    
    @FXML
    void salvarHistorico(ActionEvent event) {
Document documentoGerado = new Document();
		
		try {
	    		
	    		FileChooser fileChooser = new FileChooser();
	        	FileChooser.ExtensionFilter extFilter = 
	                    new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
	        	fileChooser.getExtensionFilters().add(extFilter);
	        	
	        	Stage fileChooserScene = new Stage();
	        	fileChooser.setTitle("Salvar PDF");
	        	File file = fileChooser.showSaveDialog(fileChooserScene);
	        	
	        
	        
	        if(tbvHistorico.getItems().size() == 0) {
	        	Alert msg = new Alert(AlertType.WARNING);
	        	msg.setHeaderText("");
	        	msg.setTitle("Tabela vazia");
	        	msg.setContentText("Não há nenhuma disciplina para ser impressa.");
	        	msg.showAndWait();
	        }else if(file != null) {
	        	PdfWriter.getInstance(documentoGerado, new FileOutputStream(file.getParent()+"/"+file.getName()+LocalTime.now().toDateTimeToday().toString()+".pdf"));
	            
	    		Image img = Image.getInstance("img/Brasão_UFRPE.png");
	    		img.scaleToFit(50, 50);
	    		img.setAlignment(Element.ALIGN_RIGHT);
	    		documentoGerado.open();
	    		documentoGerado.addTitle("Histórico de Disciplinas do professor "+professorLogado.getNome()+".");
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
	    		documentoGerado.add(new Paragraph(50,"Histórico de Disciplinas do professor "+professorLogado.getNome()+":\n\n",FontFactory.getFont(FontFactory.TIMES,15,Font.BOLD,BaseColor.BLACK)));
	    		
	    		PdfPTable table = new PdfPTable(4);
	    		table.setWidthPercentage(110);
	    		
	    		List<Disciplina> discs = tbvHistorico.getItems();
	    		
	    		List<List<PdfPCell>> dataSet = getDataHistorico(discs);
	    		
	    		for(List<PdfPCell> record : dataSet) {
	    			for(PdfPCell field : record) {
	    				table.addCell(field);
	    			}
	    		}
	    		
	    		documentoGerado.add(table);
	    		
	    		Alert msg = new Alert(AlertType.INFORMATION);
	        	msg.setHeaderText("");
	        	msg.setTitle("Sucesso!");
	        	msg.setContentText("O arquivo foi salvo com sucesso.");
	        	msg.showAndWait();
	        }
	            	
	        	
		} catch (DocumentException | IOException e1) {
			e1.printStackTrace();
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Erro!");
			msg.setContentText("Ocorreu um erro inesperado, por favor contate o reponsável.");
			msg.showAndWait();
		}finally {
			
    		documentoGerado.close();
    	}
    }
    
    @FXML
    void salvarHome(ActionEvent event) {
		
		Document documentoGerado = new Document();
		
		try {
	    		
	    		FileChooser fileChooser = new FileChooser();
	        	FileChooser.ExtensionFilter extFilter = 
	                    new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
	        	fileChooser.getExtensionFilters().add(extFilter);
	        	
	        	Stage fileChooserScene = new Stage();
	        	fileChooser.setTitle("Salvar PDF");
	        	File file = fileChooser.showSaveDialog(fileChooserScene);
	        	
	        
	        
	        if(tbvDisciplinas.getItems().size() == 0) {
	        	Alert msg = new Alert(AlertType.WARNING);
	        	msg.setHeaderText("");
	        	msg.setTitle("Tabela vazia");
	        	msg.setContentText("Não há nenhuma disciplina para ser impressa.");
	        	msg.showAndWait();
	        }else if(file != null) {
	        	PdfWriter.getInstance(documentoGerado, new FileOutputStream(file.getParent()+"/"+file.getName()+LocalTime.now().toDateTimeToday().toString()+".pdf"));
	            
	    		Image img = Image.getInstance("img/Brasão_UFRPE.png");
	    		img.scaleToFit(50, 50);
	    		img.setAlignment(Element.ALIGN_RIGHT);
	    		documentoGerado.open();
	    		documentoGerado.addTitle("Lista de Disciplinas do professor "+professorLogado.getNome()+".");
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
	    		documentoGerado.add(new Paragraph(50,"Lista de disciplinas vinculadas:\n\n",FontFactory.getFont(FontFactory.TIMES,15,Font.BOLD,BaseColor.BLACK)));
	    		
	    		PdfPTable table = new PdfPTable(4);
	    		table.setWidthPercentage(110);
	    		
	    		List<List<PdfPCell>> dataSet = getDataHome(getListDisciplinaProfessor());
	    		
	    		for(List<PdfPCell> record : dataSet) {
	    			for(PdfPCell field : record) {
	    				table.addCell(field);
	    			}
	    		}
	    		
	    		documentoGerado.add(table);
	    		
	    		Alert msg = new Alert(AlertType.INFORMATION);
	        	msg.setHeaderText("");
	        	msg.setTitle("Sucesso!");
	        	msg.setContentText("O arquivo foi salvo com sucesso.");
	        	msg.showAndWait();
	        }
	            	
	        	
		} catch (DocumentException | IOException e1) {
			e1.printStackTrace();
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Erro!");
			msg.setContentText("Ocorreu um erro inesperado, por favor contate o reponsável.");
			msg.showAndWait();
		}finally {
			
    		documentoGerado.close();
    	}
	}
    
    
    public List<List<PdfPCell>> getDataHome(List<Disciplina> discs) {
	 	
		PdfPCell nome = new PdfPCell(new Phrase("Nome"));
 		nome.setBackgroundColor(BaseColor.GRAY);
 		
 		PdfPCell horario = new PdfPCell(new Phrase("Horários"));
 		horario.setBackgroundColor(BaseColor.GRAY);
 		
 		PdfPCell sala = new PdfPCell(new Phrase("Sala"));
 		sala.setBackgroundColor(BaseColor.GRAY);
 		
 		PdfPCell area = new PdfPCell(new Phrase("Área"));
 		area.setBackgroundColor(BaseColor.GRAY);
 		
	 	List<List<PdfPCell>> data = new ArrayList<List<PdfPCell>>();
        
        PdfPCell[] tableTitleList = {nome, horario , sala, area};
        
        data.add(Arrays.asList(tableTitleList));
        
        for (Disciplina aux : discs) {
            
        	List<PdfPCell> dataLine = new ArrayList<PdfPCell>();
            
        	PdfPCell cell1 = new PdfPCell(new Phrase(aux.getNome())); 
    		PdfPCell cell2 = new PdfPCell(new Phrase((aux.getHorario1Disciplina() != null && aux.getHorario2Disciplina() != null) ? aux.getHorario1Disciplina().getHorariosToString() + ", Dia: "+aux.getHorario1Disciplina().getDia()+ "; "+aux.getHorario2Disciplina().getHorariosToString()+", Dia: "+aux.getHorario2Disciplina().getDia()
    		:(aux.getHorario1Disciplina() == null && aux.getHorario2Disciplina() != null)? aux.getHorario2Disciplina().getHorariosToString()+", Dia: "+aux.getHorario2Disciplina().getDia()
    		:(aux.getHorario1Disciplina() != null && aux.getHorario2Disciplina() == null)? aux.getHorario2Disciplina().getHorariosToString()+", Dia: "+aux.getHorario2Disciplina().getDia(): "Sem disciplinas."));
    		PdfPCell cell3 = new PdfPCell(new Phrase(aux.getSala()));
    		PdfPCell cell4 = new PdfPCell(new Phrase(aux.getAreaAtuacao()));
        	
    		PdfPCell [] cell = {cell1,cell2,cell3,cell4};
    		
            for (int j = 0; j < tableTitleList.length; j++) {
            	
            	dataLine.add(cell[j]);
            }
            data.add(dataLine);
        }
        return data;
    }
    
    
public List<List<PdfPCell>> getDataHistorico(List<Disciplina> discs) {
	 	
		PdfPCell nome = new PdfPCell(new Phrase("Nome"));
 		nome.setBackgroundColor(BaseColor.GRAY);
 		
 		PdfPCell semestre = new PdfPCell(new Phrase("Semestre"));
 		semestre.setBackgroundColor(BaseColor.GRAY);
 		
 		PdfPCell cargaHoraria = new PdfPCell(new Phrase("Carga Horária"));
 		cargaHoraria.setBackgroundColor(BaseColor.GRAY);
 		
 		PdfPCell area = new PdfPCell(new Phrase("Área"));
 		area.setBackgroundColor(BaseColor.GRAY);
 		
	 	List<List<PdfPCell>> data = new ArrayList<List<PdfPCell>>();
        
        PdfPCell[] tableTitleList = {nome, semestre , cargaHoraria, area};
        
        data.add(Arrays.asList(tableTitleList));
        
        for (Disciplina aux : discs) {
            
        	List<PdfPCell> dataLine = new ArrayList<PdfPCell>();
            
        	PdfPCell cell1 = new PdfPCell(new Phrase(aux.getNome())); 
    		PdfPCell cell2 = new PdfPCell(new Phrase(aux.getSemestre()));
    		PdfPCell cell3 = new PdfPCell(new Phrase(String.valueOf(aux.getCargaHoraria())));
    		PdfPCell cell4 = new PdfPCell(new Phrase(aux.getAreaAtuacao()));
        	
    		PdfPCell [] cell = {cell1,cell2,cell3,cell4};
    		
            for (int j = 0; j < tableTitleList.length; j++) {
            	
            	dataLine.add(cell[j]);
            }
            data.add(dataLine);
        }
        
        return data;
    }

}
