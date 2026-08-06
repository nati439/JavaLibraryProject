package exceptions;

public class BookUnavailableException extends Exception{
	public BookUnavailableException(String error) {
		super(error);
	}

}
