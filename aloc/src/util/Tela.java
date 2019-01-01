package util;


/**
	@Author: rique
*/

public enum Tela {
	
	TELA_LOGIN(0),TELA_COORDENADOR(1),TELA_PROFESSOR(2),TELA_ADD_PROFESSOR_COORD(3),TELA_ADD_DISCIPLINA_COORD(4),TELA_EDIT_DISCIPLINA_COORD(5);
	
	private int tela;
	
	Tela(int tela){
		this.setTela(tela);
	}

	public int getTela() {
		return tela;
	}

	public void setTela(int tela) {
		this.tela = tela;
	}
}

