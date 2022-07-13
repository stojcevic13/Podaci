package baze_projekat.sv412020.reports;

public class ExtendedProizvodjac {
	private String name;
	private int brRadnika;

	public ExtendedProizvodjac(String name, int totalPriceForComponent) {
		super();
		this.name = name;
		this.brRadnika = totalPriceForComponent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalPriceForComponent() {
		return brRadnika;
	}

	public void setTotalPriceForComponent(int totalPriceForComponent) {
		this.brRadnika = totalPriceForComponent;
	}

	@Override
	public String toString() {
		return String.format("PROIZVODJAC{Name: 20%s, BrRadnika: %d}", name, brRadnika);
	}

}
