package controller;
import beans.Disciplina;
import beans.Professor;
import exceptions.ChoqueDisciplinaException;
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
	
	//Retorna true se as disciplinas não tiverem sido preenchidas
	private boolean checaDuasDisciplinasDisponiveis(Professor prof) {
			
		if(prof.getDisciplina1() == null && prof.getDisciplina2() == null) {
			return true;
		}
			
		return false;
	}
	
	//Retorna true se a disciplina 1 não tiver sido preenchida 
	private boolean checaDisciplina1Disponivel(Professor prof) {
		
		return (prof.getDisciplina1() == null) ? true: false;
	}
	
	//Retorna true se a discipina 2 não tiver sido preenchida
	private boolean checaDisciplina2Disponivel(Professor prof) {
		
		return (prof.getDisciplina2() == null) ? true: false;
		
	}
	
	//Retorna true se as duas disciplinas passadas por parâmetro foram adicionadas com sucesso
	public boolean addDisciplinas(Disciplina disc1, Disciplina disc2, Professor prof) throws ChoqueDisciplinaException {
		
		if(this.checaDuasDisciplinasDisponiveis(prof)) {
			
			prof.setDisciplina1(disc1);

			if(prof.getDisciplina1().choqueDisciplina(disc2) == false) {
				prof.setDisciplina2(disc2);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean addDisciplina1(Disciplina disc, Professor prof) throws ChoqueDisciplinaException {
		
		if(this.checaDisciplina1Disponivel(prof)) {
			if(this.checaDisciplina2Disponivel(prof)) {
				prof.setDisciplina1(disc);
				return true;
			}else {
				if(prof.getDisciplina2().choqueDisciplina(disc) == false) {
					prof.setDisciplina1(disc);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean addDisciplina2(Disciplina disc, Professor prof) throws ChoqueDisciplinaException{
			
		if(this.checaDisciplina2Disponivel(prof)) {
			if(this.checaDisciplina1Disponivel(prof)) {
				prof.setDisciplina2(disc);
				return true;
			}else {
				if(prof.getDisciplina1().choqueDisciplina(disc) == false) {
					prof.setDisciplina2(disc);
					return true;
				}
			}
		}
		
		return false;
	}
}
