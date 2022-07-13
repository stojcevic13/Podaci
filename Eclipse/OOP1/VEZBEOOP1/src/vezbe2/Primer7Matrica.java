package vezbe2;

public class Primer7Matrica {

	public static void main(String[] args) {

		// definisanje visedimenzionalnih nizova
		int matricaA[][] = new int[4][7];

		for (int i = 0; i < matricaA.length; i++) {
			for (int j = 0; j < matricaA[i].length; j++) {
				matricaA[i][j] = j;
			}
		}

		// skraceni oblik
		char nizB[][] = { { 'a', 'b', 'c' }, { 48 }, { '1', '2', '3' } };

		// ispis clanova matrice
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.println("a[" + i + "][" + j + "] clan niza je " + matricaA[i][j]);
			}
		}

	}

}
