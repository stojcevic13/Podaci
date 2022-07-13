package vezbe6.primer7;

public class Knjiga {

	protected String sifra;
	protected String naziv;
	protected Double cena;
	protected Integer godinaPublikovanja;

	public Knjiga(String sifra, String naziv, Double cena, Integer godinaPublikovanja) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.cena = cena;
		this.godinaPublikovanja = godinaPublikovanja;
	}

	@Override
	public String toString() {
		return "Sifra: " + this.sifra + "\tNaziv: " + this.naziv + "\tCena: " + this.cena + "\tGodina publikovanja: "
				+ this.godinaPublikovanja;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Integer getGodinaPublikovanja() {
		return godinaPublikovanja;
	}

	public void setGodinaPublikovanja(Integer godinaPublikovanja) {
		this.godinaPublikovanja = godinaPublikovanja;
	}

	
}
