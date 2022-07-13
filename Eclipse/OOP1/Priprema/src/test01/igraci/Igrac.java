package test01.igraci;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Igrac {

	private String ime;
	private String prezime;
	private LocalDate godinaRodjenja;
	private String klub;
	private double prosekPoena;
	private double prosekAsistencija;
	private double prosekSkokova;
	
	
	
	
	
	public Igrac() {
		
	}

	public Igrac(String ime, String prezime, String godinaRodjenja, String klub, double prosekPoena,
			double prosekAsistencija, double prosekSkokova) {
		this();
		this.ime = ime;
		this.prezime = prezime;
		this.godinaRodjenja = LocalDate.parse(godinaRodjenja, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		this.klub = klub;
		this.prosekPoena = prosekPoena;
		this.prosekAsistencija = prosekAsistencija;
		this.prosekSkokova = prosekSkokova;
	}
	
	public Igrac(String ime, String prezime, LocalDate godinaRodjenja, String klub, double prosekPoena,
			double prosekAsistencija, double prosekSkokova) {
		this();
		this.ime = ime;
		this.prezime = prezime;
		this.godinaRodjenja = godinaRodjenja;
		this.klub = klub;
		this.prosekPoena = prosekPoena;
		this.prosekAsistencija = prosekAsistencija;
		this.prosekSkokova = prosekSkokova;
	}
	
	public Igrac(Igrac i) {
		this(i.ime, i.prezime, i.godinaRodjenja, i.klub, i.prosekPoena, i.prosekAsistencija, i.prosekSkokova);
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

	public LocalDate getGodinaRodjenja() {
		return godinaRodjenja;
	}

	public void setGodinaRodjenja(LocalDate godinaRodjenja) {
		this.godinaRodjenja = godinaRodjenja;
	}

	public String getKlub() {
		return klub;
	}

	public void setKlub(String klub) {
		this.klub = klub;
	}

	public double getProsekPoena() {
		return prosekPoena;
	}

	public void setProsekPoena(double prosekPoena) {
		this.prosekPoena = prosekPoena;
	}

	public double getProsekAsistencija() {
		return prosekAsistencija;
	}

	public void setProsekAsistencija(double prosekAsistencija) {
		this.prosekAsistencija = prosekAsistencija;
	}

	public double getProsekSkokova() {
		return prosekSkokova;
	}

	public void setProsekSkokova(double prosekSkokova) {
		this.prosekSkokova = prosekSkokova;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Igrac [ime=" + ime + ", prezime=" + prezime + ", godinaRodjenja=" + godinaRodjenja + ", klub=" + klub
				+ ", prosekPoena=" + prosekPoena + ", prosekAsistencija=" + prosekAsistencija + ", prosekSkokova="
				+ prosekSkokova + "]";
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(LocalDate.parse("21-12-2012", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	}
	
	
	
	
}
