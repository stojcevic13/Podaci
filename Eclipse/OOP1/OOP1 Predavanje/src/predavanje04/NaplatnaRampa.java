package predavanje04;

public class NaplatnaRampa {

	private double total;
	
	
	
	// KONSTRUKTORI
	
	public NaplatnaRampa() {}
	
	public NaplatnaRampa(double total) {
		this.total = total;
	}


	
	// GETTERI I  SETTERI
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	// METODE
	
	public void naplati(MozeDaPlatiPutarinu v) {
		this.total += v.platiPutarinu();
	}
	
	public void naplati(MozeDaPlatiPutarinu[] vozila) {
		for (MozeDaPlatiPutarinu v : vozila)
			this.total += v.platiPutarinu();
	}
	
}
