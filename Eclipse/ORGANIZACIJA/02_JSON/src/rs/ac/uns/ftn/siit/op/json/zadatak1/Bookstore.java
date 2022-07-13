package rs.ac.uns.ftn.siit.op.json.zadatak1;

import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.siit.op.json.example01.Book;

public class Bookstore {

	private List<Book> books;
	private List<Magazine> magazines;
	
	
	public Bookstore() {
		this.books = new ArrayList<Book>();
		this.magazines = new ArrayList<Magazine>();
	}


	public Bookstore(List<Book> books, List<Magazine> magazines) {
		this();
		this.books = books;
		this.magazines = magazines;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public List<Magazine> getMagazines() {
		return magazines;
	}


	public void setMagazines(List<Magazine> magazines) {
		this.magazines = magazines;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((magazines == null) ? 0 : magazines.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bookstore other = (Bookstore) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (magazines == null) {
			if (other.magazines != null)
				return false;
		} else if (!magazines.equals(other.magazines))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Bookstore [books=" + books + ", magazines=" + magazines + "]";
	}
	
}
