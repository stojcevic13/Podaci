package zadatak3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Student extends Osoba {

	private String indeks;
	private LocalDate datumUpisa;
	private ArrayList<Predmet> predmeti;
	private String ocene;
	private double prosek;
	
	
	
	
	public Student() {}

	public Student(String ime, String prezime, String jmbg, String indeks, String datumUpisa, ArrayList<Predmet> predmeti, String ocene, double prosek) {
		super(ime, prezime, jmbg);
		this.indeks = indeks;
		this.datumUpisa = LocalDate.parse(datumUpisa, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		this.predmeti = predmeti;
		this.ocene = ocene;
		this.prosek = prosek;
	}

	@Override
	public String toString() {
		return "Student [indeks=" + indeks + ", datumUpisa=" + datumUpisa + ", predmeti=" + predmeti + ", ocene="
				+ ocene + ", prosek=" + prosek + "]";
	}

	
	
	
	
	
	
}
