package repositorio;

import beans.Professor;
import exception.PessoaJaExisteException;

public class RepositorioProfessor implements IRepositorioProfessor{
	
private static RepositorioProfessor instance;	
	private Professor professores[] = new Professor[5];
	private int professorTam = 0;
	
	
	public static RepositorioProfessor getInstance() {
	    if (instance == null) {
	      instance = new RepositorioProfessor();
	    }
	    return instance;
	}
	private RepositorioProfessor() {}
	private Professor procurarProfessor(String cpf){
		for(int i = 0; i < professorTam; i++) {
			if(professores[i].getCpf().equals(cpf)) {
				return professores[i];
			}
		}
		return null;
	}
	private int procurarPos(String cpf) {
		int i = 0;
        for(; i<this.professorTam; i++) {
        	if(cpf.equals(this.professores[i].getCpf())) {
        		return i;
        	}
        }
        return professorTam;
	}
	/**
	 * Add o Funcionario no banco de Dados.
	 * @throws FuncionarioJaExisteException;
	 */
	@Override
	public void addProfessor(Professor professor) throws PessoaJaExisteException{
		if(professor != null && procurarProfessor(professor.getCpf()) == null) {
			if(this.professorTam == this.professores.length) {
				this.duplicaArray();
			}
			this.professores[professorTam] = professor;
			this.professorTam++;
		}else {
			throw new PessoaJaExisteException(professor.getCpf());
		}
	}
	@Override
	public Professor getProfessor(String cpf){
		return this.procurarProfessor(cpf);
	}
	/**
	 * Retorna funcionario por posicao no Array 
	 * @return Funcionario pela posicao
	 * @return null caso nao encontre
	 */
	@Override
	public Professor getProfessor(int pos) {
		if(pos < this.professorTam) {
			return this.professores[pos];
		}
		return null;
	}
	@Override
	public void remover(String cpf) {
		int i = this.procurarPos(cpf);
		if (i != this.professorTam) {
            this.professores[i] = this.professores[this.professorTam - 1];
            this.professores[this.professorTam - 1] = null;
            this.professorTam = this.professorTam - 1;
        } else {
        	//TODO exception
        }
	}
	private void duplicaArray() {
        if (this.professores != null && this.professores.length > 0) {
        	Professor[] arrayDuplicado = new Professor[this.professores.length * 2];
            for (int i = 0; i < this.professores.length; i++) {
                arrayDuplicado[i] = this.professores[i];
            }
            this.professores = arrayDuplicado;
        }
    }
	@Override
	public Professor[] getProfessorArray() {
		return professores;
	}
	
}
