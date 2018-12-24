package beans;

import javafx.beans.property.StringProperty;

public abstract class Pessoa {
	
	private String nome;
	private String senha;
	private String cpf;
	
	private StringProperty nomeProperty;
	private StringProperty senhaProperty;
	private StringProperty cpfProperty;
	
	public Pessoa() {}
	
	public Pessoa(String nome,String cpf) {
		this.nome=nome;
		this.cpf=cpf;
	}

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
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "\nNome: "+this.getNome() +"\nCPF: "+this.getCpf();
	}
	
	@Override
	public boolean equals(Object p) {
		if(p !=null && p instanceof Pessoa) {
			if(this.getNome().equals(((Pessoa)p).getNome()) && 
			   this.getCpf().equals(((Pessoa)p).getCpf()) &&
			   this.getSenha().equals(((Pessoa)p).getSenha())) {
				   
				   return true;
			}
		}
		return false;
	}

	public StringProperty getNomeProperty() {
		return nomeProperty;
	}

	public void setNomeProperty(StringProperty nomeProperty) {
		this.nomeProperty = nomeProperty;
	}

	public StringProperty getSenhaProperty() {
		return senhaProperty;
	}

	public void setSenhaProperty(StringProperty senhaProperty) {
		this.senhaProperty = senhaProperty;
	}

	public StringProperty getCpfProperty() {
		return cpfProperty;
	}

	public void setCpfProperty(StringProperty cpfProperty) {
		this.cpfProperty = cpfProperty;
	}
}
