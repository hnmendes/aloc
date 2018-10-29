package br.ufrpe.aloc.model;


public class Coordenador extends Pessoa{
	
	private String senha;
	
	private String login;
	
	
//	GETTERS AND SETTERS
	
	public String getSenha() {
		return senha;
	}

	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public String getLogin() {
		return login;
	}

	
	public void setLogin(String login) {
		this.login = login;
	}
	
}

