package zadatak1;

public class Pravougaonik {
	
	private double a;
	private double b;
	private Tacka tackaA;
	private Tacka tackaB;
	
	public Pravougaonik() {
		
	}
	
	public Pravougaonik(double a, double b, Tacka tackaA, Tacka tackaB) {
		this.a = a;
		this.b = b;
		this.tackaA = tackaA;
		this.tackaB = tackaB;
	}

	public double getA() {
		return this.a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return this.b;
	}
	public void setB(double b) {
		this.b = b;
	}
	
	public void setTackaA(Tacka tackaA) {
		this.tackaA = tackaA;
	}
	public void setTackaB(Tacka b) {
		this.tackaB = b;
	}
	public Tacka getTackaA() {
		return this.tackaA;
	}
	public Tacka getTackaB() {
		return this.tackaB;
	}

	
	public double izracunajPovrsinu() {
		return this.a * this.b;
	}

	public double izracunajObim() {
		return 2*a + 2*b;
	}
	
	public void provjeriTacku(Tacka neka) {
		if ( !(neka.getX() >= this.tackaA.getX() && neka.getX() <= this.tackaB.getX()) ) {
			System.out.println("Tacka se ne nalazi u pravougaoniku.");
			return;
		}
		if ( !(neka.getY() >= this.tackaA.getY() && neka.getY() <= this.tackaB.getY()) ) {
			System.out.println("Tacka se ne nalazi u pravougaoniku.");
		} else
			System.out.println("Tacka je u pravougaoniku.");
	}

}
