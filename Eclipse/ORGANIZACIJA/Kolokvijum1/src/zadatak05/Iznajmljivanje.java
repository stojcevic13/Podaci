package zadatak05;

public class Iznajmljivanje {
	
//	šifra iznajmljivanja, mesto iznajmljivanja, datum iznajmljivanja, datum vraćanja i pređeno kilometara (ukoliko 
//	automobil još nije vraćen nema ovih atributa), cena iznajmljivanja za dan, broj dana na koliko je auto iznajmljen, osoba koja je iznajmila
//	automobil (ugnježdeni JSON objekat sa imenom, prezimenom i matičnim brojem)

	private String sifra;
	private String mjesto;
	private String datumIznajmljivanja;
	private String datumVracanja;
	private double predjenoKilometara;
	private double cijenaPoDanu;
	private int dani;
	private Osoba osoba;
	
	
	public Iznajmljivanje() {
		this.osoba = new Osoba();
	}


	public Iznajmljivanje(String sifra, String mjesto, String datumIznajmljivanja, String datumVracanja,
			double predjenoKilometara, double cijenaPoDanu, int dani, Osoba osoba) {
		this();
		this.sifra = sifra;
		this.mjesto = mjesto;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.predjenoKilometara = predjenoKilometara;
		this.cijenaPoDanu = cijenaPoDanu;
		this.dani = dani;
		this.osoba = osoba;
	}


	public Iznajmljivanje(String sifra, String mjesto, String datumIznajmljivanja, double cijenaPoDanu, Osoba osoba) {
		this();
		this.sifra = sifra;
		this.mjesto = mjesto;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.cijenaPoDanu = cijenaPoDanu;
		this.osoba = osoba;
	}


	public String getSifra() {
		return sifra;
	}


	public void setSifra(String sifra) {
		this.sifra = sifra;
	}


	public String getMjesto() {
		return mjesto;
	}


	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}


	public String getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}


	public void setDatumIznajmljivanja(String datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}


	public String getDatumVracanja() {
		return datumVracanja;
	}


	public void setDatumVracanja(String datumVracanja) {
		this.datumVracanja = datumVracanja;
	}


	public double getPredjenoKilometara() {
		return predjenoKilometara;
	}


	public void setPredjenoKilometara(double predjenoKilometara) {
		this.predjenoKilometara = predjenoKilometara;
	}


	public double getCijenaPoDanu() {
		return cijenaPoDanu;
	}


	public void setCijenaPoDanu(double cijenaPoDanu) {
		this.cijenaPoDanu = cijenaPoDanu;
	}


	public int getDani() {
		return dani;
	}


	public void setDani(int dani) {
		this.dani = dani;
	}


	public Osoba getOsoba() {
		return osoba;
	}


	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cijenaPoDanu);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + dani;
		result = prime * result + ((datumIznajmljivanja == null) ? 0 : datumIznajmljivanja.hashCode());
		result = prime * result + ((datumVracanja == null) ? 0 : datumVracanja.hashCode());
		result = prime * result + ((mjesto == null) ? 0 : mjesto.hashCode());
		result = prime * result + ((osoba == null) ? 0 : osoba.hashCode());
		temp = Double.doubleToLongBits(predjenoKilometara);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Iznajmljivanje other = (Iznajmljivanje) obj;
		if (Double.doubleToLongBits(cijenaPoDanu) != Double.doubleToLongBits(other.cijenaPoDanu))
			return false;
		if (dani != other.dani)
			return false;
		if (datumIznajmljivanja == null) {
			if (other.datumIznajmljivanja != null)
				return false;
		} else if (!datumIznajmljivanja.equals(other.datumIznajmljivanja))
			return false;
		if (datumVracanja == null) {
			if (other.datumVracanja != null)
				return false;
		} else if (!datumVracanja.equals(other.datumVracanja))
			return false;
		if (mjesto == null) {
			if (other.mjesto != null)
				return false;
		} else if (!mjesto.equals(other.mjesto))
			return false;
		if (osoba == null) {
			if (other.osoba != null)
				return false;
		} else if (!osoba.equals(other.osoba))
			return false;
		if (Double.doubleToLongBits(predjenoKilometara) != Double.doubleToLongBits(other.predjenoKilometara))
			return false;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Iznajmljivanje [sifra=" + sifra + ", mjesto=" + mjesto + ", datumIznajmljivanja=" + datumIznajmljivanja
				+ ", datumVracanja=" + datumVracanja + ", predjenoKilometara=" + predjenoKilometara + ", cijenaPoDanu="
				+ cijenaPoDanu + ", dani=" + dani + ", osoba=" + osoba + "]";
	}
	
	

}
