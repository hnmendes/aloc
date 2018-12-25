package beans;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import util.Semana;

/**
	@Author: rique
*/

public class HorarioDisciplina {
	
	private LocalTime[] horarioHora;
	private Semana diaSemana;
	
	public HorarioDisciplina(LocalTime[] horarioHora, Semana diaSemana) {
		
		this.horarioHora = horarioHora;
		this.diaSemana = diaSemana;
	}
	
	public HorarioDisciplina() {
		
		horarioHora = new LocalTime[2];
	}
	
	
	public LocalTime getPrimeiroHorario() {
		
		return (this.horarioHora[0] != null) ? this.horarioHora[0] : null; 
	}
	
	public String getPrimeiroHorarioString() {
		
		return (this.getPrimeiroHorario()).getHour()+":"+(this.getPrimeiroHorario()).getMinute();
	}
	
	public String getSegundoHorarioString() {	
		return (this.getSegundoHorario()).getHour()+":"+(this.getSegundoHorario()).getMinute();
	}
	
	public String getHorariosToString() {
		
		
		if(this.getPrimeiroHorario() == null && this.getSegundoHorario() == null) {
			return "_ - _";
		}else if(this.getPrimeiroHorario() != null && this.getSegundoHorario() == null) {
			
			return this.getPrimeiroHorario()
				       .format(DateTimeFormatter
				       .ofPattern("HH:mm"))+ " - _ "; 
		}else if(this.getPrimeiroHorario() == null && this.getSegundoHorario() != null) {
			
			return "_ - " + this.getSegundoHorario()
		       					.format(DateTimeFormatter
		       					.ofPattern("HH:mm"));
		}
		
		return this.getPrimeiroHorario().format(DateTimeFormatter.ofPattern("HH:mm"))+ " - " + this.getSegundoHorario().format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	
	public LocalTime getSegundoHorario() {
		
		return (this.horarioHora[1] != null) ? this.horarioHora[1] : null;
	}
	
	
	public void setPrimeiroHorario(String hora, String minuto) {
		this.horarioHora[0] = LocalTime.parse(hora+":"+minuto,DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	
	public void setSegundoHorario(String hora, String minuto) {
		this.horarioHora[1] = LocalTime.parse(hora+":"+minuto,DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	
	public Semana getDia() {
		return (this.diaSemana != null) ? this.diaSemana : null;
	}
	
	
	public void setDia(int dia) {
		
		switch(dia) {
			
			case 0:
				this.diaSemana = Semana.SEGUNDA;
				break;
			
			case 1:
				this.diaSemana = Semana.TERCA;
				break;
			
			case 2:
				this.diaSemana = Semana.QUARTA;
				break;
			
			case 3:
				this.diaSemana = Semana.QUINTA;
				break;
			
			case 4:
				this.diaSemana = Semana.SEXTA;
				break;
			
			default:
				throw new IllegalArgumentException();
		}
	}
	
	
	@Override
	public String toString() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

		
		return "\nDia: "+ this.getDia()+"\n"+
				"\nHora inicial: "+ formatter.format(this.getPrimeiroHorario())+
				"\nHora final: "+ formatter.format(this.getSegundoHorario());
	}
	
}

