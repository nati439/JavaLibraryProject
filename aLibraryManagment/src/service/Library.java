package service;
import java.util.ArrayList;
import model.Book;
import model.Member;
public class Library {
	private ArrayList<Book> books = new ArrayList<>();
	private ArrayList<Member> members = new ArrayList<>();
	
	public void addBook(Book book){
		books.add(book);
		
	}
	public void addMember(Member member){
		members.add(member);
		
	}
	
	public String findBookByid(int id) {
		for(int i = 0; i < books.size(); i++ ) {
			if(books.id == id)
		}
	}
	
	

}
