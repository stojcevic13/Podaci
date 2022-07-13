package vezbe2;

public class Primer2UgnjezdeneNaredbe {

	public static void main(String[] args) {

		// zbir svih parnih brojeva od broja 2 do broja 9
		int suma = 0;
		for (int i = 2; i <= 9; i++) {
			if (i % 2 == 0) {
				suma = suma + i;
			}
		}
		System.out.println("Suma je: " + suma);

	}

}
