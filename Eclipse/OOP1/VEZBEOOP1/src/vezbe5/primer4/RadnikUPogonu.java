package vezbe5.primer4;

public class RadnikUPogonu extends Osoba implements ObracunPrihoda {

	private int godineStazaRadnika;
	private double osnovica;
	private double koeficijent;

	public RadnikUPogonu(String ime, String prezime, int godineStazaRadnika, double osnovica, double koeficijent) {
		super(ime, prezime);
		this.godineStazaRadnika = godineStazaRadnika;
		this.osnovica = osnovica;
		this.koeficijent = koeficijent;
	}

	public int getGodineStazaRadnika() {
		return godineStazaRadnika;
	}

	public void setGodineStazaRadnika(int godineStazaRadnika) {
		this.godineStazaRadnika = godineStazaRadnika;
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
	public double obracunajPlatu() {
		return (this.koeficijent + 0.01*this.godineStazaRadnika)*this.osnovica;
	}

	@Override
	public double obracunajPorez() {
		return obracunajPlatu() * 0.2;
	}

}
