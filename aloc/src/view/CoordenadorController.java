package view;

import java.util.Optional;

import beans.Coordenador;
import beans.Disciplina;
import beans.Professor;
import controller.Fachada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import system.AlocSystemApp;
import system.AlocSystemApp.NaMudancaTela;
import util.Tela;

/**
	@Author: rique
*/

public class CoordenadorController {
	
	
	@FXML
    protected void initialize(){
    	
		AlocSystemApp.addNaTrocaDeTelaListener(new NaMudancaTela() {
			
			@Override
			public void quandoTelaMudar(Tela novaTela, Object dados) {
				
				//Preenchendo o campo editar com os dados do coordenador logado
				
				if((Coordenador)dados != null) {
					Coordenador coord = (Coordenador) dados;
					coordenadorLogado = coord;
				}
								
			}
		});
		
    }
	
	
	ObservableList<Professor> observableProfList;
	
	
	//TAB HOME
	
    
	/** Colunas na tabela referente a TAB HOME */
	
	private Coordenador coordenadorLogado;
	
	@FXML
    private TableColumn<Professor, String> professorCol;

    @FXML
    private TableColumn<Disciplina, String> disciplina1Col;

    @FXML
    private TableColumn<Disciplina, String> disciplina2Col;
    
    
    /** Buttons da TAB HOME*/
    
    
    @FXML
    private Button btnSalvarLista;

    @FXML
    private Button btnImprimirLista;
    
    @FXML
    private Button btnSair;
    
    
    /** Filtro de pesquisa da TAB HOME*/
    
    
    @FXML
    private TextField txtSearchCPForDiscId;
    
    
    //TAB PROFESSORES
    
    
    /** Colunas na tabela referente a TAB PROFESSORES */
    
    @FXML
    private Tab professoresTab;
    
    @FXML
    private TableView<Professor> tbvProfessor;
    
    @FXML
    private TableColumn<Professor, Number> idProfCol;

    @FXML
    private TableColumn<Professor, String> nomeProfCol;

    @FXML
    private TableColumn<Professor, String> cpfProfCol;

    @FXML
    private TableColumn<Professor, String> areaProfCol;
    
    
    /**Buttons da TAB PROFESSORES*/
    
    
    @FXML
    private Button btnCadastrarProf;

    @FXML
    private Button btnRemoverProf;
    
    
    /**Filtro de Pesquisa da TAB PROFESSORES*/
    
    
    @FXML
    private TextField txtSearchProf;
    
    
    /**TAB MEUS DADOS*/
    
    @FXML
    private Tab meusDadosTab;
    
    
    //TAB DISCIPLINAS
    
    
    /**Colunas na tabela referente a TAB DISCIPLINAS*/
    
    @FXML
    private TableView<Disciplina> tbvDisciplinas;
    
    @FXML
    private TableColumn<Disciplina, Integer> idDiscCol;

    @FXML
    private TableColumn<Disciplina, String> nomeDiscCol;

    @FXML
    private TableColumn<Disciplina, String> areaDiscCol;

    @FXML
    private TableColumn<Disciplina, String> horarioDiscCol;

    @FXML
    private TableColumn<Disciplina, String> salaDiscCol;

    @FXML
    private TableColumn<Disciplina, Integer> cargaHorariaDiscCol;

    @FXML
    private TableColumn<Disciplina, Boolean> ofertadaDiscCol;
    
    
    /**Buttons da TAB DISCIPLINAS*/
    
    
    @FXML
    private Button btnCadastrarDisc;

    @FXML
    private Button btnRemoverDisc;
    
    
    /**Filtro de pesquisa da TAB DISCIPLINAS */
    
    
    @FXML
    private TextField txtSearchDisc;
    
    
    
    /**TextFields da TAB MEUS DADOS*/
    
    @FXML
    private TextField txtNomeCoord;
    
    @FXML
    private TextField txtCpfCoord;
    
    @FXML
    private PasswordField txtSenhaCoord;
    
    @FXML
    private PasswordField txtRepeatSenhaCoord;
    
    /**Button da TAB MEUS DADOS*/
    
    @FXML
    private Button btnEditar;
    
    //Métodos na Tabela

    
    /**Métodos da tabela professor*/
    
    
    @SuppressWarnings("unchecked")
	@FXML
    void areaProfCol_OnEditCommit(Event e) {
    	TableColumn.CellEditEvent<Professor, String> celulaEdicaoEvento;
        celulaEdicaoEvento = (TableColumn.CellEditEvent<Professor, String>) e;
        Professor professor = celulaEdicaoEvento.getRowValue();
        professor.setAreaAtuacao(celulaEdicaoEvento.getNewValue());
    }
    
    @SuppressWarnings("unchecked")
	@FXML
    void cpfProfCol_OnEditCommit(Event e) {
    	TableColumn.CellEditEvent<Professor, String> celulaEdicaoEvento;
        celulaEdicaoEvento = (TableColumn.CellEditEvent<Professor, String>) e;
        Professor professor = celulaEdicaoEvento.getRowValue();
        professor.setCpf(celulaEdicaoEvento.getNewValue());
    }

    @SuppressWarnings("unchecked")
	@FXML
    void idProfCol_OnEditCommit(Event e) {
    	TableColumn.CellEditEvent<Professor, String> celulaEdicaoEvento;
        celulaEdicaoEvento = (TableColumn.CellEditEvent<Professor, String>) e;
        Professor professor = celulaEdicaoEvento.getRowValue();
        professor.setId(Integer.parseInt(celulaEdicaoEvento.getNewValue()));
    }

