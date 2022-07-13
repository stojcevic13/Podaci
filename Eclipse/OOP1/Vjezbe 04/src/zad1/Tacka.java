package zad1;

public class Tacka {

	double x;
	double y;
	
	public Tacka() {
		
	}
	
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double rastojanje(Tacka druga) {
		return Math.sqrt((this.x - druga.x)*(this.x - druga.x) + (this.y - druga.y)*(this.y - druga.y));
	}
	
	public boolean desno(Tacka druga) {
		return druga.x > this.x;
	}
	
	public boolean lijevo(Tacka druga) {
		return druga.x < this.x;
	}
	
	public boolean gore(Tacka druga) {
		return druga.y > this.y;
	}
	
	public boolean dole(Tacka druga) {
		return druga.y < this.y;
	}
	
}
