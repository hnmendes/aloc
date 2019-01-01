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
		
		Disciplina disc1 = new Disciplina(1,"Inteligencia Artificial","IA","34B",60,"2018.1");
		Disciplina disc2 = new Disciplina(2,"Tópicos Avançados em Inteligencia Artificial","IA","32B",60,"2018.1");
		
		Disciplina disc3 = new Disciplina(1,"Redes","Infra","34B",60,"2018.2");
		Disciplina disc4 = new Disciplina(2,"Sistemas Operacionais","Infra","32B",60,"2018.2");
		
		disc1.setOfertada(false);
		disc2.setOfertada(false);
		
		disc3.setOfertada(true);
		disc4.setOfertada(true);
		
		LocalTime [] horario1 = new LocalTime[2];
		horario1[0] = LocalTime.parse("14:00");
		horario1[1] = LocalTime.parse("16:00");
		
		LocalTime [] horario2 = new LocalTime[2];
		
		horario2[0] = LocalTime.parse("16:00");
		horario2[1] = LocalTime.parse("18:00");
		
		disc1.setHorarioDisciplina1(new HorarioDisciplina(horario1,Semana.SEGUNDA));
		disc1.setHorarioDisciplina2(new HorarioDisciplina(horario2,Semana.QUINTA));
		
		disc2.setHorarioDisciplina1(new HorarioDisciplina(horario2,Semana.QUINTA));
		disc2.setHorarioDisciplina2(new HorarioDisciplina(horario1,Semana.SEGUNDA));
		
		disc3.setHorarioDisciplina1(new HorarioDisciplina(horario2,Semana.TERCA));
		disc3.setHorarioDisciplina2(new HorarioDisciplina(horario1,Semana.SEXTA));
		
		disc4.setHorarioDisciplina1(new HorarioDisciplina(horario2,Semana.QUINTA));
		disc4.setHorarioDisciplina2(new HorarioDisciplina(horario1,Semana.SEXTA));
		
		
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc1);
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc2);
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc3);
		Fachada.getInstance().contDisciplinas().cadastrarDisciplina(disc4);

		
		Professor prof2 = new Professor(1,"Gustavo Rodrigues","123.456.789-10","123","IA","2018.1");
		Professor prof3 = new Professor(2,"Marcone José","123.478.123-45","123","Infra","2018.1");
		Coordenador coord = new Coordenador("Cleiton Martins","123.764.234-78","123");
		
		
		prof2.setDisciplina1(disc1);
		prof2.setDisciplina2(disc2);
		
		Fachada.getInstance().contProfessor().addProfessor(prof2);
		Fachada.getInstance().contProfessor().addProfessor(prof3);
		Fachada.getInstance().contCoordenador().cadastrarCoordenador(coord);
		
		primaryStage.setScene(ScreenManager.getInstance().getLoginScene());
        primaryStage.setTitle("@loc System");
        
        primaryStage.setWidth(700);
        primaryStage.setHeight(440);
        primaryStage.setResizable(false);
        
        ScreenManager.getInstance().setPrimaryStage(primaryStage);
        
        primaryStage.setResizable(false);

        primaryStage.show();
		
	}
	
	public static void main(String [] args) {
		AlocSystemApp.launch(args);
	}

}

