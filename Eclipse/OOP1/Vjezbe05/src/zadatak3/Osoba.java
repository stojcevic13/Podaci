package zadatak3;

public abstract class Osoba {
	
	private String ime;
	private String prezime;
	private String jmbg;
	
	
	
	public Osoba() {}
	public Osoba(String ime, String prezime, String jmbg) {
		this();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}
	public Osoba(Osoba o) {
		this(o.ime, o.prezime, o.jmbg);
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
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jmbg == null) ? 0 : jmbg.hashCode());
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
		if (jmbg == null) {
			if (other.jmbg != null)
				return false;
		} else if (!jmbg.equals(other.jmbg))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg;
	}
	
	
	
	
	
	
	

}
