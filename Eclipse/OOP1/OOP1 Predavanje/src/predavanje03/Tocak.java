package predavanje03;

public class Tocak {
	
	double pritisak;
	
	public Tocak() {
		
	}
	
	public Tocak(double pritisak) {
		this.pritisak = pritisak;
	}

	public Tocak copy() {
		return new Tocak(this.pritisak);
	}

}
