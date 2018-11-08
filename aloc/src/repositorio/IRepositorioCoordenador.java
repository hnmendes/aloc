package repositorio;

import beans.Coordenador;

public interface IRepositorioCoordenador {
	public void addCoordenador(Coordenador coordenador);
	public Coordenador getCoordenador(String cpf);
	public void removerCoordenador(String cpf);
	public Coordenador getCoordenador(int pos);
	public Coordenador[] getCoordenadorArray();
	public int getCoordenadorPos(String cpf);
	public void setCoordenador(int i, Coordenador c);
}
