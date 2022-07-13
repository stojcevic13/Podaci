package vezbe5.primer12;

public class Tacka {

	public double x;
	public double y;
	
	
//	public Tacka() {
//		System.out.println("Konstruktor tacka");
//	}

	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// poziva se svaki put kada se objekat prosledi metodi koja kao parametar prima objekat klase String
	@Override
	public String toString() {
		return "x:" + x + ", y: " + y;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isti = false;
		if (obj == null) {
			return false;
		}
		// poredjenje po referenci
		if (this == obj) {
			return true;
		}
		if (obj instanceof Tacka) {
			// castovanje objekta u objekat klase Tacka
			Tacka objTacka = (Tacka) obj;
			if (this.x == objTacka.x && this.y == objTacka.y) {
				isti = true;
			}
		}
		return isti;
	}

	public Tacka deepCopy() {
		return new Tacka(this.x, this.y);
	}

}
