package vezbe11.composite;

public class Test {

	public static void main(String[] args) {

		// kategorije stampaca
		Kategorija k1 = new Kategorija("Stampaci");

		Kategorija k11 = new Kategorija("Matricni");
		Kategorija k12 = new Kategorija("Laserski");
		Kategorija k13 = new Kategorija("Ploteri");
		Kategorija k14 = new Kategorija("Potrosni materijal");

		Kategorija k121 = new Kategorija("Linijski");
		Kategorija k122 = new Kategorija("Prenosni");
		Kategorija k123 = new Kategorija("Termalni");

		Kategorija k141 = new Kategorija("Toneri");
		Kategorija k142 = new Kategorija("Ketridzi");
		Kategorija k143 = new Kategorija("Papir");

		k1.add(k11);
		k1.add(k12);
		k1.add(k13);
		k1.add(k14);

		k12.add(k121);
		k12.add(k122);
		k12.add(k123);

		k14.add(k141);
		k14.add(k142);
		k14.add(k143);

		System.out.println(k1);
	}

}
