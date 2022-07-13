package zadatak4b;

import java.util.ArrayList;
import java.util.List;

public class Klub {
	
	private String id;
	private String naziv;
	private List<Igrac> igraci;
	
	
	public Klub() {
		this.igraci = new ArrayList<Igrac>();
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

	public List<Igrac> getIgraci() {
		return igraci;
	}

	public void setIgraci(List<Igrac> igraci) {
		this.igraci = igraci;
	}

	@Override
	public String toString() {
		return "Klub [id=" + id + ", naziv=" + naziv + ", igraci=" + igraci.size() + "]";
	}
	
	
	
	

}
