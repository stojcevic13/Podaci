package predavanje04;

public class Auto extends Vozilo implements MozeDaPlatiPutarinu{
	
	private int kubikaza;
	private String mjenjac;
	
	
	// KONSTRUKTORI
	
	public Auto() {}
	
	public Auto(String tip, String boja, int brTockova, int kubikaza, String mjenjac) {
		super(tip, boja, brTockova);
		this.kubikaza = kubikaza;
		this.mjenjac = mjenjac;
	}


	// GETTERI I SETTERI
	
	public int getKubikaza() {
		return kubikaza;
	}
	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}

	public String getMjenjac() {
		return mjenjac;
	}
	public void setMjenjac(String mjenjac) {
		this.mjenjac = mjenjac;
	}



	// OVERRIDE
	
	@Override
	public double platiPutarinu() {
		return 220;
	}

	@Override
	public void vozi(String odrediste) {
		System.out.printf("Auto vozi ka %s." + odrediste);
	}

	@Override
	public String toString() {
		return "Auto [kubikaza=" + kubikaza + ", mjenjac=" + mjenjac + "]";
	}
	
	
	
	
	

}
