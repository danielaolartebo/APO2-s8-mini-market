package exceptions;

public class NoAgeException extends Exception {

	private static final long serialVersionUID = 1;

	public NoAgeException() {
		super("MINORS CANNOT REGISTER ");
	}
}