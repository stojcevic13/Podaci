package predavanje03;

public class Auto {
	
	Tocak prednjiDesni;
	Tocak prednjiLijevi;
	Tocak zadnjiDesni;
	Tocak zadnjiLijevi;
	
	public Auto() {
		this.prednjiDesni = new Tocak();
		this.prednjiLijevi = new Tocak();
		this.zadnjiDesni = new Tocak();
		this.zadnjiLijevi = new Tocak();
	}
	
	public Auto(double pdPritisak, double plPritisak, double zdPritisak, double zlPritisak) {
		this.prednjiDesni = new Tocak(pdPritisak);
		this.prednjiLijevi = new Tocak(plPritisak);
		this.zadnjiDesni = new Tocak(zdPritisak);
		this.zadnjiLijevi = new Tocak(zlPritisak);
	}
	
	public Auto(Tocak prednjiDesni, Tocak prednjiLijevi, Tocak zadnjiDesni, Tocak zadnjiLijevi) {
		this(prednjiDesni.pritisak, prednjiLijevi.pritisak, zadnjiDesni.pritisak, zadnjiLijevi.pritisak);
	}
	
	Auto copy() {
		Auto ret = new Auto();
		ret.prednjiDesni = this.prednjiDesni.copy();
		ret.prednjiLijevi = this.prednjiLijevi.copy();
		ret.zadnjiDesni = this.zadnjiDesni.copy();
		ret.zadnjiLijevi = this.zadnjiLijevi.copy();
		return ret;
	}

	
}
