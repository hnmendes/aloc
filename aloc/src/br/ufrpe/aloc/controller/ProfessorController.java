package br.ufrpe.aloc.controller;

import br.ufrpe.aloc.model.Disciplina;
import br.ufrpe.aloc.model.Professor;
import br.ufrpe.aloc.repositorio.Repositorio;

public class ProfessorController {
	
//	Metodo para fazer login com um professor.
	public boolean loginProfessor(String login, String senha, Repositorio repo) {
		
		for(Professor aux : repo.getProfessores()) {
			if(aux.getLogin().equals(login) && aux.getSenha().equals(senha)) {
				return true;
			}
		}
		
		return false;
	}
	
//	Metodo para cadastrar um professor.
	public boolean registraProfessor(Professor prof, Repositorio repo) {
		
		if(repo.addProfessor(prof)) {
			return true;
		}
		
		return false;
	}
	
//	Metodo para adicionar a disciplina 1 do professor.
	public boolean addDisciplina1Professor(Professor prof, Disciplina disc1) {
		
		//Falta implementar regra de negócio para checar se a disciplina bate horário.
		
		if(prof.getDisciplina1() == null) {
			prof.setDisciplina1(disc1);
			return true;
		}
		
		return false;
	}
	
//	Metodo para adicionar a disciplina 2 do professor.
	public boolean addDisciplina2Professor(Professor prof, Disciplina disc2) {
		
		//Falta implementar regra de negócio para checar se a disciplina bate horário.
		
		if(prof.getDisciplina2() == null) {
			prof.setDisciplina2(disc2);
			return true;
		}
		
		return false;
	}
	
}

