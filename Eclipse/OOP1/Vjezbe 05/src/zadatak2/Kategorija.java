package zadatak2;

public class Kategorija {
	
	private String naziv;
	private Kategorija nadkategorija;
	private Kategorija podkategorija;
	
	public Kategorija() {
		this.nadkategorija = new Kategorija();
		this.podkategorija = new Kategorija();
	}
	
	public Kategorija(String naziv) {
		this();
		this.naziv = naziv;
	}

	public Kategorija(String naziv, String nazivNadkategorije, String nazivPodkategorije) {
		this();
		this.naziv = naziv;
		this.nadkategorija.naziv = nazivNadkategorije;
		this.podkategorija.naziv = nazivPodkategorije;
	}
	
	public Kategorija(Kategorija k) {
		this(k.naziv, k.nadkategorija.naziv, k.podkategorija.naziv);
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Kategorija getNadkategorija() {
		return nadkategorija;
	}

	public void setNadkategorija(Kategorija nadkategorija) {
		this.nadkategorija = nadkategorija;
	}

	public Kategorija getPodkategorija() {
		return podkategorija;
	}

	public void setPodkategorija(Kategorija podkategorija) {
		this.podkategorija = podkategorija;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nadkategorija == null) ? 0 : nadkategorija.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((podkategorija == null) ? 0 : podkategorija.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kategorija other = (Kategorija) obj;
		if (nadkategorija == null) {
			if (other.nadkategorija != null)
				return false;
		} else if (!nadkategorija.equals(other.nadkategorija))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (podkategorija == null) {
			if (other.podkategorija != null)
				return false;
		} else if (!podkategorija.equals(other.podkategorija))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Naziv=" + naziv + ", nadkategorija=" + nadkategorija.naziv;
	}
	
	
	
	

}
