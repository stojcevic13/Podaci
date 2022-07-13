package arrayliste;

import java.util.ArrayList;

import equals.Osoba;

public class TestArrayListe {
	
	static void ispisiStaGod(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			System.out.println(objects[i]);
		}
	}

	public static void main(String[] args) {
		
		ArrayList<Osoba> osobe = new ArrayList<Osoba>();
		osobe.add(new Osoba("Petar", "Petrovic", 19));
		osobe.add(new Osoba("Nemanja", "Stojcevic", 19));
		System.out.println(osobe.get(0));
		
		for (Osoba o : osobe) {
			System.out.println("Osoba " + (osobe.indexOf(o) + 1) + ":" + o);
		}
		System.out.println();
		
		ispisiStaGod(1, 32, "tekst", osobe.get(0), osobe.get(1));

	}

}
