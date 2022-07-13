package zad1;

public class TestPravougaonika {

	public static void main(String[] args) {
		
		Pravougaonik pravougaonik = new Pravougaonik(4, 7, new Tacka(7, 4), new Tacka(0, 0));
		
		double povrsina = pravougaonik.izracunajPovrsinu();
		double obim = pravougaonik.izracunajObim();
		System.out.printf("Povrsina pravougaonika: %.2f. \t Obim pravougaonika: %.2f \n", povrsina, obim);
		pravougaonik.provjeri(new Tacka(9, 4));
		
//		System.out.println(pravougaonik.getDoleLijevo().desno(new Tacka(4, 4)));

	}

}
