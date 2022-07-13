package vezbe6.primer6;

public class Knjiga implements Comparable {

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

	/**
	 * Metoda na osnovu koje ce se vrsiti poredjenje prilikom sortiranja elemenata
	 */
	@Override
	public int compareTo(Object o) {
		Knjiga objKnjiga = (Knjiga) o;
		return this.naziv.compareTo(objKnjiga.naziv);
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

	@Override
	public String toString() {
		return "Sifra: " + this.sifra + "\tNaziv: " + this.naziv + "\tCena: " + this.cena + "\tGodina publikovanja: "
				+ this.godinaPublikovanja;
	}

}
