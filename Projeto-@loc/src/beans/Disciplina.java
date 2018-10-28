package beans;

public class Disciplina {
	private String nome;
	private String area;
	
	public Disciplina() {}
	
	public Disciplina(String nome, String area) {
		this.nome=nome;
		this.area=area;
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
	
	public String toString() {
		return "\nDisciplina: "+this.getNome()+"\nArea: "+this.getArea();
	}
	
	public boolean equals(Disciplina d) {		
		if(d !=null) {
			if(this.getNome().equals(d.getNome()) && this.getArea().equals(d.getArea()) ) {
				return true;
			}
		}
		return false;
	}
}
