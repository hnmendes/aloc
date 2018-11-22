package repositorio;

import beans.Sala;

public class RepositorioSala implements IRepositorioSala{
	
private static RepositorioSala instance;
	
	private Sala salas[] = new Sala[5];
	private int salasTam = 0;
	
	public static RepositorioSala getInstance() {
	    if (instance == null) {
	      instance = new RepositorioSala();
	    }
	    return instance;
	}
	
	private RepositorioSala() {}
	
	
	public void addSala(Sala sala) {
		if(sala != null && getSala(sala.getNomeSala()) == null) {
			if(this.salasTam == this.salas.length) {
				this.duplicaArray();
			}
			this.salas[salasTam] = sala;
			this.salasTam++;
		}
		//TODO exception
	}
	
	public Sala getSala(String nome) {
		for(int i = 0; i < salasTam; i++) {
			if(salas[i].getNomeSala().equals(nome)) {
				return salas[i];
			}
		}
		return null;
	}
	
	private void duplicaArray() {
        if (this.salas != null && this.salas.length > 0) {
        	Sala[] arrayDuplicado = new Sala[this.salas.length * 2];
            for (int i = 0; i < this.salas.length; i++) {
                arrayDuplicado[i] = this.salas[i];
            }
            this.salas = arrayDuplicado;
        }
    }
	
	private int procurarPos(String nome) {
		
		int i;
		
        for(i = 0; i<this.salasTam; i++) {
        	if(nome.equals(this.salas[i].getNomeSala())) {
        		return i;
        	}
        }
        return -1;
        //TODO exception
	}
	
	public void remover(String nome) {
		int i = this.procurarPos(nome);
		if (i != this.salasTam) {
            this.salas[i] = this.salas[this.salasTam - 1];
            this.salas[this.salasTam - 1] = null;
            this.salasTam = this.salasTam - 1;
        } 
		//TODO exception
	}
	
	public Sala getSala(int pos) {
		
		return (this.getSala(pos) != null) ? this.getSala(pos) : null;
	}
	
	public Sala getSalaById(int id) {
		
		for(Sala x : this.salas) {
			if(x.getId() == id) {
				return x;
			}
		}
		
		return null;
	}
	
	public Sala[] getSalaArray() {
		return this.salas;
	}
	
	
	public void setSala(int i, Sala s) {
		this.salas[i] = s;
	}
}
