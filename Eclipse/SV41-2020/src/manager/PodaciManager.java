package manager;

import entiteti.osobe.Administrator;
import entiteti.osobe.Predavac;
import entiteti.osobe.Sekretar;
import entiteti.osobe.Ucenik;
import manager.osobe.AdministratorManager;
import manager.osobe.PredavacManager;
import manager.osobe.SekretarManager;
import manager.osobe.UcenikManager;
import manager.veze.VezaJezikPredavacManager;
import manager.veze.VezaKursUcenikManager;
//import manager.veze.VezaOdrzavanjeUcenikManager;
import manager.veze.VezaTerminUcenikManager;
import manager.veze.VezaTestUcenikManager;

public class PodaciManager {
	
	
	
	// MANAGERI
	private UcenikManager ucenikManager;
	private PredavacManager predavacManager;
	private SekretarManager sekretarManager;
	private AdministratorManager administratorManager;
	
	private JezikManager jezikManager;
	private KursManager kursManager;
//	private OdrzavanjeKursaManager odrzavanjeKursaManager;
	private TestManager testManager;
	private RezultatTestaManager rezultatTestaManager;
	private TerminManager terminTestaManager;
	
	private CijenaKursaManager cijenaKursaManager;
	private UplataManager uplataManager;
	private ZahtjevManager zahtjevManager;
	
	private VezaJezikPredavacManager vezaJezikPredavacManager;
	private VezaKursUcenikManager vezaKursUcenikManager;
	private VezaTerminUcenikManager vezaTerminUcenikManager;
	private VezaTestUcenikManager vezaTestUcenikManager;
	private PojedinacanTestManager pojedinacanTestManager;
//	private VezaOdrzavanjeUcenikManager vezaOdrzavanjeUcenikManager;
	
	
	
	// FAJLOVI
	private String uceniciFile;
	private String predavaciFile;
	private String sekretariFile;
	private String administratoriFile;
	
	private String jeziciFile;
	private String kurseviFile;
//	private String odrzavanjeKursaFile;
	private String testoviFile;
	private String rezultatiTestaFile;
	private String terminiFile;
	
	private String cijeneKursevaFile;
	private String uplateFile;
	private String zahtjeviFile;
	
	private String vezaJezikPredavacFile;
	private String vezaKursUcenikFile;
	private String vezaTerminUcenikFile;
	private String vezaTestUcenikFile;
	private String pojedinacniTestoviFile;
//	private String vezaOdrzavanjeUcenikFile;





	
	
	
	
	public PodaciManager() {
		// KORISNICI
		this.uceniciFile = "./data/ucenici.txt";
		this.ucenikManager = new UcenikManager(this.uceniciFile);
		
		this.predavaciFile = "./data/predavaci.txt";
		this.predavacManager = new PredavacManager(this.predavaciFile);
		
		this.sekretariFile = "./data/sekretari.txt";
		this.sekretarManager = new SekretarManager(this.sekretariFile);
		
		this.administratoriFile = "./data/administratori.txt";
		this.administratorManager = new AdministratorManager(this.administratoriFile);
		
		
		// KURSEVI - TESTOVI
		this.jeziciFile = "./data/jezici.txt";
		this.jezikManager = new JezikManager(this.jeziciFile);
		
		this.kurseviFile = "./data/kursevi.txt";
		this.kursManager = new KursManager(this.predavacManager,  this.jezikManager, this.kurseviFile);
		
//		this.odrzavanjeKursaFile = "./data/odrzavanje-kurseva.txt";
//		this.odrzavanjeKursaManager = new OdrzavanjeKursaManager(this.predavacManager, this.kursManager, this.odrzavanjeKursaFile);
		
		this.testoviFile = "./data/testovi.txt";
		this.testManager = new TestManager(this.predavacManager, this.jezikManager, this.kursManager, this.testoviFile);
		
		this.terminiFile = "./data/termini.txt";
		this.terminTestaManager = new TerminManager(this.predavacManager, this.testManager, this.kursManager, this.terminiFile);
		
		this.rezultatiTestaFile = "./data/rezultati-testa.txt";
		this.rezultatTestaManager = new RezultatTestaManager(this.ucenikManager, this.testManager, this.terminTestaManager, this.rezultatiTestaFile);
		
		
		
		
		// CIJENE - UPLATE
		this.cijeneKursevaFile = "./data/cijene-kurseva.txt";
		this.cijenaKursaManager = new CijenaKursaManager(this.kursManager, this.cijeneKursevaFile);
		
		this.uplateFile = "./data/uplate.txt";
		this.uplataManager = new UplataManager(this.ucenikManager, this.kursManager, this.uplateFile);
		
		this.zahtjeviFile = "./data/zahtjevi.txt";
		this.zahtjevManager = new ZahtjevManager(this.ucenikManager, this.sekretarManager, this.administratorManager, this.kursManager, this.zahtjeviFile);
		
		
		// VEZE
		this.vezaJezikPredavacFile = "./data/veza-jezik-predavac.txt";
		this.vezaJezikPredavacManager = new VezaJezikPredavacManager(this.predavacManager, this.jezikManager, this.vezaJezikPredavacFile);
		
		this.vezaKursUcenikFile = "./data/veza-kurs-ucenik.txt";
		this.vezaKursUcenikManager = new VezaKursUcenikManager(this.ucenikManager, this.kursManager, this.vezaKursUcenikFile);
		
		this.pojedinacniTestoviFile = "./data/pojedinacni-testovi.txt";
		this.pojedinacanTestManager = new PojedinacanTestManager(ucenikManager, terminTestaManager, this.pojedinacniTestoviFile);
		
		this.vezaTerminUcenikFile = "./data/veza-termin-ucenik.txt";
		this.vezaTerminUcenikManager = new VezaTerminUcenikManager(this.ucenikManager, this.terminTestaManager, this.vezaTerminUcenikFile);
		
		this.vezaTestUcenikFile = "./data/veza-test-ucenik.txt";
		this.vezaTestUcenikManager = new VezaTestUcenikManager(this.ucenikManager, this.testManager, this.vezaTestUcenikFile);
		
//		this.vezaOdrzavanjeUcenikFile = "./data/veza-odrzavanje-ucenik.txt";
//		this.vezaOdrzavanjeUcenikManager = new VezaOdrzavanjeUcenikManager(ucenikManager, odrzavanjeKursaManager, vezaOdrzavanjeUcenikFile);
	}
	
	
	
