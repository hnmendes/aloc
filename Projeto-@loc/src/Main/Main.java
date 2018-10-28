package Main;

import beans.Coordenador;
import beans.Disciplina;
import beans.Pessoa;
import beans.Professor;

public class Main {
	public static void main(String[] args) {
		Pessoa p = new Pessoa("Giuliane","12345678901");
		Disciplina d = new Disciplina("Prog","ENSISO");
		Professor prof = new Professor(p,d);	
		Coordenador c = new Coordenador(p);
		System.out.println(p.toString());
		System.out.println(d.toString());
		System.out.println(prof.toString());
		System.out.println(c.toString());
	}
}
