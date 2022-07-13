package vezbe4.primer6;

public class Primer6 {

	public static void main(String[] args) {

		// definicija i inicijalizacija
		Integer ceoBrojObjekat = null;
		int ceoBrojPrimitivna = 5;

		// kreiranje Wrapper objekta sa parametrom string
		ceoBrojObjekat = new Integer("1");
		System.out.println("1. Ispis: " + ceoBrojObjekat);

		// kreiranje Wrapper objekta Integer sa primitivnim tipom int
		ceoBrojObjekat = new Integer(ceoBrojPrimitivna);
		System.out.println("2. Ispis: " + ceoBrojObjekat);

		// pozivanje statickih metoda Wrapper objekta koje parsiraju String
		int ceoBroj = Integer.parseInt("3");
		boolean logicka = Boolean.parseBoolean("true");
		float realanBroj = Float.parseFloat("3.14");

		// u slucaju pogresno prosledjene vrednosti metoda izaziva izuzetak
		// na ovaj nacin nece doci do prekida izvrsavanja programa
		try {
			ceoBrojPrimitivna = Integer.parseInt("3.14");
		} catch (Exception e) {
			System.out.println("Greska prilikom parsiranja");
		}

	}

}
