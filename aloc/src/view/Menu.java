package view;

import java.util.Scanner;

import beans.Coordenador;
import controller.Fachada;

public class Menu {
	
	private Scanner input = new Scanner(System.in);
	private Fachada f = Fachada.getInstance();
	
	public void principal() {
		
		
		int n = 0;
		
		System.out.println("----------------------------------------------------'");
		System.out.println("\n' Bem vindos ao sistema de alocação de professores. '");
		System.out.println("\n----------------------------------------------------'");
		System.out.println("\n' Digite 1 para fazer login como coordenador.       '");
		System.out.println("\n' Digite 2 para fazer cadastro como coordenador.    '");
		System.out.println("\n' Digite 3 para fazer login como professor.         '");
		System.out.println("\n' Digite 4 para fazer cadastro de professor.        '");
		System.out.println("\n' Digite 0 para sair do programa.                   '");
		System.out.println("\n----------------------------------------------------'");
		
		n = input.nextInt();
		
		this.selecionaOpcao(n);
	}
	
	
	private void limparTela() {
		for(int i = 0; i < 99; i++) {
			System.out.println("\n");
		}
	}
	
	private void fazerLoginCoordenador() {
		
		this.limparTela();
		
		int g;
		
		String login,senha;
		
		System.out.println("Digite o login, para se logar como coordenador:");
		login = this.input.next();
		System.out.println("\nDigite a senha, para se logar como coordenador:");
		senha = this.input.next();
		
		if(this.f.contCoordenador().checagemLogin(login, senha) == null) {
			this.limparTela();
			System.out.println("Usuário ou senha incorretos.");
			System.out.println("Voltar para o menu principal(1) ou tentar novamente(0) ?");
			g = input.nextInt();
			if(g == 1)
				this.principal();
			else
				this.fazerLoginCoordenador();
		}else {
			System.out.println("Logado com sucesso.");
			this.principalCoordenador(this.f.contCoordenador().checagemLogin(login, senha));
			
		}
			
		
	}
	
	private void fazerCadastroCoordenador() {
		
		Coordenador coord = new Coordenador();
		
		int g;
		
		System.out.println("Digite o nome do coordenador:");
		coord.setNome(this.input.next());
		System.out.println("Digite o cpf do coordenador:");
		coord.setCpf(this.input.next());
		System.out.println("Digite o login do coordenador:");
		coord.setLogin(this.input.next());
		System.out.println("Digite a senha do coordenador:");
		coord.setSenha(this.input.next());
		
		if(!this.f.contCoordenador().cadastrarCoordenador(coord)) {
			System.out.println("Aconteceu um erro durante o cadastro, você deseja tentar novamente(1) ou ir para o menu principal(0)?");
			g = this.input.nextInt();
			
			if(g == 0)
				this.principal();
			else
				this.fazerCadastroCoordenador();
		}else {
			System.out.println("Coordenador "+coord.getNome()+" foi cadastrado com sucesso.");
			System.out.println("Deseja criar outra conta de coordenador(1) ou voltar ao menu principal(0)?");
			g = this.input.nextInt();
			
			if(g == 0)
				this.principal();
			else
				this.fazerCadastroCoordenador();
		}
		
	}
	
	private void sair() {
		this.limparTela();
		System.out.println("Obrigado por utilizar nossos serviços...\nA equipe @loc agradece.");
		System.exit(0);
		
	}
	
	
	public void selecionaOpcao(int n) {
		
		switch(n) {
			case 1:
				this.fazerLoginCoordenador();
				break;
			
			case 2:
				this.fazerCadastroCoordenador();
				break;
			
			case 3:
				break;
				
			case 4:
				break;
				
			case 0:
				this.sair();
				break;
		}
	}
	
//	MENUS COORDENADOR
	
	public void principalCoordenador(Coordenador coord) {
		
		int g;
		
		System.out.println("-------------------------------------------------------------------------------'");
		System.out.println("\n' Bem vindo coordenador "+coord.getNome()+".                                 '");
		System.out.println("\n-----------------------------------------------------------------------------'");
		System.out.println("\n' Digite 1 para listar professores cadastrados.     						   '");
		System.out.println("\n' Digite 2 para editar um professor pelo id ou cpf. 						   '");
		System.out.println("\n' Digite 3 para listar um professor pelo id ou cpf. 						   '");
		System.out.println("\n' Digite 4 para listar disciplinas indisponíveis.   						   '");
		System.out.println("\n' Digite 5 para fazer cadastro de professor.        						   '");
		System.out.println("\n' Digite 5 para vincular diciplinas a algum professor pelo id ou cpf.        '");
		System.out.println("\n' Digite 0 para deslogar e voltar ao menu @loc.     						   '");
		System.out.println("\n-----------------------------------------------------------------------------'");
		
		g = this.input.nextInt();
		
		this.selecionaOpcao(g);
		
		
	}
	
	
	public void selecionaOpcaoCoordenador(int n) {
		
		
		switch(n) {
			
			case 1:
				//Listar professores.
				break;
			
			case 2:
				//Editar professor pelo id ou cpf.
				break;
			
			case 3:
				//Listar professor pelo id ou cpf.
				break;
			
			case 4:
				//Listar disciplinas que já foram ofertadas.
				break;
				
			case 5:
				//Vincular disciplina a algum professor pelo id ou cpf.
				break;
				
			default:
				this.principal();
				break;
		
		}
	}
	
}

