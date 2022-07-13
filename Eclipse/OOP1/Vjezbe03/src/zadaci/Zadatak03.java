package zadaci;

public class Zadatak03 {
	
	static double najmanjiEl(double[] niz) {
		double min = niz[0];
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] < min)
				min = niz[i];
		}
		return min;
	}
	
	
	static double najveciEl(double[] niz) {
		double max = niz[0];
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] > max)
				max = niz[i];
		}
		return max;
	}
	
	
	static double srednjaVrijednost(double[] niz) {
		int suma = 0;
		for (int i = 0; i < niz.length; i++)
			suma += niz[i];
		return suma*1.0 / niz.length;
	}
	
	

	public static void main(String[] args) {
		
		double[] niz = {1, 45, -2, 4, 11, -29, 16, 7};
		
		double sred = srednjaVrijednost(niz);
		for (int i = 0; i < niz.length; i++) {
			niz[i] += (niz[i] < 0) ? sred : sred*(-1);
//			if (niz[i] < 0) niz[i] += sred; else niz[i] -= sred;
		}
		
//		NE RADI, NE MIJENJA VRIJEDNOSTI NIZA
//		for (double el : niz) {
//			el += (el < 0) ? sred : sred*(-1);
//		}
		
		for (int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}

	}

}
