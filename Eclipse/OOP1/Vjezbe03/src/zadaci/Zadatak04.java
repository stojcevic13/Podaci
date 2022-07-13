package zadaci;

public class Zadatak04 {
	
	static int[] korespondentniNiz(int[] a, int[] b) {
		int[] c = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i] + b[i];
		}
		return c;
	}

	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4, 5, 6};
		int[] b = {-1, -2, -3, -4, -5, -5};

		int[] c = korespondentniNiz(a, b);
		for (int el : c)
			System.out.print(el + " ");
	}

}
