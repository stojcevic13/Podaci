package vezbe6.primer2;

public class Main {

	public static void main(String[] args) {

		GodisnjaDoba gd = GodisnjaDoba.LETO;
		System.out.println("Trenutno je " + gd);
		
		// vrednost varijable nema veze sa poretkom
		gd.doba++;
		System.out.println("I dalje je " + gd);
		System.out.println(GodisnjaDoba.LETO.ordinal()); // ordinal vraca redni broj konstante u Enum tipu
		System.out.println(GodisnjaDoba.valueOf("LETO")); // valueOf poziva toString za vrednost konstante
		
		for (GodisnjaDoba doba: GodisnjaDoba.values()) { // values vraca sve vrednosti iz Enum tipa
			System.out.println(doba + " ");
		}
		
		switch (gd) {
		case LETO:
			System.out.println("Konacno leto!");
			break;
		default:
			System.out.println("Nije jos leto.");
		}
		
	}

}
