package zadatak2;

public class Artikal {

	private String sifra;
	private String naziv;
	private Double cijena;
	private Integer kolicina;
	private String opis;
	private String kategorija;
	
	
	
	// KONSTRUKTORI
	
	public Artikal() {};
	
	public Artikal(String sifra, String naziv, double cijena, int kolicina, String opis, String kategorija) {
		this.sifra = sifra;
		this.naziv = naziv;
		this.cijena = cijena;
		this.kolicina = kolicina;
		this.opis = opis;
		this.kategorija = kategorija;
	}
	
	public Artikal(Artikal a) {
		this(a.sifra, a.naziv, a.cijena, a.kolicina, a.opis, a.kategorija);
	}

	
	
	// GETTERI I SETTERI
	
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

	public Double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public Integer getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getKategorija() {
		return kategorija;
	}
	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	
	
	

	@Override
	public String toString() {
		return "Artikal [sifra=" + sifra + ", naziv=" + naziv + ", cijena=" + cijena + ", kolicina=" + kolicina
				+ ", opis=" + opis + ", kategorija=" + kategorija + "]";
	}
	
	
	
}
