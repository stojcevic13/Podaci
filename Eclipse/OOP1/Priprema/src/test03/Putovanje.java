package test03;

import java.time.LocalDate;

public abstract class Putovanje {
	
	private String odrediste;
	private LocalDate datumOd;
	private LocalDate datumDo;
	
	
	public Putovanje() {
		
	}


	public Putovanje(String odrediste, LocalDate datumOd, LocalDate datumDo) {
		this();
		this.odrediste = odrediste;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
	}


	
	
	
	public String getOdrediste() {
		return odrediste;
	}


	public void setOdrediste(String odrediste) {
		this.odrediste = odrediste;
	}


	public LocalDate getDatumOd() {
		return datumOd;
	}


	public void setDatumOd(LocalDate datumOd) {
		this.datumOd = datumOd;
	}


	public LocalDate getDatumDo() {
		return datumDo;
	}


	public void setDatumDo(LocalDate datumDo) {
		this.datumDo = datumDo;
	}


	@Override
	public String toString() {
		return "u " + odrediste + " od " + Metode.getDatStr(datumOd) + "do " + Metode.getDatStr(datumDo);
	}
	
	
	public abstract double izracunajCenu();
	
	
	
	
	
	

}
