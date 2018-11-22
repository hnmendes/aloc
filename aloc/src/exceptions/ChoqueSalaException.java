package exceptions;

import beans.Sala;

public class ChoqueSalaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Sala sala1;
	private Sala sala2;

	
	public ChoqueSalaException(Sala sala1, Sala sala2) {
		super();
		this.sala1 = sala1;
		this.sala2 = sala2;
	}
	
	public String toString() {
		return "A Sala " + sala1.getNomeSala() + "Há um choque de Sala com " + sala2.getNomeSala();
	}
	
}
