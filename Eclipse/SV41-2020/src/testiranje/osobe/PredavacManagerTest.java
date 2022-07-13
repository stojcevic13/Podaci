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

import entiteti.osobe.Predavac;
import entiteti.osobe.Osoba.Pol;
import entiteti.osobe.Zaposleni.StrucnaSprema;
import manager.osobe.PredavacManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PredavacManagerTest {
	
	public static PredavacManager pm = new PredavacManager();
	private static Predavac p;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p = new Predavac("9999", true, "Pera", "Peric", Pol.muško, "21.12.2021", "123", "adresa123", "pperic2", "pera2", StrucnaSprema.viša, 10, 300);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		pm.removePredavac(p);
	}

	@Test
	public void aTestLoadData() {
		boolean uspjesno = pm.loadData("./data/predavaci.txt");
		assertTrue(uspjesno);
	}
	
	@Test
	public void bTestAddPredavac() {
		assertTrue(pm.addPredavac(p));
	}
	
	@Test
	public void cTestGetMapPredavaci() {
		Map<String, Predavac> mapa = pm.getMapPredavaci();
		assertTrue(mapa != null);
	}

	@Test
	public void dTestGetPredavaci() {
		ArrayList<Predavac> predavaci = (ArrayList<Predavac>) pm.getPredavaci();
		assertTrue(predavaci != null);
	}
	
	@Test
	public void eTestRemovePredavac() {
		pm.addPredavac(p);
		assertTrue(pm.removePredavac(p));
	}

	@Test
	public void fTestSaveData() {
		boolean uspjesno = pm.saveData();
		assertTrue(uspjesno);
	}







}
