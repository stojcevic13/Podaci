package predavanje04;

public class BorbeniAvion extends Avion {

	private String top;
	private int bombe;
	
	public BorbeniAvion(String oznaka, double tezina, String proizvodjac, String top, int bombe) {
		super(oznaka, tezina, proizvodjac);
		this.top = top;
		this.bombe = bombe;
	}
	
	
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}

	public int getBombe() {
		return bombe;
	}
	public void setBombe(int bombe) {
		this.bombe = bombe;
	}


	@Override
	public void sleti() {
		this.bombe = 0;
		System.out.println("Avion ispusta bombe u neku pustaru.");
		super.sleti();
	}
	
}
