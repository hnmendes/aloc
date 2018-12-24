package view;

import java.util.Optional;

import beans.Coordenador;
import beans.Professor;
import controller.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import system.AlocSystemApp;
import system.AlocSystemApp.NaMudancaTela;
import util.Tela;

public class AddProfessorCoordController {
	
	@FXML
	protected void initialize() {
		
		AlocSystemApp.addNaTrocaDeTelaListener(new NaMudancaTela() {
			
			@Override
			public void quandoTelaMudar(Tela novaTela, Object dados) {
				
				
				if((Coordenador)dados != null) {
					Coordenador coord = (Coordenador) dados;
					coordenadorLogado = coord;
				}
								
			}
		});
		
		senhaProf.setDisable(true);
	}
	
	Coordenador coordenadorLogado;
	
    @FXML
    private TextField areaAtuacaoProf;

    @FXML
    private TextField nomeProf;

    @FXML
    private TextField cpfProf;

    @FXML
    private Button btnCadastrarProf;

    @FXML
    private Button btnLimpar;

    @FXML
    private TextField idProf;

    @FXML
    private PasswordField senhaProf;

    @FXML
    private Button btnVoltar;

    @FXML
    void cadastrarProf(ActionEvent event) {
    	
    	if(areaAtuacaoProf.getText().equals("")) {
    		Alert msg = new Alert(Alert.AlertType.ERROR);
    		msg.setHeaderText("");
    		msg.setTitle("Campo incompleto.");
    		msg.setContentText("O campo de Área de Atuação está vazio.");
    		msg.show();
    	}else if(idProf.getText().equals("")) {
    		Alert msg = new Alert(Alert.AlertType.ERROR);
    		msg.setHeaderText("");
    		msg.setTitle("Campo incompleto.");
    		msg.setContentText("O campo de Id está vazio.");
    		msg.show();
    	}else if(nomeProf.getText().equals("")) {
    		Alert msg = new Alert(Alert.AlertType.ERROR);
    		msg.setHeaderText("");
    		msg.setTitle("Campo incompleto.");
    		msg.setContentText("O campo de Nome está vazio.");
    		msg.show();
    	}else if(cpfProf.getText().equals("")) {
    		Alert msg = new Alert(Alert.AlertType.ERROR);
    		msg.setHeaderText("");
    		msg.setTitle("Campo incompleto.");
    		msg.setContentText("O campo de CPF está vazio.");
    		msg.show();
    		
    	}else {
    		
    		if(Fachada.getInstance().contProfessor().getProfessor(cpfProf.getText()) != null) {
    		
    			Alert msg = new Alert(Alert.AlertType.ERROR);
        		msg.setHeaderText("");
        		msg.setTitle("Dados existentes.");
        		msg.setContentText("O CPF já foi cadastrado.");
        		msg.show();
    		
    		}else if(Fachada.getInstance().contProfessor().getProfessorById(Integer.parseInt(idProf.getText())) != null) {
    			
    			Alert msg = new Alert(Alert.AlertType.ERROR);
        		msg.setHeaderText("");
        		msg.setTitle("Dados existentes.");
        		msg.setContentText("O id já foi cadastrado.");
        		msg.show();
    		
    		}else {
    			
    			Fachada.getInstance().contProfessor().addProfessor(new Professor(Integer.parseInt(this.idProf.getText()),this.nomeProf.getText(),this.cpfProf.getText(),this.senhaProf.getText(),this.areaAtuacaoProf.getText()));
        		Alert msg = new Alert(Alert.AlertType.INFORMATION);
        		msg.setHeaderText("");
        		msg.setTitle("Sucesso!");
        		msg.setContentText("Professor "+this.nomeProf.getText()+" cadastrado com sucesso.");
        		msg.show();
        		
        		this.cpfProf.setText("");
        		this.nomeProf.setText("");
        		this.areaAtuacaoProf.setText("");
        		this.idProf.setText("");
    		}
    		
    	}
    	
    }

    @FXML
    void limparDados(ActionEvent event) {
    	this.areaAtuacaoProf.setText("");
    	this.cpfProf.setText("");
    	this.idProf.setText("");
    	this.nomeProf.setText("");
    }
    
    @FXML
    void apenasNumeros(KeyEvent event) {
    	this.idProf.textProperty().addListener((observable, antigoValor, novoValor)->{
    		if(!novoValor.matches("\\d*")) {
    			this.idProf.setText(novoValor.replaceAll("[^\\d]", ""));
    		}
    	});
    }

    @FXML
    void voltarCoordenador(ActionEvent event) {
    	
    	if(!nomeProf.getText().equals("") || !cpfProf.getText().equals("") || !areaAtuacaoProf.getText().equals("") || !idProf.getText().equals("")) {
    		
    		Alert msg = new Alert(AlertType.CONFIRMATION);
    		msg.getDialogPane().setMinWidth(400);
        	msg.setTitle("");
        	msg.setHeaderText("Atenção!");
        	msg.setContentText("Falta preencher alguns campos, deseja realmente voltar?");

        	Optional<ButtonType> result = msg.showAndWait();
        	
        	if (result.get() == ButtonType.OK){
        		AlocSystemApp.mudarTela(Tela.TELA_COORDENADOR, coordenadorLogado);
        	}
    	}else {
    		
    		AlocSystemApp.mudarTela(Tela.TELA_COORDENADOR, coordenadorLogado);
    	}
    	
    }

}
