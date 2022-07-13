package zadaci;
import java.util.Scanner;

public class Utility {
	
	String unosTeksta(Scanner sc) {
		System.out.print("Unesite tekst: ");
		String tekst = sc.nextLine();
		return tekst;
	}
	
	
	int unosIntegera(Scanner sc) {
		int broj;
		do {
			try {
				System.out.print("Unesite broj: ");
				broj = sc.nextInt();
				return broj;
			} catch (Exception e) {
				System.out.println("POGRESAN UNOS. Pokusajte ponovo: \n");
			}
			sc.nextLine();
		} while (true);
	}
	
	
	float unosFloat(Scanner sc) {
		float realanBroj32;
		do {
			try {
				System.out.print("Unesite broj: ");
				realanBroj32 = sc.nextFloat();
				return realanBroj32;
			} catch (Exception e) {
				System.out.println("POGRESAN UNOS. Pokusajte ponovo: \n");
			}
			sc.nextLine();
		} while (true);
	}
	
	
	double unosDouble(Scanner sc) {
		double realanBroj64;
		do {
			try {
				System.out.print("Unesite broj: ");
				realanBroj64 = sc.nextDouble();
				return realanBroj64;
			} catch (Exception e) {
				System.out.println("POGRESAN UNOS. Pokusajte ponovo: \n");
			}
			sc.nextLine();
		} while (true);
	}
	
	
	byte unosByte(Scanner sc) {
		byte bajt;
		do {
			try {
				System.out.print("Unesite vrijednost byte: ");
				bajt = sc.nextByte();
				return bajt;
			} catch (Exception e) {
				System.out.println("Pogresan unos. Pokusajte ponovo: \n");
			}
			sc.nextLine();
		} while (true);
	}
	
	
	char unosKaraktera(Scanner sc) {
		String tekst;
		System.out.print("Unesite karakter: ");
		tekst = sc.nextLine();
		char prviZnak = tekst.charAt(0);
		return prviZnak;
	}
	
	
	boolean unosBoolean(Scanner sc) {
		boolean bool;
		do {
			try {
				System.out.print("Unesite boolean vrijednost: ");
				bool = sc.nextBoolean();
				return bool;
			} catch (Exception e) {
				System.out.println("POGRESAN UNOS. Pokusajte ponovo: \n");
			}
			sc.nextLine();
		} while (true);
	}
	
	
	String unosOdluke(Scanner sc) {
		String odluka;
		do {
			System.out.print("Unesite odluku: ");
			odluka = sc.nextLine();
			String mala = odluka.toLowerCase();
			if (mala.equalsIgnoreCase("da") || mala.equalsIgnoreCase("ne")) {
				return mala;
			}
			System.out.println("Pogresan unos. Pokusajte ponovo: \n");
		} while (true);
	}
	
}
