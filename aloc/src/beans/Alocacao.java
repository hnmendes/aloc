package beans;

import java.util.ArrayList;

/**
	@Author: rique
*/

public class Alocacao {
	
	ArrayList<Disciplina> disciplinasLecionadas;
	
	
	public Alocacao() {
		
		disciplinasLecionadas = new ArrayList<Disciplina>();
	
	}


	public ArrayList<Disciplina> getDisciplinasLecionadas() {
		return disciplinasLecionadas;
	}


	public void setDisciplinasLecionadas(ArrayList<Disciplina> disciplinasLecionadas) {
		this.disciplinasLecionadas = disciplinasLecionadas;
	}
}

