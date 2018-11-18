package Main;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import beans.Disciplina;
import exceptions.ChoqueDisciplinaException;
import util.Semana;
import view.Menu;

public class Main {
	public static void main(String[] args) throws ChoqueDisciplinaException {
		
//		Menu m = new Menu();
		
//		m.principal();
		
		
		Disciplina disc = new Disciplina("Programação 2","Ciclo-Básico",60);
		
		disc.getHorario1Disciplina().setDia(0);
		disc.getHorario2Disciplina().setDia(4);
		
		disc.getHorario1Disciplina().setPrimeiroHorario("14","00");
		disc.getHorario1Disciplina().setSegundoHorario("16","00");
		
		disc.getHorario2Disciplina().setPrimeiroHorario("16", "00");
		disc.getHorario2Disciplina().setSegundoHorario("18", "00");
		
//		System.out.println(disc.toString()+"\n\n\n");
		
		
		Disciplina disc2 = new Disciplina("Mineração de Texto","Optativa",60);
		
		disc2.getHorario1Disciplina().setDia(1);
		disc2.getHorario2Disciplina().setDia(2);
		
		disc2.getHorario1Disciplina().setPrimeiroHorario("14","00");
		disc2.getHorario1Disciplina().setSegundoHorario("16","00");
		
		disc2.getHorario2Disciplina().setPrimeiroHorario("16", "00");
		disc2.getHorario2Disciplina().setSegundoHorario("18", "00");
		
		disc2.setOfertada(true);
		
		System.out.println(disc2.choqueDisciplina(disc));
		
		
	}
}
