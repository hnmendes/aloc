package util;


/**
	@Author: rique
*/

public enum Horario {
	
	PRIMEIRA_AULA_MANHA(0),SEGUNDA_AULA_MANHA(1),PRIMEIRA_AULA_TARDE(2),SEGUNDA_AULA_TARDE(3),PRIMEIRA_AULA_NOITE(4),SEGUNDA_AULA_NOITE(5);
	
	private int aulaHorario;
	
	Horario(int aulaHorario){
		this.aulaHorario = aulaHorario;
	}
	
	public int getAulaHorario() {
		return this.aulaHorario;
	}
	
	public void setAulaTempo(int aulaHorario) {
		this.aulaHorario = aulaHorario;
	}
}

