package exception;

public class DisciplinaJaExisteException extends Exception{
	private static final long serialVersionUID = -766054545512336036L;

	public DisciplinaJaExisteException(String s) {
		super("Disciplina ja cadastrada.");
	}
}
