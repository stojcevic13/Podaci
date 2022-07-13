package zad12zivotinje;

public class Riba extends Zivotinja {
	
	private String ime;
	private String podvrsta;
	
	
	public Riba() {}
	
	public Riba(String ime, String podvrsta) {
		super("riba");
		this.ime = ime;
		this.podvrsta = podvrsta;
	}
	
	public Riba(Riba r) {
		this(r.ime, r.podvrsta);
	}
	
	
	// getteri i setteri
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPodvrsta() {
		return podvrsta;
	}
	public void setPodvrsta(String podvrsta) {
		this.podvrsta = podvrsta;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((podvrsta == null) ? 0 : podvrsta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Riba other = (Riba) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (podvrsta == null) {
			if (other.podvrsta != null)
				return false;
		} else if (!podvrsta.equals(other.podvrsta))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "Riba:" + super.toString() + ", ime=" + ime + ", podvrsta=" + podvrsta;
	}

	@Override
	public void oglasavanje() {
		System.out.println("fldksfjs");
	}

	@Override
	public void oglasavanjeULjutini() {
		System.out.println("DKFJHDFK");
	}

	@Override
	public void nacinKretanja() {
		System.out.println("Plivanje");	
	}

}
