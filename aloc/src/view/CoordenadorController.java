package view;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import beans.Coordenador;
import beans.Disciplina;
import beans.Professor;
import controller.Fachada;
import exceptions.ChoqueDisciplinaException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
	
	//TAB HOME
	
    
	/** Colunas na tabela referente a TAB HOME */
	
	private Coordenador coordenadorLogado;
	
	@FXML
	private TabPane tabPaneAll;
	
	@FXML
	private Tab tabHome;
	
	@FXML
	private TableView<Professor> tbvProfessorDisciplina;
	
	@FXML
    private TableColumn<Professor, String> professorCol;

    @FXML
    private TableColumn<Professor, String> disciplina1Col;

    @FXML
    private TableColumn<Professor, String> disciplina2Col;
    
    @FXML
    private TableView<Disciplina> tbvDisciplinasOfertada;
    
    @FXML
    private TableColumn<Disciplina, String> nomeDiscOfertada;
    
    @FXML
    private TableColumn<Disciplina, String> horarioDiscOfertada;
    
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
    	Stage cadastro = new Stage();
    	cadastro.setTitle("Cadastro de professor");
    	cadastro.setScene(ScreenManager.getInstance().getAddProfessorScene());
    	cadastro.setResizable(false);
    	cadastro.initOwner(((Node)event.getSource()).getScene().getWindow());
    	cadastro.initModality(Modality.APPLICATION_MODAL);
    	cadastro.showAndWait();
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
    }
    
    public void updateListaProfessores() {
    	
    	ObservableList<Professor> observableProfList = FXCollections.observableArrayList();
    	List<Professor> profs = Fachada.getInstance().contProfessor().getProfessorList();
    	observableProfList.addAll(profs);
    	tbvProfessor.setItems(observableProfList);
    	tbvProfessor.refresh();
    }
    
    @FXML
    void pesquisarProfessorTbl(ActionEvent event) {
    	
    }
    
    
    //Referente a TAB DISCIPLINAS
    
    @FXML
    void cadastrarDisciplina(ActionEvent event) {
    	
    	Stage addDisciplina = new Stage();
    	addDisciplina.setTitle("Cadastrar Disciplina");
    	addDisciplina.setScene(ScreenManager.getInstance().getAddDisciplinaScene());
    	addDisciplina.initOwner(((Node)event.getSource()).getScene().getWindow());
    	addDisciplina.initModality(Modality.APPLICATION_MODAL);
    	addDisciplina.showAndWait();
    	
    }
    
    @FXML
    void editarDisc(ActionEvent event) throws IOException, Exception{
    	
    	Disciplina disc = tbvDisciplinas.getSelectionModel().selectedItemProperty().getValue();
    	
    	if(disc!= null) {
    		
    		ScreenManager.getInstance().getEditDisciplinaController().setDisciplinaSelecionada(disc);
        	
    		Stage editDisc = new Stage();
        	editDisc.setTitle("Editar Disciplina");
        	editDisc.setScene(ScreenManager.getInstance().getEditDisciplinaScene());
        	editDisc.initOwner(((Node)event.getSource()).getScene().getWindow());
        	editDisc.initModality(Modality.APPLICATION_MODAL);
        	editDisc.showAndWait();
    	}else {
    		Alert msg = new Alert(AlertType.WARNING);
    		msg.setHeaderText("");
    		msg.setTitle("Disciplina não selecionada");
    		msg.setContentText("Você precisa selecionar uma disciplina para poder editar.");
    		msg.show();
    	}
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
    }
    
    public void updateListaDisciplinas() {
    	
    	ObservableList<Disciplina> observableDiscList = FXCollections.observableArrayList();
    	List<Disciplina> discs = Fachada.getInstance().contDisciplinas().getDisciplinaList();
    	observableDiscList.addAll(discs);
    	tbvDisciplinas.setItems(observableDiscList);
    	tbvDisciplinas.refresh();
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
    		
    		((Stage) this.btnSair.getScene().getWindow()).close();
  
    		Stage login = new Stage();
    		login.setTitle("@loc System");
    		login.setScene(ScreenManager.getInstance().getLoginScene());
    		login.show();
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
        
    	ObservableList<Professor> observableProfList = FXCollections.observableArrayList(Fachada.getInstance().contProfessor().getProfessorList());
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
        
    	ObservableList<Disciplina> observableDiscList = FXCollections.observableArrayList(Fachada.getInstance().contDisciplinas().getDisciplinaList());
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
    
    public void setCoordenadorLogado(Coordenador coord) {
    	coordenadorLogado = coord;
    }
    
    @FXML
    void carregarTableProfDisc(Event e) {
    	
    	professorCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	disciplina1Col.setCellValueFactory(
                disciplina -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    property.setValue((disciplina.getValue().getDisciplina1() == null) ? "Sem disciplina." : disciplina.getValue().getDisciplina1().getNome());
                    return property;
        });
    	
    	disciplina2Col.setCellValueFactory(
                disciplina -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    property.setValue((disciplina.getValue().getDisciplina2() == null) ? "Sem disciplina." : disciplina.getValue().getDisciplina2().getNome());
                    return property;
        });
    	
    	nomeDiscOfertada.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	horarioDiscOfertada.setCellValueFactory(
    			horario -> {
    				
    				String dia1 = horario.getValue().getHorario1Disciplina().getDia().name();
    				dia1 = Character.toString(dia1.charAt(0)) + Character.toString(dia1.charAt(1)) + Character.toString(dia1.charAt(2));
    				
    				String dia2 = horario.getValue().getHorario2Disciplina().getDia().name();
    				dia2 = Character.toString(dia2.charAt(0)) + Character.toString(dia2.charAt(1)) + Character.toString(dia2.charAt(2));
    				
    				String horario1 = horario.getValue().getHorario1Disciplina().getHorariosToString();
    				String horario2 = horario.getValue().getHorario2Disciplina().getHorariosToString();
    				
                    SimpleStringProperty property = new SimpleStringProperty();
                    property.setValue(dia1+" - "+dia2+", "+horario1+ " ; "+horario2);
                    return property;
        });
    	
    	tbvDisciplinasOfertada.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				String discNome = tbvDisciplinasOfertada.getSelectionModel().getSelectedItem().getNome();
				
				if(tbvProfessorDisciplina.getSelectionModel().getSelectedItem() != null && tbvDisciplinasOfertada.getSelectionModel().getSelectedItem() != null) {
					
					System.out.println("Selecionada: "+ discNome);
					
					Dragboard db = tbvDisciplinasOfertada.startDragAndDrop(TransferMode.COPY);
	                ClipboardContent content = new ClipboardContent();
	                content.putString(discNome);
	                db.setContent(content);
//	                System.out.println(db.getString());
	                event.consume();
	                
				}else {
					Alert msg = new Alert(AlertType.WARNING);
					msg.setHeaderText("");
					msg.setTitle("Selecione um professor.");
					msg.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					msg.setContentText("Selecione um professor para vincular a disciplina "+tbvDisciplinasOfertada.getSelectionModel().getSelectedItem().getNome()+" a ele.");
					msg.showAndWait();
				}
			}
    		
    	});
    	
    	tbvProfessorDisciplina.setOnDragOver(new EventHandler<DragEvent>(){

			@Override
			public void handle(DragEvent event) {
				System.out.println("DragOver: "+ event.getDragboard().getString());
				
				if(event.getDragboard().hasString()) {
					event.acceptTransferModes(TransferMode.COPY);
				}
				
				event.consume();
			}
    		
    	});
    	
    	tbvProfessorDisciplina.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
                
				System.out.println("onDragDropped: "+ event.getDragboard().getString());
				
                Dragboard db = event.getDragboard();
 
                boolean success = false;
                
                if (db.hasString()) {
                	
                	try {
                		
                		Professor p = tbvProfessorDisciplina.getSelectionModel().getSelectedItem();
                		System.out.println(p);
                    	
                    	if(p.getDisciplina1() == null && p.getDisciplina2() == null) {
                    		Disciplina d = Fachada.getInstance().contDisciplinas().getDisciplinaByNome(db.getString());
                    		p.setDisciplina1(d);
                    		p.getDisciplina1().setProfessorLeciona(true);
                    		updateListaProfessoresDisciplinasHome();
                    		updateListaDisciplinasOfertadasHome();
                    		success = true;
                    		
                    	}else if(p.getDisciplina2() == null) {
                    		Disciplina d = Fachada.getInstance().contDisciplinas().getDisciplinaByNome(db.getString());
                    		p.setDisciplina2(d);
                    		p.getDisciplina2().setProfessorLeciona(true);
                    		updateListaProfessoresDisciplinasHome();
                    		updateListaDisciplinasOfertadasHome();
                    		success = true;
                    		
                    	}else if(p.getDisciplina1() != null && p.getDisciplina2() == null) {
                    		Disciplina d = Fachada.getInstance().contDisciplinas().getDisciplinaByNome(db.getString());
                    		success = p.getDisciplina1().choqueDisciplina(d);
                    		p.setDisciplina2((!success) ? d : null);
                    		p.getDisciplina2().setProfessorLeciona(true);
                    		updateListaProfessoresDisciplinasHome();
                    		updateListaDisciplinasOfertadasHome();
                    		success = true;
                    		
                    	}else if(p.getDisciplina1() == null && p.getDisciplina2() != null) {
                    		Disciplina d = Fachada.getInstance().contDisciplinas().getDisciplinaByNome(db.getString());
                    		success = p.getDisciplina2().choqueDisciplina(d);
                    		p.setDisciplina1((!success) ? d : null);
                    		p.getDisciplina1().setProfessorLeciona(true);
                    		updateListaProfessoresDisciplinasHome();
                    		updateListaDisciplinasOfertadasHome();
                    		success = true;
                    	}else if(p.getDisciplina1() != null && p.getDisciplina2() != null) {
                    		
                    		Alert msg = new Alert(AlertType.ERROR);
                    		msg.setHeaderText("");
                    		msg.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    		msg.setTitle("Disciplinas preenchidas.");
                    		msg.setContentText("Você não pode mais adicionar disciplinas, pois esse professor já completou o máximo de duas disciplinas.");
                    		msg.showAndWait();
                    	}
                    	
                	}catch(ChoqueDisciplinaException e) {
                		
                		e.printStackTrace();
                		Alert msg = new Alert(AlertType.WARNING);
                		msg.setHeaderText("");
                		msg.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                		msg.setTitle("Choque de disciplinas.");
                		msg.setContentText(e.toString());
                		msg.showAndWait();
                	}
                	
                }
                event.setDropCompleted(success);
                event.consume();
			}
    		
    	});
    	
    	tbvProfessorDisciplina.setOnDragDone(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				
				System.out.println("Feito.");

				if (event.getTransferMode() == TransferMode.COPY) {
					
                }
                
				updateListaProfessoresDisciplinasHome();
                event.consume();
            }
    		
    	});
    	
    	
