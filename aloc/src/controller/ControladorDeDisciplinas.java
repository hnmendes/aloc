package controller;

import repositorio.IRepositorioDisciplina;

public class ControladorDeDisciplinas {
	
	private IRepositorioDisciplina instanceRepDisciplinas;
	
	public ControladorDeDisciplinas(IRepositorioDisciplina instanceRepDisciplinas) {
		this.instanceRepDisciplinas = instanceRepDisciplinas;
	}
}
