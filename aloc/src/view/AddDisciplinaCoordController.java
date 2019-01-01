package view;

import java.util.Arrays;
import java.util.List;

import beans.Disciplina;
import controller.Fachada;
import exceptions.ChoqueDisciplinaException;
import exceptions.IdDisciplinaExistenteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import util.Semana;
import util.TextFieldFormatter;

/**
	@Author: rique
*/

public class AddDisciplinaCoordController {
	
	@FXML
    private TextField txtNomeDisc;

    @FXML
    private TextField txtAreaAtuacaoDisc;

    @FXML
    private TextField txtSalaDisc;

    @FXML
    private TextField txtCargaHorariaDisc;

    @FXML
    private TextField txtInicioAulaHorario1;

    @FXML
    private TextField txtFimAulaHorario1;

    @FXML
    private ComboBox<Semana> cbDiaHorario1;

    @FXML
    private TextField txtInicioAulaHorario2;

    @FXML
    private TextField txtFimAulaHorario2;

    @FXML
    private ComboBox<Semana> cbDiaHorario2;

    @FXML
    private TextField txtSemestreDisc;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private CheckBox cbOfertada;
    
    @FXML
    private TextField txtIdDisc;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    protected void initialize() {
    	
    	this.setComboBox();
    	
    	anchorPane.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    	anchorPane.getStyleClass().add("anchorLogin");
    }
    
    @FXML
    void apenasNumeros(KeyEvent event) {
    	this.txtIdDisc.textProperty().addListener((observable, antigoValor, novoValor)->{
    		if(!novoValor.matches("\\d*")) {
    			this.txtIdDisc.setText(novoValor.replaceAll("[^\\d]", ""));
    		}
    	});
    }

