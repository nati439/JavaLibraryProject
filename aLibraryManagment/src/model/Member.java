package model;

import java.util.ArrayList;

public class Member {
	private int memberid;
	private String firstname;
	private String lastname;
	private String membershipStatus;
	ArrayList<Book> borrowedBooks = new ArrayList<>();
	static final int max_book = 3;

	public Member(String firstname, String lastname, String membershipStatus, int memberid) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.membershipStatus = membershipStatus;
		this.memberid = memberid;
	}

	public boolean borrowBook(Book book) {
		if (borrowedBooks.size() < max_book) {
			borrowedBooks.add(book);
			return true;
		} else {
			return false;
		}
	}

	public boolean returnBook(Book book) {
		for (int i = 0; i < borrowedBooks.size(); i++) {
			if (book == borrowedBooks.get(i)) {
				borrowedBooks.remove(i);
				return true;
			}
		}
		
		return false;
	}

	public boolean canBorrowMoreBooks() {
		if (borrowedBooks.size() < max_book) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public int getId() {
        return memberid;
    }
	public String toString() {
		return "Member" + "{" + "id=" + this.memberid + "," + "name=" + this.firstname + " " + this.lastname + ", " + "borrowed=" + borrowedBooks.size() + "}";
	}
}