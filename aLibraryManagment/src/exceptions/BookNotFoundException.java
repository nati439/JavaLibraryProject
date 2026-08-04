package exceptions;

public class BookNotFoundException extends Exception{
	//create a template.
	//Exception is the parent, BookNotFoundException is the child
	public BookNotFoundException(String error) {
		 super(error);
	}
}
