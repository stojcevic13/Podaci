package testiranje;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import entiteti.RezultatTesta;
import entiteti.TerminTesta;
import entiteti.osobe.Ucenik;
import manager.JezikManager;
import manager.KursManager;
import manager.RezultatTestaManager;
import manager.TerminManager;
import manager.TestManager;
import manager.osobe.PredavacManager;
import manager.osobe.UcenikManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RezultatTestaManagerTest {
	
	public static UcenikManager um = new UcenikManager("./data/ucenici.txt");
	public static JezikManager jm = new JezikManager("./data/jezici.txt");
	public static PredavacManager pm = new PredavacManager("./data/predavaci.txt");
	public static KursManager km = new KursManager(pm, jm, "./data/kursevi.txt");
	public static TestManager tm = new TestManager(pm, jm, km, "./data/testovi.txt");
	public static TerminManager terminm = new TerminManager(pm, tm, km, "./data/termini.txt");
	public static RezultatTestaManager rm = new RezultatTestaManager(um, tm, terminm);
	
	private static Ucenik uc;
	private static entiteti.Test t;
	private static TerminTesta termin;
	private static RezultatTesta r;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uc = um.getMapUcenici().get("0000");
		t = tm.getMapTestovi().get("0006");
		termin = terminm.getMapTermini().get("0008");
		r = new RezultatTesta("9999", 12, 5);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		rm.removeRezultat(r);
	}

	@Test
	public void aTestLoadData() {
		boolean uspjesno = rm.loadData("./data/rezultati-testa.txt");
		assertTrue(uspjesno);
	}
	
	@Test
	public void bTestAddRezultat() {
		assertTrue(rm.addRezultat(r, uc, t, termin));
	}
	
	@Test
	public void cTestGetMapRezultati() {
		Map<String, RezultatTesta> mapa = rm.getMapRezultati();
		assertTrue(mapa != null);
	}

	@Test
	public void dTestGetRezultati() {
		ArrayList<RezultatTesta> rezultati = (ArrayList<RezultatTesta>) rm.getRezultati();
		assertTrue(rezultati != null);
	}
	
	@Test
	public void eTestRemoveRezultat() {
		rm.addRezultat(r, uc, t, termin);
		assertTrue(rm.removeRezultat(r));
	}

	@Test
	public void fTestSaveData() {
		boolean uspjesno = rm.saveData();
		assertTrue(uspjesno);
	}






}
