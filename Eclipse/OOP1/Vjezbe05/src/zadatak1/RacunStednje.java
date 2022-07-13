package zadatak1;

public class RacunStednje extends Racun {
	
	private boolean pokrenutaStednja;
	private double godisnjiKoeficijentStednje;
	
	
	
	
	public RacunStednje() {}
	public RacunStednje(Osoba vlasnik, double stanje, boolean pokrenutaStednja, double godisnjiKoeficijentStednje) {
		super(vlasnik, stanje);
		this.pokrenutaStednja = pokrenutaStednja;
		this.godisnjiKoeficijentStednje = godisnjiKoeficijentStednje;
	}
	public RacunStednje(RacunStednje r) {
		this(r.getVlasnik(), r.getStanje(), r.pokrenutaStednja, r.godisnjiKoeficijentStednje);
	}



	
	public boolean isPokrenutaStednja() {
		return pokrenutaStednja;
	}
	public void setPokrenutaStednja(boolean pokrenutaStednja) {
		this.pokrenutaStednja = pokrenutaStednja;
	}
	public double getGodisnjiKoeficijentStednje() {
		return godisnjiKoeficijentStednje;
	}
	public void setGodisnjiKoeficijentStednje(double godisnjiKoeficijentStednje) {
		this.godisnjiKoeficijentStednje = godisnjiKoeficijentStednje;
	}
	
	
	
	
	@Override
	public boolean podigniPare(double suma) {
		if (suma > this.getStanje() || this.pokrenutaStednja == true)
			return false;
		this.setStanje(this.getStanje() - suma);
		return true;
	}

	@Override
	public void uplatiPare(double suma) {
		this.setStanje(this.getStanje() + suma);
	}
	
	public void pokreniStednju() {
		this.pokrenutaStednja = true;
	}
	
	public void obustaviStednju(int meseci) {
		this.pokrenutaStednja = false;
		this.setStanje(this.getStanje() + this.getStanje()*(this.godisnjiKoeficijentStednje * 0.01 * meseci/12) 
				+ this.getStanje() * (this.godisnjiKoeficijentStednje * 0.01 * (meseci%12)*1.0/12));
	}

}
