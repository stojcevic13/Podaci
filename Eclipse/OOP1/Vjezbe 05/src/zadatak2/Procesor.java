package zadatak2;

public class Procesor extends KomponentaRacunara {

	private String radniTakt;
	private int brJezgara;
	
	// konstruktori
	public Procesor() {
		super();
	}
	public Procesor(KomponentaRacunara kr, String radniTakt, int brJezgara) {
		super(kr);
		this.radniTakt = radniTakt;
		this.brJezgara = brJezgara;
	}
	public Procesor(String sifra, String naziv, double cijena, int kolicina, String opis, Kategorija kategorija, String radniTakt, int brJezgara) {
		super(sifra, naziv, cijena, kolicina, opis, kategorija);
		this.radniTakt = radniTakt;
		this.brJezgara = brJezgara;
	}
	public Procesor(String sifra, String naziv, double cijena, int kolicina, String opis, String nazivKategorije,
			String nazivNadkategodire, String nazivPodkategorije, String radniTakt, int brJezgara) {
		super(sifra, naziv, cijena, kolicina, opis, nazivKategorije, nazivNadkategodire, nazivPodkategorije);
		this.radniTakt = radniTakt;
		this.brJezgara = brJezgara;
	}
	public Procesor(Procesor p) {
		this(p.getSifra(), p.getNaziv(), p.getCijena(), p.getKolicina(), p.getOpis(), p.getKategorija().getNaziv(),
				p.getKategorija().getNadkategorija().getNaziv(), p.getKategorija().getPodkategorija().getNaziv(), p.radniTakt, p.brJezgara);
	}
	
	// getteri i setteri
	public String getRadniTakt() {
		return radniTakt;
	}
	public void setRadniTakt(String radniTakt) {
		this.radniTakt = radniTakt;
	}
	public int getBrJezgara() {
		return brJezgara;
	}
	public void setBrJezgara(int brJezgara) {
		this.brJezgara = brJezgara;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + brJezgara;
		result = prime * result + ((radniTakt == null) ? 0 : radniTakt.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procesor other = (Procesor) obj;
		if (brJezgara != other.brJezgara)
			return false;
		if (radniTakt == null) {
			if (other.radniTakt != null)
				return false;
		} else if (!radniTakt.equals(other.radniTakt))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", radniTakt=" + radniTakt + ", brJezgara=" + brJezgara;
	}
	
	
	
	
	
}
