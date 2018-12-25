package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public void removerDisciplina(String nome) {
		this.instanceRepDisciplinas.remover(nome);
	}
	
	
}
