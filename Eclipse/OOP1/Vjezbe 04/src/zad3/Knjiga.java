package zad3;

public class Knjiga {
	
	private String sifra;
	private String naslov;
	private int godinaIzdanja;
	private String autori;
	private double cijena;
	
	public Knjiga() {
		this.sifra = "nepoznato";
		this.naslov = "nepoznato";
		this.autori = "nepoznato";
	}
	
	public Knjiga(String sifra, String naslov, int godinaIzdanja, String autori, double cijena) {
		this.sifra = sifra;
		this.naslov = naslov;
		this.godinaIzdanja = godinaIzdanja;
		this.autori = autori;
		this.cijena = cijena;
	}
	
	public Knjiga(Knjiga k) {
		this.sifra = k.sifra;
		this.naslov = k.naslov;
		this.godinaIzdanja = k.godinaIzdanja;
		this.autori = k.autori;
		this.cijena = k.cijena;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public int getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(int godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

	public String getAutori() {
		return autori;
	}

	public void setAutori(String autori) {
		this.autori = autori;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	
	

}
