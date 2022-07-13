package vezbe5.primer4;

// moze se naslediti samo jedna klasa
// moze implementirati vise interfejsa
// public class Direktor extends Osoba implements ObracunPrihoda, Comparable{
public class Direktor extends Osoba implements ObracunPrihoda{

	private double osnovica;
	private double koeficijent;
	private double bonus;

	public Direktor(String ime, String prezime, double osnovica, double koeficijent, double bonus) {
		super(ime, prezime);
		this.osnovica = osnovica;
		this.koeficijent = koeficijent;
		this.bonus = bonus;
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

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public double obracunajPlatu() {
		return this.koeficijent * this.osnovica + this.bonus;
	}

	@Override
	public double obracunajPorez() {
		double porez = obracunajPlatu() * 0.2;
		if (obracunajPlatu() > 100000) {
			porez *= 2;
		}
		return porez;
	}
	
	// polimorfizam
	public void otpustiRadnika(Osoba r) {
		System.out.println("Otpustili ste radnika " + r.getIme() + " " + r.getPrezime());
	}

}
