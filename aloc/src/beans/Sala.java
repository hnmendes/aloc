package beans;

import java.util.List;

/**
	@Author: rique
*/

public class Sala {
	
	private int id;
	
	private String nomeSala;
	
	private List<Disciplina> disciplinas;
	
	private boolean disponivel;
	
	
	//------------Getters and Setters----------------------------------------
	
	public String getNomeSala() {
		return this.nomeSala;
	}
	
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	
	public List<Disciplina> getDisciplinas(){
		return this.disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public boolean getDisponivel() {
		return this.disponivel;
	}
	
	public void setDisponivel(boolean disponibilidade) {
		this.disponivel = disponibilidade;
	}
	
	//-----------------------------------------------------------------------------
	
	
	
	/*
	 * * Checar a disponibilidade da sala.
	 * 
	 * Para checar a disponibilidade precisamos checar os horarios
	 * 
	 */
	
	
	
}

