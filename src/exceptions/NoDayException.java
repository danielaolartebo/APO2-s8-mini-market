package exceptions;

public class NoDayException extends Exception {

	private static final long serialVersionUID = 1;

	public NoDayException() {
		super("TODAY IS NOT YOUR PICO Y CEDULA DAY ");
	}
}
