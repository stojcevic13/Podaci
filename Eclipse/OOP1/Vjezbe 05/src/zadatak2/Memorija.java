package zadatak2;

public class Memorija extends KomponentaRacunara {

	String kapacitet;

	public Memorija() {
		super();
	}

	public Memorija(KomponentaRacunara kr, String kapacitet) {
		super(kr);
		this.kapacitet = kapacitet;
	}

	public Memorija(String sifra, String naziv, double cijena, int kolicina, String opis, Kategorija kategorija, String kapacitet) {
		super(sifra, naziv, cijena, kolicina, opis, kategorija);
		this.kapacitet = kapacitet;
	}

	public Memorija(String sifra, String naziv, double cijena, int kolicina, String opis, String nazivKategorije,
			String nazivNadkategodire, String nazivPodkategorije, String kapacitet) {
		super(sifra, naziv, cijena, kolicina, opis, nazivKategorije, nazivNadkategodire, nazivPodkategorije);
		this.kapacitet = kapacitet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((kapacitet == null) ? 0 : kapacitet.hashCode());
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
		Memorija other = (Memorija) obj;
		if (kapacitet == null) {
			if (other.kapacitet != null)
				return false;
		} else if (!kapacitet.equals(other.kapacitet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", kapacitet=" + kapacitet;
	}
	
	
	

	
}
