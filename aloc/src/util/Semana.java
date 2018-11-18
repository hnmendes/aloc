package util;


/**
	@Author: rique
*/

public enum Semana {
	
	SEGUNDA(0),TERCA(1),QUARTA(2),QUINTA(3),SEXTA(4);
	
	private int dia;
	
	Semana(int dia){
		this.dia = dia;
	}
	
	public int getDia() {
		return this.dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
}

