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
	private int cargaHoraria;
	

	public HorarioDisciplina() {
		
		horarioHora = new LocalTime[2];
	}
	
	
	public LocalTime getPrimeiroHorario() {
		
		return (this.horarioHora[0] != null) ? this.horarioHora[0] : null; 
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
	
	
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}
	
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

		
		return "\nDia: "+ this.getDia()+"\n"+
				"\nHora inicial: "+ formatter.format(this.getPrimeiroHorario())+
				"\nHora final: "+ formatter.format(this.getSegundoHorario());
	}
	
}

