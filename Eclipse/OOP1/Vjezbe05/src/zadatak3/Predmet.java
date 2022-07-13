package zadatak3;

public class Predmet {

	 String sifra;
	 String naziv;
	 String semestar;
	 Profesor profesor;
	
	
	
	
	public Predmet() {
		this.profesor = new Profesor();
	}
	public Predmet(String sifra, String naziv, String semestar) {
		this();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
	}
	public Predmet(String sifra, String naziv, String semestar, Profesor profesor) {
		this();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.profesor = profesor;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Predmet: sifra=" + sifra + ", naziv=" + naziv + ", semestar=" + semestar + ", profesor=" + profesor.getIme() + " " + profesor.getPrezime();
	}

	
	
	
	
	
	
	
}
