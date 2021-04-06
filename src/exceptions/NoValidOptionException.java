package exceptions;

public class NoValidOptionException extends Exception{

	private static final long serialVersionUID = 1;

	public NoValidOptionException() {
		super("PLEASE TYPE IN A VALID OPTION");
	}
}

