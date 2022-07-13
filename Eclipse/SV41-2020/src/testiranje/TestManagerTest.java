package testiranje;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import entiteti.Jezik;
import entiteti.Kurs;
import entiteti.osobe.Predavac;
import manager.JezikManager;
import manager.KursManager;
import manager.TestManager;
import manager.osobe.PredavacManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestManagerTest {
	
	public static JezikManager jm = new JezikManager("./data/jezici.txt");
	public static PredavacManager pm = new PredavacManager("./data/predavaci.txt");
	public static KursManager km = new KursManager(pm, jm, "./data/kursevi.txt");
	public static TestManager tm = new TestManager(pm, jm, km);
	
	private static Jezik jez;
	private static Predavac p;
	private static Kurs k;
	private static entiteti.Test t;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		jez = jm.getMapJezici().get("ruski");
		p = pm.getMapPredavaci().get("0007");
		k = km.getMapKursevi().get("0002");
		t = new entiteti.Test("9999", "dummy test", 100);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tm.removeTest(t);
	}

	@Test
	public void aTestLoadData() {
		boolean uspjesno = tm.loadData("./data/testovi.txt");
		assertTrue(uspjesno);
	}
	
	@Test
	public void bTestAddTest() {
		assertTrue(tm.addTest(t, p, jez, k));
	}
	
	@Test
	public void cTestGetMapTestovi() {
		Map<String, entiteti.Test> mapa = tm.getMapTestovi();
		assertTrue(mapa != null);
	}

	@Test
	public void dTestGetTestovi() {
		ArrayList<entiteti.Test> testovi = (ArrayList<entiteti.Test>) tm.getTestovi();
		assertTrue(testovi != null);
	}
	
	@Test
	public void eTestRemoveTest() {
		tm.addTest(t, p, jez, k);
		assertTrue(tm.removeTest(t));
	}

	@Test
	public void fTestSaveData() {
		boolean uspjesno = tm.saveData();
		assertTrue(uspjesno);
	}


}
