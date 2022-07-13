package baze_projekat.sv412020.reports;

import java.util.ArrayList;
import java.util.List;

import baze_projekat.sv412020.*;

public class ExtendedServis {
	private List<ExtendedProizvodjac> extendedProizvodjaci;
	private int id;
	private String name;
	private double avgRadnika;
	
	public ExtendedServis(int idr, String name) {
		super();
		this.extendedProizvodjaci = new ArrayList<ExtendedProizvodjac>();
		this.id = idr;
		this.name = name;
		this.avgRadnika = 0;
	}

	public List<ExtendedProizvodjac> getExtendedComponents() {
		return extendedProizvodjaci;
	}

	public void setExtendedComponents(List<ExtendedProizvodjac> extendedComponents) {
		this.extendedProizvodjaci = extendedComponents;
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

	public double getAvgRadnika() {
		return avgRadnika;
	}

	public void setAvgRadnika(double avgRadnika) {
		this.avgRadnika = avgRadnika;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String servisData = "\nSERVIS{Id:" + id + ", Name:" + name
		+ ", AvgRadnika:" + avgRadnika;
		sb.append(servisData);
		
		for(ExtendedProizvodjac ec : extendedProizvodjaci) {
			sb.append("\n\t" + ec.toString());
		}
		
		sb.append("}\n");
		
		return sb.toString();
	}
	
}
