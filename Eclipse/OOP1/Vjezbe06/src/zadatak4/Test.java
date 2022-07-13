package zadatak4;


public class Test {

	public static void main(String[] args) {

		UgovorManager ugovorManager = new UgovorManager("ugovor.txt");
		IgracManager igracManager = new IgracManager(ugovorManager, "igrac.txt");
		
		for (Igrac i : igracManager.getIgraci())
			System.out.println(i);
		
		for (Ugovor u : ugovorManager.getUgovori())
			System.out.println(u);

	}

}
