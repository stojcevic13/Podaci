package zadaci;

import java.util.Scanner;

public class Zadatak06 {
	
	static Scanner sc = new Scanner(System.in);
	
	static int unosIntegera(Scanner sc, String poruka) {
		int broj;
		do {
			try {
				System.out.print(poruka);
				broj = sc.nextInt();
				return broj;
			} catch (Exception e) {
				System.out.println("POGRESAN UNOS. Pokusajte ponovo: \n");
			}
			sc.nextLine();
		} while (true);
	}
	
	
	static boolean unosBoolean(Scanner sc, String poruka) {
		boolean bool;
		do {
			try {
				System.out.print(poruka);
				bool = sc.nextBoolean();
				return bool;
			} catch (Exception e) {
				System.out.println("POGRESAN UNOS. Pokusajte ponovo: \n");
			}
			sc.nextLine();
		} while (true);
	}
	
	
	static void inicijalizujMatricu(String[][] matrica) {
		for (int i = 0; i < matrica.length; i++)
			for (int j = 0; j < matrica[i].length; j++)
				matrica[i][j] = "0";
	}
	
	
	static void ispisiMatricu(String[][] matrica) {
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++)
				System.out.print(matrica[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	
	static void postaviBrod(String[][] matrica, int brodRed, int brodKol, int vel, boolean vert) {
		for (int i = 0; i < vel; i++) {
			matrica[brodRed][brodKol] = "1";
			if (vert == false) brodKol++;
			else brodRed++;
		}
	}
	
	
	static void azurirajMatricu(String[][] podaci, String[][] trenutno, int x, int y) {
		trenutno[x][y] = (podaci[x][y] == "1") ? "1" : "x";
		ispisiMatricu(trenutno);
	}
	
	
	static void postaviBrodove(String[][] podaci) {
		int brodRed, brodKol;
		boolean vert;
		
		for (int i = 4; i >= 1; i--) {
			System.out.printf("BROD VELICINE %d\n\n",i);
			brodRed = unosIntegera(sc, "Unesite x koordinatu broda: ");
			sc.nextLine();
			brodKol = unosIntegera(sc, "Unesite y koordinatu broda: ");
			sc.nextLine();
			vert = unosBoolean(sc, "Brod je vertikalan: ");
			postaviBrod(podaci, brodRed, brodKol, i, vert);
			ispisiMatricu(podaci);
		}
	}

	
	static void pokreniIgru() {
		int redovi = unosIntegera(sc, "Unesite broj redova: ");
		int kolone = unosIntegera(sc, "Unesite broj kolona: ");
		String[][] podaci = new String[redovi][kolone];
		inicijalizujMatricu(podaci);
		postaviBrodove(podaci);
		igraj(podaci);
	}
	
	
	static void igraj(String[][] podaci) {
		String[][] trenutno = new String[7][10];
		inicijalizujMatricu(trenutno);
		
		int brPokusaja = 0;
		do {
			brPokusaja += 1;
			System.out.printf("POKUSAJ %d", brPokusaja);
			int x = unosIntegera(sc, "Unesite x koordinatu: ");
			sc.nextLine();
			int y = unosIntegera(sc, "Unesite y koordinatu: ");
			azurirajMatricu(podaci, trenutno, x, y);
		} while (brPokusaja <= 10);

	}


	public static void main(String[] args) {

		pokreniIgru();
		
	}

}