	public void saveDataPodaci() {
		this.ucenikManager.saveData();
		this.predavacManager.saveData();
		this.sekretarManager.saveData();
		this.administratorManager.saveData();
		
		this.jezikManager.saveData();
		this.kursManager.saveData();
//		this.odrzavanjeKursaManager.saveData();
		this.testManager.saveData();
		this.rezultatTestaManager.saveData();
		this.terminTestaManager.saveData();
		
		this.cijenaKursaManager.saveData();
		this.uplataManager.saveData();
		this.zahtjevManager.saveData();
		
		this.vezaJezikPredavacManager.saveData();
		this.vezaKursUcenikManager.saveData();
		this.pojedinacanTestManager.saveData();
		this.vezaTestUcenikManager.saveData();
		this.vezaTerminUcenikManager.saveData();
//		this.vezaOdrzavanjeUcenikManager.saveData();
	}
	
	
	

	

	public UcenikManager getUcenikManager() {
		return ucenikManager;
	}

	public PredavacManager getPredavacManager() {
		return predavacManager;
	}

	public SekretarManager getSekretarManager() {
		return sekretarManager;
	}
	
	public AdministratorManager getAdministratorManager() {
		return administratorManager;
	}

	public JezikManager getJezikManager() {
		return jezikManager;
	}

	public KursManager getKursManager() {
		return kursManager;
	}
	
//	public OdrzavanjeKursaManager getOdrzavanjeKursaManager() {
//		return odrzavanjeKursaManager;
//	}

	public TestManager getTestManager() {
		return testManager;
	}

	public RezultatTestaManager getRezultatTestaManager() {
		return rezultatTestaManager;
	}

	public TerminManager getTerminTestaManager() {
		return terminTestaManager;
	}

	public CijenaKursaManager getCijenaKursaManager() {
		return cijenaKursaManager;
	}

	public UplataManager getUplataManager() {
		return uplataManager;
	}

	public ZahtjevManager getZahtjevManager() {
		return zahtjevManager;
	}
	
	public PojedinacanTestManager getPojedinacanTestManager() {
		return pojedinacanTestManager;
	}
	
	



	
	
	
	
	public static void main(String[] args) {
//		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
//		JezikManager jezikManager = new JezikManager("./data/jezici.txt");
//		
//		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
//		
//		for (Jezik jez : jezikManager.getJezici())
//			System.out.println(jez);
//		
//		System.out.println();
//		for (Kurs k : kursManager.getKursevi())
//			System.out.println(k);
		
		PodaciManager podaci = new PodaciManager();
		
		
		System.out.println("UCENICI");
		for (Ucenik uc : podaci.getUcenikManager().getUcenici()) {
			System.out.println(uc);
		}
		System.out.println();
		
		
		System.out.println("PREDAVACI");
		for (Predavac uc : podaci.getPredavacManager().getPredavaci()) {
			System.out.println(uc);
		}
		System.out.println();
		
		
		System.out.println("SEKRETARI");
		for (Sekretar uc : podaci.getSekretarManager().getSekretari()) {
			System.out.println(uc);
		}
		System.out.println();
		
		System.out.println("ADMINISTRATORI");
		for (Administrator uc : podaci.getAdministratorManager().getAdministratori()) {
			System.out.println(uc);
		}

		
		
	}

}
