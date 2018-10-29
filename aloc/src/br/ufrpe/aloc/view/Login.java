package br.ufrpe.aloc.view;

import java.util.Scanner;

import br.ufrpe.aloc.controller.CoordenadorController;
import br.ufrpe.aloc.controller.ProfessorController;
import br.ufrpe.aloc.repositorio.Repositorio;

public class Login {
	
	
	private Scanner input;

	public void fazerLogin(Repositorio repo) {

		input = new Scanner(System.in);
		String aux = new String();
		
		System.out.println("Bem vindo ao @loc.");
		System.out.println("Você gostaria de se logar como coordenador ou professor?");
		
		aux = input.nextLine();
		
		switch(aux) {
			
			case "professor":
				ProfessorController prof = new ProfessorController();
				
				String lp,sp = new String();
				
				System.out.println("\n\n\n\n\nDigite o login de professor:");
				lp = input.nextLine();
				
				System.out.println("Digite a senha de professor:");
				sp = input.nextLine();
				
				if(prof.loginProfessor(lp, sp, repo))
					System.out.println("Logado com sucesso.");
				else
					System.out.println("Usuário ou senha incorretos, ou esse usuário não existe.");
				
				break;
				
			case "coordenador":
				
				CoordenadorController coord = new CoordenadorController();
				
				String lc,sc = new String();
				
				System.out.println("\n\n\n\n\nDigite o login de coordenador:");
				lc = input.nextLine();
				
				System.out.println("Digite a senha de coordenador:");
				sc = input.nextLine();
				
				if(coord.loginCoordenador(lc, sc, repo))
					System.out.println("Logado com sucesso.");
				else
					System.out.println("Usuário ou senha incorretos, ou esse usuário não existe.");
				
				break;
				
			default:
				System.out.println("Opção inválida.");
				break;
		}
	}
}

