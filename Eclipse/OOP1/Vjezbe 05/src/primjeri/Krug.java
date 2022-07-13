package primjeri;

public class Krug extends Figura {
	
	double r;

	@Override
	public double izracunajPovrsinu() {
		return r*r*Math.PI;
	}

	@Override
	public double izracunajObim() {
		return 2*r*Math.PI;
	}

	
	
}
