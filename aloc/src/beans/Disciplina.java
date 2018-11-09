package beans;

import java.time.LocalDate;

import util.Semana;


public class Disciplina {
	
	private String nome;
	private String area;
	private int cargaHoraria;
	private Semana dias[] = new Semana[2];
	
	public Disciplina() {}
	
	public Disciplina(String nome, String area) {
		this.nome=nome;
		this.area=area;
	}
	

//	GETTERS AND SETTERS
	
	
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
	
	public Semana getDia2() {
		return this.dias[1];
	}
	
	public boolean equals(Disciplina d) {		
		if(d !=null) {
			if(this.getNome().equals(d.getNome()) && this.getArea().equals(d.getArea()) ) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "\nDisciplina: "+this.getNome()+"\nArea: "+this.getArea();
	}
	
}
