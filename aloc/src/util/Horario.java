package util;


/**
	@Author: rique
*/

public enum Horario {
	
	PrimeiraAulaManha(0),SegundaAulaManha(1),PrimeiraAulaTarde(2),SegundaAulaTarde(3),PrimeiraAulaNoite(4),SegundaAulaNoite(5);
	
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

