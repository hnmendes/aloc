package view;

import beans.Coordenador;
import beans.Disciplina;
import beans.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import system.AlocSystemApp;
import util.Semana;
import util.Tela;

/**
	@Author: rique
*/

public class EditDisciplinaCoordController {
	
	@FXML
    protected void initialize(){
/*AlocSystemApp.addNaTrocaDeTelaListener(new NaMudancaTela() {
			
			@Override
			public void quandoTelaMudar(Tela novaTela, Object dados) {
				
				if((Coordenador)dados != null && dados instanceof Coordenador) {
					Coordenador coord = (Coordenador) dados;
					coordSelecionado = coord;
				}else if((Disciplina)dados != null && dados instanceof Disciplina) {
					Disciplina disc = (Disciplina) dados;
					discSelecionada = disc;
				}else if((Professor)dados != null && dados instanceof Professor) {
					Professor prof = (Professor) dados;
					profSelecionado = prof;
				}
			}
		});*/
	}
	
	private Coordenador coordSelecionado;
	private Professor profSelecionado;
	private Disciplina discSelecionada;
	
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
    void carregarDados() {
    	
    	/*System.out.println(discSelecionada.toString());
    	
    	txtNomeDisc.setText(discSelecionada.getNome());
		txtAreaAtuacaoDisc.setText(discSelecionada.getAreaAtuacao());
		txtSalaDisc.setText(discSelecionada.getSala());
		txtCargaHorariaDisc.setText(String.valueOf(discSelecionada.getCargaHoraria()));
		txtInicioAulaHorario1.setText(discSelecionada.getHorario1Disciplina().getPrimeiroHorarioString());
		txtFimAulaHorario1.setText(discSelecionada.getHorario1Disciplina().getSegundoHorarioString());
		txtInicioAulaHorario2.setText(discSelecionada.getHorario2Disciplina().getPrimeiroHorarioString());
		txtFimAulaHorario2.setText(discSelecionada.getHorario2Disciplina().getSegundoHorarioString());
		txtSemestreDisc.setText(discSelecionada.getSemestre());
		cbDiaHorario1.getItems().add(discSelecionada.getHorario1Disciplina().getDia());
		cbDiaHorario2.getItems().add(discSelecionada.getHorario2Disciplina().getDia());*/
    }
    
    @FXML
    void editarDisciplina(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }
	
}

