package controller;

import beans.Disciplina;
import exceptions.DisciplinaExistenteException;
import repositorio.IRepositorioDisciplina;

public class ControladorDeDisciplinas {
	
	private IRepositorioDisciplina instanceRepDisciplinas;
	
	public ControladorDeDisciplinas(IRepositorioDisciplina instanceRepDisciplinas) {
		this.instanceRepDisciplinas = instanceRepDisciplinas;
	}
	
	
	public Disciplina[] getDisciplinaArray() {
		return instanceRepDisciplinas.getDisciplinaArray();
	}
	
	public Disciplina getDisciplinaById(int id) {
		
		if(id != 0) {
			return instanceRepDisciplinas.getDisciplinaById(id);
		}
		
		return null;
	}
	
	public boolean cadastrarDisciplina(Disciplina d) throws DisciplinaExistenteException{
		
		if(d!=null && this.instanceRepDisciplinas.getDisciplina(d.getNome()) != null) {
			instanceRepDisciplinas.addDisciplina(d);
			return true;
		}else {
			throw new DisciplinaExistenteException(d);
		}
	}
	
	
}
