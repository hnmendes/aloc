package controller;

import beans.Coordenador;
import repositorio.IRepositorioCoordenador;

public class ControladorDeCoordenador {
	
	private IRepositorioCoordenador instanceRepCoordenador;

	public ControladorDeCoordenador(IRepositorioCoordenador instanceRepCoordenador){
		this.instanceRepCoordenador = instanceRepCoordenador;
	}
	
	/**
	 * Adiciona o coordenador no reposit�rio.
	 * @param Coordenador
	 */
	public boolean cadastrarCoordenador(Coordenador c){
		if(c!=null && c.getCpf()!=null && c.getNome()!=null) {
			instanceRepCoordenador.addCoordenador(c);
			return true;
		}
		
		return false;
		//TODO exception
	}
	
	/**
	 * Remove o coordenador.
	 * @param cpf
	 */
	public boolean removerCoordenador(String cpf){
		if(cpf!=null) {
			instanceRepCoordenador.removerCoordenador(cpf);
			return true;
		}
		
		return false;
		//TODO exception
	}
	
	/**
	 * Retorna Coordenador.
	 * @param cpf
	 * @return
	 * @throws NaoEncontradoException
	 * @throws CadastroInvalidoException
	 */
	public Coordenador getCoordenador(String cpf){
		if(cpf!=null) {
			return instanceRepCoordenador.getCoordenador(cpf);
		}
		return null;
		//TODO exception
	}
	
	/**
	 * Retorna array de coordenadores.
	 * @return
	 */
	public Coordenador[] getCoordenadorArray() {
		return instanceRepCoordenador.getCoordenadorArray();
	}
	
	
	public Coordenador checagemLogin(String cpf, String senha) {
		boolean validando = false;
		
		Coordenador coord = null;
		
		if(cpf != null && senha != null) {
			int pos = 0;
			do {
				if(instanceRepCoordenador.getCoordenador(pos) != null) {
					if(instanceRepCoordenador.getCoordenador(pos).getCpf().equals(cpf)
							&& instanceRepCoordenador.getCoordenador(pos).getSenha().equals(senha)) {
						coord = instanceRepCoordenador.getCoordenador(pos);
						validando = true;
						return coord;
						
					}
				}else {
					break;
				}
				pos++;
			}while(validando == false);
		}
		
		return null;
	}
	
	public void editarCoordenador(String cpf, Coordenador c) {
		this.instanceRepCoordenador.setCoordenador(cpf, c);
	}
}
