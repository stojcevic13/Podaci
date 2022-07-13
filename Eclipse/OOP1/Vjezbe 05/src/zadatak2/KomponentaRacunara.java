package zadatak2;

public abstract class KomponentaRacunara extends Artikal {

	private Kategorija kategorija;
	
	public KomponentaRacunara() {}
	
	public KomponentaRacunara(String sifra, String naziv, double cijena, int kolicina, String opis, String nazivKategorije, String nazivNadkategodire, String nazivPodkategorije) {
		super(sifra, naziv, cijena, kolicina, opis);
		this.kategorija = new Kategorija(nazivKategorije, nazivNadkategodire, nazivPodkategorije);
	}
	
	public KomponentaRacunara(String sifra, String naziv, double cijena, int kolicina, String opis, Kategorija kategorija) {
		super(sifra, naziv, cijena, kolicina, opis);
		this.kategorija = kategorija;
	}
	
	public KomponentaRacunara(KomponentaRacunara kr) {
		this(kr.getSifra(), kr.getNaziv(), kr.getCijena(), kr.getKolicina(), kr.getOpis(), kr.getKategorija());
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((kategorija == null) ? 0 : kategorija.hashCode());
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
		KomponentaRacunara other = (KomponentaRacunara) obj;
		if (kategorija == null) {
			if (other.kategorija != null)
				return false;
		} else if (!kategorija.equals(other.kategorija))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "kategorija=" + this.kategorija;
	}


}
