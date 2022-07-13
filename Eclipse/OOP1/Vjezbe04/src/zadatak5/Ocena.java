package zadatak5;

public class Ocena {

	private Predmet predmet;
	private Integer ocena;
	
	
	
	// KONSTRUKTORI
	
	public Ocena() {}
	public Ocena(Predmet predmet, Integer ocena) {
		this();
		this.predmet = predmet;
		this.ocena = ocena;
	};
	public Ocena(Ocena o) {
		this(o.predmet, o.ocena);
	}
	
	
	
	
	// GETTERI I SETTERI
	
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
	public Integer getOcena() {
		return ocena;
	}
	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	
	
	
	// OVERRIDE
	
	@Override
	public String toString() {
		return "Ocena [predmet=" + predmet + ", ocena=" + ocena + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ocena == null) ? 0 : ocena.hashCode());
		result = prime * result + ((predmet == null) ? 0 : predmet.hashCode());
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
		Ocena other = (Ocena) obj;
		if (ocena == null) {
			if (other.ocena != null)
				return false;
		} else if (!ocena.equals(other.ocena))
			return false;
		if (predmet == null) {
			if (other.predmet != null)
				return false;
		} else if (!predmet.equals(other.predmet))
			return false;
		return true;
	}

	
	
	
	
	
	
}
