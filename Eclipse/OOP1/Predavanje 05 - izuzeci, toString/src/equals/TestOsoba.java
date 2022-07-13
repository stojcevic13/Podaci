package equals;

public class TestOsoba {

	public static void main(String[] args) {
		
		Osoba o1 = new Osoba("Petar", "Petrovic", 19);
		Osoba o2 = new Osoba("Petar", "Petrovic", 19);
		
		System.out.println(o1);
		System.out.println(o2);
		
		System.out.println("Jednaki: " + (o1.equals(o2)));
		
	}

}
