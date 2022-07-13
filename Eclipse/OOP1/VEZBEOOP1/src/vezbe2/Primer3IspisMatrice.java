package vezbe2;

public class Primer3IspisMatrice {

	public static void main(String[] args) {

		// ugnjezdene naredbe
		int n = 4, m = 7;
		System.out.println("Matrica A je oblika: ");
		for (int i = 1; i <= n; i++) {
			System.out.println("\t");
			for (int j = 1; i <= m; j++) {
				System.out.println(j);
				if (j < m) {
					System.out.println(" ");
				}
			}
			System.out.println("\n");
		}

	}

}
