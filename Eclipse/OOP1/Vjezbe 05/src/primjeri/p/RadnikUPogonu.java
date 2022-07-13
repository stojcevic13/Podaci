package primjeri.p;

public class RadnikUPogonu extends Osoba implements ObracunPrihoda{

	private int godineStaza;
	private double osnovica;
	private double koeficijent;
	
	public int getGodineStaza() {
		return godineStaza;
	}

	public void setGodineStaza(int godineStaza) {
		this.godineStaza = godineStaza;
	}

	public double getOsnovica() {
		return osnovica;
	}

	public void setOsnovica(double osnovica) {
		this.osnovica = osnovica;
	}

	public double getKoeficijent() {
		return koeficijent;
	}

	public void setKoeficijent(double koeficijent) {
		this.koeficijent = koeficijent;
	}

	@Override
	public double izracunajPlatu() {
		return (this.koeficijent + 0.01*this.godineStaza) * this.osnovica;
	}

	@Override
	public double izracunajPorez() {
		return this.izracunajPlatu() * 0.2;
	}

}
