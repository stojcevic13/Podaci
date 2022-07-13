package vezbe4.primer3.b;

public class Tacka {

	/** x koordinata */
	double x;
	/** y koordinata */
	double y;

	/**
	 * Racuna udaljenost izmedju dve tacke
	 * @param t - tacka do koje se racuna rastojanje
	 * @return rastojanje dve tacke
	 */
	double rastojanje(Tacka t) {
		double d = Math.sqrt((x - t.x) * (x - t.x) + (y - t.y) * (y - t.y));
		return d;
	}

	/**
	 * Racuna udaljenost izmedju dve tacke
	 * @param x - x koordinata tacke do koje se racuna rastojanje
	 * @param y - y koordinata tace do koje se racuna rastojanje
	 * @return rastojanje dve tacke
	 */
	double rastojanje(double x, double y) {
		// this se odnosi na objekat nad kojim je pozvana metoda
		// this.x - atribut x iz objekta klase Tacka nad kojim je pozvana metoda
		// x - parametar metode
		double d = Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
		return d;
	}

}
