package kss.model;

public class Igrac {

	private int id;
	private String ime;
	private String prezime;
	private Klub klub;
	
	
	
	
	
	public Igrac() {
		this.ime = "";
		this.prezime = "";
	}

	public Igrac(int id, String ime, String prezime, Klub k) {
		this();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.klub = k;
	}

	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Klub getKlub() {
		return klub;
	}

	public void setKlub(Klub klub) {
		this.klub = klub;
	}

	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Igrac other = (Igrac) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Igrac [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", klub=" + klub.getNaziv() + "]";
	}

	public Object toCell(int columnIndex) {
		switch (columnIndex) {
			case 0:
				return this.id;
			case 1:
				return this.ime;
			case 2:
				return this.prezime;
			case 3:
				return this.klub.getNaziv();
			default:
				return null;
		}
	}
	
	
	public void setCell(Object value, int columnIndex) {
		switch (columnIndex) {
			case 1:
				this.ime = (String) value;
			case 2:
				this.prezime = (String) value;
			case 3:
				this.klub.setNaziv((String) value);
			default:
				return;
		}
	}
	
	
	
}
