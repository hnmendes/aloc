package controller;

import beans.Disciplina;
import exceptions.DisciplinaExistenteException;
import exceptions.IdDisciplinaExistenteException;
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
	
	public boolean cadastrarDisciplina(Disciplina d) throws DisciplinaExistenteException,IdDisciplinaExistenteException{
		
		try {
			
			if(d!=null) {
				instanceRepDisciplinas.addDisciplina(d);
				return true;
			}
			
		}catch(DisciplinaExistenteException e) {
			
			e.printStackTrace();
			
		}catch(IdDisciplinaExistenteException ex) {
			
			ex.printStackTrace();
			
		}
		
		return false;
		
	}
	
	
}
