package beans;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	
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
	
	@Override
	public String toString() {
		return "\nNome: "+this.getNome() +"\nCPF: "+this.getCpf();
	}
	
	@Override
	public boolean equals(Object p) {
		if(p !=null && p instanceof Pessoa) {
			if(this.getNome().equals(((Pessoa)p).getNome()) && this.getCpf().equals(((Pessoa)p).getCpf())) {
				return true;
			}
		}
		return false;
	}
}
