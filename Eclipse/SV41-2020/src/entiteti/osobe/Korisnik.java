package entiteti.osobe;


public class Korisnik extends Osoba {
	
	public static enum Uloge {UCENIK, PREDAVAC, SEKRETAR, ADMINISTRATOR};


	private boolean aktivan;
	private String korisnickoIme;
	private String lozinka;
	private Uloge uloga;
	
	
	
	
	
	public Korisnik() {
		
	}

	public Korisnik(String id, boolean aktivan, String ime, String prezime, Pol pol, String datumRodjenja, String telefon,
			String adresa, String korisnickoIme, String lozinka) {
		super(id, ime, prezime, pol, datumRodjenja, telefon, adresa);
		this.aktivan = aktivan;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	


	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public Uloge getUloga() {
		return uloga;
	}

	public void setUloga(Uloge uloga) {
		this.uloga = uloga;
	}
	
	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	
	
	
	@Override
	public String toString() {
		return super.toString() + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", uloga=" + this.uloga;
	}
	
	
	
	
	public static void main(String[] args) {
		Korisnik k = new Korisnik("0000", true, "Pera", "Peric", Osoba.Pol.muško, "21.12.2012", "04230923", "adresa12", "pperic", "pera123");
		System.out.println(k);
	}
	
	
	
	
	
}
