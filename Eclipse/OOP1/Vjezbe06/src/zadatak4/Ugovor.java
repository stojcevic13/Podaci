package zadatak4;

public class Ugovor {
	
	private String id;
	private int godinaOd;
	private int godinaDo;
	private int godisnjaPlata;
	
	
	
	public Ugovor() {
		
	}



	public Ugovor(String id, int godinaOd, int godinaDo, int godisnjaPlata) {
		this();
		this.id = id;
		this.godinaOd = godinaOd;
		this.godinaDo = godinaDo;
		this.godisnjaPlata = godisnjaPlata;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getGodinaOd() {
		return godinaOd;
	}



	public void setGodinaOd(int godinaOd) {
		this.godinaOd = godinaOd;
	}



	public int getGodinaDo() {
		return godinaDo;
	}



	public void setGodinaDo(int godinaDo) {
		this.godinaDo = godinaDo;
	}



	public int getGodisnjaPlata() {
		return godisnjaPlata;
	}



	public void setGodisnjaPlata(int godisnjaPlata) {
		this.godisnjaPlata = godisnjaPlata;
	}






	@Override
	public String toString() {
		return "Ugovor [id=" + id + ", godinaOd=" + godinaOd + ", godinaDo=" + godinaDo + ", godisnjaPlata="
				+ godisnjaPlata + "]";
	}
	
	
	
	
	

}
