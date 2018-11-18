package beans;

public abstract class Pessoa {
	
	private String nome;
	private String login;
	private String senha;
	private String cpf;
	
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
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) {
		this.login = login;
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
			   this.getLogin().equals(((Pessoa)p).getLogin()) &&
			   this.getSenha().equals(((Pessoa)p).getSenha())) {
				   
				   return true;
			}
		}
		return false;
	}
}
