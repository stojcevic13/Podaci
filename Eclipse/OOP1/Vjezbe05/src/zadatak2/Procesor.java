package zadatak2;

public class Procesor extends KomponentaRacunara {
	
	private double radniTakt;
	private int brJezgara;
	
	
	
	
	public Procesor() {}
	public Procesor(String sifra, String naziv, double cijena, int kolicina, String opis, String kategorija, double radniTakt, int brJezgara) {
		super(sifra, naziv, cijena, kolicina, opis, kategorija);
		this.radniTakt = radniTakt;
		this.brJezgara = brJezgara;
	}
	public Procesor(Procesor m) {
		this(m.getSifra(), m.getNaziv(), m.getCijena(), m.getKolicina(), m.getOpis(), m.getKategorija(), m.radniTakt, m.brJezgara);
	}

	
	
	
	public double getRadniTakt() {
		return radniTakt;
	}
	public void setRadniTakt(double radniTakt) {
		this.radniTakt = radniTakt;
	}
	public int getBrJezgara() {
		return brJezgara;
	}
	public void setBrJezgara(int brJezgara) {
		this.brJezgara = brJezgara;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Procesor: " + super.toString() + ", radniTakt=" + this.radniTakt + ", brJezgara=" + this.brJezgara;
	}
	

}
