package zadatak1;

public class TestPravougaonik {

	public static void main(String[] args) {
		
		Pravougaonik p1 = new Pravougaonik(2, 3, new Tacka(1, 1), new Tacka(4, 3));
		
		System.out.println(p1.izracunajObim());
		System.out.println(p1.izracunajPovrsinu());
		p1.provjeriTacku(new Tacka(4, 2));

	}

}
