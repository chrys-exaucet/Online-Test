package exceptions;

@SuppressWarnings("serial")
public  class	 BadDataException extends RuntimeException {
	 
	private String	message;
		
	 public BadDataException(String message) {this.message = message ;}
				
	public String getMessage() {return message ;}	
} 
	
