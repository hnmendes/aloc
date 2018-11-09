package repositorio;

import beans.Professor;

public interface IRepositorioProfessor {	
	public void addProfessor(Professor professor);	
	public Professor getProfessor(String cpf);	
	public Professor getProfessor(int pos);
	public void remover(String cpf);
	public Professor[] getProfessorArray();
	public Professor getProfessorById(int id);
}
