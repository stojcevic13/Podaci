package test03;

import java.time.LocalDate;

public class Letovanje extends Putovanje {
	
	private int brZvezdica;
	private int brObroka;
	
	
	
	public Letovanje() {

	}
	
	public Letovanje(String odrediste, LocalDate datumOd, LocalDate datumDo, int brZvezdica, int brObroka) {
		super(odrediste, datumOd, datumDo);
		this.brZvezdica = brZvezdica;
		this.brObroka = brObroka;
	}
	
	
	



	public int getBrZvezdica() {
		return brZvezdica;
	}

	public void setBrZvezdica(int brZvezdica) {
		this.brZvezdica = brZvezdica;
	}

	public int getBrObroka() {
		return brObroka;
	}

	public void setBrObroka(int brObroka) {
		this.brObroka = brObroka;
	}
	
	
	

	@Override
	public double izracunajCenu() {
		return Metode.razlikaDana(getDatumOd(), getDatumDo()) * brZvezdica * brObroka * 2000;
	}

	
	
	@Override
	public String toString() {
		return "Letovanje " + super.toString() + " u hotel sa " + brZvezdica + " i " + brObroka + " obroka dnevno";
	}

	
	
	
	
}
