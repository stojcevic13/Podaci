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
import entiteti.Uplata;
import entiteti.osobe.Administrator;
import entiteti.osobe.Ucenik;
import manager.osobe.PredavacManager;
import manager.osobe.UcenikManager;

public class UplataManager {
	

	private List<Uplata> uplate;
	private Map<String, Uplata> mapUplate;

	private String uplateFile;
	private UcenikManager ucenikManager;
	private KursManager kursManager;

	public UplataManager(UcenikManager ucenikManager, KursManager kursManager) {
		this.ucenikManager = ucenikManager;
		this.kursManager = kursManager;
		this.uplate = new ArrayList<Uplata>();
		this.mapUplate = new HashMap<String, Uplata>();
	}

	public UplataManager(UcenikManager ucenikManager, KursManager kursManager, String uplateFile) {
		this(ucenikManager, kursManager);
		this.uplateFile = uplateFile;
		loadData(uplateFile);
	}

   

	public boolean loadData(String file) {
		if (this.uplateFile == null)
			this.uplateFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.uplateFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				Uplata uplata = parseUplata(linija);
				this.uplate.add(uplata);
				this.mapUplate.put(uplata.getId(), uplata);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Uplata parseUplata(String linija) {
		//# ID_UPLATE; DATUM_UPLATE; IZNOS; id_ucenika; id_kursa
		String[] tokens = linija.split(";");
		String idUplate = tokens[0].trim();
		String datumUplate = tokens[1].trim();
		double iznos = Double.parseDouble(tokens[2].trim());

		Uplata uplata = new Uplata(idUplate, datumUplate, iznos);
		
		if (tokens.length > 4) {
			String idUcenika = tokens[3].trim();
			String idKursa = tokens[4].trim();
			
			// KURS
			uplata.setKurs(this.kursManager.getMapKursevi().get(idKursa));
			
			// UCENIK
			Ucenik uc = this.ucenikManager.getMapUcenici().get(idUcenika);
			uplata.setUcenik(uc);
			uc.getUplate().add(uplata);
			uc.setUkupnoUplaceno(uc.getUkupnoUplaceno() + iznos);

		}


		Administrator.prihodi += iznos;
		Administrator.svaUplacivanja.add(uplata);
		
		return uplata;
	}
	

	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.uplateFile), "utf-8"));

			out.println("# ID_UPLATE; DATUM_UPLATE; IZNOS; id_ucenika; id_kursa");
			for (Uplata uplata : this.uplate) {
//				System.out.println(uc.toFileString());
				out.println(uplata.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public boolean addUplata(Uplata u, Ucenik uc, Kurs k) {
		if (mapUplate.containsKey(u.getId()))
			return false;
		this.uplate.add(u);
		this.mapUplate.put(u.getId(), u);
		
		// KURS
		u.setKurs(k);
		
		// UCENIK
		u.setUcenik(uc);
		uc.getUplate().add(u);
		uc.setUkupnoUplaceno(uc.getUkupnoUplaceno() + u.getIznos());
		
		// ADMIN
		Administrator.prihodi += u.getIznos();
		Administrator.svaUplacivanja.add(u);
		
		return true;
	}
	
	public boolean removeUplata(Uplata u) {
		if (!mapUplate.containsKey(u.getId()))
			return false;
		
		// UCENIK
		u.getUcenik().getUplate().remove(u);
		u.getUcenik().setUkupnoUplaceno(u.getUcenik().getUkupnoUplaceno() - u.getIznos());
		
		// ADMIN
		Administrator.prihodi -= u.getIznos();
		Administrator.svaUplacivanja.remove(u);
		
		this.uplate.remove(u);
		this.mapUplate.remove(u.getId());
		return true;
	}
	
	
	public Map<String, Uplata> getMapUplate() {
		return mapUplate;
	}
	
	
	public List<Uplata> getUplate() {
		return uplate;
	}
	
	
	
	public static void main(String[] args) {
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");
		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
		
//		TestManager testManager = new TestManager(predavacManager, jezikManager, "./data/testovi.txt");
		
		UcenikManager ucenikManager = new UcenikManager("./data/ucenici.txt");
		
		
		UplataManager uplataManager = new UplataManager(ucenikManager, kursManager, "./data/uplate.txt");
		
		for (Uplata uplata : uplataManager.getUplate()) {
			System.out.println(uplata);
		}
	}

}
