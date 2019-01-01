package beans;

import exceptions.ChoqueDisciplinaException;
import util.Semana;

public class Disciplina {
	
	private int id;
	
	private String nome;
	
	private String areaAtuacao;
	
	private HorarioDisciplina[] horarios = new HorarioDisciplina[2];
	
	private String sala;
	
	private int cargaHoraria;
	
	private boolean ofertada = false; //Saber se a disciplina já foi escolhida/ofertada por algum professor.
	
	private String semestre;
	
	private boolean professorLeciona = false;
	
	
	public Disciplina(int id, String nome, String areaAtuacao, String sala, int cargaHoraria,String primeiroHorario1, String segundoHorario1, Semana dia1, String primeiroHorario2, String segundoHorario2, Semana dia2, String semestre, boolean ofertada) {
		
		this.id = id;
		this.nome = nome;
		this.areaAtuacao = areaAtuacao;
		this.sala = sala;
		this.cargaHoraria = cargaHoraria;
		
		this.horarios[0] = new HorarioDisciplina();
		
		this.horarios[0].setPrimeiroHorario(primeiroHorario1);
		this.horarios[0].setSegundoHorario(segundoHorario1);
		this.horarios[0].setDia(dia1);
		
		this.horarios[1] = new HorarioDisciplina();
		
		this.horarios[1].setPrimeiroHorario(primeiroHorario2);
		this.horarios[1].setSegundoHorario(segundoHorario2);
		this.horarios[1].setDia(dia2);
		
		this.semestre = semestre;
		
		this.ofertada = ofertada;
	}
	
	public Disciplina(String inicioHorario1, String fimHorario1, Semana dia1, String inicioHorario2, String fimHorario2, Semana dia2) {
		
		this.horarios[0].setPrimeiroHorario(inicioHorario1);
		this.horarios[0].setSegundoHorario(fimHorario1);
		this.horarios[0].setDia(dia1);
		
		this.horarios[1].setPrimeiroHorario(inicioHorario2);
		this.horarios[1].setSegundoHorario(fimHorario2);
		this.horarios[1].setDia(dia2);
		
	}
	
	public Disciplina(int id, String nome, String areaAtuacao, String sala, int cargaHoraria, String semestre) {
		
		this.id = id;
		this.nome = nome;
		this.areaAtuacao = areaAtuacao;
		this.sala = sala;
		this.cargaHoraria = cargaHoraria;
		
		this.horarios[0] = new HorarioDisciplina();
		this.horarios[1] = new HorarioDisciplina();
		
		this.semestre = semestre;
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
		
		if(this.semestre.equals(d.semestre)) {
			
			if( this.getHorario1Disciplina().getDia().getDia() == d.getHorario1Disciplina().getDia().getDia() || 
					this.getHorario2Disciplina().getDia().getDia() == d.getHorario2Disciplina().getDia().getDia() ||
					this.getHorario1Disciplina().getDia().getDia() == d.getHorario2Disciplina().getDia().getDia() ||
					this.getHorario2Disciplina().getDia().getDia() == d.getHorario1Disciplina().getDia().getDia())
				{
					if( this.getHorario1Disciplina().getPrimeiroHorario().getHourOfDay() == d.getHorario1Disciplina().getPrimeiroHorario().getHourOfDay() ||
						this.getHorario1Disciplina().getSegundoHorario().getHourOfDay() == d.getHorario1Disciplina().getSegundoHorario().getHourOfDay() &&
				    
						this.getHorario2Disciplina().getPrimeiroHorario().getHourOfDay() == d.getHorario2Disciplina().getPrimeiroHorario().getHourOfDay() ||
						this.getHorario2Disciplina().getSegundoHorario().getHourOfDay() == d.getHorario2Disciplina().getSegundoHorario().getHourOfDay()) {
						
					}
					
					throw new ChoqueDisciplinaException(d,this);
				}
		}
		
		return false;
	}


	public String getSala() {
		return sala;
	}


	public void setSala(String sala) {
		this.sala = sala;
	}


	public String getSemestre() {
		return semestre;
	}


	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	public void editarDisciplina(String nome, String areaAtuacao, String sala, int cargaHoraria, String primeiroHorario1, String segundoHorario1, Semana dia1, String primeiroHorario2, String segundoHorario2, Semana dia2, String semestre, boolean ofertada) {
		
		this.nome = nome;
		this.areaAtuacao = areaAtuacao;
		this.sala = sala;
		this.cargaHoraria = cargaHoraria;
		
		this.horarios[0] = new HorarioDisciplina();
		
		this.horarios[0].setPrimeiroHorario(primeiroHorario1);
		this.horarios[0].setSegundoHorario(segundoHorario1);
		this.horarios[0].setDia(dia1);
		
		this.horarios[1] = new HorarioDisciplina();
		
		this.horarios[1].setPrimeiroHorario(primeiroHorario2);
		this.horarios[1].setSegundoHorario(segundoHorario2);
		this.horarios[1].setDia(dia2);
		
		this.semestre = semestre;
		
		this.ofertada = ofertada;
	}

	public boolean isProfessorLeciona() {
		return professorLeciona;
	}

	public void setProfessorLeciona(boolean professorLeciona) {
		this.professorLeciona = professorLeciona;
	}
	
}
