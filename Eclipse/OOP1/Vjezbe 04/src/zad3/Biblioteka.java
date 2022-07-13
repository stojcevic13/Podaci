package zad3;

import java.util.ArrayList;

public class Biblioteka {

	private ArrayList<Knjiga> knjige;
	
	public Biblioteka() {
		this.knjige = new ArrayList<Knjiga>();
	}
	
	public void dodajKnjigu(Knjiga k) {
		this.knjige.add(k);
	}
	
	public void obrisiKnjigu(Knjiga k) {
		this.knjige.remove(k);
	}
	
	public void izmjenaKnjige(Knjiga stara, Knjiga nova) {
		this.knjige.set(this.knjige.indexOf(stara), nova);
	}
	
	private void ispisiFormat(Knjiga k) {
		System.out.printf("Redni broj: %d.  Sifra: %s  Naslov: %s  Godina izdanja: %d  Autori: %s  Cijena: %.2f", 
				(this.knjige.indexOf(k) + 1), k.getSifra(), k.getNaslov(), k.getGodinaIzdanja(), k.getAutori(), k.getCijena());
		System.out.println();
	}
	
	public void ispisiSveKnjige() {
		for (Knjiga k : this.knjige) {
			ispisiFormat(k);
		}
		System.out.println();
	}
	
}
