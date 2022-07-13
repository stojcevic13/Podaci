package zadatak4c;

import java.util.ArrayList;
import java.util.List;

public class Klub {
	
	private String id;
	private String naziv;
	private List<Liga> lige;
	
	
	public Klub() {
		this.lige = new ArrayList<Liga>();
	}

	public Klub(String id, String naziv) {
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
	
	public List<Liga> getLige() {
		return lige;
	}

	public void setLige(List<Liga> lige) {
		this.lige = lige;
	}

	@Override
	public String toString() {
		return "Klub [id=" + id + ", naziv=" + naziv + ", lige=" + lige.size() + "]";
	}
	
	
	
	

}
