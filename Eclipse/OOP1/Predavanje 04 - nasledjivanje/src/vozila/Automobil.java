package vozila;

import dijeloviVozila.MozeDaPlatiPutarinu;
import dijeloviVozila.Tocak;

public class Automobil extends Vozilo implements MozeDaPlatiPutarinu{

	Tocak prednjiDesni;
	Tocak prednjiLijevi;
	Tocak zadnjiDesni;
	Tocak zadnjiLijevi;
	
	public Automobil() {
		this.prednjiDesni = new Tocak();
		this.prednjiLijevi = new Tocak();
		this.zadnjiDesni = new Tocak();
		this.zadnjiLijevi = new Tocak();
	}
	
	public Automobil(Tocak prednjiDesni, Tocak prednjiLijevi, Tocak zadnjiDesni, Tocak zadnjiLijevi) {
		super();
		this.prednjiDesni = prednjiDesni;
		this.prednjiLijevi = prednjiLijevi;
		this.zadnjiDesni = zadnjiDesni;
		this.zadnjiLijevi = zadnjiLijevi;
	}

	@Override
	public void vozi(String odrediste) {
		System.out.println("Auto vozi ka " + odrediste);	
	}

	@Override
	public double platiPutarinu() {
		return 500.0;
	}
	
	

}
