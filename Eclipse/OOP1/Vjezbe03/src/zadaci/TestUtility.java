package zadaci;

import java.util.Scanner;

public class TestUtility {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Utility unos = new Utility();
		
		String tekst = unos.unosTeksta(sc);
		System.out.println("Unijeli ste: " + tekst +"\n");
		
		int broj = unos.unosIntegera(sc);
		System.out.println("Unijeli ste: " + broj +"\n");
		
		float realan32 = unos.unosFloat(sc);
		System.out.println("Unijeli ste: " + realan32 +"\n");
		
		double realan64 = unos.unosDouble(sc);
		System.out.println("Unijeli ste: " + realan64 +"\n");
		
		byte bajt = unos.unosByte(sc);
		System.out.println("Unijeli ste: " + bajt +"\n");
		
		boolean bool = unos.unosBoolean(sc);
		System.out.println("Unijeli ste: " + bool +"\n");
		
		String odgovor = unos.unosOdluke(sc);
		System.out.println("Unijeli ste: " + odgovor +"\n");
		
		

	}

}
