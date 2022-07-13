package Zad5;

public class Ocjena {
	
	private Predmet predmet;
	private int ocjena;
	
	public Ocjena() {
		
	}
	
	public Ocjena(Predmet predmet, int ocjena) {
		super();
		this.predmet = predmet;
		this.ocjena = ocjena;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getOcjena() {
		return ocjena;
	}

	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
	}
	
	
	

}
