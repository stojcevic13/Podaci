package zadaci;

public class Zadatak01 {
	
	static void ispisiZnakObrnuto(String s) {
		for (int i = s.length()-1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
	}
	
	
	static void ispisiRijecObrnuto(String s) {
		String rijec = "";
		for (int i = s.length()-1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				System.out.println(rijec);
				rijec = "";
			} else {
				rijec = s.charAt(i) + rijec;
			}
		}
	}

	
	public static void main(String[] args) {
		
		String tekst = "Norve�anin Kjetil Jansrud osvojio je zlatnu medalju u superveleslalomu na " +
					"Zimskim olimpijskim igrama u So�iju po�to je za 30 stotih delova sekunde " +
					"bio br�i od drugoplasiranog Amerikanca Endrjua Vajbrehta.";
		
		ispisiRijecObrnuto(tekst);

	}

}
