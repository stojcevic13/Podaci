package baze_projekat.sv412020.reports;

public class ExtendedUgovor {
	private String nazProiz;
	private String nazSer;
	private String uslovi;
	
	
	public ExtendedUgovor(String nazProiz, String nazSer, String uslovi) {
		super();
		this.nazProiz = nazProiz;
		this.nazSer = nazSer;
		this.uslovi = uslovi;
	}


	public String getNazProiz() {
		return nazProiz;
	}


	public void setNazProiz(String nazProiz) {
		this.nazProiz = nazProiz;
	}


	public String getNazSer() {
		return nazSer;
	}


	public void setNazSer(String nazSer) {
		this.nazSer = nazSer;
	}


	public String getUslovi() {
		return uslovi;
	}


	public void setUslovi(String uslovi) {
		this.uslovi = uslovi;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nazProiz == null) ? 0 : nazProiz.hashCode());
		result = prime * result + ((nazSer == null) ? 0 : nazSer.hashCode());
		result = prime * result + ((uslovi == null) ? 0 : uslovi.hashCode());
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
		ExtendedUgovor other = (ExtendedUgovor) obj;
		if (nazProiz == null) {
			if (other.nazProiz != null)
				return false;
		} else if (!nazProiz.equals(other.nazProiz))
			return false;
		if (nazSer == null) {
			if (other.nazSer != null)
				return false;
		} else if (!nazSer.equals(other.nazSer))
			return false;
		if (uslovi == null) {
			if (other.uslovi != null)
				return false;
		} else if (!uslovi.equals(other.uslovi))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.format("UGOVOR{NazProiz: 20%s, NazSer: 20%s, Uslovi: 20%s}", nazProiz, nazSer, uslovi);
	}

	
}
