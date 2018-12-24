package system;

import java.util.ArrayList;

import beans.Coordenador;
import beans.Disciplina;
import beans.Professor;
import controller.Fachada;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Tela;
import view.ScreenManager;

/**
	@Author: rique
*/

public class AlocSystemApp extends Application{
	
	private static Stage stage;
	
	
	private static Scene login;
	
	private static Scene coord;
	
	private static Scene addProfCoord;
	
	private static Scene prof;
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		
//		primaryStage.setScene(ScreenManager.getInstance().getMyScene());
		primaryStage.setTitle("@loc System");
		
		//FXML's
		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		Parent fxmlCoord = FXMLLoader.load(getClass().getResource("/view/CoordenadorFXML.fxml"));
		Parent fxmlAddProfCoord = FXMLLoader.load(getClass().getResource("/view/AddProfessorCoordFXML.fxml"));
		Parent fxmlProf  = FXMLLoader.load(getClass().getResource("/view/ProfessorFXML.fxml"));
		
		
		//Scenes
		login = new Scene(fxmlLogin,400,440);
		coord = new Scene(fxmlCoord,400,440);
		prof  = new Scene(fxmlProf,400,440);
		addProfCoord = new Scene(fxmlAddProfCoord,400,440);
		
		primaryStage.setScene(login);
		
		primaryStage.setWidth(700);
		primaryStage.setHeight(440);
		primaryStage.setResizable(false);
		
		
		
		
		Disciplina disc1 = new Disciplina(1,"Inteligencia Artificial2","IA",60);
		Disciplina disc2 = new Disciplina(2,"Tópicos Avançados em Inteligencia Artificial","IA",60);
		
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc1);
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc2);
		
		Professor prof = new Professor(1,"Henrique Nunes","123","123","IA");
		Coordenador coord = new Coordenador("José Martins","123","123");
		
		Fachada.getInstance().contProfessor().addProfessor(prof);
		Fachada.getInstance().contCoordenador().cadastrarCoordenador(coord);
		
		System.out.println(Fachada.getInstance().contProfessor().getProfessorList().toString());
		
		
		
		ScreenManager.getInstance().setPrimaryStage(primaryStage);
		
		primaryStage.show();
		
	}
	
	public static void mudarTela(Tela tela, Object dados) {
		
		switch(tela) {
			case TELA_LOGIN:
				stage.setScene(login);
				notificarTodosListeners(Tela.TELA_LOGIN, dados);
				break;
			
			case TELA_PROFESSOR:
				stage.setScene(prof);
				notificarTodosListeners(Tela.TELA_PROFESSOR, dados);
				break;
			
			case TELA_COORDENADOR:
				stage.setScene(coord);
				notificarTodosListeners(Tela.TELA_COORDENADOR, dados);
				break;
			case TELA_ADD_PROFESSOR_COORD:
				stage.setScene(addProfCoord);
				notificarTodosListeners(Tela.TELA_ADD_PROFESSOR_COORD, dados);
				break;
		}
	}
	
	private static ArrayList<NaMudancaTela> listeners = new ArrayList<>();
	
	public static interface NaMudancaTela{
		void quandoTelaMudar(Tela novaTela, Object dados);
	}
	
	public static void addNaTrocaDeTelaListener(NaMudancaTela newListener) {
		listeners.add(newListener);
	}
	
	private static void notificarTodosListeners(Tela novaTela, Object dados) {
		listeners.forEach(
			l -> l.quandoTelaMudar(novaTela, dados)
		);
	}
	
	public static void main(String [] args) {
		AlocSystemApp.launch(args);
	}

}

