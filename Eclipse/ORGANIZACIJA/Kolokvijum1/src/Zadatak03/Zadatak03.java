package Zadatak03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import zadatak01.Putovanje;

public class Zadatak03 {
	
	static final String CSV_FILE = "resources/zadatak01/podaci_autobuske_stanice.csv";
	static final String OUTPUT_JSON_FILE = "resources/zadatak03/putovanja_sa_povratkom.json";
	static final String OUTPUT_YAML_FILE = "resources/zadatak03/putovanja_bez_povratka.yaml";
	
	static List<Putovanje> putovanja;
	static Map<String, List<Putovanje>> mapPutovanja = new HashMap<String, List<Putovanje>>();
	static List<Putovanje> putovanjaSaPovratkom = new ArrayList<Putovanje>();
	static List<Putovanje> putovanjaBezPovratka = new ArrayList<Putovanje>();
	
	
	public static void main(String[] args) {

		try {
			
			loadData(CSV_FILE);
			razvrstajRelacije();
			System.out.println(putovanjaBezPovratka);
			System.out.println(putovanjaSaPovratkom);
			saveJson(OUTPUT_JSON_FILE);
			saveYaml(OUTPUT_YAML_FILE);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static void saveYaml(String outputYamlFile) throws IOException {
		
		DumperOptions dumperOptions = new DumperOptions();
		dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		dumperOptions.setIndent(4);
		Yaml yaml = new Yaml(dumperOptions);
		yaml.dump(putovanjaBezPovratka, new FileWriter(outputYamlFile));
	}



	private static void saveJson(String outputJsonFile) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputJsonFile), putovanjaSaPovratkom);
		
	}



	private static void razvrstajRelacije() {
		for (Putovanje p : putovanja) {
			String key = p.getSifra();
			if (!mapPutovanja.containsKey(key)) {
				mapPutovanja.put(key, new ArrayList<Putovanje>());
			}
			mapPutovanja.get(key).add(p);
		}
		for (Putovanje p : putovanja) {
			if (postojiPovratak(p))
				putovanjaSaPovratkom.add(p);
			else
				putovanjaBezPovratka.add(p);
		}
		
		
	}

	
	
	private static boolean postojiPovratak(Putovanje p1) {
		String key = p1.getSifra();
		for (Putovanje p2 : mapPutovanja.get(key)) {
			if ( p1.getMjestoPolaska().equals(p2.getMjestoDolaska()) && ( p1.dateTimeDolaska().isBefore(p2.dateTimePolaska())) )
				return true;
		}
		return false;
	}



	private static void loadData(String csvFile) throws FileNotFoundException, IOException {

		try(Reader reader = new FileReader(csvFile)){
			
			CsvToBean<Putovanje> csvToBean = new CsvToBeanBuilder<Putovanje>(reader)
				.withType(Putovanje.class).withSkipLines(1).build();
			
			putovanja = csvToBean.parse();
		}
	}
	
	

}
