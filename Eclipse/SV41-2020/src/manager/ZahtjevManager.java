package manager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entiteti.Kurs;
import entiteti.Zahtjev;
import entiteti.Zahtjev.Stanje;
import entiteti.osobe.Sekretar;
import entiteti.osobe.Ucenik;
import manager.osobe.AdministratorManager;
import manager.osobe.PredavacManager;
import manager.osobe.SekretarManager;
import manager.osobe.UcenikManager;

public class ZahtjevManager {
	
	private List<Zahtjev> zahtjevi;
	private Map<String, Zahtjev> mapZahtjevi;
	
	private List<Zahtjev> obradjeniZahtjevi;
	private List<Zahtjev> neobradjeniZahtjevi;

	private String zahtjeviFile;
	
	private UcenikManager ucenikManager;
	private SekretarManager sekretarManager;
	private AdministratorManager adminManager;
	private KursManager kursManager;


	public ZahtjevManager(UcenikManager ucenikManager, SekretarManager sekretarManager, AdministratorManager adminManager, KursManager kursManager) {
		this.ucenikManager = ucenikManager;
		this.sekretarManager = sekretarManager;
		this.adminManager = adminManager;
		this.kursManager = kursManager;
		
		this.zahtjevi = new ArrayList<Zahtjev>();
		this.obradjeniZahtjevi = new ArrayList<Zahtjev>();
		this.neobradjeniZahtjevi = new ArrayList<Zahtjev>();
		this.mapZahtjevi = new HashMap<String, Zahtjev>();
	}

	public ZahtjevManager(UcenikManager ucenikManager, SekretarManager sekretarManager, AdministratorManager adminManager, KursManager kursManager, String zahtjeviFile) {
		this(ucenikManager, sekretarManager, adminManager, kursManager);
		this.zahtjeviFile = zahtjeviFile;
		loadData(zahtjeviFile);
	}

   

	public boolean loadData(String file) {
		if (this.zahtjeviFile == null)
			this.zahtjeviFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.zahtjeviFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				Zahtjev zahtjev = parseZahtjev(linija);
				this.zahtjevi.add(zahtjev);
				this.mapZahtjevi.put(zahtjev.getId(), zahtjev);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Zahtjev parseZahtjev(String linija) {
		//# ID_ZAHTJEVA; ID_UCENIKA; ID_KURSA; STANJE; DATUM_SLANJA; datum_obrade; id_sekretara; uloga
		Zahtjev zahtjev;
		String[] tokens = linija.split(";");
		String idZahtjeva = tokens[0].trim();
		String idUcenika = tokens[1].trim();
		String idKursa = tokens[2].trim();
		Stanje stanje = Zahtjev.parseStanje(tokens[3].trim());
		String datumSlanja = tokens[4].trim();
		
		// AKO JE ZAHTJEV OBRADJEN
		if (tokens.length > 7) {
			String datumObrade = tokens[5].trim();
			String idObradjivaca = tokens[6].trim();
			zahtjev = new Zahtjev(idZahtjeva, stanje, datumSlanja, datumObrade);
			this.obradjeniZahtjevi.add(zahtjev);
			if (tokens[7].trim().equals("SEKRETAR")) {
				zahtjev.setObradjivac(this.sekretarManager.getMapSekretari().get(idObradjivaca));
				sekretarManager.getMapSekretari().get(idObradjivaca).getObradjeniZahtjevi().add(zahtjev);	
			} else {
				zahtjev.setObradjivac(this.adminManager.getMapAdministratori().get(idObradjivaca));
				adminManager.getMapAdministratori().get(idObradjivaca).getObradjeniZahtjevi().add(zahtjev);	
			}

			
		// AKO ZAHTJEV NIJE OBRADJEN
		} else {
			zahtjev = new Zahtjev(idZahtjeva, stanje, datumSlanja);
			Sekretar.getNeobradjeniZahtjevi().add(zahtjev);
			this.neobradjeniZahtjevi.add(zahtjev);
		}
		zahtjev.setUcenik(this.ucenikManager.getMapUcenici().get(idUcenika));
		zahtjev.setKurs(this.kursManager.getMapKursevi().get(idKursa));
		
		return zahtjev;
	}
	
	
	public boolean addZahtjev(Zahtjev z, Ucenik uc, Kurs k) {
		if (mapZahtjevi.containsKey(z.getId()))
			return false;
		this.zahtjevi.add(z);
		this.mapZahtjevi.put(z.getId(), z);
		

		Sekretar.getNeobradjeniZahtjevi().add(z);
		this.neobradjeniZahtjevi.add(z);
		
		z.setUcenik(uc);
		z.setKurs(k);
		
		return true;
	}
	
	public boolean removeZahtjev(Zahtjev z) {
		if (!mapZahtjevi.containsKey(z.getId()))
			return false;
		
		Sekretar.getNeobradjeniZahtjevi().remove(z);
		this.neobradjeniZahtjevi.remove(z);
		
		this.zahtjevi.remove(z);
		this.mapZahtjevi.remove(z.getId());
		return true;
	}
	

	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.zahtjeviFile), "utf-8"));

			out.println("# ID_ZAHTJEVA; ID_UCENIKA; ID_KURSA; STANJE; DATUM_SLANJA; datum_obrade; id_sekretara; uloga");
			for (Zahtjev zahtjev : this.zahtjevi) {
//				System.out.println(uc.toFileString());
				out.println(zahtjev.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public Map<String, Zahtjev> getMapZahtjevi() {
		return mapZahtjevi;
	}
	
	
	public List<Zahtjev> getZahtjevi() {
		return zahtjevi;
	}
	
	public List<Zahtjev> getObradjeniZahtjevi() {
		return obradjeniZahtjevi;
	}
	
	public List<Zahtjev> getNeobradjeniZahtjevi() {
		return neobradjeniZahtjevi;
	}
	
	
	
	public static void main(String[] args) {
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");
//		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
		
//		TestManager testManager = new TestManager(predavacManager, jezikManager, "./data/testovi.txt");
		
		UcenikManager ucenikManager = new UcenikManager("./data/ucenici.txt");
		SekretarManager sekretarManager = new SekretarManager("./data/sekretari.txt");
		AdministratorManager adminManager = new AdministratorManager("./data/administratori.txt");
		
		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
//		OdrzavanjeKursaManager odrzavanjeKursaManager = new OdrzavanjeKursaManager(predavacManager, kursManager, "./data/odrzavanje-kurseva.txt");
		ZahtjevManager zahtjevManager = new ZahtjevManager(ucenikManager, sekretarManager, adminManager, kursManager, "./data/zahtjevi.txt");
		
		for (Zahtjev zahtjev : zahtjevManager.getZahtjevi()) {
			System.out.println(zahtjev);
		}
		
		for (Sekretar s : sekretarManager.getSekretari()) {
			System.out.println(s);
		}
	}


}

