package vezbe4.primer1;

public class TestKlasa {

	public static void main(String[] args) {

		// deklarisanje promenljive k tipa NazivKlase
		NazivKlase k;
		int i;
		// instanciranje objekta tipa NazivKlase
		k = new NazivKlase();

		System.out.println("Naziv atributa: " + k.nazivAtributa);
		// pozivanje metode nazivMetode iz klase k
		k.nazivMetode();
		System.out.println("Naziv atributa: " + k.nazivAtributa);

	}

}
