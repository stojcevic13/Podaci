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

import entiteti.osobe.Administrator;
import entiteti.osobe.Osoba.Pol;
import entiteti.osobe.Zaposleni.StrucnaSprema;
import manager.osobe.AdministratorManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministratorManagerTest {
	
	public static AdministratorManager am = new AdministratorManager();
	private static Administrator ad;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ad = new Administrator("9999", true, "Pera", "Peric", Pol.muško, "21.12.2021", "123", "adresa123", "pperic2", "pera2", StrucnaSprema.viša, 10, 300);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		am.removeAdministrator(ad);
	}

	@Test
	public void aTestLoadData() {
		boolean uspjesno = am.loadData("./data/administratori.txt");
		assertTrue(uspjesno);
	}
	
	@Test
	public void bTestAddAdministrator() {
		assertTrue(am.addAdministrator(ad));
	}
	
	@Test
	public void cTestGetMapAdministratori() {
		Map<String, Administrator> mapa = am.getMapAdministratori();
		assertTrue(mapa != null);
	}

	@Test
	public void dTestGetAdministratori() {
		ArrayList<Administrator> admini = (ArrayList<Administrator>) am.getAdministratori();
		assertTrue(admini != null);
	}
	
	@Test
	public void eTestRemoveAdministrator() {
		am.addAdministrator(ad);
		assertTrue(am.removeAdministrator(ad));
	}

	@Test
	public void fTestSaveData() {
		boolean uspjesno = am.saveData();
		assertTrue(uspjesno);
	}







}
