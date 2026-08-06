package model;
import interfaces.Borrowable;
import java.util.Objects;
import aLibraryManagment.Enums;

public class Book implements Borrowable{
	private static int nextId = 1;
    private int id;
    private String title;
    private String author;
    private String isbn;
    private Enums genre;
    private int totalCopies;
    private int availableCopies;

    // constructor — you had title, author, genre here;
    // you still needed to add isbn, totalCopies, availableCopies (derived), and id (auto-generated) — 
    // these last parts weren't finished/confirmed in our chat
    public Book(String title, String author, Enums genre, int totalCopies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        id = nextId;
        nextId += 1;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        
    }

    public boolean borrowCopy(){
        if (isAvailable()) {
            availableCopies -= 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean returnCopy() {
        if (availableCopies < totalCopies) {
            availableCopies += 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean isAvailable() {
        return availableCopies >= 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        if (this.id == other.id && this.isbn.equals(other.isbn)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.isbn);
    }
 // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Enums getGenre() {
        return genre;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    // Setters (id and availableCopies excluded on purpose)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenre(Enums genre) {
        this.genre = genre;
    }

    public void setTotalCopies(int totalCopies) {
        if (totalCopies >= availableCopies) {
            this.totalCopies = totalCopies;
        }
    }

    // toString
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                '}';
    }
}