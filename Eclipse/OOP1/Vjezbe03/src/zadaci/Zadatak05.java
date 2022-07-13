package zadaci;

import java.util.Scanner;

public class Zadatak05 {
	
	static Scanner sc = new Scanner(System.in);
	
	
	static void ispisiNaziveArtikala(String[][] artikli) {
		for (int i = 0; i < artikli.length; i++)
			System.out.println(artikli[i][0]);
	}
	
	
	static void ispisiPodatkeArtikla(String[] artikal) {
		System.out.println("Naziv artikla: " + artikal[0]);
		System.out.println("Proizvodjac: " + artikal[2]);
		System.out.println("Cijena: " + artikal[3]);
		System.out.println(artikal[4]);
	}

	
//	static String unosPodatka(String poruka) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print(poruka);
//		String unos = sc.nextLine();
//		sc.close();
//		return unos;
//	}

	
	static void ispisiPodatkeOdredjenogArtikla(String[][] artikli) {
		String sifra = unosTeksta(sc, "Unesite sifru artikla: ");
		for (int i = 0; i < artikli.length; i++)
			if (artikli[i][1].equals(sifra)) {
				ispisiPodatkeArtikla(artikli[i]);
				break;
			}
	}

	
	static void ispisiArtikleNaAkciji(String[][] artikli) {
		for (String[] artikal : artikli)
			if (artikal[4].equals("akcija"))
				ispisiPodatkeArtikla(artikal);
	}
	
	
	static void ispisiArtikleOdredjenogProizvodjaca(String[][] artikli) {
		String proizvodjac = unosTeksta(sc, "Unesite naziv proizvodjaca: ");
		for (String[] artikal : artikli) {
			if (artikal[2].equalsIgnoreCase(proizvodjac)) {
				ispisiPodatkeArtikla(artikal);
			}
		}
	}

	
	static String unosOpcije() {
		Scanner sc = new Scanner(System.in);
		System.out.print(">>>");
		String unos = sc.nextLine();
		sc.close();
		return unos;
	}
	
	
	static void ispisiOpcije() {
		System.out.println("1 - Ispisi naziv svih artikala");
		System.out.println("2 - Ispisi podatke odredjenog artikla");
		System.out.println("3 - Ispisi artikle na akciji");
		System.out.println("4 - Ispisi artikle odredjenog proizvodjaca");
		System.out.println("5 - Izlaz");
	}

	
	static String unosTeksta(Scanner sc, String poruka) {
		System.out.print(poruka);
		String tekst = sc.nextLine();
		return tekst;
	}
	
	
//	public static void main(String[] args) {
//		
//		String tekst = "Coko plazma|s01|Bambi|85.30|akcija\nSmoki|s02|Stark|55.00|nije na akciji\nCipsi|s03|Marbo |115.20|nije na akciji\nKrem Bananica|s04|Stark|11.00|akcija\n";
//		
//		String[] niz = tekst.split("\n");
//		String[][] artikli = new String[niz.length][];
//		
//		for (int i = 0; i < niz.length; i++) {
//			artikli[i] = niz[i].split("\\|");
//		}
//		
//	
//		program:
//		do {
//			ispisiOpcije();
//			String unos = unosTeksta(sc, ">>>");
//			System.out.println(unos);
//			switch (unos) {
//				case "1":
//					ispisiNaziveArtikala(artikli);
//					break;
//				case "2":
//					ispisiPodatkeOdredjenogArtikla(artikli);
//					break;
//				case "3":
//					ispisiArtikleNaAkciji(artikli);
//					break;
//				case "4":
//					ispisiArtikleOdredjenogProizvodjaca(artikli);
//					break;
//				case "5":
//					System.out.println("Izasli ste iz programa.");
//					break program;
//			}
//			sc.nextLine();
//		} while (true);
//
//		
//		
//	}

}
