package vezbe3.funkcije;

public class Primer1HelloWorld {

	/*
	 * Pozeljno je iznad funkcije napisati kratak komentar
	 * kojim se objasnjava programska logika i svrha funkcije
	 */
	//  ispis Hello world teksta
	static void pozdrav() {
		System.out.println("Hello World!");
	}
	
	public static void main(String[] args) {
		//poziv staticke funkcije 
		pozdrav();
		//ili na staticki nacin
		Primer1HelloWorld.pozdrav();
		
		//u slucaju kada funkcija pozdrava nije staticka
		Primer2 objekat = new Primer2();
		objekat.pozdrav();

	}

}
