package repositorio;

import beans.Disciplina;

public class RepositorioDisciplina implements IRepositorioDisciplina {
	private static RepositorioDisciplina instance;
	
	private Disciplina disciplinas[] = new Disciplina[5];
	private int disciplinasTam = 0;	
	
	public static RepositorioDisciplina getInstance() {
	    if (instance == null) {
	      instance = new RepositorioDisciplina();
	    }
	    return instance;
	}
	
	private RepositorioDisciplina() {}
	
	private Disciplina procurarDisciplina(String nome){
		for(int i = 0; i < disciplinasTam; i++) {
			if(disciplinas[i].getNome().equals(nome)) {
				return disciplinas[i];
			}
		}
		return null;
	}
	/**
	 * Retorna posicionamento no array do reposit�rio.
	 * @param nome
	 * @return int i com o posicionamento do Disciplina no Array.
	 */
	private int procurarPos(String nome){
		int i = 0;
        for(; i<this.disciplinasTam; i++) {
        	if(nome.equals(this.disciplinas[i].getNome())) {
        		return i;
        	}
        }
        return -1;
        //TODO exception
	}
	/**
	 * Add o Disciplina no banco de Dados.
	 * @throws Tratamento antes de add.
	 * @param disciplina
	 */
	@Override
	public void addDisciplina(Disciplina disciplina) {
		
		if(disciplina != null) {
			
			if(this.disciplinasTam == this.disciplinas.length) {
				this.duplicaArray();
			}
			
			this.disciplinas[disciplinasTam] = disciplina;
			this.disciplinasTam++;
		
		}
	}
	
	
	@Override
	public Disciplina getDisciplina(String nome){
		return this.procurarDisciplina(nome);
	}
	
	
	/**
	 * Retorna disciplina por posicao no Array 
	 * @return Disciplina pela posicao
	 * @return null caso nao encontre
	 */
	@Override
	public Disciplina getDisciplina(int pos) {
		if(pos < this.disciplinasTam) {
			return this.disciplinas[pos];
		}
		return null;
	}

	
	private void duplicaArray() {
        if (this.disciplinas != null && this.disciplinas.length > 0) {
        	Disciplina[] arrayDuplicado = new Disciplina[this.disciplinas.length * 2];
            for (int i = 0; i < this.disciplinas.length; i++) {
                arrayDuplicado[i] = this.disciplinas[i];
            }
            this.disciplinas = arrayDuplicado;
        }
    }
	
	public Disciplina getDisciplinaById(int id) {
		return this.procurarDisciplina(id);
	}
	
	private Disciplina procurarDisciplina(int id){
		for(int i = 0; i < disciplinasTam; i++) {
			if(disciplinas[i].getId() == id) {
				return disciplinas[i];
			}
		}
		return null;
	}
	
	@Override
	public Disciplina[] getDisciplinaArray() {
		return disciplinas;
	}
	
	
	@Override
	public int getDisciplinaPos(String nome){
		return this.procurarPos(nome);
		//TODO exception
	}
	
	
	@Override
	public void setDisciplina(int i, Disciplina d) {
		disciplinas[i] = d;
	}
	
	public void remover(String nome) {
		int i = this.procurarPos(nome);
		if (i != this.disciplinasTam) {
            this.disciplinas[i] = this.disciplinas[this.disciplinasTam - 1];
            this.disciplinas[this.disciplinasTam - 1] = null;
            this.disciplinasTam = this.disciplinasTam - 1;
        } else {
        	//TODO exception
        }
	}
}
