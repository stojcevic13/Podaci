package zadatak5;

public class Predmet {

	private String sifra;
	private String naziv;
	private Integer semestar;
	private String profesor;
	
	
	
	// KONSTRUKTORI
	
	public Predmet() {}
	public Predmet(String sifra, String naziv, Integer semestar, String profesor) {
		this();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.profesor = profesor;
	}
	public Predmet(Predmet p) {
		this(p.sifra, p.naziv, p.semestar, p.profesor);
	}

	
	
	
	// GETTERI I SETTERI
	
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getSemestar() {
		return semestar;
	}
	public void setSemestar(Integer semestar) {
		this.semestar = semestar;
	}

	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}


	
	
	
	// OVERRIDE
	
	@Override
	public String toString() {
		return "Predmet [sifra=" + sifra + ", naziv=" + naziv + ", semestar=" + semestar + ", profesor=" + profesor
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
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
		Predmet other = (Predmet) obj;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}
	
	
	
	
	// METODE
	
	
	
	
	
	

	
	
	
	
}
