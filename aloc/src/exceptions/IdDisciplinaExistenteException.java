package exceptions;

import beans.Disciplina;

/**
	@Author: rique
*/

public class IdDisciplinaExistenteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Disciplina disc;
	
	public IdDisciplinaExistenteException(Disciplina disc) {
		this.disc = disc;
	}
	
	@Override
	public String toString() {
		
		return "O id "+this.disc.getId()+" já está cadastrado, por favor insira outro id.";
	}
}

