package zadatak1;

public abstract class Racun {

	protected Osoba vlasnikRacuna;
	protected double stanjeRacuna;
	
	public Osoba getVlasnikRacuna() {
		return vlasnikRacuna;
	}

	public void setVlasnikRacuna(Osoba vlasnikRacuna) {
		this.vlasnikRacuna = vlasnikRacuna;
	}

	public double getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(double stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}

	public Racun() {
		this.vlasnikRacuna = new Osoba();
	}
	
	public Racun(Osoba vlasnikRacuna, double stanjeRacuna) {
		super();
		this.vlasnikRacuna = vlasnikRacuna;
		this.stanjeRacuna = stanjeRacuna;
	}
	
	public abstract boolean podigniPare(double suma);
	public abstract void uplatiPare(double suma);
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(stanjeRacuna);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((vlasnikRacuna == null) ? 0 : vlasnikRacuna.hashCode());
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
		if (Double.doubleToLongBits(stanjeRacuna) != Double.doubleToLongBits(other.stanjeRacuna))
			return false;
		if (vlasnikRacuna == null) {
			if (other.vlasnikRacuna != null)
				return false;
		} else if (!vlasnikRacuna.equals(other.vlasnikRacuna))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vlasnik racuna=" + vlasnikRacuna + "\n, Stanje racuna=" + stanjeRacuna;
	}
	
	

}
