package repositorio;

import beans.Coordenador;

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
	 * @return int i com o posicionamento do Coordenador no Array.
	 */
	private int procurarPos(String cpf) {
		int i = 0;
        for(; i<this.coordenadoresTam; i++) {
        	if(cpf.equals(this.coordenadores[i].getCpf())) {
        		return i;
        	}
        }
        return -1;
        //TODO exception
	}
	/**
	 * Add o Coordenador no banco de Dados.
	 */
	@Override
	public void addCoordenador(Coordenador coordenador) {
		if(coordenador != null && procurarCoordenador(coordenador.getCpf()) == null) {
			if(this.coordenadoresTam == this.coordenadores.length) {
				this.duplicaArray();
			}
			this.coordenadores[coordenadoresTam] = coordenador;
			this.coordenadoresTam++;
		}
		//TODO exception
	}
	@Override
	public Coordenador getCoordenador(String cpf){
		return this.procurarCoordenador(cpf);
	}
	/**
	 * Retorna coordenador por posicao no Array 
	 * @return Coordendor pela posicao
	 * @return null caso nao encontre
	 */
	
	public Coordenador getCoordenador(int pos) {
		if(pos < this.coordenadoresTam) {
			return this.coordenadores[pos];
		}
		return null;
	}
	@Override
	public void removerCoordenador(String cpf){
		int i = this.procurarPos(cpf);
		if (i != this.coordenadoresTam) {
            this.coordenadores[i] = this.coordenadores[this.coordenadoresTam - 1];
            this.coordenadores[this.coordenadoresTam - 1] = null;
            this.coordenadoresTam = this.coordenadoresTam - 1;
        } 
		//TODO exception
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
	public int getCoordenadorPos(String cpf) {
		return this.procurarPos(cpf);
		//TODO exception
	}
	@Override
	public void setCoordenador(int i, Coordenador c) {
		coordenadores[i] = c;
	}
}
