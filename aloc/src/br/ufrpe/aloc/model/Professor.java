package br.ufrpe.aloc.model;


public class Professor extends Pessoa{
	
	private int id;
	
	private Disciplina[] disciplinas = new Disciplina[2];
	
	private String login;
	
	private String senha;
	
	private String sala;
	
	private String area;
	
	
//	GETTERS AND SETTERS
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getArea() {
		return area;
	}

	public void setÁrea(String area) {
		this.area = area;
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
		
		return ((this.id == p.getId()) && (this.login == p.getLogin()) && (this.sala == p.getSala()) && (this.area == p.getArea()) && (this.senha == p.getSenha()))? true : false;
	}
	
}	

