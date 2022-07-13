package predavanje04;

public class Pista {

	private int brAviona;
	
	
	// KONSTRUKTORI
	
	public Pista() {}
	
	public Pista(int brAviona) {
		this.brAviona = brAviona;
	}

	
	// GETTERI I SETTERI
	
	public int getBrAviona() {
		return brAviona;
	}
	public void setBrAviona(int brAviona) {
		this.brAviona = brAviona;
	}
	
	
	public void slijetanjeNovogAviona(Avion a) {
		System.out.println("Provjera da li ima mjesta");
		a.sleti();
		this.brAviona += 1;
	}
	
	public void polijetanjeAvionaSaPiste(Avion a) {
		System.out.println("Provjera ima li prostora");
		a.poleti();
		this.brAviona -= 1;
	}
	
	
}

