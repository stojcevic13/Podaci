package Zad5;

import java.util.ArrayList;

public class Student {

	private String indeks;
	private String ime;
	private String prezime;
	private int godinaUpisa;
	private ArrayList<Ocjena> ocjene;
	
	
	public Student() {
		this.ocjene = new ArrayList<Ocjena>();
	}
	
	public Student(String indeks, String ime, String prezime, int godinaUpisa) {
		super();
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
		this.godinaUpisa = godinaUpisa;
		this.ocjene = new ArrayList<Ocjena>();
	}

	
	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public ArrayList<Ocjena> getOcjene() {
		return ocjene;
	}

	public void setOcjene(ArrayList<Ocjena> ocjene) {
		this.ocjene = ocjene;
	}

	public double getProsjek() {
		return this.ocjene.size() / suma(this.ocjene) ;
	}

	private int suma(ArrayList<Ocjena> ocjene) {
		int suma = 0;
		for (Ocjena o: ocjene) {
			suma += o.getOcjena(); 
		}
		return suma;
	}
	
	public void dodajOcjenu(Ocjena ocjena) {
		this.ocjene.add(ocjena);
	}
	
	public void izbrisiOcjenu(Ocjena ocjena) {
		this.ocjene.remove(ocjena);
	}
	
	public void ispisiOcjene() {
		System.out.println("Ocjene: ");
		for (Ocjena o : this.ocjene) {
			System.out.printf("Predmet: %s  Ocjena: %d \n", o.getPredmet().getNazivPredmeta(), o.getOcjena());
		}
	}
	
	
	
	

	
}
