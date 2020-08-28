package exceptions;

@SuppressWarnings("serial")
public class NullAuthentificationDataException extends Exception {
	
	private String message ;
	
	public NullAuthentificationDataException(String message) {
		this.message = message ;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
