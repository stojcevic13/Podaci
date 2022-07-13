package zadatak2;

public class Memorija extends KomponentaRacunara {

	private double kapacitet;
	
	
	
	public Memorija() {}
	public Memorija(String sifra, String naziv, double cijena, int kolicina, String opis, String kategorija, double kapacitet) {
		super(sifra, naziv, cijena, kolicina, opis, kategorija);
		this.kapacitet = kapacitet;
	}
	public Memorija(Memorija m) {
		this(m.getSifra(), m.getNaziv(), m.getCijena(), m.getKolicina(), m.getOpis(), m.getKategorija(), m.kapacitet);
	}

	
	
	
	public double getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(double kapacitet) {
		this.kapacitet = kapacitet;
	}

	
	
	
	@Override
	public String toString() {
		return "Memorija: " + super.toString() + ", kapacitet=" + kapacitet;
	}

	
	
	
	
	
	
	
	
	
	
}
