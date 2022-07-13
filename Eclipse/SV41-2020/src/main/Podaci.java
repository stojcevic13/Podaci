package main;

import manager.PodaciManager;

public class Podaci {

	private static PodaciManager podaci;

	public Podaci() {
		podaci = new PodaciManager();
	}
	
	
	public static PodaciManager getPodaci() {
		return podaci;
	}

	
	
}
