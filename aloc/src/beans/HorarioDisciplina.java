package beans;

import org.joda.time.LocalTime;
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
		
		return this.getPrimeiroHorario().toString("HH:mm");
	}
	
	public String getSegundoHorarioString() {	
		return this.getSegundoHorario().toString("HH:mm");
	}
	
	public String getHorariosToString() {
		
		
		if(this.getPrimeiroHorario() == null && this.getSegundoHorario() == null) {
			return "_ - _";
		}else if(this.getPrimeiroHorario() != null && this.getSegundoHorario() == null) {
			
			return this.getPrimeiroHorario().toString("HH:mm")+ " - _ "; 
		}else if(this.getPrimeiroHorario() == null && this.getSegundoHorario() != null) {
			
			return "_ - " + this.getSegundoHorario().toString("HH:mm");
		}
		
		return this.getPrimeiroHorario().toString("HH:mm")+ " - " + this.getSegundoHorario().toString("HH:mm");
	}
	
	
	public LocalTime getSegundoHorario() {
		
		return (this.horarioHora[1] != null) ? this.horarioHora[1] : null;
	}
	
	public void setPrimeiroHorario(String horaMinuto) {
		this.horarioHora[0] = LocalTime.parse(horaMinuto);
	}
	
	public void setSegundoHorario(String horaMinuto) {
		this.horarioHora[1] = LocalTime.parse(horaMinuto);
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
	
	public void setDia(Semana dia) {
		this.diaSemana = dia;
	}
	
	
	@Override
	public String toString() {
		
		return "\nDia: "+ this.getDia()+"\n"+
				"\nHora inicial: "+ this.getPrimeiroHorario().toString("HH:mm")+
				"\nHora final: "+ this.getSegundoHorario().toString("HH:mm");
	}
	
	public static String toTimeString(LocalTime source) {

	    try {
	        return source.toString("HH:mm");
	    } catch (Exception ignored) {
	    }

	    return null;
	}
	
}

