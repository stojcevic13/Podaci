package zad1;

/**
 * @author acer
 *
 */
public class Pravougaonik {

	private double a;
	private double b;
	private Tacka goreDesno = new Tacka();
	private Tacka doleLijevo = new Tacka();

	public Pravougaonik() {
		this.a = 0;
		this.b = 0;
	}

	public Pravougaonik(double a, double b, double x1, double y1, double x2, double y2) {
		this.a = a;
		this.b = b;
		this.goreDesno.x = x1;
		this.goreDesno.y = y1;
		this.doleLijevo.x = x2;
		this.doleLijevo.y = y2;
	}
	
	public Pravougaonik(double a, double b, Tacka goreDesno, Tacka doleLijevo) {
		this(a, b, goreDesno.x, goreDesno.y, doleLijevo.x, doleLijevo.y);
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

	public Tacka getGoreDesno() {
		return goreDesno;
	}

	public void setGoreDesno(Tacka goreDesno) {
		this.goreDesno = goreDesno;
	}

	public Tacka getDoleLijevo() {
		return doleLijevo;
	}

	public void setDoleLijevo(Tacka doleLijevo) {
		this.doleLijevo = doleLijevo;
	}

	public double izracunajPovrsinu() {
		return this.a * this.b;
	}

	public double izracunajObim() {
		return 2 * (a + b);
	}
	
	public void provjeri(Tacka neka) {
//		Tacka goreLijevo = new Tacka(this.doleLijevo.getX(), this.goreDesno.getY());
//		Tacka doleDesno = new Tacka(this.goreDesno.x, this.doleLijevo.y);
		
		if ((this.doleLijevo.desno(neka) && this.doleLijevo.gore(neka)) && (this.goreDesno.lijevo(neka) && this.goreDesno.dole(neka)))
			System.out.println("Unutar pravougaonika.");
		else
			System.out.println("Nije unutar pravougaonika.");
	}

}
