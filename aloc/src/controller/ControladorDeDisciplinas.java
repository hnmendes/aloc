package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import beans.Disciplina;
import exceptions.ChoqueDisciplinaException;
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
	
	
	public List<Disciplina> getDisciplinaList(){
		
		List<Disciplina> discs = Arrays.asList(this.getDisciplinaArray());
		
		discs = discs.stream()
				.filter(d -> d != null)
				.collect(Collectors.toList());
		
		return discs;
	}
	
	
	public Disciplina getDisciplinaById(int id) {
		
		if(id != 0) {
			return instanceRepDisciplinas.getDisciplinaById(id);
		}
		
		return null;
	}
	
	public boolean cadastrarDisciplina(Disciplina d) throws IdDisciplinaExistenteException{
		
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
	
	/*
	public void cadastrarDisciplina(Disciplina d) throws IdDisciplinaExistenteException{
		
		if(this.instanceRepDisciplinas.getDisciplinaById(d.getId()) == null) {
			this.getDisciplinaList().add(d);
		}else
	}*/
	
	public Disciplina getDisciplinaByNome(String nome) {
		for(Disciplina aux : this.getDisciplinaList()) {
			if(aux.getNome().equals(nome)) {
				return aux;
			}
		}
		
		return null;
	}
	
	public void removerDisciplina(String nome) {
		this.instanceRepDisciplinas.remover(nome);
	}
	
	public boolean disciplinaChocaHorarioAdd(Disciplina disc) throws ChoqueDisciplinaException {
		
		for(Disciplina aux : this.getDisciplinaList()) {
			
			if(aux.choqueDisciplina(disc)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean disciplinaChocaHorarioEdit(Disciplina disc) throws ChoqueDisciplinaException {
		
		for(Disciplina aux : this.getDisciplinaList()) {
			
			if(aux.getOfertada()) {
				
				if(!disc.equals(aux) && disc.choqueDisciplina(aux)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
