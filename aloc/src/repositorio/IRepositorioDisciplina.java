package repositorio;

import beans.Disciplina;

public interface IRepositorioDisciplina {
	public void addDisciplina(Disciplina disciplina);
	public Disciplina getDisciplina(String nome);
	public void remover(String nome);
	public Disciplina getDisciplina(int pos);
	public Disciplina[] getDisciplinaArray();
	public int getDisciplinaPos(String nome);
	public void setDisciplina(int i, Disciplina d);
}
