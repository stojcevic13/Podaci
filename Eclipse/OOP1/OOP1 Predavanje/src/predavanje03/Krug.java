package predavanje03;

public class Krug {
	
	double r;
	Tacka centar;
	
	public Krug(){
		this.centar = new Tacka();
	}
	
	public Krug(double x, double y, double r){
		this.centar = new Tacka(x, y);
		this.r = r;
	}
	
	public Krug(Tacka centar, double r) {
		this(centar.x, centar.y, r);
	}
	
	void provjeriTacku(Tacka neka) {
		double udaljenost = this.centar.udaljenost(neka);
		if (udaljenost > r)
			System.out.println("Tacka je izvan kruga.");
		else if (udaljenost < r)
			System.out.println("Tacka je unutar kruga.");
		else
			System.out.println("Tacka je na krugu.");
	}

	
	

}
