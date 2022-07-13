package zad2;

public class Artikal {

	private String sifra;
	private String naziv;
	private double cijena;
	private int raspolozivaKolicina;
	private String opis;
	private String kategorija;
	
	public Artikal(){
		this.sifra = "nepoznato";
		this.naziv = "nepoznato";
		this.opis = "nepoznato";
		this.kategorija = "nepoznato";
	}
	
	
	public Artikal(String sifra, String naziv, double cijena, int raspolozivaKolicina, String opis, String kategorija) {
			this.sifra = sifra;
			this.naziv = naziv;
			this.cijena = cijena;
			this.raspolozivaKolicina = raspolozivaKolicina;
			this.opis = opis;
			this.kategorija = kategorija;
		}
	
	public Artikal(Artikal a) {
		this.sifra = a.sifra;
		this.naziv = a.naziv;
		this.cijena = a.cijena;
		this.raspolozivaKolicina = a.raspolozivaKolicina;
		this.opis = a.opis;
		this.kategorija = a.kategorija;
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

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public int getRaspolozivaKolicina() {
		return raspolozivaKolicina;
	}

	public void setRaspolozivaKolicina(int raspolozivaKolicina) {
		this.raspolozivaKolicina = raspolozivaKolicina;
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
	
	
	
	
	
}
