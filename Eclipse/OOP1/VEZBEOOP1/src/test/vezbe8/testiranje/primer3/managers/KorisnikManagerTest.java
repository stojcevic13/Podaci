package test.vezbe8.testiranje.primer3.managers;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import vezbe8.testiranje.primer3.managers.KorisnikManager;
import vezbe8.testiranje.primer3.managers.TipKorisnikaManager;
import vezbe8.testiranje.primer3.models.Korisnik;

public class KorisnikManagerTest {

	public static KorisnikManager km = KorisnikManager.getInstance();
	public static TipKorisnikaManager tm = TipKorisnikaManager.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("KorisnikManager test start.");

		tm.addTipKorisnika("tip1", true);
		tm.addTipKorisnika("tip2", false);

		km.addKorisnik("imenko", "prezimenic", "0123", "iprez", "pass123", "tip1");
		km.addKorisnik("pera", "peric", "4567", "test", "123pass", "tip2");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// oslobadjanje resursa i vracanje u zateceno stanje pre testa
		System.out.println("KorisnikManager test end.");
	}

	@Test
	public void testAddKorisnik() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadFromFileString() {
		fail("Not yet implemented");
	}

	@Test
	public void testTryLogin() {
		Korisnik user = km.tryLogin("iprez", "pass123");
		assertTrue(user != null);

		user = km.tryLogin("iprez", "15352");
		assertTrue(user == null);

		user = km.tryLogin("iprezaa", "pass123");
		assertTrue(user == null);
	}

	@Test
	public void testEditKorisnik() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetKorisnik() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetKorisnikFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetKorisnikFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetKorisnici() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetKorisnici() {
		fail("Not yet implemented");
	}

}
