package repositorio;

import beans.Disciplina;
import exception.DisciplinaJaExisteException;
import exception.NaoEncontradoException;

public class RepositorioDisciplina implements IRepositorioDisciplina{
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
	 * Retorna posicionamento no array do repositório.
	 * @param cpf
	 * @return int i com o posicionamento do Funcionário no Array.
	 * @throws NaoEncontradoException é lançado quando o Funcionario não foi encontrado no Array.
	 */
	private int procurarPos(String nome) throws NaoEncontradoException{
		int i = 0;
        for(; i<this.disciplinasTam; i++) {
        	if(nome.equals(this.disciplinas[i].getNome())) {
        		return i;
        	}
        }
        throw new NaoEncontradoException("Disciplina");
	}
	/**
	 * Add o Funcionario no banco de Dados.
	 * @throws FuncionarioJaExisteException;
	 */
	@Override
	public void addDisciplina(Disciplina disciplina) throws DisciplinaJaExisteException{
		if(disciplina != null && procurarDisciplina(disciplina.getNome()) == null) {
			if(this.disciplinasTam == this.disciplinas.length) {
				this.duplicaArray();
			}
			this.disciplinas[disciplinasTam] = disciplina;
			this.disciplinasTam++;
		}else {
			throw new DisciplinaJaExisteException(disciplina.getNome());
		}
	}
	@Override
	public Disciplina getDisciplina(String nome){
		return this.procurarDisciplina(nome);
	}
	/**
	 * Retorna funcionario por posicao no Array 
	 * @return Funcionario pela posicao
	 * @return null caso nao encontre
	 */
	@Override
	public Disciplina getDisciplina(int pos) {
		if(pos < this.disciplinasTam) {
			return this.disciplinas[pos];
		}
		return null;
	}
	@Override
	public void remover(String nome) throws NaoEncontradoException {
		int i = this.procurarPos(nome);
		if (i != this.disciplinasTam) {
            this.disciplinas[i] = this.disciplinas[this.disciplinasTam - 1];
            this.disciplinas[this.disciplinasTam - 1] = null;
            this.disciplinasTam = this.disciplinasTam - 1;
        } else {
        	throw new NaoEncontradoException("Disciplina");
        }
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
	@Override
	public Disciplina[] getDisciplinaArray() {
		return disciplinas;
	}
	@Override
	public int getDisciplinaPos(String nome) throws NaoEncontradoException {
		return this.procurarPos(nome);
	}
	@Override
	public void setDisciplina(int i, Disciplina d) {
		disciplinas[i] = d;
	}
}
