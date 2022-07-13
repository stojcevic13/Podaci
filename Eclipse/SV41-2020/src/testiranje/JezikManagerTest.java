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
import manager.JezikManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JezikManagerTest {
	
	public static JezikManager jm = new JezikManager();
	private static Jezik jez;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		jez = new Jezik("mandarinski", true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		jm.removeJezik(jez);
	}

	@Test
	public void aTestLoadData() {
		boolean uspjesno = jm.loadData("./data/jezici.txt");
		assertTrue(uspjesno);
	}
	
	@Test
	public void bTestAddJezik() {
		assertTrue(jm.addJezik(jez));
	}
	
	@Test
	public void cTestGetMapJezici() {
		Map<String, Jezik> mapa = jm.getMapJezici();
		assertTrue(mapa != null);
	}

	@Test
	public void dTestGetJezici() {
		ArrayList<Jezik> jezici = (ArrayList<Jezik>) jm.getJezici();
		assertTrue(jezici != null);
	}
	
	@Test
	public void eTestRemoveJezik() {
		jm.addJezik(jez);
		assertTrue(jm.removeJezik(jez));
	}

	@Test
	public void fTestSaveData() {
		boolean uspjesno = jm.saveData();
		assertTrue(uspjesno);
	}



}
