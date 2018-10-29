package br.ufrpe.aloc.main;

import br.ufrpe.aloc.model.Professor;
import br.ufrpe.aloc.repositorio.Repositorio;
import br.ufrpe.aloc.view.Login;

/**
	@Author: rique
*/

public class Main2 {

	public static void main(String[] args) {
		
		Repositorio repo = new Repositorio();
		
		Professor teste = new Professor();
		
		teste.setId(1);
		teste.setLogin("teste");
		teste.setNome("Teste");
		teste.setSala("Sala 23");
		teste.setSenha("123");
		teste.setÁrea("IA");
		teste.setCpf("12345678910");
		
		repo.addProfessor(teste);
		
		Login loginProf = new Login();
		
		loginProf.fazerLogin(repo);
		

	}

}

