package controller;
import beans.Professor;
import repositorio.IRepositorioProfessor;

public class ControladorDeProfessor {
	
	private IRepositorioProfessor instanceRepProfessor;
	
	public ControladorDeProfessor(IRepositorioProfessor instanceRepProfessor) {
		this.instanceRepProfessor = instanceRepProfessor;
	}

	/**
	 * Adiciona professor
	 */
	public void addProfessor(Professor professor) {
		if(professor!=null && professor.getCpf() != null && professor.getLogin() != null 
				&& professor.getNome() != null && professor.getSenha() != null) {
			instanceRepProfessor.addProfessor(professor);
		}
		//TODO exception
	}
	/**
	 * @param String cpf
	 * @return Professor
	 */
	public Professor getProfessor(String cpf, int id) {
		if(cpf != null) {
			if(instanceRepProfessor.getProfessor(cpf)!=null) {
				return instanceRepProfessor.getProfessor(cpf);
			}
		}else if(id != 0) {
			if(instanceRepProfessor.getProfessorById(id) != null) {
				return instanceRepProfessor.getProfessorById(id);
			}
		}
		//TODO exception
		return null;
	}
	/**
	 * Remove um professor do banco de dados de acordo com o seu CPF.
	 * @param cpf
	 */
	public void remover(String cpf){
		if(cpf != null) {
			instanceRepProfessor.remover(cpf);
		}
		//TODO exception
	}
	/**
	 * Retorna Professor de acordo com a posicao enviada como parametro
	 * @param pos
	 * @return Professor
	 */
	public Professor getProfessor(int pos){
		if(instanceRepProfessor.getProfessor(pos)!=null) {
			return instanceRepProfessor.getProfessor(pos);
		}
		return null;
		//TODO exception
	}
	/**
	 * retorna todo o array de professor do reposit�rio.
	 * @return Professor[]
	 */
	public Professor[] getProfessorArray() {
		return instanceRepProfessor.getProfessorArray();
	}
	
	//Retorna true se não chocar, false se estiver indisponível.
	public boolean checaDuasDisciplinasDisponiveis(Professor prof) {
			
		if(prof.getDisciplina1() == null && prof.getDisciplina2() == null) {
			return true;
		}
			
		return false;
	}
}
