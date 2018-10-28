package repositorio;

import beans.Coordenador;
import exception.NaoEncontradoException;
import exception.PessoaJaExisteException;

public class RepositorioCoordenador implements IRepositorioCoordenador {
	private static RepositorioCoordenador instance;
	
	private Coordenador coordenadores[] = new Coordenador[5];
	private int coordenadoresTam = 0;
	
	
	public static RepositorioCoordenador getInstance() {
	    if (instance == null) {
	      instance = new RepositorioCoordenador();
	    }
	    return instance;
	}
	private RepositorioCoordenador() {}
	private Coordenador procurarCoordenador(String cpf){
		for(int i = 0; i < coordenadoresTam; i++) {
			if(coordenadores[i].getCpf().equals(cpf)) {
				return coordenadores[i];
			}
		}
		return null;
	}
	/**
	 * Retorna posicionamento no array do repositório.
	 * @param cpf
	 * @return int i com o posicionamento do Funcionário no Array.
	 * @throws NaoEncontradoException é lançado quando o Funcionario não foi encontrado no Array.
	 */
	private int procurarPos(String cpf) throws NaoEncontradoException{
		int i = 0;
        for(; i<this.coordenadoresTam; i++) {
        	if(cpf.equals(this.coordenadores[i].getCpf())) {
        		return i;
        	}
        }
        throw new NaoEncontradoException("Funcionario");
	}
	/**
	 * Add o Funcionario no banco de Dados.
	 * @throws FuncionarioJaExisteException;
	 */
	@Override
	public void addCoordenador(Coordenador coordenador) throws PessoaJaExisteException{
		if(coordenador != null && procurarCoordenador(coordenador.getCpf()) == null) {
			if(this.coordenadoresTam == this.coordenadores.length) {
				this.duplicaArray();
			}
			this.coordenadores[coordenadoresTam] = coordenador;
			this.coordenadoresTam++;
		}else {
			throw new PessoaJaExisteException(coordenador.getCpf());
		}
	}
	@Override
	public Coordenador getCoordenador(String cpf){
		return this.procurarCoordenador(cpf);
	}
	/**
	 * Retorna funcionario por posicao no Array 
	 * @return Funcionario pela posicao
	 * @return null caso nao encontre
	 */
	@Override
	public Coordenador getCoordenador(int pos) {
		if(pos < this.coordenadoresTam) {
			return this.coordenadores[pos];
		}
		return null;
	}
	@Override
	public void remover(String cpf) throws NaoEncontradoException {
		int i = this.procurarPos(cpf);
		if (i != this.coordenadoresTam) {
            this.coordenadores[i] = this.coordenadores[this.coordenadoresTam - 1];
            this.coordenadores[this.coordenadoresTam - 1] = null;
            this.coordenadoresTam = this.coordenadoresTam - 1;
        } else {
        	throw new NaoEncontradoException("Coordenador");
        }
	}
	private void duplicaArray() {
        if (this.coordenadores != null && this.coordenadores.length > 0) {
        	Coordenador[] arrayDuplicado = new Coordenador[this.coordenadores.length * 2];
            for (int i = 0; i < this.coordenadores.length; i++) {
                arrayDuplicado[i] = this.coordenadores[i];
            }
            this.coordenadores = arrayDuplicado;
        }
    }
	@Override
	public Coordenador[] getCoordenadorArray() {
		return coordenadores;
	}
	@Override
	public int getCoordenadorPos(String cpf) throws NaoEncontradoException {
		return this.procurarPos(cpf);
	}
	@Override
	public void setCoordenador(int i, Coordenador c) {
		coordenadores[i] = c;
	}
}
