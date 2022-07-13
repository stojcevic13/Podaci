package Zad5;

public class Predmet {
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private int semestar;
	private String profesor;
	
	
	public Predmet() {
		
	}
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, int semestar, String profesor) {
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.profesor = profesor;
	}
	
	
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	public int getSemestar() {
		return semestar;
	}
	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	public void ispisiPredmet() {
		System.out.printf("Sifra: %s  Naziv: %s  Semestar: %d  Profesor: %s \n",
				this.getSifraPredmeta(), this.getNazivPredmeta(), this.getSemestar(), this.getProfesor());
	}

}
