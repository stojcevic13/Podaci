package zadatak2;

public abstract class Artikal {

	private String sifra;
	private String naziv;
	private Double cijena;
	private Integer kolicina;
	private String opis;
	
	
	
	
	public Artikal() {};
	public Artikal(String sifra, String naziv, double cijena, int kolicina, String opis) {
		this.sifra = sifra;
		this.naziv = naziv;
		this.cijena = cijena;
		this.kolicina = kolicina;
		this.opis = opis;
	}
	public Artikal(Artikal a) {
		this(a.sifra, a.naziv, a.cijena, a.kolicina, a.opis);
	}
	
	
	
	
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
	public Double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	public Integer getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
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
		Artikal other = (Artikal) obj;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "sifra=" + sifra + ", naziv=" + naziv + ", cijena=" + cijena + ", kolicina=" + kolicina
				+ ", opis=" + opis;
	}



}
