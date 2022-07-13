package vezbe7.primer11;

public class MyException extends Exception{

	private String details;
	
	public MyException(String details) {
		this.details = details;
	}
	
	public String toString() {
		return ("Output = " + details);
	}
	
}
