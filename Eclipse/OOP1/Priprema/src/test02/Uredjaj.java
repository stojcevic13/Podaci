package test02;

public abstract class Uredjaj {
	
	private int id;
	private double dijagonala;
	private String proizvodjac;
	private double cijena;
	
	
	
	public Uredjaj() {
		
	}

	public Uredjaj(int id, double dijagonala, String proizvodjac, double cijena) {
		this();
		this.id = id;
		this.dijagonala = dijagonala;
		this.proizvodjac = proizvodjac;
		this.cijena = cijena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDijagonala() {
		return dijagonala;
	}

	public void setDijagonala(double dijagonala) {
		this.dijagonala = dijagonala;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	
	
	
	
	public abstract double preuzmiCijenu(boolean akcija);
	public double preuzmiDijagonalu() {
		return this.dijagonala;
	}

	@Override
	public String toString() {
		return String.format("proizvodjaca %s sa cenom od %.1f RSD, dijagonalom %.1f\"" , this.proizvodjac, this.cijena, this.dijagonala);
	}
	
	
	
	
	
	

}
