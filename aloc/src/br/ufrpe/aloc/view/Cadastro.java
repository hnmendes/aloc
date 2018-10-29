package br.ufrpe.aloc.view;

import java.util.Scanner;

import br.ufrpe.aloc.repositorio.Repositorio;

public class Cadastro {
	
	
	private Scanner input;

	public void cadastro(Repositorio repo) {
		
		input = new Scanner(System.in);
		
		System.out.println("Bem vindo ao cadastro do @aloc.");
		
		System.out.println("Deseja cadastrar professor ou coordenador?");
		
		
	}
}