    @FXML
    void cadastrarDisciplina(ActionEvent event) throws IdDisciplinaExistenteException, ChoqueDisciplinaException {
    	
    	String nome = txtNomeDisc.getText();
		String areaAtuacao = txtAreaAtuacaoDisc.getText();
		String sala =txtSalaDisc.getText();
		int cargaHoraria = Integer.parseInt(txtCargaHorariaDisc.getText());
		String inicioHorario1 = txtInicioAulaHorario1.getText();
		String fimHorario1 = txtFimAulaHorario1.getText();
		String inicioHorario2 = txtInicioAulaHorario2.getText();
		String fimHorario2 = txtFimAulaHorario2.getText();
		String semestre = txtSemestreDisc.getText();
		Semana diaHorario1 = cbDiaHorario1.getValue();
		Semana diaHorario2 = cbDiaHorario2.getValue();
		boolean ofertada = cbOfertada.isSelected();
		int id = Integer.parseInt(txtIdDisc.getText());
		
		if(nome.equals("")) {
			
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo Nome está vazio.");
			msg.showAndWait();
			
		}else if(areaAtuacao.equals("")) {
		
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo Area de Atuação está vazio.");
			msg.showAndWait();
			
		}else if(semestre.equals("") && semestre.endsWith(" ")){
			
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo Semestre está vazio ou incorreto.");
			msg.showAndWait();
			
		}else if(sala.equals("")) {
		
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo Sala está vazio.");
			msg.showAndWait();
			
		}else if(cargaHoraria < 30 && cargaHoraria > 75) {
		
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("A Carga Horária não pode ser menor do que 30 nem maior que 75.");
			msg.showAndWait();
			
		}else if(inicioHorario1 == null || inicioHorario1.endsWith(" ") ) {
			
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo de Inicio Horário 1 precisa ser preenchido com todos os números.");
			msg.showAndWait();
			
		}else if(fimHorario1 == null || fimHorario1.endsWith(" ")) {
		
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo de Fim Horário 1 precisa ser preenchido com todos os números.");
			msg.showAndWait();
			
		}else if(inicioHorario2 == null || inicioHorario2.endsWith(" ")) {
			
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo de Inicio Horário 2 precisa ser preenchido com todos os números.");
			msg.showAndWait();
			
		}else if(txtIdDisc.getText().equals("")) {
			
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo de Id precisa ser preenchido.");
			msg.showAndWait();
			
		}else if(fimHorario2 == null || fimHorario2.endsWith(" ")){
			
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo de Fim Horário 2 precisa ser preenchido com todos os números.");
			msg.showAndWait();
			
		}else if(diaHorario1 == null){
			
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo do primeiro dia precisa ser selecionado.");
			msg.showAndWait();
			
		}else if(diaHorario2 == null) {
			
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo do segundo dia precisa ser selecionado.");
			msg.showAndWait();
			
		}else if(Fachada.getInstance().contDisciplinas().getDisciplinaByNome(nome) != null) {
			
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Disciplina existente");
			msg.setContentText("Já existe a disciplina que você está tentando cadastrar.");
			msg.showAndWait();
			
		}else if(Fachada.getInstance().contDisciplinas().getDisciplinaById(id) != null){
			
			Alert msg = new Alert(AlertType.WARNING);
	    	msg.setHeaderText("");
    		msg.setTitle("Id existente.");
    		msg.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    		msg.setContentText("O id "+id+" não pode ser adicionado.\n\nMotivo: Id existente.");
    		msg.showAndWait();
    		
		}else if(inicioHorario1.equals(fimHorario1)) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Horário incorreto");
			msg.setContentText("Você não pode adicionar uma horário de inicio de fim iguais.");
			msg.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			msg.showAndWait();
		}else if(inicioHorario2.equals(fimHorario2)) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Horário incorreto");
			msg.setContentText("Você não pode adicionar uma horário de inicio de fim iguais.");
			msg.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			msg.showAndWait();
		}else if(inicioHorario1.equals(inicioHorario2) && fimHorario1.equals(fimHorario2) && diaHorario1.equals(diaHorario2)) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Horário incorreto");
			msg.setContentText("Os horários não podem se repetir, por favor selecione horários válidos e que não repitam os mesmos dias.");
			msg.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			msg.showAndWait();
		} else if(cbOfertada.isSelected()){
				
				try {
					
					Disciplina disc = new Disciplina(id,nome, areaAtuacao, sala, cargaHoraria, inicioHorario1, fimHorario1, diaHorario1, inicioHorario2, fimHorario2, diaHorario2, semestre, ofertada);
					@SuppressWarnings("unused")
					boolean chocaHorario = Fachada.getInstance().contDisciplinas().disciplinaChocaHorarioAdd(disc);
					
					Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc);
					
					ScreenManager.getInstance().getCoordenadorController().updateListaDisciplinas();
					
					Alert msg = new Alert(AlertType.INFORMATION);
					msg.setHeaderText("");
					msg.setTitle("Sucesso!");
					msg.setContentText("A disciplina " + disc.getNome() + " foi cadastrada com sucesso.");
					msg.showAndWait();
					
					limparDados();
					
				}catch(ChoqueDisciplinaException e) {
					
					e.printStackTrace();
					
		    		Alert msg = new Alert(AlertType.WARNING);
		    		msg.setHeaderText("");
		    		msg.setTitle("Choque de Horário.");
		    		msg.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		    		msg.setContentText("A disciplina não pode ser ofertada.\n\nMotivo: " + e.toString());
		    		msg.showAndWait();

		    		cbOfertada.setSelected(false);
				}
				
		}else {
			
			try {
				
				Disciplina disc = new Disciplina(id,nome, areaAtuacao, sala, cargaHoraria, inicioHorario1, fimHorario1, diaHorario1, inicioHorario2, fimHorario2, diaHorario2, semestre, ofertada);
				@SuppressWarnings("unused")
				boolean chocaHorario = Fachada.getInstance().contDisciplinas().disciplinaChocaHorarioAdd(disc);
				
				Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc);
				ScreenManager.getInstance().getCoordenadorController().updateListaDisciplinas();
					
				Alert msg = new Alert(AlertType.INFORMATION);
				msg.setHeaderText("");
				msg.setTitle("Sucesso!");
				msg.setContentText("A disciplina " + disc.getNome() + " foi cadastrada com sucesso.");
				msg.showAndWait();
				
				limparDados();
				
			}catch(ChoqueDisciplinaException e) {
				
				e.printStackTrace();
	    		Alert msg = new Alert(AlertType.WARNING);
	    		msg.setHeaderText("");
	    		msg.setTitle("Choque de Horário.");
	    		msg.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
	    		msg.setContentText("A disciplina não pode ser ofertada.\n\nMotivo: " + e.toString());
	    		msg.showAndWait();
			}
		}
			
		
    }

    @FXML
    void voltar(ActionEvent event) {
    	((Stage)btnVoltar.getScene().getWindow()).close();
    }
    
    @FXML
    void mascaraCargaHoraria(KeyEvent event) {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("##");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtCargaHorariaDisc);
    	tff.formatter();
    }

    @FXML
    void mascaraFimAula1(KeyEvent event) {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("##:##");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtFimAulaHorario1);
    	tff.formatter();
    }

    @FXML
    void mascaraFimAula2(KeyEvent event) {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("##:##");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtFimAulaHorario2);
    	tff.formatter();
    }

    @FXML
    void mascaraInicioAula1(KeyEvent event) {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("##:##");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtInicioAulaHorario1);
    	tff.formatter();
    }

    @FXML
    void mascaraInicioAula2(KeyEvent event) {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("##:##");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtInicioAulaHorario2);
    	tff.formatter();
    }


    @FXML
    void mascaraSemestre(KeyEvent event) {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("####.#");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtSemestreDisc);
    	tff.formatter();
    }
    
    void setComboBox() {
    	
    	List<Semana> semanaList = Arrays.asList(Semana.SEGUNDA,Semana.TERCA,Semana.QUARTA,Semana.QUINTA,Semana.SEXTA);
    	
    	cbDiaHorario1.setValue(Semana.SEGUNDA);
    	cbDiaHorario2.setValue(Semana.SEGUNDA);
    	
    	cbDiaHorario1.getItems().addAll(semanaList);
    	cbDiaHorario2.getItems().addAll(semanaList);
    }
    
    void limparDados() {
    	
    	txtNomeDisc.setText("");
		txtAreaAtuacaoDisc.setText("");
		txtSalaDisc.setText("");
		txtCargaHorariaDisc.setText("");
		txtInicioAulaHorario1.setText("");
		txtFimAulaHorario1.setText("");
		txtInicioAulaHorario2.setText("");
		txtFimAulaHorario2.setText("");
		txtSemestreDisc.setText("");
		cbDiaHorario1.setValue(Semana.SEGUNDA);
		cbDiaHorario2.setValue(Semana.SEGUNDA);
		cbOfertada.setSelected(false);
		txtIdDisc.setText("");
    }
    
}

