package vezbe8.testiranje.primer3.models;

public class TipKorisnika {

	String tip;
	boolean b;

	public TipKorisnika(String tip, boolean b) {
		super();
		this.tip = tip;
		this.b = b;
	}

	public TipKorisnika() {

	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

}