    @SuppressWarnings("unchecked")
	@FXML
    void nomeProfCol_OnEditCommit(Event e) {
    	TableColumn.CellEditEvent<Professor, String> celulaEdicaoEvento;
        celulaEdicaoEvento = (TableColumn.CellEditEvent<Professor, String>) e;
        Professor professor = celulaEdicaoEvento.getRowValue();
        professor.setNome(celulaEdicaoEvento.getNewValue());
    }
    
    /**Métodos da Tabela Disciplina*/
    
    @FXML
    void areaDiscCol_OnEditCommit(ActionEvent event) {
    	
    }

    @FXML
    void cargaHorariaDiscCol_OnEditCommit(ActionEvent event) {

    }
    
    @FXML
    void horarioDiscCol_OnEditCommit(ActionEvent event) {

    }

    @FXML
    void idDiscCol_OnEditCommit(ActionEvent event) {

    }

    
    @FXML
    void nomeDiscCol_OnEditCommit(ActionEvent event) {

    }

    @FXML
    void ofertadaDiscCol_OnEditCommit(ActionEvent event) {

    }

    @FXML
    void salaDiscCol_OnEditCommit(ActionEvent event) {

    }
    
    
    /**Métodos Handles*/
    
    
    //Referente a TAB PROFESSORES
    
    @FXML
    void cadastrarProfessor(ActionEvent event) {
    	AlocSystemApp.mudarTela(Tela.TELA_ADD_PROFESSOR_COORD, coordenadorLogado);
    }
    
    @FXML
    void removerProfessor(ActionEvent event) {
    	
    }
    
    @FXML
    void carregarTableProfessores() {
    	
    	idProfCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    	nomeProfCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	cpfProfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	areaProfCol.setCellValueFactory(new PropertyValueFactory<>("areaAtuacao"));
    	
    	updateListaProfessores();
    }
    
    public void updateListaProfessores() {
    	
    	ObservableList<Professor> result = FXCollections.observableArrayList();
        
    	result.addAll(Fachada.getInstance().contProfessor().getProfessorList());        
        
    	tbvProfessor.setItems(result);
    }
    
    
    //Referente a TAB DISCIPLINAS
    
    @FXML
    void cadastrarDisciplina(ActionEvent event) {

    }
    
    @FXML
    void removerDisciplina(ActionEvent event) {

    }
    

    //Referente a TAB HOME
    
    @FXML
    void salvarLista(ActionEvent event) {

    }
    
    @FXML
    void imprimirLista(ActionEvent event) {

    }
    
    
    //Referente a TAB MEUS DADOS
    
    @FXML
    void editar(ActionEvent event) {
    	
    	System.out.println("Botão Editar Clicado.");
    	
    	if(!txtSenhaCoord.getText().equals(txtRepeatSenhaCoord.getText())) {

    		Alert msg = new Alert(Alert.AlertType.ERROR);
    		msg.setHeaderText("");
    		msg.setTitle("Verifique as senhas.");
    		msg.setContentText("As senhas digitadas não são iguais.");
    		msg.show();
    		
    	}else if(txtSenhaCoord.getText().equals("")){
    		
    		Alert msg = new Alert(Alert.AlertType.ERROR);
    		msg.setHeaderText("");
    		msg.setTitle("Verifique as senhas.");
    		msg.setContentText("A senha está vazia.");
    		msg.show();
    		
    	}else if(txtRepeatSenhaCoord.getText().equals("")){
    		
    		Alert msg = new Alert(Alert.AlertType.ERROR);
    		msg.setHeaderText("");
    		msg.setTitle("Verifique as senhas.");
    		msg.setContentText("A repetição de senha está vazia.");
    		msg.show();
    		
    	}else {
    		this.coordenadorLogado.setNome(txtNomeCoord.getText());
    		this.coordenadorLogado.setCpf(txtCpfCoord.getText());
    		this.coordenadorLogado.setSenha(txtSenhaCoord.getText());
    		
    		Fachada.getInstance().contCoordenador().editarCoordenador(coordenadorLogado.getCpf(), coordenadorLogado);
    		
    		Alert msg = new Alert(Alert.AlertType.INFORMATION);
    		msg.setHeaderText("");
    		msg.setTitle("Sucesso!");
    		msg.setContentText("Dados editados com sucesso.");
    		msg.show();
    		
    		txtRepeatSenhaCoord.setText("");
    		txtSenhaCoord.setText("");
    	}
    }
    
    @FXML
    void deslogar(ActionEvent event) {
    	
    	Alert msg = new Alert(AlertType.CONFIRMATION);
    	msg.setTitle("");
    	msg.setHeaderText("Sair");
    	msg.setContentText("Você realmente deseja sair?");

    	Optional<ButtonType> result = msg.showAndWait();
    	
    	if (result.get() == ButtonType.OK){
    		AlocSystemApp.mudarTela(Tela.TELA_LOGIN, null);
    	}
    	
    }
    
    @FXML
    void carregarDados() {
    	txtCpfCoord.setText(coordenadorLogado.getCpf());
    	txtCpfCoord.setDisable(true);
    	txtNomeCoord.setText(coordenadorLogado.getNome());
    }
    

	
    
}

