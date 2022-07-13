package predavanje04;

public abstract class Vozilo {
	
	private String tip;
	private String boja;
	private int brTockova;
	
	
	// KONSTRUKTORI
	
	public Vozilo() {}
	public Vozilo(String tip, String boja, int brTockova) {
		this.tip = tip;
		this.boja = boja;
		this.brTockova = brTockova;
	}
	
	
	
	// GETTERI I SETTERI
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getBoja() {
		return boja;
	}
	public void setBoja(String boja) {
		this.boja = boja;
	}

	public int getBrTockova() {
		return brTockova;
	}
	public void setBrTockova(int brTockova) {
		this.brTockova = brTockova;
	}
	
	
	//public abstract double platiPutarinu();
	public abstract void vozi(String odrediste);

}
