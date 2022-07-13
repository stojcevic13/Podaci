package vezbe5.primer12;

public class Test {

	public static void main(String[] args) {

		Tacka t1 = new Tacka(3.2, 5.7);
		System.out.println(t1);

		System.out.println("Kreiranje piksela");
		Piksel p = new Piksel(3.2, 5.7, "plava");
		System.out.println(p);

		Tacka t2 = new Tacka(3.2, 5.7);
		Tacka t3 = new Tacka(3, 7);
		System.out.println(t2.toString());

		System.out.println(t1.equals(t2));
		System.out.println(t1.equals(p)); // poredjenje sa pikselom
		System.out.println(t1.equals(t3));
		
		Tacka t4 = (Tacka)p;
		System.out.println(t4.toString());	
		System.out.println(t4.equals(p));
		
		// greska - objekat klase Tacka ne moze biti cast-ovan u objekat klase Piksel
		// Piksel p2 = (Piksel)t3;
		ispisi(t1);
		ispisi(p);
	}
	
	// polimorfizam
	// kao parametar moze biti prosledjen objekat tipa klase Tacka ili neke klase naslednice
	public static void ispisi(Tacka t) {
		System.out.println(t); // poziva se metoda konkretne klase koja nasledjuje baznu klasu
	}

}
