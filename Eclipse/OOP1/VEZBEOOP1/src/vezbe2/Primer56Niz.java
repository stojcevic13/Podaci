package vezbe2;

public class Primer56Niz {

	public static void main(String[] args) {

		// prikazati niz koji sadrzi prvih 5 prirodnih brojeva
		int nizA[]; // deklaracija niza ciji su elementi celi brojevi
		nizA = new int[5]; // alokacija 5 memorijskih polja velicine celobrojnog tipa
		nizA[0] = 1; // promena vrednosti elementa niza
		nizA[1] = 2; // promena vrednosti elementa niza
		nizA[2] = 3; // promena vrednosti elementa niza
		nizA[3] = 4; // promena vrednosti elementa niza
		nizA[4] = 5; // promena vrednosti elementa niza

		// skraceni oblik - deklaracija, alokacija i inicijalizacija
		int nizB[] = { 1, 2, 3, 4, 5 };

		// elementi niza mogu da budu vrednost konstante, promenljive, funkcije
		// niz celih brojeva
		int broj = 2;
		int[] nizCelihBrojeva = { 7, 5, broj, 9, 11 / 3, -13, 1 };
		// niz realnih brojava
		double[] nizRealnihBrojeva = { Math.PI / 2, 3.0, 2 + 3 / 5, Math.E, Math.sqrt(3) };
		// niz reci
		String[] nizImena = { "Pero", "Mika", "Lazo" };

		// pristup elementu niza A
		System.out.println("Peti element niza A je " + nizA[4]);
		// ispis niza
		System.out.println("Niz A je " + nizA.toString());
		// ispis clanova niza
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " clan niza je " + nizA[i]);
		}

		// prikazi sumu niza A
		int suma = 0;
		for (int i = 0; i < nizA.length; i++) {
			suma += nizA[i]; // suma = suma + niz[i]
		}
		System.out.printf("Suma niza je: " + suma);
	}

}
