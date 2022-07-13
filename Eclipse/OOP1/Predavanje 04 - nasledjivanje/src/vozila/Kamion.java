package vozila;

import dijeloviVozila.MozeDaPlatiPutarinu;
import dijeloviVozila.Tocak;

public class Kamion extends Vozilo implements MozeDaPlatiPutarinu {
	
	Tocak prednjiDesni;
	Tocak prednjiLijevi;
	Tocak srednjiLijevi;
	Tocak srednjiDesni;
	Tocak zadnjiDesni;
	Tocak zadnjiLijevi;
	
	public Kamion() {
		this.prednjiDesni = new Tocak();
		this.prednjiLijevi = new Tocak();
		this.srednjiLijevi = new Tocak();
		this.srednjiDesni = new Tocak();
		this.zadnjiDesni = new Tocak();
		this.zadnjiLijevi = new Tocak();
	}

	public Kamion(Tocak prednjiDesni, Tocak prednjiLijevi, Tocak srednjiLijevi, Tocak srednjiDesni, Tocak zadnjiDesni,
			Tocak zadnjiLijevi) {
		super();
		this.prednjiDesni = prednjiDesni;
		this.prednjiLijevi = prednjiLijevi;
		this.srednjiLijevi = srednjiLijevi;
		this.srednjiDesni = srednjiDesni;
		this.zadnjiDesni = zadnjiDesni;
		this.zadnjiLijevi = zadnjiLijevi;
	}

	public Tocak getPrednjiDesni() {
		return prednjiDesni;
	}

	public void setPrednjiDesni(Tocak prednjiDesni) {
		this.prednjiDesni = prednjiDesni;
	}

	public Tocak getPrednjiLijevi() {
		return prednjiLijevi;
	}

	public void setPrednjiLijevi(Tocak prednjiLijevi) {
		this.prednjiLijevi = prednjiLijevi;
	}

	public Tocak getSrednjiLijevi() {
		return srednjiLijevi;
	}

	public void setSrednjiLijevi(Tocak srednjiLijevi) {
		this.srednjiLijevi = srednjiLijevi;
	}

	public Tocak getSrednjiDesni() {
		return srednjiDesni;
	}

	public void setSrednjiDesni(Tocak srednjiDesni) {
		this.srednjiDesni = srednjiDesni;
	}

	public Tocak getZadnjiDesni() {
		return zadnjiDesni;
	}

	public void setZadnjiDesni(Tocak zadnjiDesni) {
		this.zadnjiDesni = zadnjiDesni;
	}

	public Tocak getZadnjiLijevi() {
		return zadnjiLijevi;
	}

	public void setZadnjiLijevi(Tocak zadnjiLijevi) {
		this.zadnjiLijevi = zadnjiLijevi;
	}

	@Override
	public void vozi(String odrediste) {
		System.out.println("Kamion trese ka " + odrediste);
	}

	@Override
	public double platiPutarinu() {
		return 900.0;
	}
	
	
	
	

}
