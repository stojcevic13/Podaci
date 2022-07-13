package zadatak2;

public abstract class Artikal {
	
	private String sifra;
	private String naziv;
	private double cijena;
	private int kolicina;
	private String opis;
	
	
	public Artikal() {}
	
	public Artikal(String sifra, String naziv, double cijena, int kolicina, String opis) {
		this();
		this.sifra = sifra;
		this.naziv = naziv;
		this.cijena = cijena;
		this.kolicina = kolicina;
		this.opis = opis;
	}
	
	public Artikal(Artikal a) {
		this(a.sifra, a.naziv, a.cijena, a.kolicina, a.opis);
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

	public int getKolicina() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cijena);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + kolicina;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
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
		Artikal other = (Artikal) obj;
		if (Double.doubleToLongBits(cijena) != Double.doubleToLongBits(other.cijena))
			return false;
		if (kolicina != other.kolicina)
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "sifra=" + sifra + ", naziv=" + naziv + ", cijena=" + cijena + ", kolicina=" + kolicina
				+ ", opis=" + opis;
	}
	
	
	
	

}
