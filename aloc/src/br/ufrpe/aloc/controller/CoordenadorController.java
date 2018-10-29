package br.ufrpe.aloc.controller;

import br.ufrpe.aloc.model.Coordenador;
import br.ufrpe.aloc.repositorio.Repositorio;

public class CoordenadorController {
	
	
//	Metodo para fazer login como um coordenador.
	public boolean loginCoordenador(String login, String senha, Repositorio repo) {
		
		for(Coordenador aux : repo.getCoordenadores()) {
			if(aux.getLogin().equals(login) && aux.getSenha().equals(senha)) {
				return true;
			}
		}
		
		return false;
	}
	
//	Metodo para cadastrar um professor.
	public boolean registraCoordenador(Coordenador coord, Repositorio repo) {
		
		if(repo.addCoordenador(coord)) {
			return true;
		}
		
		return false;
	}
}

