package automat;

import java.util.ArrayList;
import java.util.List;

import automat.event.*;

/**
 * Kontroler parkinga - klasa koja predstavlja kontekst za izvršavanje konacnog automata
 */
public class KontrolerParkinga implements Publisher {		
	public static final int MAX_BROJ_MESTA = 10;
	
	private int brojSlobodnihMesta;
	private SvetloNaSemaforu aktivnoSvetlo;
	private Stanje tekuceStanje;

	public  KontrolerParkinga() {
		tekuceStanje = new ImaMesta(this);
		brojSlobodnihMesta = MAX_BROJ_MESTA;
		aktivnoSvetlo = SvetloNaSemaforu.ZELENO;
	}
	
	public SvetloNaSemaforu getAktivnoSveto() {
		return aktivnoSvetlo;
	}
	
	public int getBrojSlobodnihMesta() {
		return brojSlobodnihMesta;
	}
	
	/**	
	 * U realnom sistemu, ova metoda bi se direktno obracala semaforu (fizickom uredjaju) 
	 */
	public void upaliCrveno() {
		aktivnoSvetlo = SvetloNaSemaforu.CRVENO;
		notifyObservers();
	}	
	
	public void upaliZeleno() {
		aktivnoSvetlo = SvetloNaSemaforu.ZELENO;
		notifyObservers();
	}		
	
	/**	
	 * Automat informacije o dogadjajima koje dobija od svojih senzora prosledjuje svom aktivnom stanju:
	 */
	public void usaoAutomobil() {				
		tekuceStanje.usaoAutomobil();
	}
	
	public void izasaoAutomobil() {
		tekuceStanje.izasaoAutomobil();
	}
	
	public void azurirajBrojMesta(int zaKoliko) {
		brojSlobodnihMesta = brojSlobodnihMesta + zaKoliko; 
		notifyObservers();
	}
	
	public void promeniTekuceStanje(Stanje novoStanje) {
		tekuceStanje.exit();
		novoStanje.entry();
		tekuceStanje = novoStanje;				
	}
	
	// Lista onih koji prate promenu podataka (Observer sablon)
	// Uveden je radi izbegavanja cvrstog sprezanja sa elementima korisnickog interfejsa
	// Na ovaj nacin se vise razlicitih elemenata korisnickog interfejsa (cak i oni koji nisu poznati u trenutku inicijalnog dizajna aplikacije) 
	// mogu pretpaltiti da prate promene
	private List<Observer> observers = new ArrayList<Observer>();
		
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
		
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}	
	
	public void notifyObservers() {
		UpdateEvent e = new UpdateEvent(this, brojSlobodnihMesta, aktivnoSvetlo);
		//Slanje dogadjaja da se desila promena svima koji su se registrovali za pracenje promena:
		for (Observer observer : observers) {
			observer.updatePerformed(e);
		}
	}
}
