package vezbe5.primer12;

public class Piksel extends Tacka {

	public String boja;

	public Piksel(double x, double y, String boja) {
		// greska - poziv konstruktora roditeljske klase mora biti prvi
		//System.out.println(("Kontruktor: Piksel"));
		
		// ako mi ne pozovemo eksplicitno konstruktor, pozvace se podrazumevani (bez parametara), ukoliko postoji
		super(x, y); // super oznacava roditeljsku klasu, super(x, y) => poziv konstruktora Tacka(x, y)
		this.boja = boja;
		System.out.println(("Kontruktor: Piksel"));
	}

	// override - redefinisanje metoda koje postoje u roditeljskoj klasi
	// ukoliko nije predefinisana, poziva se metoda iz roditeljske klase
	@Override
	public String toString() {
		// super se moze koristiti u metodama i konstruktorima
		String ret = super.toString();
		ret += " boja: " + this.boja;
		return ret;
	}
}
