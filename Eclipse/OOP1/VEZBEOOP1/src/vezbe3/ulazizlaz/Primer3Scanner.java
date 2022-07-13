package vezbe3.ulazizlaz;

import java.util.Scanner;

public class Primer3Scanner {

	static String ocitajTekst(Scanner sc) {
		String tekst = sc.nextLine();
		return tekst;
	}
	
	//citanje promenljive integer
	static int ocitajBroj(Scanner sc) {
		int ceoBroj = 0;
		boolean notRead = true;
		do {
			if (sc.hasNextInt()) {
				ceoBroj = sc.nextInt();
				notRead = false;
			} else {
				if(!sc.nextLine().isEmpty()) {
					System.out.println("GRESKA - pokusajte ponovo: ");
				}
			}
			
			//ocitava znak novi red
			sc.nextLine();
			// drugi nacin
			/*try{
				ceoBroj = sc.nextInt();
				
			} catch(Exception e) {
				System.out.println("GRESKA - pokusajte ponovo: ");
			}
			sc.nextLine();
			*/
			
		} while (notRead);
		
		return ceoBroj;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Unesi recenicu: ");
		String text = ocitajTekst(sc);
		System.out.println("Ispis recenice: " + text);

		System.out.print("Unesi broj: ");
		int ceoBroj = 0;
		ceoBroj = ocitajBroj(sc);
	
		System.out.println("Ispis broja: " + ceoBroj);
	}

	
	
}
