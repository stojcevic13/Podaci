package zad12zivotinje;

public abstract class Zivotinja {

	private String vrsta;
	
	public Zivotinja() {}
	
	public Zivotinja(String vrsta) {
		this.vrsta = vrsta;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vrsta == null) ? 0 : vrsta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zivotinja other = (Zivotinja) obj;
		if (vrsta == null) {
			if (other.vrsta != null)
				return false;
		} else if (!vrsta.equals(other.vrsta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "vrsta=" + vrsta;
	}
	
	public abstract void oglasavanje();
	public abstract void oglasavanjeULjutini();
	public abstract void nacinKretanja();
	
	
	
}
