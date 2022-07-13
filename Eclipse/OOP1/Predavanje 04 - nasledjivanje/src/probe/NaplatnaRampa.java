package probe;

import dijeloviVozila.MozeDaPlatiPutarinu;
import vozila.Automobil;
import vozila.Kamion;
//import vozila.Traktor;
//import vozila.Vozilo;

public class NaplatnaRampa {
	
	private double total = 0;

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public void placanjePutarine (MozeDaPlatiPutarinu[] vozila) {
		for (MozeDaPlatiPutarinu v : vozila) {
			this.total += v.platiPutarinu();
		}
	}
	
	public static void main(String[] args) {
		
		NaplatnaRampa np = new NaplatnaRampa();
		
		MozeDaPlatiPutarinu v1 = new Automobil();
		MozeDaPlatiPutarinu v2 = new Kamion();
		MozeDaPlatiPutarinu v3 = new Automobil();
//		Vozilo v4 = new Traktor();
		
		MozeDaPlatiPutarinu[] vozila = {v1, v2, v3};
		
		np.placanjePutarine(vozila);
		System.out.println("Total: " + np.getTotal());

	}

}
