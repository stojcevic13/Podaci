package vezbe3.ulazizlaz;

public class Primer1IzlazniTokPisanjeNaEkran {

	public static void main(String[] args) {

		System.out.println("Koriscenje izlaznog toka stampanja na ekran:");
		System.out.printf("Boolean ispis, vrednost %b je ispisana\n", true);
		System.out.printf("Slovo ispis, vrednost %c je ispisana\n", 'A');
		System.out.printf("Integer ispis, vrednost %d je ispisana\n", 10);
		System.out.printf("Heksadecimalni ispis, vrednost %H je ispisana\n", 15);
		System.out.printf("Real ispis, vrednost %f je ispisana\n", 10.5);
		System.out.printf("Real ispis, vrednost %e je ispisana\n", 123000000.123);
		System.out.println("Formatizovani ispis u obliku %[sirina][.preciznost]tip");
		System.out.printf("Real ispis, vrednost %.2f je ispisana\n", 100.54321);

	}

}
