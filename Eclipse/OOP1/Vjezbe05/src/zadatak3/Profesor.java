package zadatak3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Profesor extends Osoba {
	
	 String brLicneKarte;
	 LocalDate datZaposljavanja;
	 String titula;
	 ArrayList<Predmet> predmeti;
	
	
	
	public Profesor () {
		this.predmeti = new ArrayList<Predmet>();
	}
	public Profesor(String ime, String prezime, String jmbg, String brLicneKarte, String datZaposljavanja, String titula) {
		super(ime, prezime, jmbg);
		this.brLicneKarte = brLicneKarte;
		this.datZaposljavanja = LocalDate.parse(datZaposljavanja, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		this.titula = titula;
		this.predmeti = new ArrayList<Predmet>();
	}
	public Profesor(String brLicneKarte, String datZaposljavanja, String titula, ArrayList<Predmet> predmeti) {
		this();
		this.brLicneKarte = brLicneKarte;
		this.datZaposljavanja = LocalDate.parse(datZaposljavanja, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		this.titula = titula;
		this.predmeti = predmeti;
	}

	
	@Override
	public String toString() {
		return "Profesor: " + super.toString() + ", brLicneKarte=" + brLicneKarte + ", datZaposljavanja=" + datZaposljavanja + ", titula="
				+ titula + ", predmeti=" + predmeti;
	}
	
	
	

}
