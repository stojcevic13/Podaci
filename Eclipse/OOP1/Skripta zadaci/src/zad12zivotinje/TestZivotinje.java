package zad12zivotinje;

import java.util.Random;

public class TestZivotinje {

	public static void main(String[] args) {

		Zivotinja[] zivotinje = {
				new Pas("Dzeki", "Haski"),
				new Riba("Riba1", "skusa"),
				new Pingvin("Kralj")
		};
		
		Random random = new Random();
		
		for (int i = 0; i < 4; i++) {
			Zivotinja z = zivotinje[random.nextInt(zivotinje.length)];
			System.out.println((i+1) + ". zivotinja");
			System.out.println(z);
			z.oglasavanje();
			z.oglasavanjeULjutini();
			z.nacinKretanja();
			System.out.println();
		}
		
	}

}
