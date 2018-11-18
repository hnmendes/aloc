package exceptions;

import beans.Disciplina;

/**
	@Author: rique
*/

public class ChoqueDisciplinaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Disciplina disc;
	private Disciplina disc2;
	
	
	public ChoqueDisciplinaException(Disciplina disc, Disciplina disc2){
		super();
		this.disc = disc;
		this.disc2 = disc2;
		
	}
	
	@Override
	public String toString() {
		return "A disciplina "+disc.getNome()+" choca o horário com a disciplina "+disc2.getNome()+".";
	}

}

