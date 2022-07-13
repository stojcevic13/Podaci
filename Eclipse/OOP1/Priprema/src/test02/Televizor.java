package test02;

public class Televizor extends Uredjaj {

	
	private int brHDMIUlaza;
	
	
	
	public Televizor() {
		
	}

	public Televizor(int id, double dijagonala, String proizvodjac, double cijena, int brHDMIUlaza) {
		super(id, dijagonala, proizvodjac, cijena);
		this.brHDMIUlaza = brHDMIUlaza;
	}
	

	
	public int getBrHDMIUlaza() {
		return brHDMIUlaza;
	}

	public void setBrHDMIUlaza(int brHDMIUlaza) {
		this.brHDMIUlaza = brHDMIUlaza;
	}

	
	
	@Override
	public double preuzmiCijenu(boolean akcija) {
		return (akcija) ? (this.getCijena() - this.getCijena()*0.1) : this.getCijena();
	}

	@Override
	public String toString() {
		return "Televizor " + super.toString() + " i " + brHDMIUlaza + " HDMI ulaza";
	}
	
	
	

	
}
