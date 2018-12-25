package view;

import java.util.List;
import java.util.Optional;

import beans.Coordenador;
import beans.Disciplina;
import beans.Professor;
import controller.Fachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import system.AlocSystemApp;
import util.Tela;

/**
	@Author: rique
*/

public class CoordenadorController {
	
	@FXML
    protected void initialize(){
		
		txtSearchProf.textProperty().addListener(new ChangeListener<String>() {
            @Override
			public void changed(ObservableValue<? extends String> observable, String antigoValor, String novoValor) {
                filtroProfessorList(antigoValor,novoValor);

            }
        });
		
		txtSearchDisc.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String antigoValor, String novoValor) {
				filtroDisciplinaList(antigoValor,novoValor);
			}

        });
		
		//Editar valores na tabela

		tbvProfessor.setEditable(true);
		nomeProfCol.setCellFactory(TextFieldTableCell.forTableColumn());
		areaProfCol.setCellFactory(TextFieldTableCell.forTableColumn());
    }
	
	
	ObservableList<Professor> observableProfList = FXCollections.observableArrayList();
	ObservableList<Disciplina> observableDiscList = FXCollections.observableArrayList();
	
	
	//TAB HOME
	
    
	/** Colunas na tabela referente a TAB HOME */
	
	private Coordenador coordenadorLogado;
	
	@FXML
	private TabPane tabPaneAll;
	
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
    private Tab tabDisciplinas;
    
    @FXML
    private TableView<Disciplina> tbvDisciplinas;
    
    @FXML
    private TableColumn<Disciplina, Integer> idDiscCol;

    @FXML
    private TableColumn<Disciplina, String> nomeDiscCol;

    @FXML
    private TableColumn<Disciplina, String> areaDiscCol;

    @FXML
    private TableColumn<Disciplina, String> horario1DiscCol;
    
    @FXML
    private TableColumn<Disciplina, String> horario2DiscCol;
    
    @FXML
    private TableColumn<Disciplina, String> periodoDiscCol;

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
    
    @FXML
    private Button btnEditarDisc;
    
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
    void nomeProfCol_OnEditCommit(Event e) {
    	TableColumn.CellEditEvent<Professor, String> celulaEdicaoEvento;
        celulaEdicaoEvento = (TableColumn.CellEditEvent<Professor, String>) e;
        Professor professor = celulaEdicaoEvento.getRowValue();
        professor.setNome(celulaEdicaoEvento.getNewValue());
    }
    
    /**Métodos Handles*/
    
    
    //Referente a TAB PROFESSORES
    
    @FXML
    void cadastrarProfessor(ActionEvent event) {
    	
    	tabPaneAll.getSelectionModel().select(0);
    	
    	//AlocSystemApp.mudarTela(Tela.TELA_ADD_PROFESSOR_COORD, coordenadorLogado);
    }
    
    @FXML
    void removerProfessor(ActionEvent event) {
    	
    	Professor pSelecionado = tbvProfessor.getSelectionModel().getSelectedItem();
    	tbvProfessor.getItems().remove(pSelecionado);
    	Fachada.getInstance().contProfessor().remover(pSelecionado.getCpf());
    }
    
    @FXML
    void carregarTableProfessores(Event e) {
    	
    	if(tbvProfessor.getItems().size() == 0) {
            tbvProfessor.setPlaceholder(new Label("Lista vazia."));
    	}
    	
    	idProfCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    	nomeProfCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	cpfProfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	areaProfCol.setCellValueFactory(new PropertyValueFactory<>("areaAtuacao"));
    	
    	updateListaProfessores();
    	
    	tbvProfessor.refresh();
    	
    }
    
    public void updateListaProfessores() {
    	
    	List<Professor> profs = Fachada.getInstance().contProfessor().getProfessorList();
    	
    	observableProfList.removeAll(profs);
    	
    	observableProfList.addAll(profs);
    	
    	tbvProfessor.setItems(observableProfList);
    	
    }
    
    @FXML
    void pesquisarProfessorTbl(ActionEvent event) {
    	
    }
    
    
    //Referente a TAB DISCIPLINAS
    
    @FXML
    void cadastrarDisciplina(ActionEvent event) {

    }
    
    
    @FXML
    void removerDisciplina(ActionEvent event) {
    	Disciplina dSelecionada = tbvDisciplinas.getSelectionModel().getSelectedItem();
    	tbvDisciplinas.getItems().remove(dSelecionada);
    	Fachada.getInstance().contDisciplinas().removerDisciplina(dSelecionada.getNome());;
    }
    
    @FXML
    void carregarTableDisciplinas(Event e) {
    	
    	if(tbvDisciplinas.getItems().size() == 0) {
            tbvDisciplinas.setPlaceholder(new Label("Lista vazia."));
    	}
    	
    	ofertadaDiscCol.setCellFactory(tc -> new TableCell<Disciplina, Boolean>() {
    	    @Override
    	    protected void updateItem(Boolean item, boolean empty) {
    	        super.updateItem(item, empty);
    	        setText(empty ? null :
    	            item.booleanValue() ? "Sim" : "Não");
    	    }
    	});
    	
    	idDiscCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    	nomeDiscCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	areaDiscCol.setCellValueFactory(new PropertyValueFactory<>("areaAtuacao"));
    	
    	horario1DiscCol.setCellValueFactory(
                horario -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    property.setValue(horario.getValue().getHorario1Disciplina().getHorariosToString()+", "+
                    horario.getValue().getHorario2Disciplina().getDia());
                    return property;
        });
    	
    	horario2DiscCol.setCellValueFactory(
                horario -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    property.setValue(horario.getValue().getHorario2Disciplina().getHorariosToString()+", "+
                    horario.getValue().getHorario1Disciplina().getDia());
                    return property;
        });
    	
    	salaDiscCol.setCellValueFactory(new PropertyValueFactory<>("sala"));
    	cargaHorariaDiscCol.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
    	ofertadaDiscCol.setCellValueFactory(new PropertyValueFactory<>("ofertada"));
    	periodoDiscCol.setCellValueFactory(new PropertyValueFactory<>("semestre"));
    	
    	updateListaDisciplinas();
    	
    	tbvDisciplinas.refresh();
    	
    }
    
    public void updateListaDisciplinas() {
    	
    	List<Disciplina> discs = Fachada.getInstance().contDisciplinas().getDisciplinaList();
    	
    	observableDiscList.removeAll(discs);
    	
    	observableDiscList.addAll(discs);
    	
    	tbvDisciplinas.setItems(observableDiscList);
    	
    	
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
    		//AlocSystemApp.mudarTela(Tela.TELA_LOGIN, null);
    	}
    	
    }
    
    @FXML
    void carregarDados() {
    	txtCpfCoord.setText(coordenadorLogado.getCpf());
    	txtCpfCoord.setDisable(true);
    	txtNomeCoord.setText(coordenadorLogado.getNome());
    }
    
    
    //Filtro Professor
    public void filtroProfessorList(String antigoValor, String novoValor) {
        
    	ObservableList<Professor> filtroList = FXCollections.observableArrayList();
        
        if(txtSearchProf == null || (novoValor.length() < antigoValor.length()) || novoValor == null) {
            tbvProfessor.setItems(observableProfList);
        }
        else {
            novoValor = novoValor.toUpperCase();
            
            for(Professor profs : tbvProfessor.getItems()) {
            	String nomeProf = profs.getNome();
            	String idProf = String.valueOf(profs.getId());
            	
            	if(nomeProf.toUpperCase().contains(novoValor) || idProf.contains(novoValor)) {
            		filtroList.add(profs);
            	}
            }
            
            
            
            tbvProfessor.setPlaceholder(new Label("Professor não encontrado."));
            tbvProfessor.setItems(filtroList);
            
        }
    }
    
    
  //Filtro Disciplina
    public void filtroDisciplinaList(String antigoValor, String novoValor) {
        
    	ObservableList<Disciplina> filtroList = FXCollections.observableArrayList();
        
        if(txtSearchDisc == null || (novoValor.length() < antigoValor.length()) || novoValor == null) {
            tbvDisciplinas.setItems(observableDiscList);
        }
        else {
            novoValor = novoValor.toUpperCase();
            
            for(Disciplina discs : tbvDisciplinas.getItems()) {
            	String nomeDisc = discs.getNome();
            	String idDisc = String.valueOf(discs.getId());
            	
            	if(nomeDisc.toUpperCase().contains(novoValor) || idDisc.contains(novoValor)) {
            		filtroList.add(discs);
            	}
            }
            
            tbvDisciplinas.setPlaceholder(new Label("Disciplina não encontrada."));
            tbvDisciplinas.setItems(filtroList);
            
        }
    }
    
    
    @FXML
    void editarDisc(ActionEvent event) {
    	
    	
    }
    
    public void setCoordenadorLogado(Coordenador coord) {
    	coordenadorLogado = coord;
    }
    
    
}

