package beans;

public class Coordenador extends Pessoa{
	
	public Coordenador() {}
	
	public Coordenador(String nome, String cpf) {
		super.setNome(nome);
		super.setCpf(cpf);
	}
	
	public Coordenador(String nome, String cpf, String senha) {
		super.setCpf(cpf);
		super.setSenha(senha);
		super.setNome(nome);
	}
	
	public Coordenador (Pessoa p) {
		this(p.getNome(),p.getCpf());
	}

	
	@Override
	public String toString() {
		return super.toString();
	}	
	
	@Override
	public boolean equals(Object c) {	
		if(c !=null && c instanceof Coordenador && super.equals((Pessoa)c)) {
			if(this.getSenha().equals(((Coordenador)c).getSenha()) && this.getCpf().equals(((Coordenador)c).getCpf())) {
				return true;
			}
		}
		return false;
	}
}
