package zadatak1;

public class TestRacuni {

	public static void main(String[] args) {
		
		Osoba o = new Osoba("Nemanja", "Stojcevic", "4392479213");
		TekuciRacun r1 = new TekuciRacun(o, 100, 1);
		RacunStednje r2 = new RacunStednje(o, 1000, true, 1);
		
		r1.uplatiPare(110);
		System.out.println(r1.getStanje());
		
		if (r2.podigniPare(10))
			System.out.println("Pare su podignute.");
		else
			r2.obustaviStednju(10);
			System.out.println("Pare nisu podignute.");

		r2.podigniPare(100);
		System.out.println(r2.getStanje());
	}

}
