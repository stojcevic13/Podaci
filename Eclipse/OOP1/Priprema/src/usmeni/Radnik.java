package usmeni;

public class Radnik extends Osoba {
	
	@Override
	public void dodaj(String txt) {
		this.ime = txt + this.ime;
	}
	
	public void dodaj2(String txt) {
		dodaj(txt);
		super.dodaj(txt);
	}
	
	
	public static void main(String[] args) {
		Radnik r = new Radnik();
		r.ime = "Nemanja";
		r.dodaj2(" txt ");
		System.out.println(r.ime);
		
	}

}
