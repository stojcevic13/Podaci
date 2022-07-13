package predavanje04;

public class Kamion extends Auto {

	// KONSTRUKTORI
	
	
	public Kamion() {}
	
	public Kamion(String tip, String boja, int brTockova, int kubikaza, String mjenjac) {
		super(tip, boja, brTockova, kubikaza, mjenjac);
	}
	
	
	
	// OVERRIDE
	
	@Override
	public double platiPutarinu() {
		return 1000;
	}
	
	@Override
	public void vozi(String odrediste) {
		System.out.printf("Kamion brunda ka %s.", odrediste);
	}
	
	

}
