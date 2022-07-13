package vezbe3.ulazizlaz;

import java.util.Scanner;

public class Primer2CitanjeTastatureUzScanner {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//citanje teksta
		System.out.print("Unesi recenicu: ");
		String text = sc.nextLine();
		System.out.println("Ispis recenice: " + text);
		
		//citanje promenljive integer
		System.out.print("Unesi broj: ");
		int ceoBroj = 0;
		//try{
			ceoBroj = sc.nextInt();
		
		/*} catch(Exception e) {
			System.out.println("Niste uneli broj " + e);
			System.exit(0); // moze a i ne mora exit
		}*/
		System.out.println("Ispis broja: " + ceoBroj);
		
		//citanje promenljive float
		System.out.print("Unesi realan broj: ");
		float realniBroj = sc.nextFloat();
		System.out.println("Ispis realnog broja: " + realniBroj);
		
		sc.close();
		System.out.println("Program izvrsen");
	
	}

}
