package zadatak1;

public class Osoba {

	protected String ime;
	protected String prezime;
	protected String JMBG;
	
	public Osoba() {
		
	}
	
	public Osoba(String ime, String prezime, String jMBG) {
		this();
		this.ime = ime;
		this.prezime = prezime;
		JMBG = jMBG;
	}
	
	public Osoba(Osoba o) {
		this(o.ime, o.prezime, o.JMBG);
	}


	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((JMBG == null) ? 0 : JMBG.hashCode());
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
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
		Osoba other = (Osoba) obj;
		if (JMBG == null) {
			if (other.JMBG != null)
				return false;
		} else if (!JMBG.equals(other.JMBG))
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ime:" + ime + ", Prezime: " + prezime + ", JMBG: " + JMBG;
	}
	
	
	
	
	
	
	
}
