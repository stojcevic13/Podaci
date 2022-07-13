package zadatak4c;

import java.util.ArrayList;
import java.util.List;

public class Liga {
	
	private String id;
	private String naziv;
	private List<Klub> klubovi;
	
	
	
	public Liga() {
		this.klubovi = new ArrayList<Klub>();
	}



	public Liga(String id, String naziv) {
		this();
		this.id = id;
		this.naziv = naziv;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNaziv() {
		return naziv;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}



	public List<Klub> getKlubovi() {
		return klubovi;
	}



	public void setKlubovi(List<Klub> klubovi) {
		this.klubovi = klubovi;
	}



	@Override
	public String toString() {
		return "Liga [id=" + id + ", naziv=" + naziv + ", klubovi=" + klubovi.size() + "]";
	}
	
	
	

}
