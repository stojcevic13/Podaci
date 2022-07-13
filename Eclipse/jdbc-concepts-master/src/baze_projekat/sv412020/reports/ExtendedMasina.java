package baze_projekat.sv412020.reports;

import java.util.ArrayList;
import java.util.List;

public class ExtendedMasina {
	private List<ExtendedUgovor> extendedUgovori;
	private int id;
	private String name;
	private int brUgovora;
	
	public ExtendedMasina(int id, String name){
		this.extendedUgovori = new ArrayList<ExtendedUgovor>();
		this.id = id;
		this.name = name;
		this.brUgovora = 0;
	}
	
	
	public List<ExtendedUgovor> getExtendedUgovori() {
		return extendedUgovori;
	}
	public void setExtendedMasine(List<ExtendedUgovor> extendedUgovori) {
		this.extendedUgovori = extendedUgovori;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBrUgovora() {
		return brUgovora;
	}
	public void setBrUgovora(int brUgovora) {
		this.brUgovora = brUgovora;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brUgovora;
		result = prime * result + ((extendedUgovori == null) ? 0 : extendedUgovori.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ExtendedMasina other = (ExtendedMasina) obj;
		if (brUgovora != other.brUgovora)
			return false;
		if (extendedUgovori == null) {
			if (other.extendedUgovori != null)
				return false;
		} else if (!extendedUgovori.equals(other.extendedUgovori))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String servisData = "\nMASINA{Id:" + id + ", Name:" + name
		+ ", BRuGOVORA:" + brUgovora;
		sb.append(servisData);
		
		for(ExtendedUgovor ec : extendedUgovori) {
			sb.append("\n\t" + ec.toString());
		}
		
		sb.append("}\n");
		
		return sb.toString();
	}
}
