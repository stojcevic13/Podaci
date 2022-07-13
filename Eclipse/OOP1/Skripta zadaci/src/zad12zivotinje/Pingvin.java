package zad12zivotinje;

public class Pingvin extends Zivotinja {
	
	String ime;
	
	public Pingvin() {}
	
	public Pingvin(String ime) {
		super("pingvin");
		this.ime = ime;
	}
	
	public Pingvin(Pingvin p) {
		this(p.ime);
	}
	

	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}

	
	@Override
	public void oglasavanje() {
		System.out.println("kjdfhsd");
	}

	@Override
	public void oglasavanjeULjutini() {
		System.out.println("FDJHSFD");	
	}

	@Override
	public void nacinKretanja() {
		System.out.println("krecem se.");	
	}

}
