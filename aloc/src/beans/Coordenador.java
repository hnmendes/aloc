package beans;

public class Coordenador extends Pessoa{
	
	private String login;
	private String senha;
	
	public Coordenador() {}
	
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
	
	@Override
	public boolean equals(Object c) {	
		if(c !=null && c instanceof Coordenador && super.equals((Pessoa)c)) {
			if(this.senha.equals(((Coordenador)c).senha) && this.login.equals(((Coordenador)c).login)) {
				return true;
			}
		}
		return false;
	}
}
