package vezbe1;

public class PrimerSwitchCase {

	public static void main(String[] args) {

		int mesec = 25;
		switch (mesec) {
			case 1: System.out.println("Januar");
					break;
			case 2: System.out.println("Februar");
					break;
			case 3: System.out.println("Mart");
					break;
			case 4: System.out.println("April");
					break;
			case 5: System.out.println("Maj");
					break;
			case 6: System.out.println("Jun");
					break;
			case 7: case 8: case 9: System.out.println("Letnji meseci");
					break;
			case 10: System.out.println("Oktobar");
					break;
			case 11: System.out.println("Novembar");
					break;
			case 12: System.out.println("Decembar");
					break;
			default: System.out.println("Nepostojeci mesec");
					break;
		}
		
	}

}
