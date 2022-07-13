package zad2;

import java.util.ArrayList;

public class Prodavnica {
	
	ArrayList<Artikal> artikli;
	
	public Prodavnica() {
		this.artikli = new ArrayList<Artikal>();
	}
	
	void dodajArtikal(Artikal a) {
		this.artikli.add(a);
	}
	
	void izmjenaCijeneArtikla(Artikal a, double novaCijena) {
		Artikal izmijenjen = a;
		izmijenjen.setCijena(novaCijena);
		this.artikli.set(this.artikli.indexOf(a), izmijenjen);
	}
	
	void izmjenaNazivaArtikla(Artikal a, String noviNaziv) {
		Artikal izmijenjen = a;
		izmijenjen.setNaziv(noviNaziv);
		this.artikli.set(this.artikli.indexOf(a), izmijenjen);
	}
	
	void izmjenaKolicineArtikla(Artikal a, int novaKolicina) {
		Artikal izmijenjen = a;
		izmijenjen.setRaspolozivaKolicina(novaKolicina);
		this.artikli.set(this.artikli.indexOf(a), izmijenjen);
	}
	
	void ispisiSvePodatkeOArtiklu(Artikal a) {
		System.out.println("Sifra: " + a.getSifra());
		System.out.println("Naziv: " + a.getNaziv());
		System.out.println("Cijena: " + a.getCijena());
		System.out.println("Raspoloziva kolicina: " + a.getRaspolozivaKolicina());
		System.out.println("Opis: " + a.getOpis());
		System.out.println("Kategorija: " + a.getKategorija());
	}
	
	private void ispisiFormat(Artikal a) {
		System.out.printf("Redni broj: %d  Naziv: %s  Cijena: %.2f  Kolicina: %d  Sifra: %s ", 
				(this.artikli.indexOf(a) + 1), a.getNaziv(), a.getCijena(), a.getRaspolozivaKolicina(), a.getSifra());
		System.out.println();
	}
	
	public void ispisiSveArtikle() {
		for (Artikal a : this.artikli) {
			ispisiFormat(a);
		}
		System.out.println();
	}
	
	public void ispisiArtiklePoKategoriji(String kategorija) {
		for (Artikal a : this.artikli) {
			if (a.getKategorija().equalsIgnoreCase(kategorija))
				ispisiFormat(a);
		}
		System.out.println();
	}
	
	public void sortirajPoNazivu() {
		Artikal tmp = new Artikal();
		for (int i = 0; i < this.artikli.size() - 1; i++) {
			for (int j = i+1; j < this.artikli.size(); j++) {
				if (this.artikli.get(i).getNaziv().charAt(0) > this.artikli.get(j).getNaziv().charAt(0)) {
					tmp = this.artikli.get(i);
					this.artikli.set(i, this.artikli.get(j));
					this.artikli.set(j, tmp);
				}
			}
		}
	}
	
	public void sortirajPoCijeni() {
		Artikal tmp = new Artikal();
		for (int i = 0; i < this.artikli.size() - 1; i++) {
			for (int j = i+1; j < this.artikli.size(); j++) {
				if (this.artikli.get(i).getCijena() > this.artikli.get(j).getCijena()) {
					tmp = this.artikli.get(i);
					this.artikli.set(i, this.artikli.get(j));
					this.artikli.set(j, tmp);
				}
			}
		}
	}
	
	public void sortirajPoKategoriji() {
		Artikal tmp = new Artikal();
		for (int i = 0; i < this.artikli.size() - 1; i++) {
			for (int j = i+1; j < this.artikli.size(); j++) {
				if (this.artikli.get(i).getKategorija().charAt(0) > this.artikli.get(j).getKategorija().charAt(0)) {
					tmp = this.artikli.get(i);
					this.artikli.set(i, this.artikli.get(j));
					this.artikli.set(j, tmp);
				}
			}
		}
	}



}
