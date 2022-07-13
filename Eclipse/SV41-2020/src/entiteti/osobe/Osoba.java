package entiteti.osobe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Osoba {

	public enum Pol {muško, žensko};
	
	private String id;
	private String ime;
	private String prezime;
	private Pol pol;
	private LocalDate datumRodjenja;
	private String telefon;
	private String adresa;
	
	
	
	
	
	public Osoba() {
		
	}

	public Osoba(String id, String ime, String prezime, Pol pol, String datumRodjenja, String telefon,
			String adresa) {
		this();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.datumRodjenja = LocalDate.parse(datumRodjenja, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		this.telefon = telefon;
		this.adresa = adresa;
//		this.uloga = uloga;
	}

	
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Pol getPol() {
		return pol;
	}

	public String getPolStr() {
		return "" + pol;
	}
	
	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public String getDatumRodjenjaStr() {
		if (datumRodjenja != null)
			return datumRodjenja.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		return "";
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public void setDatumRodjenjaStr(String datumRodjenja) {
		this.datumRodjenja = LocalDate.parse(datumRodjenja, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	
	
	
	
	@Override
	public String toString() {
		return "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol + ", datumRodjenja="
				+ datumRodjenja.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ", telefon=" + telefon + ", adresa=" + adresa;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Osoba o = new Osoba("0000", "fdf", "pr", Osoba.Pol.muško, "21.12.2012", "43942", "fsd");
		System.out.println(o);
	}
	
	
	
	
}
