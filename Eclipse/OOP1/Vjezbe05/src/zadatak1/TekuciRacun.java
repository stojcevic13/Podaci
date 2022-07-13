package zadatak1;

public class TekuciRacun extends Racun {

	private double mesecnaNaknada;
	
	
	
	
	public TekuciRacun() {}
	public TekuciRacun(Osoba vlasnik, double stanje, double mesecnaNaknada) {
		super(vlasnik, stanje);
		this.mesecnaNaknada = mesecnaNaknada;
	}
	public TekuciRacun(TekuciRacun r) {
		this(r.getVlasnik(), r.getStanje(), r.mesecnaNaknada);
	}
	
	
	

	public double getMesecnaNaknada() {
		return mesecnaNaknada;
	}
	public void setMesecnaNaknada(double mesecnaNaknada) {
		this.mesecnaNaknada = mesecnaNaknada;
	}
	
	

	
	
	@Override
	public String toString() {
		String ret = super.toString();
		return ret + "mesecnaNaknada=" + mesecnaNaknada;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(mesecnaNaknada);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TekuciRacun other = (TekuciRacun) obj;
		if (Double.doubleToLongBits(mesecnaNaknada) != Double.doubleToLongBits(other.mesecnaNaknada))
			return false;
		return true;
	}

	
	
	
	
	@Override
	public boolean podigniPare(double suma) {
		if (suma > this.getStanje())
			return false;
		this.setStanje(this.getStanje() - suma);
		return true;
	}

	@Override
	public void uplatiPare(double suma) {
		this.setStanje(this.getStanje() + (suma - suma*0.01));
	}
	
	public void obracunajMesecnuNaknadu() {
		this.setStanje(this.getStanje() - this.mesecnaNaknada);
	}

	
}
