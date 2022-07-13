package vozila;

public class Traktor extends Vozilo {
	
	public Traktor() {
		
	}

	@Override
	public void vozi(String odrediste) {
		System.out.println("Traktor puzi ka " + odrediste);
	}

}
