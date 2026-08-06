package service;
import java.util.ArrayList;
import exceptions.MaximumBooksReachedException;
import exceptions.BookNotFoundException;
import exceptions.BookUnavailableException;
import model.Book;
import model.Member;
public class Library {
	private ArrayList<Book> books = new ArrayList<>();
	private ArrayList<Member> members = new ArrayList<>();
	private ArrayList<Book> books2 = new ArrayList<>();

	
	public void addBook(Book book){
		books.add(book);
		
	}
	public void addMember(Member member){
		members.add(member);
		
	}
	
	public Book findBookByid(int id) throws BookNotFoundException{
		//throws is a warning to compiler "this way throw smt"
		for(int i = 0; i < books.size(); i++ ) {
			 Book x = books.get(i);
			if( x.getId() == id) {
				return x;
			}
		}
		
		throw new BookNotFoundException(
		//throw is like 'return'. It stops everything to say there is error.
				"Book not found"
		);
	}
	
	public Member findMemberById(int id) {
		for(int i = 0; i < members.size(); i++ ) {
			 Member x = members.get(i);
			if( x.getId() == id) {
				return x;
			}
		}
		
		return null;
	}
	
	public Book checkoutBook(int memberId, int bookId) throws  BookNotFoundException, MaximumBooksReachedException, BookUnavailableException{
		Member x = findMemberById(memberId);
		
		Book y = findBookByid(bookId);
		
		
		
		
		
		if(x == null|| y == null) {
			throw new BookNotFoundException(
				"Book not found"
			);
		}
		if(x.canBorrowMoreBooks()) {
			if(y.getAvailableCopies() >= 1) {
				if (y.borrowCopy() ) {
					if(x.borrowBook(y)) {
						return y;
					}else {
						throw new BookUnavailableException(
								"Book not available"
						);
						}
				}else {
					throw new BookUnavailableException(
							"Book not available"
							);
				}
			}else {
					throw new BookUnavailableException(
							"Book not available"
							);
			} 
		}else {
			throw new MaximumBooksReachedException(
					"Book is full"
			);
		}
		
	}
	
	public void returnBook(int memberid, int bookid) throws BookNotFoundException{
		//may cause error later
		Member x = findMemberById(memberid);
		Book y = findBookByid(bookid);
		if (y == null || x == null) {
			throw new BookNotFoundException(
					"Book not found"
			);
		}
		if(x.returnBook(y)) {
			y.returnCopy();
		}

	}
	
	
	public ArrayList<Book> listAvailableBook() {
		for (Book i : books) {
			if(i.isAvailable()) {
				books2.add(i);
			}
		}
		
		return books2;
	}
	
	
	

	
	

}
