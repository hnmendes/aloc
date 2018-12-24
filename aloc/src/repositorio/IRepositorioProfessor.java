package repositorio;

import java.util.List;

import beans.Professor;

public interface IRepositorioProfessor {	
	public void addProfessor(Professor professor);	
	public Professor getProfessor(String cpf);	
	public Professor getProfessor(int pos);
	public void remover(String cpf);
	public List<Professor> getProfessorList();
	public Professor[] getProfessorArray();
	public Professor getProfessorById(int id);
}
