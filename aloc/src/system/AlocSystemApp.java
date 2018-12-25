package system;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import beans.Coordenador;
import beans.Disciplina;
import beans.HorarioDisciplina;
import beans.Professor;
import controller.Fachada;
import javafx.application.Application;
import javafx.stage.Stage;
import util.Semana;
import view.ScreenManager;

/**
	@Author: rique
*/

public class AlocSystemApp extends Application{
	
	/*private static Stage stage;
	
	
	private static Scene login;
	
	private static Scene coord;
	
	private static Scene addProfCoord;
	
	private static Scene addDiscCoord;
	
	private static Scene editDiscCoord;
	
	private static Scene prof;
	*/
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		/*
		
		stage = primaryStage;
		
		primaryStage.setScene(ScreenManager.getInstance().getMyScene());
		primaryStage.setTitle("@loc System");
		
		//FXML's
		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		Parent fxmlCoord = FXMLLoader.load(getClass().getResource("/view/CoordenadorFXML.fxml"));
		Parent fxmlAddProfCoord = FXMLLoader.load(getClass().getResource("/view/AddProfessorCoordFXML.fxml"));
		Parent fxmlAddDiscCoord = FXMLLoader.load(getClass().getResource("/view/AddDisciplinaCoordFXML.fxml"));
 		Parent fxmlEditDiscCoord = FXMLLoader.load(getClass().getResource("/view/EditDisciplinaCoordFXML.fxml"));
		Parent fxmlProf  = FXMLLoader.load(getClass().getResource("/view/ProfessorFXML.fxml"));
		
		
		//Scenes
		login = new Scene(fxmlLogin,800,640);
		coord = new Scene(fxmlCoord,800,640);
		addProfCoord = new Scene(fxmlAddProfCoord,800,640);
		addDiscCoord = new Scene(fxmlAddDiscCoord,800,640);
		editDiscCoord = new Scene(fxmlEditDiscCoord,800,640);
		prof  = new Scene(fxmlProf,800,640);*/
		
		/*primaryStage.setScene(login);
		
		primaryStage.setWidth(700);
		primaryStage.setHeight(440);
		primaryStage.setResizable(false);*/
		
		primaryStage.setScene(ScreenManager.getInstance().getLoginScene());
        primaryStage.setTitle("@loc System");
        
        primaryStage.setWidth(800);
        primaryStage.setHeight(534);
        primaryStage.setResizable(false);
        
        ScreenManager.getInstance().setPrimaryStage(primaryStage);
        
        primaryStage.show();
		
		
		Disciplina disc1 = new Disciplina(1,"Inteligencia Artificial2","IA","34B",60,"2018.1");
		Disciplina disc2 = new Disciplina(2,"Tópicos Avançados em Inteligencia Artificial","IA","32B",60,"2018.2");
		
		LocalTime [] horario1 = new LocalTime[2];
		
		horario1[0] = LocalTime.parse("14:00",DateTimeFormatter.ofPattern("HH:mm"));
		horario1[1] = LocalTime.parse("16:00",DateTimeFormatter.ofPattern("HH:mm"));
		
		LocalTime [] horario2 = new LocalTime[2];
		
		horario2[0] = LocalTime.parse("16:00",DateTimeFormatter.ofPattern("HH:mm"));
		horario2[1] = LocalTime.parse("18:00",DateTimeFormatter.ofPattern("HH:mm"));
		
		disc1.setHorarioDisciplina1(new HorarioDisciplina(horario1,Semana.SEGUNDA));
		disc1.setHorarioDisciplina2(new HorarioDisciplina(horario2,Semana.QUINTA));
		
		disc2.setHorarioDisciplina1(new HorarioDisciplina(horario2,Semana.QUINTA));
		disc2.setHorarioDisciplina2(new HorarioDisciplina(horario1,Semana.SEGUNDA));
		
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc1);
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc2);
		
		Professor prof2 = new Professor(1,"Henrique Nunes","123","123","IA");
		Coordenador coord = new Coordenador("José Martins","123","123");
		
		Fachada.getInstance().contProfessor().addProfessor(prof2);
		Fachada.getInstance().contCoordenador().cadastrarCoordenador(coord);
		
		primaryStage.setScene(ScreenManager.getInstance().getLoginScene());
        primaryStage.setTitle("@loc System");
        
        primaryStage.setWidth(800);
        primaryStage.setHeight(534);
        primaryStage.setResizable(false);
        
        ScreenManager.getInstance().setPrimaryStage(primaryStage);
        
        primaryStage.show();
		
		/*ScreenManager.getInstance().setPrimaryStage(primaryStage);
		
		primaryStage.show();*/
		
	}
	/*
	public static void mudarTela(Tela tela, Object dados) {
		
		switch(tela) {
			case TELA_LOGIN:
				stage.setWidth(700);
				stage.setHeight(440);
				stage.setResizable(false);
				
				stage.setScene(login);

				notificarTodosListeners(Tela.TELA_LOGIN, dados);
				break;
			
			case TELA_PROFESSOR:
				stage.setScene(prof);
				notificarTodosListeners(Tela.TELA_PROFESSOR, dados);
				break;
			
			case TELA_COORDENADOR:
				stage.setWidth(920);
				stage.setHeight(400);
				
				stage.setResizable(false);
				
				stage.setScene(coord);
				
				notificarTodosListeners(Tela.TELA_COORDENADOR, dados);
				break;
			case TELA_ADD_PROFESSOR_COORD:
				stage.setWidth(700);
				stage.setHeight(440);
				stage.setResizable(false);
				
				stage.setScene(addProfCoord);
				notificarTodosListeners(Tela.TELA_ADD_PROFESSOR_COORD, dados);
				break;
				
			case TELA_ADD_DISCIPLINA_COORD:
				
				stage.setResizable(false);
				stage.setScene(addDiscCoord);
				notificarTodosListeners(Tela.TELA_ADD_DISCIPLINA_COORD, dados);
				break;
			
			case TELA_EDIT_DISCIPLINA_COORD:
				
				stage.setResizable(false);
				stage.setScene(editDiscCoord);
				notificarTodosListeners(Tela.TELA_EDIT_DISCIPLINA_COORD, dados);
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
	}*/
	
	public static void main(String [] args) {
		AlocSystemApp.launch(args);
	}

}

