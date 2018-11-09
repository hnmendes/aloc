package beans;


import util.Semana;


public class Disciplina {
	
	private int id;
	private String nome;
	private String area;
	private int cargaHoraria;
	private Semana dias[];
	private boolean ofertada = false;
	
	public Disciplina() {
		dias = new Semana[2];
	}
	
	public Disciplina(String nome, String area) {
		this.nome=nome;
		this.area=area;
	}
	

//	GETTERS AND SETTERS
	
	
	public boolean getOfertada() {
		return this.ofertada;
	}
	
	public void setOfertada(boolean b) {
		this.ofertada = b;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public Semana[] getDiasArray() {
		return this.dias;
	}
	
	public Semana getDia1() {
		return this.dias[0];
	}
	
	public void setDia1(Semana dia) {
		this.dias[0] = dia;
	}
	
	public Semana getDia2() {
		return this.dias[1];
	}
	
	public void setDia2(Semana dia) {
		this.dias[1] = dia;
	}
	
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}
	
	public void setCargaHoraria(int ch) {
		this.cargaHoraria = ch;
	}
	
	public boolean equals(Disciplina d) {		
		if(d !=null) {
			if(this.getNome().equals(d.getNome()) && this.getArea().equals(d.getArea()) ) {
				return true;
			}
		}
		return false;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "\nDisciplina: "+this.getNome()+"\nArea: "+this.getArea();
	}
	
	//Se retornar verdadeiro as disciplinas se chocam.
	public boolean choqueDisciplinaDia1(Disciplina disc) {
		
		if(this.getDia1().getHorario() == disc.getDia1().getHorario()) {
			return true;
		}
		
		return false;
	}
	
	public boolean choqueDisciplinaDia2(Disciplina disc) {
		
		if(this.getDia2().getHorario() == disc.getDia2().getHorario()) {
			return true;
		}
		
		return false;
	}
}
