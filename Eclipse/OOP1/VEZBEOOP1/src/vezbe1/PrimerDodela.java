package vezbe1;

public class PrimerDodela {

	public static void main(String[] args) {

		// deklaracija i inicijalizacija promenljivih
		// celobrojni tip, integer
		int a = 1;
		System.out.println("Vrednost a: " + a );
		
		// deklaracija i inicijalizacija vise promenljivih
		int promenljiva1, promenljiva2 = 3, promenljiva3 = -1, rezultat;
		
		// greska - dodela bez prethodne inicijalizacije
		// rezultat = promenljiva1;
		
		// decimalni tip, float, double
		float b = 5.55F;
		double d = 3.14;
		double c = 6;
		
		// koriscenje aritmetickih operatora
		rezultat = promenljiva2 + a * promenljiva3;
		System.out.println("Rezultat je: " + rezultat);
		
		rezultat = 7 % 4;
		System.out.println("Ostatak pri deljenju 7 sa 4 je: " + rezultat);
		
		System.out.println("Vrednost b + c "+ b + c);
		System.out.println("Vrednost b + c sa zagradama " + (b + c));

		System.out.println("Vrednost b + d sa zagradama " + (b + d));

		// operatori uvecanja i smanjenja
		
		int broj = 0;
		// prefiksni oblik
		System.out.println("1. Ispis promenljive a je: "+ ++a);
		System.out.println("2. Ispis promenljive a je: "+ a);
		
		//broj = ++a; // a = a + 1; broj = a
		
		// postfiksni oblik
		// a = 2
		
		//broj = a++; // broj = a; a = a + 1
		System.out.println("3. Ispis promenljive a je: "+ a--);
		System.out.println("4. Ispis promenljive a je: "+ a);



		
		
		
	}

}
