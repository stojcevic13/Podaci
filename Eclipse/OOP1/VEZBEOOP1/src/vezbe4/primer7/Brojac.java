package vezbe4.primer7;

public class Brojac {

	public static int vrednost = 0; // static - zajednicki atribut za sve objekte klase Brojac
	public static final String NAZIV = "Brojac 1"; // final - konstanta, vrednost atributa se ne moze menjati

	public Brojac() {
		this.vrednost++;
	}

}
