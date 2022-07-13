package zadatak2;

public class StavkaRacuna {

	private int redniBroj;
	private Artikal artikal;
	private double cijena;
	private int kolicina;
	
	
	// konstruktori
	public StavkaRacuna() {}
	public StavkaRacuna(int redniBroj, Artikal artikal, double cijena, int kolicina) {
		this();
		this.redniBroj = redniBroj;
		this.artikal = artikal;
		this.cijena = cijena;
		this.kolicina = kolicina;
	}

	
	// getteri i setteri
	public StavkaRacuna(StavkaRacuna sr) {
		this(sr.redniBroj, sr.artikal, sr.cijena, sr.kolicina);
	}
	public int getRedniBroj() {
		return redniBroj;
	}
	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}
	public Artikal getArtikal() {
		return artikal;
	}
	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
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

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artikal == null) ? 0 : artikal.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cijena);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + kolicina;
		result = prime * result + redniBroj;
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
		StavkaRacuna other = (StavkaRacuna) obj;
		if (artikal == null) {
			if (other.artikal != null)
				return false;
		} else if (!artikal.equals(other.artikal))
			return false;
		if (Double.doubleToLongBits(cijena) != Double.doubleToLongBits(other.cijena))
			return false;
		if (kolicina != other.kolicina)
			return false;
		if (redniBroj != other.redniBroj)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "redniBroj=" + redniBroj + ", artikal=" + artikal + ", cijena=" + cijena + ", kolicina=" + kolicina;
	}
	
	
	
	
	
	
	
}