//    	tbvProfessorDisciplina.setOndrag
    	
    	/*
    	 * 
    	 *	    @FXML
				TableView<String> tableView;
				private  ObservableList<String> tableContent = FXCollections.observableArrayList();
				
				//...
				
				tableView.setOnMouseClicked(new EventHandler<MouseEvent>() { //click
				            @Override
				            public void handle(MouseEvent event) {
				                    if(event.getClickCount()==2){ // double click
				
				                        String selected =   tableView.getSelectionModel().getSelectedItem();
				                        if(selected !=null){
				                            System.out.println("select : "+selected);
				                           ...
				                        }
				                    }
				            }
				    });
				
				tableView.setOnDragDetected(new EventHandler<MouseEvent>() { //drag
				        @Override
				        public void handle(MouseEvent event) {
				            // drag was detected, start drag-and-drop gesture
				            String selected = tableView.getSelectionModel().getSelectedItem();
				            if(selected !=null){
				
				                Dragboard db = tableView.startDragAndDrop(TransferMode.ANY);
				                ClipboardContent content = new ClipboardContent();
				                content.putString(selected);
				                db.setContent(content);
				                event.consume(); 
				            }
				        }
				    });
				
				tableView.setOnDragOver(new EventHandler<DragEvent>() {
				            @Override
				            public void handle(DragEvent event) {
				                // data is dragged over the target 
				                Dragboard db = event.getDragboard();
				                if (event.getDragboard().hasString()){
				                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				                }
				                event.consume();
				            }
				        });
				
				tableView.setOnDragDropped(new EventHandler<DragEvent>() {
				            @Override
				            public void handle(DragEvent event) {
				                Dragboard db = event.getDragboard();
				                boolean success = false;
				                if (event.getDragboard().hasString()) {            
				
				                    String text = db.getString();
				                    tableContent.add(text);
				                    tableView.setItems(tableContent);
				                    success = true;
				                }
				                event.setDropCompleted(success);
				                event.consume();
				            } 
				        });   
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * */
    	
    	updateListaProfessoresDisciplinasHome();
    	updateListaDisciplinasOfertadasHome();
    }
    
    public void updateListaProfessoresDisciplinasHome() {
    	
    	ObservableList<Professor> observableProfList = FXCollections.observableArrayList();
    	List<Professor> profs = Fachada.getInstance().contProfessor().getProfessorList();
    	observableProfList.addAll(profs);
    	tbvProfessorDisciplina.setItems(observableProfList);
    	tbvProfessorDisciplina.refresh();
    }
    
    public void updateListaDisciplinasOfertadasHome() {
    	
    	ObservableList<Disciplina> observableDiscList = FXCollections.observableArrayList();
    	List<Disciplina> discs = Fachada.getInstance().contDisciplinas().getDisciplinaList();
    	
    	discs = discs.stream()
    			.filter(d -> d.getOfertada() && !d.isProfessorLeciona())
    			.collect(Collectors.toList());
    	
    	observableDiscList.addAll(discs);
    	tbvDisciplinasOfertada.setItems(observableDiscList);
    	
    	if(tbvDisciplinasOfertada.getItems() == null || tbvDisciplinasOfertada.getItems().size() == 0) {
    		tbvDisciplinasOfertada.setPlaceholder(new Label("Não há disciplinas ofertadas no momento."));
    	}
    	
    	tbvDisciplinasOfertada.refresh();
    }
}

