package exceptions;

import beans.Disciplina;

/**
	@Author: rique
*/

public class DisciplinaExistenteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Disciplina disc;
	
	public DisciplinaExistenteException(Disciplina disc) {
		this.disc = disc;
	}
	
	@Override
	public String toString() {
		
		return "A disciplina "+this.disc.getNome()+" já está cadastrada, por favor insira outro nome.";
	}
}

