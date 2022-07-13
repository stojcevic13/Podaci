package zadatak1;

public class RacunStednje extends Racun {
	
	private boolean pokrenutaStednja;
	private double godinsnjiKoeficijentStednje;

	@Override
	public boolean podigniPare(double suma) {
		if (suma > this.stanjeRacuna)
			return false;
		if (this.pokrenutaStednja == true)
			return false;
		this.stanjeRacuna -= suma; 
		return true;
	}

	@Override
	public void uplatiPare(double suma) {
		this.stanjeRacuna += (suma - suma*0.01);
	}
	
	public void pokreniStednju() {
		this.pokrenutaStednja = true;
	}

	public void obustaviStednju(int mjeseci) {
		this.pokrenutaStednja = false;
		int brojGodina = mjeseci / 12;
		double ostatakMjeseci = (mjeseci % 12) * 1.0;
		this.stanjeRacuna = this.stanjeRacuna + this.stanjeRacuna * (this.godinsnjiKoeficijentStednje * 0.01 * brojGodina)
				+ stanjeRacuna * (this.godinsnjiKoeficijentStednje * 0.01 * ostatakMjeseci/12);
	}
}
