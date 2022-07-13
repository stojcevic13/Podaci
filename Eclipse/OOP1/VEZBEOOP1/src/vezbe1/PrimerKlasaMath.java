package vezbe1;

public class PrimerKlasaMath {

	public static void main(String[] args) {

		//Klasa Math
		/* 
		 *  odredjivanje povrsine kruga poluprecnika r=2,
		 *  usvojeno je da je vrednost Pi preuzeta iz klase Math
		 */
		double povrsina;
		int r = 2;
		//opcija 1
		povrsina = r * r * Math.PI;
		System.out.println("Povrsina kruga je: " + povrsina);
		//opcija 2
		//koriscenje funkcije pow(x,y) za racunanje r^2
		povrsina = Math.pow(r,2) * Math.PI;
		System.out.println("Povrsina kruga je: " + povrsina);

		double kub = Math.pow(r, 3);
		System.out.println("2^3 je: " + kub);
	}

}
