package br.ufrpe.aloc.model;


public abstract class Pessoa {
	
	private String nome;
	
	private String cpf;

	
//	GETTERS AND SETTERS
	
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		
		return "Nome: "+this.nome+"\nCpf: "+this.cpf;
	}
	
	
}

