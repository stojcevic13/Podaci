package zadatak1;

public abstract class Racun {

	private Osoba vlasnik;
	private double stanje;
	
	
	
	
	public Racun() {
		this.vlasnik = new Osoba();
	}
	public Racun(Osoba vlasnik, double stanje) {
		this();
		this.vlasnik = vlasnik;
		this.stanje = stanje;
	}
	public Racun(Racun r) {
		this(r.vlasnik, r.stanje);
	}

	
	
	
	public Osoba getVlasnik() {
		return vlasnik;
	}
	public void setVlasnik(Osoba vlasnik) {
		this.vlasnik = vlasnik;
	}
	public double getStanje() {
		return stanje;
	}
	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	
	
	
	@Override
	public String toString() {
		return "Vlasnik:\n" + vlasnik + "\nStanje: " + stanje;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(stanje);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((vlasnik == null) ? 0 : vlasnik.hashCode());
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
		Racun other = (Racun) obj;
		if (Double.doubleToLongBits(stanje) != Double.doubleToLongBits(other.stanje))
			return false;
		if (vlasnik == null) {
			if (other.vlasnik != null)
				return false;
		} else if (!vlasnik.equals(other.vlasnik))
			return false;
		return true;
	}
	
	
	
	
	public abstract boolean podigniPare(double suma);
	public abstract void uplatiPare(double suma);
	
	
	
	
}
