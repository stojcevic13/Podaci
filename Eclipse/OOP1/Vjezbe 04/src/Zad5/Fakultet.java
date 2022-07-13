package Zad5;

import java.util.ArrayList;
import java.util.Scanner;

public class Fakultet {
	
	ArrayList<Student> studenti;
	ArrayList<Predmet> predmeti;
	
	public Fakultet() {
		this.studenti = new ArrayList<Student>();
		this.predmeti = new ArrayList<Predmet>();
	}
	
	public Fakultet(ArrayList<Student> studenti, ArrayList<Predmet> predmeti) {
		super();
		this.studenti = studenti;
		this.predmeti = predmeti;
	}
	
	public void dodajStudenta(Student student) {
		this.studenti.add(student);
	}
	
	public void obrisiStudenta(Student student) {
		this.studenti.remove(student);
	}
	
	public void ispisiStudente(int... red) {
		for (Student s : this.studenti) {
			System.out.printf("Br indeksa: %s  Ime: %s  Prezime: %s  Godina upisa: %d  Prosjek: %.2f \n",
					s.getIndeks(), s.getIme(), s.getPrezime(), s.getGodinaUpisa(), s.getProsjek());
			s.ispisiOcjene();
		}
	}
	
	public ArrayList<Student> pretragaPoIndeksu(String indeks) {
		ArrayList<Student> selektovani = new ArrayList<Student>();
		for (Student s : this.studenti) {
			if (s.getIndeks().equals(indeks))
				selektovani.add(s);
		}
		return selektovani;
	}
	
	public ArrayList<Student> pretragaPoImenu(String ime) {
		ArrayList<Student> selektovani = new ArrayList<Student>();
		for (Student s : this.studenti) {
			if (s.getIme().equals(ime))
				selektovani.add(s);
		}
		return selektovani;
	}
	
	public ArrayList<Student> pretragaPoPrezimenu(String prezime) {
		ArrayList<Student> selektovani = new ArrayList<Student>();
		for (Student s : this.studenti) {
			if (s.getPrezime().equals(prezime))
				selektovani.add(s);
		}
		return selektovani;
	}
	
	public ArrayList<Student> pretragaPoGodUpisa(int godinaUpisa) {
		ArrayList<Student> selektovani = new ArrayList<Student>();
		for (Student s : this.studenti) {
			if (s.getGodinaUpisa() == godinaUpisa)
				selektovani.add(s);
		}
		return selektovani;
	}
	
	public ArrayList<Student> pretragaPoProsjeku(double donjaGranica, double gornjaGranica) {
		ArrayList<Student> selektovani = new ArrayList<Student>();
		for (Student s : this.studenti) {
			if (s.getProsjek() >= donjaGranica && s.getProsjek() <= gornjaGranica)
				selektovani.add(s);
		}
		return selektovani;
	}
	
	

	public void dodajPredmet(Predmet predmet) {
		this.predmeti.add(predmet);
	}
	
	public void obrisiPredmet(Predmet predmet) {
		this.predmeti.remove(predmet);
	}
	
	
	public void ispisipredmete() {
		for (Predmet p : this.predmeti) {
			p.ispisiPredmet();
		}
	}
	
	public ArrayList<Predmet> pretragaPredmetaPoSifri(String sifra){
		ArrayList<Predmet> selektovani = new ArrayList<Predmet>();
		for(Predmet p : this.predmeti) {
			if (p.getSifraPredmeta().equals(sifra))
				selektovani.add(p);
		}
		return selektovani;
	}
	
	public ArrayList<Predmet> pretragaPredmetaPoSemestru(int semestar){
		ArrayList<Predmet> selektovani = new ArrayList<Predmet>();
		for(Predmet p : this.predmeti) {
			if (p.getSemestar() == semestar)
				selektovani.add(p);
		}
		return selektovani;
	}
	
	public ArrayList<Predmet> pretragaPredmetaPoProfesoru(String profesor){
		ArrayList<Predmet> selektovani = new ArrayList<Predmet>();
		for(Predmet p : this.predmeti) {
			if (p.getProfesor().equals(profesor))
				selektovani.add(p);
		}
		return selektovani;
	}
	
	
	public void unesiNoviPredmet() {
		Scanner sc = new Scanner(System.in);
		String sifra = Utility.unosStringa(sc, "Sifra predmeta: ");
		String naziv = Utility.unosStringa(sc, "Naziv predmeta");
		int semestar = Utility.unosBroja(sc, "Semestar: ");
		String profesor = Utility.unosStringa(sc, "Profesor: ");
		Predmet p = new Predmet(sifra, naziv, semestar, profesor);
		dodajPredmet(p);
		sc.close();
	}
	
	private Predmet vratiPredmetUnosomSifre() {
		String sifra;
		Scanner sc = new Scanner(System.in);
		do {
			sifra = Utility.unosStringa(sc, "Sifra predmeta: ");
			for (Predmet p : this.predmeti) {
				if (p.getSifraPredmeta().equals(sifra)) {
					sc.close();
					return p;
				}
			System.out.println("Pogresna sifra. Pokusajte ponovo.\n");
			sc.nextLine();
			}
		} while (true);
	}
	
	public void izmjenaPodatakaOPredmetu() {
		Scanner sc = new Scanner(System.in);
		Predmet stariPredmet = vratiPredmetUnosomSifre();
		ispisiOpcijeIzmjenePredmeta();
		int opcija = Utility.unosOpcije(sc, 1, 3);
		
		switch (opcija) {
			case 1:
				String naziv = Utility.unosStringa(sc, "Novi naziv predmeta: ");
				stariPredmet.setNazivPredmeta(naziv);
			case 2:
				int semestar = Utility.unosBroja(sc, "Novi semestar: ");
				stariPredmet.setSemestar(semestar);
			case 3:
				String profesor = Utility.unosStringa(sc, "Novi profesor: ");
				stariPredmet.setProfesor(profesor);
		}
		sc.close();
	}

	private void ispisiOpcijeIzmjenePredmeta() {
		System.out.println("1 - Promjena naziva predmeta");
		System.out.println("2 - Promjena semestra");
		System.out.println("3 - Promjena profesora");
	}
	
	public void obrisiPredmet() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Brisanje predmeta:");
		Predmet predmetZaBrisanje = vratiPredmetUnosomSifre();
		this.predmeti.remove(predmetZaBrisanje);
	}
	
	public void ispisiPredmetOdabranSifrom() {
		Scanner sc = new Scanner(System.in);
		Predmet p = vratiPredmetUnosomSifre();
		p.ispisiPredmet();
	}
	
	public void unosNovogStudenta() {
		Scanner sc = new Scanner(System.in);
		Student s = new Student();
		s.setIndeks(unosIndeksa()); 
		s.setIme(Utility.unosStringa(sc, "Ime: "));
		s.setPrezime(Utility.unosStringa(sc, "Prezime: "));
		s.setGodinaUpisa(Utility.unosBroja(sc, "Godina upisa: "));
		this.dodajStudenta(s);
		
	}

	private String unosIndeksa() {
		String indeks;
		boolean ponovljeno = false;
		Scanner sc = new Scanner(System.in);
		do {
			indeks = Utility.unosStringa(sc, "Broj indeksa: ");
			for (Student s : this.studenti) {
				if (s.getIndeks().equals(s)) {
					System.out.println("Ovakav broj indeksa vec postoji. Pokusajte ponovo.");
					ponovljeno = true;
					break;
				}
				if (ponovljeno == false)
					return indeks;
				sc.nextLine();
			}
		} while (true);
	}
	
	
	
	
	
	

}
