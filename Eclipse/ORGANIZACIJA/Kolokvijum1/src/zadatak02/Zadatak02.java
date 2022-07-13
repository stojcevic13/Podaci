package zadatak02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import zadatak01.Putovanje;

public class Zadatak02 {

	static final String CSV_FILE = "resources/zadatak01/podaci_autobuske_stanice.csv";
	
	static List<Putovanje> putovanja;
	static Map<String, Putovanje> mapPutovanja = new HashMap<String, Putovanje>();
	  // sifra, brojac
	static Map<String, Integer> mapPopularity = new HashMap<String, Integer>();
	static Map<String, Double> mapZarada = new HashMap<String, Double>();
	
	public static void main(String[] args) {
		
		try {
			
			loadData(CSV_FILE);
			searchAndSaveData();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	private static void searchAndSaveData() throws IOException {
		Putovanje mostPopularRelation = null, longestRelation = null, najisplativijaRelacija = null;
		
		int maxTrajanje = 0, trajanje;
		
		for (Putovanje p : putovanja) {
			if (!mapPutovanja.containsKey(p.getSifra())) {
				mapPutovanja.put(p.getSifra(), p);		// PRAVLJENJE MAPE
				mapZarada.put(p.getSifra(), 0.0);
				mapPopularity.put(p.getSifra(), 0);
				
				// PRONALAZENJE NAJDUZE RELACIJE
				if ((trajanje = p.getTrajanje()) > maxTrajanje) {
					maxTrajanje = trajanje;
					longestRelation = p;
				}
			}
			
			mapPopularity.put(p.getSifra(), mapPopularity.get(p.getSifra()) + 1);
			mapZarada.put(p.getSifra(), mapZarada.get(p.getSifra()) + p.getCijena()*p.getProdatihKarata());
		}
		
		// PRONALAZENJE
		int maxPolazaka = 0, brPolazaka;
		double maxZarada = 0.0, zarada;
		for (String sifra : mapPutovanja.keySet()) {
			
			// NAJPOPULARNIJA RELACIJA
			if ( (brPolazaka = mapPopularity.get(sifra)) > maxPolazaka) {
				maxPolazaka = brPolazaka;
				mostPopularRelation = mapPutovanja.get(sifra);
			}
			// NAISPLATIVIJA RELACIJA
			if ( (zarada = mapZarada.get(sifra)) > maxZarada) {
				maxZarada = zarada;
				najisplativijaRelacija = mapPutovanja.get(sifra);
			}
		}
		
		saveData(mostPopularRelation, longestRelation, najisplativijaRelacija);
	}

	
	
	private static void saveData(Putovanje mostPopularRelation, Putovanje longestRelation, Putovanje najisplativijaRelacija) throws IOException {
		
		Map<String, Putovanje> izlaz = new HashMap<String, Putovanje>();
		izlaz.put("najpopularnijaRelacija", mostPopularRelation);
		izlaz.put("najduzaRelacija", longestRelation);
		izlaz.put("najisplativijaRelacija", najisplativijaRelacija);
		
		FileWriter outputYamlFile = new FileWriter("resources/zadatak02/output.yaml");
		DumperOptions dumperOptions = new DumperOptions();
		dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		dumperOptions.setIndent(4);
		Yaml yaml = new Yaml(dumperOptions);		
		yaml.dump(izlaz, outputYamlFile);

		
		
	}

	
	
	private static void loadData(String csvFile) throws FileNotFoundException, IOException {

		try(Reader reader = new FileReader(csvFile)){
			
			CsvToBean<Putovanje> csvToBean = new CsvToBeanBuilder<Putovanje>(reader) 
					.withType(Putovanje.class).withSkipLines(1).build();
			
			putovanja = csvToBean.parse();
			
		}
	}

	
	
}
