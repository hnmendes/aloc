package repositorio;

import beans.Disciplina;
import exceptions.DisciplinaExistenteException;
import exceptions.IdDisciplinaExistenteException;

public interface IRepositorioDisciplina {
	public void addDisciplina(Disciplina disciplina) throws DisciplinaExistenteException,IdDisciplinaExistenteException;
	public Disciplina getDisciplina(String nome);
	public void remover(String nome);
	public Disciplina getDisciplina(int pos);
	public Disciplina getDisciplinaById(int id);
	public Disciplina[] getDisciplinaArray();
	public int getDisciplinaPos(String nome);
	public void setDisciplina(int i, Disciplina d);
}
