package primjeri;

public class Piksel extends Tacka {

	private String boja;

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public Piksel(double x, double y, String boja) {
		super(x, y);
		this.boja = boja;
	}
	
	
}
