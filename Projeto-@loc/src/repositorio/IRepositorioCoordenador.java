package repositorio;

import beans.Coordenador;
import exception.NaoEncontradoException;
import exception.PessoaJaExisteException;

public interface IRepositorioCoordenador {
	public void addCoordenador(Coordenador coordenador) throws PessoaJaExisteException;
	public Coordenador getCoordenador(String cpf);
	public void remover(String cpf) throws NaoEncontradoException;
	public Coordenador getCoordenador(int pos);
	public Coordenador[] getCoordenadorArray();
	public int getCoordenadorPos(String cpf) throws NaoEncontradoException;
	public void setCoordenador(int i, Coordenador c);
}
