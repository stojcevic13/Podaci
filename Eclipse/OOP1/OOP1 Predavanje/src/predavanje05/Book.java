package predavanje05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Book implements Comparable<Book>{
	
	String id, name;
	Integer year;
	
	public Book() {};

	public Book(String id, String name, Integer year) {
		this();
		this.id = id;
		this.name = name;
		this.year = year;
	}

	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", year=" + year + "]";
	}

	@Override
	public int compareTo(Book o) {
		return this.name.compareTo(o.name);
	}
	
	static void sortirajPoVrijednosti(HashMap<Integer, Book> mapa) {
		List<Entry<Integer, Book>> lista = new LinkedList<Entry<Integer, Book>>(mapa.entrySet());
		
		Collections.sort(lista, new Comparator<Entry<Integer, Book>>() {

				@Override
				public int compare(Entry<Integer, Book> o1, Entry<Integer, Book> o2) {
					return o1.getValue().year.compareTo(o2.getValue().year);
				}		
			}
		);
		
		for (Entry<Integer, Book> entry : lista) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
	
	



	public static void main(String[] args) {
		
		Book[] books = {
				new Book("0005", "Serviraj za pobedu", 2013),
				new Book("0001", "Na Drini cuprija", 1961),
				new Book("0002", "Fajront u Sarajevu", 2000),
				new Book("0033", "Mali princ", 1998),
				new Book("0004", "Alisa u zemlji cuda", 2001)
		};
		
		// poziva se compareTo iz klase Book
		Arrays.sort(books);
		System.out.println(Arrays.asList(books));

		Arrays.sort(books, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.year.compareTo(o2.year);
			}
		});
	    
		System.out.println(Arrays.asList(books));
		
//		HashMap<Integer, Book> mapa = new HashMap<Integer, Book>();
//		mapa.put(0, new Book("0005", "Serviraj za pobedu", 2013));
//		mapa.put(1, new Book("0001", "Na Drini cuprija", 1961));
//		mapa.put(2, new Book("0002", "Fajront u Sarajevu", 2000));
//		mapa.put(3, new Book("0033", "Mali Princ", 1998));
//		mapa.put(4, new Book("0004", "Alisa u zemlji cuda", 2001));
//		mapa.put(5, new Book("0021", "Veliki Talas", 2015));
//		sortirajPoVrijednosti(mapa);
		
		
//		ArrayList<Book> books = new ArrayList<Book>();
//		books.add(new Book("0005", "Serviraj za pobedu", 2013));
//		books.add(new Book("0001", "Na Drini cuprija", 1961));
//		books.add(new Book("0002", "Fajront u Sarajevu", 2000));
//		books.add(new Book("0033", "Mali Princ", 1998));
//		books.add(new Book("0004", "Alisa u zemlji cuda", 2001));
//		books.add(new Book("0021", "Veliki Talas", 2015));
//		
//		Collections.sort(books, new Comparator<Book>() {
//			@Override
//			public int compare(Book o1, Book o2) {
//				return o1.year.compareTo(o2.year);
//			}
//		});
//		
//		System.out.println(books);
		
		
		
		
	}



}
