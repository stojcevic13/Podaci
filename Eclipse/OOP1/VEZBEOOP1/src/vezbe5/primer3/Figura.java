package vezbe5.primer3;

/**
 * Primer apstraktne klase
 *
 */
public abstract class Figura {

	// moze imati nestaticke atribute
	double obim;
	double povrsina;

	// apstraktna metoda - nema telo, mora biti implementirana u klasi naslednici
	public abstract double izracunajPovrsinu();

	public abstract double izracunajObim();
	
	// moze imati metode koje nisu apstraktne
	public void ispisi() {
		System.out.println("Povrsina figure je: " + this.povrsina + ", obim je: " + this.obim);
	}

}
