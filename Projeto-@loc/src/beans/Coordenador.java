package beans;

public class Coordenador extends Pessoa{
	private String login;
	private String senha;
	
	public Coordenador(String nome, String cpf) {
		super.setNome(nome);
		super.setCpf(cpf);
	}
	
	public Coordenador (Pessoa p) {
		this(p.getNome(),p.getCpf());
	}
	
	public Coordenador(Pessoa p, String login, String senha) {
		this(p);
		this.login=login;
		this.senha=senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}	
	
	public boolean equals(Coordenador c) {	
		//Precisa verificar se a senha e login tbm sao iguais?? 
		//Acho que não, já que cada pessoa só tem um login e senha, se o pessoa é igual, login e senha serão iguais tbm
		if(c !=null && super.equals(c)) {
			return true;
		}
		return false;
	}
}
