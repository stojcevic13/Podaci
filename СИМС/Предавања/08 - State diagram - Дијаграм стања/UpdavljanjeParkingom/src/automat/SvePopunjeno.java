/**
 * 
 */
package automat;

/**
 * Stanje koje je aktivno kada nema mesta na parkingu
 */
public class SvePopunjeno extends Stanje {
	
	public SvePopunjeno(KontrolerParkinga aKontekst) {
		super(aKontekst);
	}	
	
	public void entry() {		
		kontekst.upaliCrveno();
	}	
	
	public void exit() {		
		kontekst.upaliZeleno();
	}
	
	public void izasaoAutomobil() {		
		kontekst.azurirajBrojMesta(1);	
		kontekst.promeniTekuceStanje(new ImaMesta(kontekst));
	}
}
