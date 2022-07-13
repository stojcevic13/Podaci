package primjeri.p;

public class Direktor extends Osoba implements ObracunPrihoda{
	
	private double osnvica;
	private double koeficijent;
	private double bonus;

	public double getOsnvica() {
		return osnvica;
	}

	public void setOsnvica(double osnvica) {
		this.osnvica = osnvica;
	}

	public double getKoeficijent() {
		return koeficijent;
	}

	public void setKoeficijent(double koeficijent) {
		this.koeficijent = koeficijent;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public double izracunajPlatu() {
		return this.koeficijent * this.osnvica + bonus;
	}

	@Override
	public double izracunajPorez() {
		double plata = this.izracunajPlatu();
		double porez = plata * 0.2;
		if (plata > 100000) {
			return 2*porez;
		}
		return porez;
	}

}
