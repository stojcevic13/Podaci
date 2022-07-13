package testiranje.osobe;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import entiteti.osobe.Sekretar;
import entiteti.osobe.Osoba.Pol;
import entiteti.osobe.Zaposleni.StrucnaSprema;
import manager.osobe.SekretarManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SekretarManagerTest {
	
	public static SekretarManager sm = new SekretarManager();
	private static Sekretar sek;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sek = new Sekretar("9999", true, "Pera", "Peric", Pol.muško, "21.12.2021", "123", "adresa123", "pperic2", "pera2", StrucnaSprema.viša, 10, 300);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sm.removeSekretar(sek);
	}

	@Test
	public void aTestLoadData() {
		boolean uspjesno = sm.loadData("./data/sekretari.txt");
		assertTrue(uspjesno);
	}
	
	@Test
	public void bTestAddSekretar() {
		assertTrue(sm.addSekretar(sek));
	}
	
	@Test
	public void cTestGetMapSekretari() {
		Map<String, Sekretar> mapa = sm.getMapSekretari();
		assertTrue(mapa != null);
	}

	@Test
	public void dTestGetSekretari() {
		ArrayList<Sekretar> sekretari = (ArrayList<Sekretar>) sm.getSekretari();
		assertTrue(sekretari != null);
	}
	
	@Test
	public void eTestRemoveSekretar() {
		sm.addSekretar(sek);
		assertTrue(sm.removeSekretar(sek));
	}

	@Test
	public void fTestSaveData() {
		boolean uspjesno = sm.saveData();
		assertTrue(uspjesno);
	}


}
