package service;
import java.util.ArrayList;
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
	
	public Book findBookByid(int id) {
		for(int i = 0; i < books.size(); i++ ) {
			 Book x = books.get(i);
			if( x.getId() == id) {
				return x;
			}
		}
		
		return null;
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
	
	public Book checkoutBook(int memberId, int bookId) {
		Member x = findMemberById(memberId);
		Book y = findBookByid(bookId);
		if(x == null|| y == null) {
			return null;
		}
		if(x.canBorrowMoreBooks()) {
			if(y.getAvailableCopies() >= 1) {
				if (y.borrowCopy() ) {
					if(x.borrowBook(y)) {
						return y;
					}else {return null;}
				}else {return null;}
			}else {return null;}
		}else {
			return null;
		}
		
	}
	
	public void returnBook(int memberid, int bookid) {
		//may cause error later
		Member x = findMemberById(memberid);
		Book y = findBookByid(bookid);
		
		if(x.returnBook(y)) {
			y.borrowCopy();
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
