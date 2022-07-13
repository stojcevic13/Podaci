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
import entiteti.Zahtjev;
import entiteti.Zahtjev.Stanje;
import entiteti.osobe.Ucenik;
import manager.JezikManager;
import manager.KursManager;
import manager.ZahtjevManager;
import manager.osobe.AdministratorManager;
import manager.osobe.PredavacManager;
import manager.osobe.SekretarManager;
import manager.osobe.UcenikManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZahtjevManagerTest {
	
	public static UcenikManager ucm = new UcenikManager("./data/ucenici.txt");
	public static SekretarManager sekm = new SekretarManager("./data/sekretari.txt");
	public static AdministratorManager am = new AdministratorManager("./data/administratori.txt");
	public static JezikManager jm = new JezikManager("./data/jezici.txt");
	public static PredavacManager pm = new PredavacManager("./data/predavaci.txt");
	public static KursManager km = new KursManager(pm, jm, "./data/kursevi.txt");
	public static ZahtjevManager zm = new ZahtjevManager(ucm, sekm, am, km);
	
	private static Ucenik uc;
	private static Kurs k;
	private static Zahtjev z;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uc = ucm.getMapUcenici().get("0000");
		k = km.getMapKursevi().get("0002");
		z = new Zahtjev("9999", Stanje.KREIRAN, "21.08.2021");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		zm.removeZahtjev(z);
	}

	@Test
	public void aTestLoadData() {
		boolean uspjesno = zm.loadData("./data/zahtjevi.txt");
		assertTrue(uspjesno);
	}

	@Test
	public void bTestAddZahtjev() {
		assertTrue(zm.addZahtjev(z, uc, k));
	}
	
	@Test
	public void cTestGetMapZahtjevi() {
		Map<String, Zahtjev> mapa = zm.getMapZahtjevi();
		assertTrue(mapa != null);
	}

	@Test
	public void dTestGetZahtjevi() {
		ArrayList<Zahtjev> zahtjevi = (ArrayList<Zahtjev>) zm.getZahtjevi();
		assertTrue(zahtjevi != null);
	}

	@Test
	public void eTestRemoveZahtjev() {
		zm.addZahtjev(z, uc, k);
		assertTrue(zm.removeZahtjev(z));
	}

	@Test
	public void fTestSaveData() {
		boolean uspjesno = zm.saveData();
		assertTrue(uspjesno);
	}



}
