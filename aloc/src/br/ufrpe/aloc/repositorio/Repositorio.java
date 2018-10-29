package br.ufrpe.aloc.repositorio;

import java.util.ArrayList;

import br.ufrpe.aloc.model.Coordenador;
import br.ufrpe.aloc.model.Disciplina;
import br.ufrpe.aloc.model.Professor;

public class Repositorio {
	
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Coordenador> coordenadores = new ArrayList<Coordenador>();
	
//	GETTERS AND SETTERS
	
	public ArrayList<Disciplina> getDisciplinas(){
		return this.disciplinas;
	}
	
	public ArrayList<Professor> getProfessores(){
		return this.professores;
	}
	
	public ArrayList<Coordenador> getCoordenadores(){
		return this.coordenadores;
	}
	
	public void setDisciplinas(ArrayList<Disciplina> disc) {
		this.disciplinas = disc;
	}
	
	public void setCoordenadores(ArrayList<Coordenador> coord) {
		this.coordenadores = coord;
	}
	
	public void setProfessores(ArrayList<Professor> prof) {
		this.professores = prof;
	}
	
	
//	ADD AND REMOVE METHODS
	
	
	public boolean addProfessor(Professor prof) {
		
		for(Professor aux : this.professores) {
			if(aux.equals(prof)) {
				return false;
			}else {
				this.professores.add(prof);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean removeProfessor(Professor prof) {
		
		for(Professor aux : this.professores) {
			if(aux.equals(prof)) {
				this.professores.remove(prof);
				return true;
			}else {
				return false;
			}
				
		}
		
		return false;
	}
	
	
public boolean addDisciplina(Disciplina disc) {
		
		for(Disciplina aux : this.disciplinas) {
			if(aux.equals(disc)) {
				return false;
			}else {
				this.disciplinas.add(disc);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean removeDisciplina(Disciplina disc) {
		
		for(Disciplina aux : this.disciplinas) {
			if(aux.equals(disc)) {
				this.disciplinas.remove(disc);
				return true;
			}else {
				return false;
			}
				
		}
		
		return false;
	}
	
public boolean addCoordenador(Coordenador coord) {
		
		for(Coordenador aux : this.coordenadores) {
			if(aux.equals(coord)) {
				return false;
			}else {
				this.coordenadores.add(coord);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean removeCoordenador(Coordenador coord) {
		
		for(Coordenador aux : this.coordenadores) {
			if(aux.equals(coord)) {
				this.coordenadores.remove(coord);
				return true;
			}else {
				return false;
			}
				
		}
		
		return false;
	}
}

