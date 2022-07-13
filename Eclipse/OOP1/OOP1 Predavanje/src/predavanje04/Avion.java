package predavanje04;

public class Avion {

	private String oznaka;
	private double tezina;
	private String proizvodjac;
	
	public Avion() {};
	
	public Avion(String oznaka, double tezina, String proizvodjac) {
		this.oznaka = oznaka;
		this.tezina = tezina;
		this.proizvodjac = proizvodjac;
	}

	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public double getTezina() {
		return tezina;
	}
	public void setTezina(double tezina) {
		this.tezina = tezina;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	
	
	public void sleti() {
		System.out.println("Avion slijece.");
	}
	
	public void poleti() {
		System.out.println("Avion polijece.");
	}
	
}
