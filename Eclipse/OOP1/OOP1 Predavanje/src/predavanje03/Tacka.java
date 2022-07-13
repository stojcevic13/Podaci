package predavanje03;

public class Tacka {
	
	double x;
	double y;
	
	public Tacka() {
		
	}
	
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Tacka(Tacka t) {
		this(t.x, t.y);
	}

	public double udaljenost(Tacka neka) {
		return Math.sqrt((this.x - neka.x)*(this.x - neka.x) + (this.y - neka.y)*(this.y - neka.y));
	}

	

}
