package beans;

public class Pessoa {
	private String nome;
	private String cpf;
	
	public Pessoa() {}
	
	public Pessoa(String nome,String cpf) {
		this.nome=nome;
		this.cpf=cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String toString() {
		return "\nNome: "+this.getNome() +"\nCPF: "+this.getCpf();
	}
	
	public boolean equals(Pessoa p) {
		if(p !=null) {
			if(this.getNome().equals(p.getNome()) && this.getCpf().equals(p.getCpf())) {
				return true;
			}
		}
		return false;
	}
}
