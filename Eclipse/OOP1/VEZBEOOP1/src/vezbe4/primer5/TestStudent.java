package vezbe4.primer5;

public class TestStudent {

	public static void main(String[] args) {

		System.out.println("\nPrimjer instanciranja objekata pomocu razlicitih konstruktora");

		// kreiranje objekta pomocu konstruktora bez parametar
		Student s1 = new Student();
		// kreiranje objekta pomocu kontruktora sa parametrima koji su atributi klasi
		Student s2 = new Student("Marko", "111", "Novi Sad");
		// poziv konstruktora kopije sa parametrom koji je referenca na objekat
		Student s3 = new Student(s2);
		// shallow copy, dve promenljive sadrze referencu na isti objekat u memoriji
		Student s4 = s2;

		s1.prikaziPodatke();
		s2.prikaziPodatke();
		s3.prikaziPodatke();
		s4.prikaziPodatke();

		int a, b;
		a = 3;
		b = a;
		a = 5;
		System.out.println("a = " + a + "\t b = " + b);

		System.out.println("\nNakon izmene grada studenta2");
		s2.setGrad("Beograd");
		s2.prikaziPodatke();
		s3.prikaziPodatke();
		s4.prikaziPodatke();
	}

}
