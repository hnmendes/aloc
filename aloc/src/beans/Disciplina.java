package beans;

import exceptions.ChoqueDisciplinaException;

public class Disciplina {
	
	private int id;
	
	private String nome;
	
	private String areaAtuacao;
	
	private HorarioDisciplina[] horarios = new HorarioDisciplina[2];
	
	private Sala sala;
	
	private int cargaHoraria;
	
	private boolean ofertada = false; //Saber se a disciplina já foi escolhida/ofertada por algum professor.
	
	
	public Disciplina(String nome, String areaAtuacao, int cargaHoraria) {
		
		this.nome = nome;
		this.areaAtuacao = areaAtuacao;
		this.cargaHoraria = cargaHoraria;
		this.horarios[0] = new HorarioDisciplina();
		this.horarios[1] = new HorarioDisciplina();
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

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setArea(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
	
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}
	
	public void setCargaHoraria(int ch) {
		this.cargaHoraria = ch;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public HorarioDisciplina getHorario1Disciplina() {
		return this.horarios[0];
	}
	
	public HorarioDisciplina getHorario2Disciplina() {
		return this.horarios[1];
	}
	
	public void setHorarioDisciplina1(HorarioDisciplina horario) {
		this.horarios[0] = horario;
	}
	
	public void setHorarioDisciplina2(HorarioDisciplina horario) {
		this.horarios[1] = horario;
	}
	
	@Override
	public String toString() {
		
		String ofertada = (this.ofertada) ? "Sim" : "Não";
		
		return "Disciplina: "+ this.getNome()+
				"\n\nArea: "+ this.getAreaAtuacao()+
				"\n\nCarga Horária: "+ this.getCargaHoraria()+
				"\n\nHorário 1:\n "+ this.getHorario1Disciplina()+
				"\n\nHorário 2:\n "+ this.getHorario2Disciplina()+
				"\n\nOfertada: "+ ofertada;
	}
	
	public boolean equals(Object d) {		
		if(d !=null && d instanceof Disciplina) {
			if(this.getNome().equals(((Disciplina)d).getNome()) && this.getAreaAtuacao().equals(((Disciplina)d).getAreaAtuacao()) ) {
				return true;
			}
		}
		return false;
	}
	
	
	//Primeiramente checo se os dias são iguais, depois checo se cada horário inicial e final das disciplinas são iguais,
	//depois eu checo se o horário da disciplina 'd' choca, somando o primeiro horário desta disciplina por 2 e comparando com
	//o segundo horário, já que, por definição do projeto cada aula tem 2 horas.
	
	/**Caso retorne falso é porque as disciplinas não chocam-se**/
	public boolean choqueDisciplina(Disciplina d) throws ChoqueDisciplinaException{
		
		if( this.getHorario1Disciplina().getDia().getDia() == d.getHorario1Disciplina().getDia().getDia() || 
			this.getHorario2Disciplina().getDia().getDia() == d.getHorario2Disciplina().getDia().getDia() ||
			this.getHorario1Disciplina().getDia().getDia() == d.getHorario2Disciplina().getDia().getDia() ||
			this.getHorario2Disciplina().getDia().getDia() == d.getHorario1Disciplina().getDia().getDia())
		{
			if( this.getHorario1Disciplina().getPrimeiroHorario().getHour() == d.getHorario1Disciplina().getPrimeiroHorario().getHour() ||
				this.getHorario1Disciplina().getSegundoHorario().getHour() == d.getHorario1Disciplina().getSegundoHorario().getHour() &&
		    
				this.getHorario2Disciplina().getPrimeiroHorario().getHour() == d.getHorario2Disciplina().getPrimeiroHorario().getHour() ||
				this.getHorario2Disciplina().getSegundoHorario().getHour() == d.getHorario2Disciplina().getSegundoHorario().getHour()) {
				
			}
			
			throw new ChoqueDisciplinaException(d,this);
		}
		
		return false;
	}
	
}
