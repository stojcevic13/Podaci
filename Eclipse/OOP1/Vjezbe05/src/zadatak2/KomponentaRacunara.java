package zadatak2;

public class KomponentaRacunara extends Artikal {

	private String kategorija;
	
	
	
	
	public KomponentaRacunara() {}
	public KomponentaRacunara(String sifra, String naziv, double cijena, int kolicina, String opis, String kategorija) {
		super(sifra, naziv, cijena, kolicina, opis);
		this.kategorija = kategorija;
	}
	public KomponentaRacunara(KomponentaRacunara k) {
		this(k.getSifra(), k.getNaziv(), k.getCijena(), k.getKolicina(), k.getOpis(), k.kategorija);
	}

	
	
	
	public String getKategorija() {
		return kategorija;
	}
	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	
	
	
	@Override
	public String toString() {
		return "KomponentaRacunara: " + super.toString() + ", kategorija" + this.kategorija;
	}

	
	
	
	
	
	
	
	
}
