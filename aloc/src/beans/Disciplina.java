package beans;

import java.time.LocalDate;


public class Disciplina {
	
	private String nome;
	private String area;
	private LocalDate horario;
	
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
	
	public LocalDate getHorario() {
		return this.horario;
	}
	
	public void setHorario(LocalDate horario) {
		this.horario = horario;
	}
	
	
	public boolean equals(Disciplina d) {		
		if(d !=null) {
			if(this.getNome().equals(d.getNome()) && this.getArea().equals(d.getArea()) ) {
				return true;
			}
		}
		return false;
	}
	
	public boolean horarioChoque(Disciplina d) {
		
		if(this.getHorario().equals(d))
			return true;
			
		return false;
	}	
	
	@Override
	public String toString() {
		return "\nDisciplina: "+this.getNome()+"\nArea: "+this.getArea();
	}
	
}
