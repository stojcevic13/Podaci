package izuzeci;

import java.util.Scanner;

public class Utility {
	
	public static int unosBroja(Scanner sc, String poruka) {
		int broj;
		do {
			try {
				System.out.print(poruka);
				broj = sc.nextInt();
				return broj;
			} catch (Exception e) {
				System.out.println("Greska! Pokusajte ponovo: \n");
				sc.nextLine();
			}
			
		} while (true);
	}

}
