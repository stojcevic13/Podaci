package predavanje02;

import java.util.Scanner;

public class Skener {
	
	static int zbir(int... niz) {
		int s = 0;
		for (int i = 0; i < niz.length; i++) {
			s += niz[i];
		}
		return s;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("Unesite kapacitet niza: ");
//		int n = sc.nextInt();
//		int[] niz = new int[n];
//		
//		for (int i=0; i < n; i++) {
//			System.out.printf("Unesite %d. element niza: ",(i+1));
//			niz[i] = sc.nextInt();
//		}
//		
//		for (int i=0; i < n; i++) {
//			System.out.print(niz[i] + " ");
//		}
		
//		int[] niz = {1, 3, 78, 34, 21, 16, 52};
		int suma = zbir(1, 3, 78, 34, 21, 16, 52);
		System.out.println(suma);
		sc.close();

	}

}
