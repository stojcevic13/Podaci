package zadatak1;

public class TekuciRacun extends Racun {
	
	private double mjesecnaNaknada;
	
	public TekuciRacun() {
		
	}
	
	public TekuciRacun(Osoba vlasnikRacuna, double stanjeRacuna, double mjesecnaNaknada) {
		super(vlasnikRacuna, stanjeRacuna);
		this.mjesecnaNaknada = mjesecnaNaknada;
	}

	public TekuciRacun(TekuciRacun tr) {
		this(tr.vlasnikRacuna, tr.stanjeRacuna, tr.mjesecnaNaknada);
	}
	
	
	public double getMjesecnaNaknada() {
		return mjesecnaNaknada;
	}

	public void setMjesecnaNaknada(double mjesecnaNaknada) {
		this.mjesecnaNaknada = mjesecnaNaknada;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(mjesecnaNaknada);
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
		if (Double.doubleToLongBits(mjesecnaNaknada) != Double.doubleToLongBits(other.mjesecnaNaknada))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		String s = super.toString();
		return s + "Mjesecna naknada: " + mjesecnaNaknada;
	}

	@Override
	public boolean podigniPare(double suma) {
		if (suma > this.stanjeRacuna)
			return false;
		this.stanjeRacuna -= suma; 
		return true;
	}

	@Override
	public void uplatiPare(double suma) {
		this.stanjeRacuna += (suma - suma*0.01);
	}
	
	public void obracunajMjesecnuNaknadu() {
		this.stanjeRacuna -= this.mjesecnaNaknada;
	}
	
	

}
