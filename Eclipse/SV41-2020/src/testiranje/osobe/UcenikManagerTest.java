package testiranje.osobe;

import static org.junit.Assert.*;

//import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import entiteti.osobe.Ucenik;
import entiteti.osobe.Osoba.Pol;
import manager.osobe.UcenikManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UcenikManagerTest {
	
	public static UcenikManager um = new UcenikManager();
	private static Ucenik uc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uc = new Ucenik("9999", true, "Pera", "Peric", Pol.muško, "21.12.2021", "123", "adresa123", "pperic2", "pera2");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		um.removeUcenik(uc);
	}

	@Test
	public void aTestLoadData() {
		boolean uspjesno = um.loadData("./data/ucenici.txt");
		assertTrue(uspjesno);
	}
	
	@Test
	public void bTestAddUcenik() {
		assertTrue(um.addUcenik(uc));
	}
	
	@Test
	public void cTestGetMapUcenici() {
		Map<String, Ucenik> mapa = um.getMapUcenici();
		assertTrue(mapa != null);
	}

	@Test
	public void dTestGetUcenici() {
		ArrayList<Ucenik> ucenici = (ArrayList<Ucenik>) um.getUcenici();
		assertTrue(ucenici != null);
	}

	@Test
	public void eTestRemoveUcenik() {
		um.addUcenik(uc);
		assertTrue(um.removeUcenik(uc));
	}
	
	@Test
	public void fTestSaveData() {
		boolean uspjesno = um.saveData();
		assertTrue(uspjesno);
	}


}
