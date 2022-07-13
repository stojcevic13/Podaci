
public class Zad6 {

	public static void main(String[] args) {
		
		int precnik = 6, h = 4, r = precnik / 2;
		double s;
		
		double baza = Math.pow(r, 2) * Math.PI;
		s = Math.sqrt(r*r + h*h);
		double omotac = s*r*Math.PI;
		
		double povrsinaKupe = baza + omotac;
		
		System.out.printf("Povrsina kupe je: %.2f", povrsinaKupe);
	}

}
