package repositorio;

import beans.Disciplina;
import exception.DisciplinaJaExisteException;
import exception.NaoEncontradoException;

public interface IRepositorioDisciplina {
	public void addDisciplina(Disciplina disciplina) throws DisciplinaJaExisteException;
	public Disciplina getDisciplina(String nome);
	public void remover(String nome) throws NaoEncontradoException;
	public Disciplina getDisciplina(int pos);
	public Disciplina[] getDisciplinaArray();
	public int getDisciplinaPos(String nome) throws NaoEncontradoException;
	public void setDisciplina(int i, Disciplina d);
}
