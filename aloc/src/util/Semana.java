package util;


/**
	@Author: rique
*/

public enum Semana {
	
	Segunda(0),Terça(1),Quarta(2),Quinta(3),Sexta(4);
	
	
	private int dia;
	private Horario horario;
	
	Semana(int dia){
		this.dia = dia;
	}
	
	public int getDia() {
		return this.dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public void addHorario(int x) {
		horario.setAulaTempo(x);
	}
	
	public Horario getHorario() {
		return this.horario;
	}
	
}

