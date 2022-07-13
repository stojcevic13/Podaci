package zadatak1;

public class zadatak1 {

	public static void main(String[] args) {
		
		// ZADATAK 1
//		for (int i = 10; i >= 1; i--) 
//			System.out.print(i + " ");

		
		
		// ZADATAK 2
//		int cetvrtine = 0;
//		for (double i = -1; i <= 1.51; i += 0.25)
//			cetvrtine += 1;
//		System.out.printf("Na intervalu [-1, 1.5] ima %d cetvrtina.",cetvrtine);

		
		
		// ZADATAK 3
//		int[] niz = new int[16];
//		for (int i = 0; i < niz.length; i++) {
//			niz[i] = (i == 0) ? 1 : niz[i-1] + 10;
//			System.out.print(niz[i] + " ");
//		}
		
		
		
		// ZADATAK 4
//		int[][] b = { {1, 2, 3}, {44}, {21, 45} };
//		for (int i = 0; i < b.length; i++) {
//			for (int j = 0; j < b[i].length; j++)
//				System.out.print(b[i][j] + " ");
//			System.out.println();
//		}
		
		
		
		// ZADATAK 5
//		int p = 1;
//		for (int i = 10; i <= 20; i+=2)
//			p *= i;
//		System.out.println(p);
		
		
		
		// ZADATAK 6
//		int brDana = 0;
//		search:
//		for (int god = 2000; god <= 2016; god++)
//			for (int mj = 1; mj <= 12; mj++) {
//				if (god == 2016 && mj == 3) {
//					brDana += 10;
//					break search;
//				}
//				brDana += (mj % 2 == 0) ? 30 : 31;
//			}
//		System.out.println(brDana);
		
		
		
		// ZADATAK 7
//		int[] A = {-10, 16, 3, 1, 4, -2};
//		int max = A[0], min=A[0];
//		int suma = 0;
//		double sredina;
//		
//		for (int i = 0; i < A.length; i++) {
//			if (A[i] < min) min = A[i]; 
//			else if (A[i] > max) max = A[i];
//			suma += A[i];
//		}
//		sredina = suma*1.0 / A.length;
//		System.out.printf("Najmanji element niza: %d\nNajveci element niza: %d\nSrednja vrijednost niza: %.2f\n", min, max, sredina);
//		
//		System.out.print("Pozitivni elementi manji od srednje vrijednosti: ");
//		for (int i = 0; i < A.length; i++)
//			if (A[i] > 0 && A[i] < sredina)
//				System.out.print(A[i] + " ");
		
		
		
		// ZADATAK 8 I ZADATAK 9
//		int[][] matrica = new int[7][5];
//		int sumaGl = 0;
//		System.out.println("Matrica je oblika:");
//		for (int i = 0; i < matrica.length; i++) {
//			for (int j = 0; j < matrica[i].length; j++) {
//				matrica[i][j] = i + j;
//				System.out.print("\t" + matrica[i][j]);
//				if (i == j) sumaGl += matrica[i][j];
//			}
//			System.out.println();
//		}
//		System.out.println("\nSuma elemenata glavne dijagonale: " + sumaGl);
		
		
		
		// ZADATAK 10
//		int[][] matrica = { {1, 2, 3}, {4, 5 ,6}, {7, 8, 9}};
//		int i, j, k;
//		
//		for (i = 0; i < matrica.length; i++) {
//			for (j = 0; j < matrica[0].length; j++)
//				System.out.print(matrica[i][j] + " ");
//			System.out.println();
//		}
//		
//		
//		// ZAMJENA
//		j = 0;
//		k = matrica.length - 1;
//		int tmp;
//		for (i = 0; i < matrica.length; i++) {
//			tmp = matrica[i][j];
//			matrica[i][j] = matrica[i][k];
//			matrica[i][k] = tmp;
//			j += 1;
//			k -= 1;
//		}
//		System.out.println();
//		
//		for (i = 0; i < matrica.length; i++) {
//			for (j = 0; j < matrica[0].length; j++)
//				System.out.print(matrica[i][j] + " ");
//			System.out.println();
//		}
		
		
		
	}

}
