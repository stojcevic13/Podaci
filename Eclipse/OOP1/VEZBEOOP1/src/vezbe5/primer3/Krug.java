package vezbe5.primer3;

public class Krug extends Figura {
	
	public double r;
	
	public Krug(double r) {
		super();
		this.r = r;
	}

	// sve apstraknte metode iz roditeljske klase moraju biti implementirane
	@Override
	public double izracunajPovrsinu() {
		this.povrsina = r*r*Math.PI;
		return povrsina;
	}

	@Override
	public double izracunajObim() {
		this.obim =  2*r*Math.PI;
		return obim;
	}

}
