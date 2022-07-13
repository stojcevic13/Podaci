package izuzeci;

import java.util.Scanner;

public class TestIzuzetak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int broj = Utility.unosBroja(sc, "Unesite broj: ");
		System.out.println(broj);
		
		sc.close();
		
		int[] brojevi = {1, 2, 3, 4, 5};
		try {
			System.out.println("brojevi[9] = " + brojevi[9]);
		} catch (Exception e) {
			System.out.println("Indeks je prevelik.");
		}
		
		int a = 9;
		int b = 6;
		double c = 1.0;
		
		try {
			c = a*1.0 / b;
			System.out.println(c);
		} catch (ArithmeticException ae) {
			System.out.println("Dijeljenje sa nulom.");
		}

		
		

	}

}
