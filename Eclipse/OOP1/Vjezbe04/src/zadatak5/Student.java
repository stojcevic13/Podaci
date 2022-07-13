package zadatak5;

import java.util.ArrayList;

public class Student {

	private String indeks;
	private String ime;
	private String prezime;
	private Integer godUpisa;
	private ArrayList<Ocena> ocene;
	private Double prosek;
	
	
	
	
	// KONSTRUKTORI
	
	public Student() {
		this.ocene = new ArrayList<Ocena>();
	}
	public Student(String indeks, String ime, String prezime, Integer godUpisa, ArrayList<Ocena> ocene, Double prosek) {
		this();
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
		this.godUpisa = godUpisa;
		this.ocene = ocene;
		this.prosek = prosek;
	}
	public Student(Student s) {
		this(s.indeks, s.ime, s.prezime, s.godUpisa, s.ocene, s.prosek);
	}

	
	
	
	// GETTERI I SETTERI
	
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
	public Integer getGodUpisa() {
		return godUpisa;
	}
	public void setGodUpisa(Integer godUpisa) {
		this.godUpisa = godUpisa;
	}
	public ArrayList<Ocena> getOcene() {
		return ocene;
	}
	public void setOcene(ArrayList<Ocena> ocene) {
		this.ocene = ocene;
	}
	public Double getProsek() {
		return prosek;
	}
	public void setProsek(Double prosek) {
		this.prosek = prosek;
	}

	
	
	
	// OVERRIDE
	
	@Override
	public String toString() {
		return "Student [indeks=" + indeks + ", ime=" + ime + ", prezime=" + prezime + ", godUpisa=" + godUpisa
				+ ", ocene=" + ocene + ", prosek=" + prosek + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
