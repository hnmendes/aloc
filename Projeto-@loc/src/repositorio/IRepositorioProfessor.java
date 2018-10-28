package repositorio;

import beans.Professor;
import exception.PessoaJaExisteException;

public interface IRepositorioProfessor {	
	public void addProfessor(Professor professor) throws PessoaJaExisteException;	
	public Professor getProfessor(String cpf);	
	public Professor getProfessor(int pos);
	public void remover(String cpf);
	public Professor[] getProfessorArray();
}
