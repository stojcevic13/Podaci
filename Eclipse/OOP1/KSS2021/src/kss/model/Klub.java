package kss.model;

import java.util.ArrayList;
import java.util.List;

public class Klub {

	private int id;
	private String naziv;
	private List<Igrac> igraci;
	
	
	
	
	public Klub() {
		this.igraci = new ArrayList<Igrac>();
	}

	public Klub(int id, String naziv) {
		this();
		this.id = id;
		this.naziv = naziv;
	}

	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		Klub other = (Klub) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Klub [id=" + id + ", naziv=" + naziv + ", igraca=" + igraci.size() + "]";
	}

	public Object toCell(int columnIndex) {
		if (columnIndex == 0)
			return ("" + this.id);
		else if (columnIndex == 1)
			return this.naziv;
		else
			return "";
	}

	public void setCell(Object value, int col) {
		switch (col) {
			case 1:
				this.naziv = (String) value;
				break;
			default:
				return;
		}
	}

	
	
	
	
	
	
	
	
	
	
}
