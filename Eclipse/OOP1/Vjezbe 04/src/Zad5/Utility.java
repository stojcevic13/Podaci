package Zad5;

import java.util.Scanner;

public class Utility {
	
	public static int unosBroja(Scanner sc, String poruka) {
		int broj;
		do {
			try {
				System.out.print(poruka);
				broj = sc.nextInt();
				sc.close();
				return broj;
			} catch (Exception e) {
				System.out.println("Pogresan unos. Pokusajte ponovo.\n");
				sc.nextLine();
			}
		} while (true);
	}
	
	public static String unosStringa(Scanner sc, String poruka) {
		String tekst;
		System.out.print(poruka);
		tekst = sc.nextLine();
		sc.close();
		return tekst;
	}

	public static int unosOpcije(Scanner sc, int donjaGranica, int gornjaGranica) {
		int opcija;
		do {
			opcija = unosBroja(sc, ">>> ");
			if (opcija >= donjaGranica && opcija <= gornjaGranica) {
				sc.close();
				return opcija;
			}
			System.out.printf("Unesite broj od %d do %d", donjaGranica, gornjaGranica);
			sc.nextLine();
		} while (true);
		
	}
}
