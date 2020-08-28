package exceptions;

@SuppressWarnings("serial")
public class SurveySecurityException extends Exception {

	private String	message;
	
	 public SurveySecurityException(String message) {this.message = message ;}
				
	public String getMessage() {return message ;}	
} 