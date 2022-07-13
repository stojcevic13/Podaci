package vozila;

public abstract class Vozilo {
	
	String model;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public abstract void vozi(String odrediste);
	
	
}
