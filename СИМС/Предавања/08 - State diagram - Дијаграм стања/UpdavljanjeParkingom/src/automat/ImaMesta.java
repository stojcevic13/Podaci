/**
 * 
 */
package automat;

/**
 * Stanje koje je aktivno kada ima mesta na parkingu
 */
public class ImaMesta extends Stanje {	
	public ImaMesta(KontrolerParkinga aKontekst) {
		super(aKontekst);
	}
	
	public void usaoAutomobil() {
		kontekst.azurirajBrojMesta(-1);		
		if (kontekst.getBrojSlobodnihMesta() == 0) 
			kontekst.promeniTekuceStanje(new SvePopunjeno(kontekst));		
	}
	
	public void izasaoAutomobil() {
		if (kontekst.getBrojSlobodnihMesta() < KontrolerParkinga.MAX_BROJ_MESTA) {
			kontekst.azurirajBrojMesta(1);
		}				
	}		
}
