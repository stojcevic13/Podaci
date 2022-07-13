package vezbe4.primer7;

public class Test {

	public static void main(String[] args) {
		
		Brojac br1 = new Brojac();
		Brojac br2 = new Brojac();
		
		// rad sa statickim atributima
		System.out.println(Brojac.vrednost);
		//	br1.vrednost = 2;
		System.out.println(br2.vrednost);
		System.out.println(Brojac.NAZIV);
		
		Brojac br3 = new Brojac();
		System.out.println(Brojac.vrednost);
		System.out.println(br2.vrednost);

		// greska - nije moguce menjati vrednost final atributa 
		// Brojac.NAZIV = "Naziv 2";
	}

}
