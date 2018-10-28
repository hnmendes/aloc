package exception;

public class PessoaJaExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public PessoaJaExisteException(String cpf) {
		super("Pessoa ja cadastrada.");
	}
}
