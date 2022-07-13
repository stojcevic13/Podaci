package vezbe2;

public class Primer1IspisPrvihN {

	public static void main(String[] args) {

		/*
		 * for (inicijalizacija; logicki uslov; korekcija){ naredbe koje se izvrsavaju
		 * sve dok inicijalna vrednost ne dostigne granicu }
		 */
		// ispis prvih N prirodnih brojeva
		int granica = 10;
		System.out.println("Ispis prvih N = " + granica + " prirodnih brojeva");
		for (int i = 1; i <= granica; i++) {
			System.out.print(i + " ");
		}

	}

}
