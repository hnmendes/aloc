package system;


import org.joda.time.LocalTime;
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
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Disciplina disc1 = new Disciplina(1,"Inteligencia Artificial2","IA","34B",60,"2018.1");
		Disciplina disc2 = new Disciplina(2,"Tópicos Avançados em Inteligencia Artificial","IA","32B",60,"2018.2");
		
		LocalTime [] horario1 = new LocalTime[2];
		disc1.setOfertada(true);
		horario1[0] = LocalTime.parse("14:00");
		horario1[1] = LocalTime.parse("16:00");
		
		LocalTime [] horario2 = new LocalTime[2];
		
		horario2[0] = LocalTime.parse("16:00");
		horario2[1] = LocalTime.parse("18:00");
		
		disc1.setHorarioDisciplina1(new HorarioDisciplina(horario1,Semana.SEGUNDA));
		disc1.setHorarioDisciplina2(new HorarioDisciplina(horario2,Semana.QUINTA));
		
		disc2.setHorarioDisciplina1(new HorarioDisciplina(horario2,Semana.QUINTA));
		disc2.setHorarioDisciplina2(new HorarioDisciplina(horario1,Semana.SEGUNDA));
		
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc1);
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc2);
		
		Professor prof2 = new Professor(1,"Henrique Nunes","123","123","IA");
		Coordenador coord = new Coordenador("José Martins","123","123");
		
		
//		prof2.setDisciplina1(disc1);
//		prof2.setDisciplina2(disc2);
		
		Fachada.getInstance().contProfessor().addProfessor(prof2);
		Fachada.getInstance().contCoordenador().cadastrarCoordenador(coord);
		
		primaryStage.setScene(ScreenManager.getInstance().getLoginScene());
        primaryStage.setTitle("@loc System");
        
        primaryStage.setWidth(800);
        primaryStage.setHeight(534);
        primaryStage.setResizable(false);
        
        ScreenManager.getInstance().setPrimaryStage(primaryStage);
        
        primaryStage.show();
		
	}
	
	public static void main(String [] args) {
		AlocSystemApp.launch(args);
	}

}

