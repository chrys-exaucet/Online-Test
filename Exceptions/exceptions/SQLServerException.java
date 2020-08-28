package exceptions;

@SuppressWarnings("serial")
public class SQLServerException extends Exception {
	
	
	
	private String message ;
	
	public SQLServerException(String message) {
		this.message = message ;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
