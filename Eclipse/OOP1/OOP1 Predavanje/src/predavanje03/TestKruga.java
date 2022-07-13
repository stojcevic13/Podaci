package predavanje03;

public class TestKruga {

	public static void main(String[] args) {
		
		Tacka centar = new Tacka(5, 5);
		Tacka neka = new Tacka(4, 4);
		Krug k1 = new Krug(centar, 5);
		
		k1.provjeriTacku(neka);


	}

}
