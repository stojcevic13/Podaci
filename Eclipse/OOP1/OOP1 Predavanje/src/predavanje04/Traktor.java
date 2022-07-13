package predavanje04;

public class Traktor extends Vozilo {


	
	// KONSTRUKTORI
	
	public Traktor() {}
	
	public Traktor(String tip, String boja, int brTockova) {
		super(tip, boja, brTockova);
	}
	
	
	
	// OVERRIDE
	
	@Override
	public void vozi(String odrediste) {
		System.out.printf("Traktor puzi ka %s.", odrediste);
	}
	
	
	
	// METODE
	
	public void ori() {
		System.out.println("Traktor ore.");
	}

}
