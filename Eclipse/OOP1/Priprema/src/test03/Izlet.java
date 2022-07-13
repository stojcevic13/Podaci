package test03;

import java.time.LocalDate;

public class Izlet extends Putovanje {

	private int brDnevnihUlaznica;
	
	
	
	
	public Izlet() {
		
	}
	
	public Izlet(String odrediste, LocalDate datumOd, LocalDate datumDo, int brDnevnihUlaznica) {
		super(odrediste, datumOd, datumDo);
		this.brDnevnihUlaznica = brDnevnihUlaznica;
	}
	
	
	
	




	public int getBrDnevnihUlaznica() {
		return brDnevnihUlaznica;
	}

	public void setBrDnevnihUlaznica(int brDnevnihUlaznica) {
		this.brDnevnihUlaznica = brDnevnihUlaznica;
	}
	
	
	
	
	
	

	@Override
	public String toString() {
		return "Izlet " + super.toString() + " sa " + brDnevnihUlaznica + " ulaznica dnevno";
	}

	@Override
	public double izracunajCenu() {
		return Metode.razlikaDana(getDatumOd(), getDatumDo()) * brDnevnihUlaznica * 1000;
	}
	
}
