package controller;
import repositorio.IRepositorioCoordenador;
import repositorio.IRepositorioDisciplina;
import repositorio.IRepositorioProfessor;
import repositorio.RepositorioCoordenador;
import repositorio.RepositorioDisciplina;
import repositorio.RepositorioProfessor;

public class Fachada {
	private static Fachada instance;
	private IRepositorioCoordenador instanceRepCoordenador = RepositorioCoordenador.getInstance();
	private IRepositorioProfessor instanceRepProfessor = RepositorioProfessor.getInstance();
	private IRepositorioDisciplina instanceRepDisciplina = RepositorioDisciplina.getInstance();
	
	private ControladorDeDisciplinas controladorDeDisciplina;
	private	ControladorDeCoordenador controladorDeCoordenador;
	private	ControladorDeProfessor controladorDeProfessor;
	/**
	 * Retorna instance da fachada, assim limitando sua cria��o para uma �nica
	 * @return instance
	 */
	public static Fachada getInstance() {
	    if (instance == null) {
	      instance = new Fachada();
	    }
	    return instance;
	}
	private Fachada () {
		this.controladorDeDisciplina = new ControladorDeDisciplinas(this.instanceRepDisciplina);
		this.controladorDeCoordenador = new ControladorDeCoordenador(this.instanceRepCoordenador);
		this.controladorDeProfessor = new ControladorDeProfessor(this.instanceRepProfessor);
	}
	/**
	 * Acesso ao controladorDeDisciplinas
	 * @return controladorDeDisciplinas
	 */
	public ControladorDeDisciplinas contDisciplinas() {
		return this.controladorDeDisciplina;
	}
	/**
	 * Acesso ao controladorDeCoordenador
	 * @return controladorDeCoordenador
	 */
	public ControladorDeCoordenador contCoordenador() {
		return this.controladorDeCoordenador;
	}
	/**
	 * Acesso ao controladorDeProfessor
	 * @return controladorDeProfessor
	 */
	public ControladorDeProfessor contProfessor() {
		return this.controladorDeProfessor;
	}
	
}
