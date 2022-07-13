package zadatak1;

public class Tacka {

	private double x;
	private double y;
	
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
	
	public double rastojanje(Tacka neka) {
		return Math.sqrt((this.x - neka.getX())*(this.x - neka.getX()) + (this.y - neka.getY())*(this.y - neka.getY()));
	}
}
