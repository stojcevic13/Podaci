package testiranje;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import entiteti.Kurs;
import entiteti.Uplata;
import entiteti.osobe.Ucenik;
import manager.JezikManager;
import manager.KursManager;
import manager.UplataManager;
import manager.osobe.PredavacManager;
import manager.osobe.UcenikManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UplataManagerTest {
	
	public static UcenikManager ucm = new UcenikManager("./data/ucenici.txt");
	public static JezikManager jm = new JezikManager("./data/jezici.txt");
	public static PredavacManager pm = new PredavacManager("./data/predavaci.txt");
	public static KursManager km = new KursManager(pm, jm, "./data/kursevi.txt");
	public static UplataManager upm = new UplataManager(ucm, km);
	
	private static Ucenik uc;
	private static Kurs k;
	private static Uplata u;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uc = ucm.getMapUcenici().get("0000");
		k = km.getMapKursevi().get("0002");
		u = new Uplata("9999", "21.08.2021", 300);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		upm.removeUplata(u);
	}

	@Test
	public void testLoadData() {
		boolean uspjesno = upm.loadData("./data/uplate.txt");
		assertTrue(uspjesno);
	}
	
	@Test
	public void testAddUplata() {
		assertTrue(upm.addUplata(u, uc, k));
	}
	
	@Test
	public void testGetMapUplate() {
		Map<String, Uplata> mapa = upm.getMapUplate();
		assertTrue(mapa != null);
	}

	@Test
	public void testGetUplate() {
		ArrayList<Uplata> uplate = (ArrayList<Uplata>) upm.getUplate();
		assertTrue(uplate != null);
	}
	
	@Test
	public void testRemoveUplata() {
		upm.addUplata(u, uc, k);
		assertTrue(upm.removeUplata(u));
	}

	@Test
	public void testSaveData() {
		boolean uspjesno = upm.saveData();
		assertTrue(uspjesno);
	}



}
