package vezbe3.stringovi;

public class Primer1RadSaPromenljivomTipaString {

	public static void main(String[] args) {

		//definisanje promenljive tipa string
		String a = "Ovo je tekst";
		System.out.println(a);
		
		//konkatenacija stringova
		//ukoliko promenljiva nije string poziva se njena konverzija
		String b = a + 5 + "zadatka";
		System.out.println(b);
		
		//prikaz broja karaktera Stringa
		System.out.println("Broj elemenata Stringa a je: " + a.length());
		
		//pristup odredjenom karakteru Stringa, indeks prvog karaktera je 0
		System.out.println("Prvi karakter: " + a.charAt(0));
		System.out.println("Drugi karakter: " + a.charAt(1));
		//greska pristup nepostojecem elementu, prepraviti na a.length()-1
		System.out.println("Poslednji element Stringa a je: " + a.charAt(a.length()));
		
		
	}

}
