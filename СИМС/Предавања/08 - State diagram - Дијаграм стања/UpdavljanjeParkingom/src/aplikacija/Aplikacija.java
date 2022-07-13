package aplikacija;

import automat.KontrolerParkinga;
import prozor.TestProzor;

public class Aplikacija {
	
	public static void main(String[] args) {
		KontrolerParkinga kontroler = new KontrolerParkinga();
		TestProzor prozor = new TestProzor(kontroler);	
		prozor.setVisible(true);				
	}
}
