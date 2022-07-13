package zadatak2;

public class StavkaRacuna {
	
	private String redBrStavkeRacuna;
	private Artikal artikal;
	private double cijena;
	private double kolicina;
	
	
	
	
	public StavkaRacuna() {}
	public StavkaRacuna(String redBrStavkeRacuna, Artikal artikal, double cijena, double kolicina) {
		this();
		this.redBrStavkeRacuna = redBrStavkeRacuna;
		this.artikal = artikal;
		this.cijena = cijena;
		this.kolicina = kolicina;
	}
	public StavkaRacuna(StavkaRacuna s) {
		this(s.redBrStavkeRacuna, s.artikal, s.cijena, s.kolicina);
	}
	public String getRedBrStavkeRacuna() {
		return redBrStavkeRacuna;
	}

	
	
	
	public void setRedBrStavkeRacuna(String redBrStavkeRacuna) {
		this.redBrStavkeRacuna = redBrStavkeRacuna;
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
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((redBrStavkeRacuna == null) ? 0 : redBrStavkeRacuna.hashCode());
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
		if (redBrStavkeRacuna == null) {
			if (other.redBrStavkeRacuna != null)
				return false;
		} else if (!redBrStavkeRacuna.equals(other.redBrStavkeRacuna))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StavkaRacuna: redBrStavkeRacuna=" + redBrStavkeRacuna + ", artikal=" + artikal + ", cijena=" + cijena
				+ ", kolicina=" + kolicina;
	}

	
	
	
	
	
	
	
	
	
	
}
