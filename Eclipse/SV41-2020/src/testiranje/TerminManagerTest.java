package testiranje;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import entiteti.Kurs;
import entiteti.TerminTesta;
import entiteti.osobe.Predavac;
import manager.JezikManager;
import manager.KursManager;
import manager.TerminManager;
import manager.TestManager;
import manager.osobe.PredavacManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TerminManagerTest {
	
	public static JezikManager jm = new JezikManager("./data/jezici.txt");
	public static PredavacManager pm = new PredavacManager("./data/predavaci.txt");
	public static KursManager km = new KursManager(pm, jm, "./data/kursevi.txt");
	public static TestManager tm = new TestManager(pm, jm, km, "./data/testovi.txt");
	public static TerminManager terminm = new TerminManager(pm, tm, km);
	
	private static Predavac p;
	private static Kurs k;
	private static entiteti.Test t;
	private static TerminTesta termin;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p = pm.getMapPredavaci().get("0007");
		k = km.getMapKursevi().get("0002");
		t = tm.getMapTestovi().get("0006");
		termin = new TerminTesta("9999", "21.12.2021 - 18:00");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		terminm.removeTermin(termin);
	}

	@Test
	public void aTestLoadData() {
		boolean uspjesno = terminm.loadData("./data/termini.txt");
		assertTrue(uspjesno);
	}
	
	@Test
	public void bTestAddTermin() {
		assertTrue(terminm.addTermin(termin, p, t, k));
	}
	
	@Test
	public void cTestGetMapTermini() {
		Map<String, TerminTesta> mapa = terminm.getMapTermini();
		assertTrue(mapa != null);
	}

	@Test
	public void dTestGetTermini() {
		ArrayList<TerminTesta> termini = (ArrayList<TerminTesta>) terminm.getTermini();
		assertTrue(termini != null);
	}
	
	@Test
	public void eTestRemoveTermin() {
		terminm.addTermin(termin, p, t, k);
		assertTrue(terminm.removeTermin(termin));
	}

	@Test
	public void fTestSaveData() {
		boolean uspjesno = terminm.saveData();
		assertTrue(uspjesno);
	}


}
