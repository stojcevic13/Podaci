package automat;

/**
 * Stanje - apstraktni predak hijerarhije 
 */
public abstract class Stanje {	
	protected KontrolerParkinga kontekst;	
	
	public Stanje(KontrolerParkinga aKontekst) {
		kontekst = aKontekst;		
	}
	
	public void entry() {				
	}
	
	public void exit() {	
	}
	
	public void usaoAutomobil() {		
	}
	
	public void izasaoAutomobil() {		
	}
}
