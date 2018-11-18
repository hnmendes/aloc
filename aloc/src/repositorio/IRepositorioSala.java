package repositorio;

import beans.Sala;

/**
	@Author: rique
*/

public interface IRepositorioSala {
	
	public interface IRepositorioDisciplina {
		
		public void addSala(Sala sala);
		public Sala getSala(String nome);
		public void remover(String nome);
		public Sala getSala(int pos);
		public Sala getSalaById(int id);
		public Sala[] getSalaArray();
		public int getSalaPos(String nome);
		public void setSala(int i, Sala s);
	
	}

}

