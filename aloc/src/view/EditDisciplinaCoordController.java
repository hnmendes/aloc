package view;

import java.util.Arrays;
import java.util.List;

import beans.Disciplina;
import controller.Fachada;
import exceptions.ChoqueDisciplinaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import util.Semana;
import util.TextFieldFormatter;

/**
	@Author: rique
*/

public class EditDisciplinaCoordController {
	
	@FXML
    protected void initialize(){
		
	}
	
	private int idDisciplinaSelecionada;
	
	@FXML
    private Tab tabEditar;
	
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
    private Button btnEditar;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private CheckBox cbOfertada;
    
    @FXML
    void mudarOfertada(ActionEvent event) throws ChoqueDisciplinaException {
    	
		Disciplina disc = Fachada.getInstance().contDisciplinas().getDisciplinaById(idDisciplinaSelecionada);
    	
		try {
			
			@SuppressWarnings("unused")
			boolean chocaHorario = Fachada.getInstance().contDisciplinas().disciplinaChocaHorarioEdit(disc);
			
	    	
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
		
		
    }
    
    @FXML
    void carregarDados() {

    }
    
    @FXML
    void editarDisciplina(ActionEvent event) throws ChoqueDisciplinaException {
    	
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
		
		Disciplina disc = Fachada.getInstance().contDisciplinas().getDisciplinaById(idDisciplinaSelecionada);

		
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
			
		}else if(sala.equals("")) {
		
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("O campo Sala está vazio.");
			msg.showAndWait();
			
		}else if(cargaHoraria < 30) {
		
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Campos incorretos");
			msg.setContentText("A Carga Horária não pode ser menor do que 30.");
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
			
		}else if(!disc.equals(Fachada.getInstance().contDisciplinas().getDisciplinaByNome(nome)) && Fachada.getInstance().contDisciplinas().getDisciplinaByNome(nome) != null){
			Alert msg = new Alert(AlertType.ERROR);
			msg.setHeaderText("");
			msg.setTitle("Disciplina existente");
			msg.setContentText("Já existe uma disciplina com esse nome.");
			msg.showAndWait();
		}else{
			
			disc.editarDisciplina(nome, areaAtuacao, sala, cargaHoraria, inicioHorario1, fimHorario1, diaHorario1, inicioHorario2, fimHorario2, diaHorario2, semestre, ofertada);
			
			ScreenManager.getInstance().getCoordenadorController().updateListaDisciplinas();
			
			Alert msg = new Alert(AlertType.INFORMATION);
			msg.setHeaderText("");
			msg.setTitle("Sucesso!");
			msg.setContentText("Os dados da disciplina " + disc.getNome() + " foram editados com sucesso.");
			msg.showAndWait();
			
			((Stage)btnEditar.getScene().getWindow()).close();
		}
		
    }

    @FXML
    void voltar(ActionEvent event) {
    	
    	((Stage)btnVoltar.getScene().getWindow()).close();
    
    }
    
    public void setDisciplinaSelecionada(Disciplina disc){
    	
    	txtNomeDisc.setText(disc.getNome());
		txtAreaAtuacaoDisc.setText(disc.getAreaAtuacao());
		txtSalaDisc.setText(disc.getSala());
		txtCargaHorariaDisc.setText(String.valueOf(disc.getCargaHoraria()));
		txtInicioAulaHorario1.setText(disc.getHorario1Disciplina().getPrimeiroHorarioString());
		txtFimAulaHorario1.setText(disc.getHorario1Disciplina().getSegundoHorarioString());
		txtInicioAulaHorario2.setText(disc.getHorario2Disciplina().getPrimeiroHorarioString());
		txtFimAulaHorario2.setText(disc.getHorario2Disciplina().getSegundoHorarioString());
		txtSemestreDisc.setText(disc.getSemestre());
		
		List<Semana> semanaList = Arrays.asList(Semana.SEGUNDA,Semana.TERCA,Semana.QUARTA,Semana.QUINTA,Semana.SEXTA);
		
		cbDiaHorario1.getItems().addAll(semanaList);
		cbDiaHorario2.getItems().addAll(semanaList);
		cbDiaHorario1.setValue(disc.getHorario1Disciplina().getDia());
		cbDiaHorario2.setValue(disc.getHorario2Disciplina().getDia());
		cbOfertada.setSelected(disc.getOfertada());
		
		idDisciplinaSelecionada = disc.getId();
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
    
    

}

