package beans;


public class Professor extends Pessoa{
	
	private int id;
	private Disciplina[] disciplinas = new Disciplina[2];
	private String areaAtuacao;
	private Alocacao disciplinasAlocadas;
	private String semestre;
	
	
	public Professor(int id, String nome, String cpf, String senha, String areaAtuacao) {
		this.id = id;
		super.setNome(nome);
		super.setCpf(cpf);
		this.areaAtuacao = areaAtuacao;
		super.setSenha(senha);
		this.disciplinasAlocadas = new Alocacao();
	}
	
	public Professor(int id, String nome, String cpf, String senha, String areaAtuacao, String semestre) {
		this.id = id;
		super.setNome(nome);
		super.setCpf(cpf);
		this.areaAtuacao = areaAtuacao;
		super.setSenha(senha);
		this.setSemestre(semestre);
		this.disciplinasAlocadas = new Alocacao();
	}

	public Professor() {}
	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
	
	public void setDisciplina1(Disciplina disc1) {
		this.disciplinas[0] = disc1;
	}
	
	public void setDisciplina2(Disciplina disc2) {
		this.disciplinas[1] = disc2;
	}
	
	public Disciplina getDisciplina1() {
		return this.disciplinas[0];
	}
	
	public Disciplina getDisciplina2() {
		return this.disciplinas[1];
	}
	
	public Disciplina[] getDisciplinas() {
		return this.disciplinas;
	}
	
	public boolean equals(Professor p) {
		
		return (p != null && p instanceof Professor && (this.id == p.getId()) && (this.areaAtuacao.equals(p.getAreaAtuacao())) && (this.getSenha().equals(p.getSenha())) )? true : false;
	}
	
	

	@Override
	public String toString() {
		super.toString();
		return "\nProfessor: "+this.getNome()+"\nCPF: "+this.getCpf()+"\nArea: "+this.getAreaAtuacao();
	}


	public Alocacao getDisciplinasAlocadas() {
		return disciplinasAlocadas;
	}


	public void setDisciplinasAlocadas(Alocacao disciplinasAlocadas) {
		this.disciplinasAlocadas = disciplinasAlocadas;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
