package vezbe4.primer3.a;

/*
 * Klasa Krug
 * Model geometrijske figure krug koja ima svoju povrsinu i obim
 */

public class Krug {

	/** poluprecnik kruga */
	double r;

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

}
