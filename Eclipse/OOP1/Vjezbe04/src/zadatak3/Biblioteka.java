package zadatak3;

import java.util.ArrayList;

public class Biblioteka {
	
	private ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
	
	
	
	// KONSTRUKTORI
	
	public Biblioteka() {};
	
	public Biblioteka(ArrayList<Knjiga> knjige) {
		this();
		this.knjige = knjige;
	}
	
	
	
	// GETTERI I SETTERI
	
	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}
	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}


	
	// METODE
	
	public void dodajNovuKnjigu(Knjiga k) {
		this.knjige.add(k);
	}
	
	public void izbrisiKnjigu(Knjiga k) {
		this.knjige.remove(k);
	}
	
	public void izmijeniKnjigu(Knjiga stara, Knjiga nova) {
		this.knjige.set(this.knjige.indexOf(stara), nova);
	}
	
	public void ispisiSveKnjige() {
		for (Knjiga k : this.knjige) {
			System.out.println(k);
		}
	}

	
	public static void main(String[] args) {
		
		Biblioteka b = new Biblioteka();
		
		//Knjiga k = new Knjiga("0000", "Na Drini cuprija", 1961, new Autor("Ivo", "Andric", "349402", new Knjiga))
//		b.dodajNovuKnjigu(new Knjiga("0001", "Serviraj za pobedu", 2011, "Novak Djokovic", 800.0));
//		b.dodajNovuKnjigu(new Knjiga("0002", "Na Drini cuprija", 1961, "Ivo Andric", 1000.0));
//		b.dodajNovuKnjigu(new Knjiga("0003", "Fajront u Sarajevu", 2000, "Nele Karajlic", 1200.0));
//		b.dodajNovuKnjigu(new Knjiga("0004", "Mali princ", 1998, "Egziperi", 600.0));

		
	}



}
