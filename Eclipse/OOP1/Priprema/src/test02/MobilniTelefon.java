package test02;

public class MobilniTelefon extends Uredjaj {
	
	private int kameraMP;
	
	
	
	public MobilniTelefon() {
		
	}

	public MobilniTelefon(int id, double dijagonala, String proizvodjac, double cijena, int brHDMIUlaza) {
		super(id, dijagonala, proizvodjac, cijena);
		this.kameraMP = brHDMIUlaza;
	}
	

	
	public int getKameraMP() {
		return kameraMP;
	}

	public void setKameraMP(int kameraMP) {
		this.kameraMP = kameraMP;
	}

	
	
	@Override
	public double preuzmiCijenu(boolean akcija) {
		return (akcija) ? (this.getCijena() - this.getCijena()*0.15) : this.getCijena();
	}

	@Override
	public String toString() {
		return "Mobilni telefon " + super.toString() + " i kamerom od " + kameraMP + " MP";
	}

}
