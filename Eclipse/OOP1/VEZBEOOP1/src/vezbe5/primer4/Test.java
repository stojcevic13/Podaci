package vezbe5.primer4;

public class Test {

	public static void main(String[] args) {
		
		Osoba osoba = new Osoba("Jovan", "Jovanovic");
		Direktor direktor = new Direktor("Marko", "Markovic", 70000, 1.5, 30000);
		RadnikUPogonu radnik = new RadnikUPogonu("Milan", "Milanovic", 5, 40000, 1.2);
		
		System.out.println(direktor.obracunajPlatu());
		System.out.println(direktor.obracunajPorez());
		
		System.out.println(radnik.obracunajPlatu());
		System.out.println(radnik.obracunajPorez());
		
		direktor.otpustiRadnika(direktor);
		direktor.otpustiRadnika(osoba);
		direktor.otpustiRadnika(radnik);
	}

}
