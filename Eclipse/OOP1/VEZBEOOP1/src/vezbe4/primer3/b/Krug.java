package vezbe4.primer3.b;

/*
 * Klasa Krug
 * Model geometrijske figure krug koja ima svoju povrsinu i obim sa metodom za proveru da li se proizvoljna tacka 
 * nalazi unutar prostora koji zauzima figura
 */

public class Krug {

	/** poluprecnik kruga */
	double r;

	/** centar kruga */
	Tacka c;

	/**
	 * 
	 * @return povrsina kruga
	 */
	double povrsina() {
		return r * r * Math.PI;
	}

	/**
	 * 
	 * @return obim kruga
	 */
	double obim() {
		return 2 * r * Math.PI;
	}

	/**
	 * Ispisuje da li je neka tacka unutar, izvan ili na krugu, na osnovu
	 * udaljenosti od centra kruga.
	 */
	void provera(Tacka t) {
		double d = t.rastojanje(c);
		if (d < r) {
			System.out.println("Tacka se nalazi unutar kruga");
		} else if (d == r) {
			System.out.println("Tacka se nalazi na krugu");
		} else {
			System.out.println("Tacka se nalazi izvan kruga");
		}
	}

}
