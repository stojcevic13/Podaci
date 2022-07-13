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

import entiteti.Jezik;
import entiteti.Kurs;
import entiteti.Kurs.Nivo;
import entiteti.osobe.Predavac;
import manager.JezikManager;
import manager.KursManager;
import manager.osobe.PredavacManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KursManagerTest {

	public static JezikManager jm = new JezikManager("./data/jezici.txt");
	public static PredavacManager pm = new PredavacManager("./data/predavaci.txt");
	public static KursManager km = new KursManager(pm, jm);
	
	private static Jezik jez;
	private static Predavac p;
	private static Kurs k;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		jez = jm.getMapJezici().get("ruski");
		p = pm.getMapPredavaci().get("0001");
		k = new Kurs("9999", Nivo.a1, true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		km.removeKurs(k);
	}

	@Test
	public void aTestLoadData() {
		boolean uspjesno = km.loadData("./data/kursevi.txt");
		assertTrue(uspjesno);
	}
	
	@Test
	public void bTestAddKurs() {
		assertTrue(km.addKurs(k, jez, p));
	}
	
	@Test
	public void cTestGetMapKursevi() {
		Map<String, Kurs> mapa = km.getMapKursevi();
		assertTrue(mapa != null);
	}

	@Test
	public void dTestGetKursevi() {
		ArrayList<Kurs> kursevi = (ArrayList<Kurs>) km.getKursevi();
		assertTrue(kursevi != null);
	}
	
	@Test
	public void eTestRemoveKurs() {
		km.addKurs(k, jez, p);
		assertTrue(km.removeKurs(k));
	}

	@Test
	public void fTestSaveData() {
		boolean uspjesno = km.saveData();
		assertTrue(uspjesno);
	}







}
