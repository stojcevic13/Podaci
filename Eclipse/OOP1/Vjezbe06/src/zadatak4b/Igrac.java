package zadatak4b;

public class Igrac {
	
	private String id;
	private String ime;
	private String prezime;
	private Klub klub;
	
	
	public Igrac() {
		
	}


	public Igrac(String id, String ime, String prezime) {
		this();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
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
	public String toString() {
		return "Igrac [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", klub=" + klub + "]";
	}
	
	
	
	

}
