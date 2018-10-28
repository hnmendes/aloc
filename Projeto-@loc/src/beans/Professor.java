package beans;

public class Professor extends Pessoa{
	private int id;
	private Disciplina disciplina;
	private String sala;
	private String area;

	public Professor() {}
	
	public Professor(Pessoa p, Disciplina d) {
		if(p!=null & d!=null) {
			super.setNome(p.getNome());		
			super.setCpf(p.getCpf());
			this.setDisciplina(d);
			this.area=d.getArea();
		}		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		super.toString();
		return "\nProfessor: "+this.getNome()+"\nCPF: "+this.getCpf()+"\nDisciplina: "+this.getDisciplina().getNome()+"\nArea: "+this.getArea();
	}
	
	
	public boolean equals(Professor p) {		
		if(p !=null && super.equals(p)) {
			if(this.getDisciplina().equals(p.getDisciplina()) && this.id == p.getId()) {
				return true;
			}
		}
		return false;
	}
	
}
