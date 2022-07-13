package zadatak05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

public class Zadatak05 {
	
	static final String JSON_INPUT_FILE = "resources/zadatak05/podaci.json";
	static final String YAML_OUTPUT_FILE = "resources/zadatak05/odabrani_mjesec_godina.yaml";
	static final String CSV_OUTPUT_FILE = "resources/zadatak05/iznajmljivanje_po_osobi.csv";
	
	static Agencija agencija;
	static Map<String, List<Iznajmljivanje>> iznPoOsobi = new HashMap<String, List<Iznajmljivanje>>();
	static Map<String, Osoba> mapOsobe = new HashMap<String, Osoba>();

	public static void main(String[] args) {
		
		try {
			createJsonInputFile(JSON_INPUT_FILE);
			loadFromJson(JSON_INPUT_FILE);
			monthYearIznajmljivanja();
			iznajmljivanjePoOsobi();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	private static void iznajmljivanjePoOsobi() throws IOException {
		
		for (Iznajmljivanje i : agencija.getIznajmljivanja()) {
			String jmbg = i.getOsoba().getJmbg();
			if (!mapOsobe.containsKey(jmbg)) {
				mapOsobe.put(jmbg, i.getOsoba());
				iznPoOsobi.put(jmbg, new ArrayList<Iznajmljivanje>());
			}
			if (i.getDatumVracanja() != null)
				iznPoOsobi.get(jmbg).add(i);
			saveToCsv(CSV_OUTPUT_FILE, iznPoOsobi);
		}
		
	}



	private static void saveToCsv(String csvOutputFile, Map<String, List<Iznajmljivanje>> iznPoOsobi) throws IOException {
		try(CSVWriter csvWriter = (CSVWriter) new CSVWriterBuilder(new FileWriter(csvOutputFile))
				.withSeparator(',').withQuoteChar(ICSVWriter.NO_QUOTE_CHARACTER).build()) {
			
			csvWriter.writeNext("ime,prezime,jmbg,ukupnoPotroseno,prosjecnoDana".split(","));
			for (String jmbg : iznPoOsobi.keySet()) {
				Osoba o = mapOsobe.get(jmbg);
				double totalSum = 0, averageDays; 
				int totalDays = 0;
				for (Iznajmljivanje i : iznPoOsobi.get(jmbg)) {
					totalDays += i.getDani();
					totalSum += i.getDani() * i.getCijenaPoDanu();
				}
				averageDays = totalDays*1.0 / iznPoOsobi.get(jmbg).size();
				
				csvWriter.writeNext((o.getIme() + "," + o.getPrezime() + "," + o.getJmbg() + "," + totalSum + "," + averageDays).split(","));
			}	
		}
	}



	private static void monthYearIznajmljivanja() throws IOException {
		List<Iznajmljivanje> iznajmljivanja = new ArrayList<Iznajmljivanje>();
		int month = Utility.inputNumber("Unesite redni broj mjeseca: ");
		int year = Utility.inputNumber("Unesite godinu: ");

		for (Iznajmljivanje i : agencija.getIznajmljivanja()) {
			LocalDate date = Utility.getLocalDate(i.getDatumIznajmljivanja());
			if ( (date.getMonthValue() == month) && (date.getYear() == year) )
				iznajmljivanja.add(i);
		}
		saveToYaml(YAML_OUTPUT_FILE, iznajmljivanja);
	}



	private static void saveToYaml(String yamlOutputFile, List<Iznajmljivanje> iznajmljivanja) throws IOException {
		DumperOptions dumperOptions = new DumperOptions();
		dumperOptions.setDefaultFlowStyle(FlowStyle.BLOCK);
		dumperOptions.setIndent(4);
		Yaml yaml = new Yaml(dumperOptions);
		yaml.dump(iznajmljivanja, new FileWriter(yamlOutputFile));
	}



	private static void loadFromJson(String jsonInputFile) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		agencija = mapper.readValue(new File(jsonInputFile), Agencija.class);
		
	}
	
	
	
	private static void createJsonInputFile(String jsonInputFile) throws IOException {
		JsonFactory jsonFactory = new JsonFactory();
		JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(jsonInputFile), JsonEncoding.UTF8).useDefaultPrettyPrinter();
		
		jsonGenerator.writeStartObject();
		jsonGenerator.writeArrayFieldStart("iznajmljivanja");
		writeIznajmljivanjeObject(jsonGenerator, new Iznajmljivanje("0000", "Beograd", "21.12.2012.", "22.12.2012.", 30, 500, 1, new Osoba("Deki", "Stankovic", "723456789876")));
		writeIznajmljivanjeObject(jsonGenerator, new Iznajmljivanje("0001", "Novi Sad", "22.12.2012.", "23.12.2012.", 20, 500, 1, new Osoba("Janko", "Jankovic2", "5234567890123")));
		writeIznajmljivanjeObject(jsonGenerator, new Iznajmljivanje("0002", "Nis", "23.12.2012.", "26.12.2012.", 40, 850, 3, new Osoba("Sale", "Katai", "623456759876")));
		writeIznajmljivanjeObject(jsonGenerator, new Iznajmljivanje("0003", "Subotica", "24.12.2012.", "27.12.2012.", 30, 450, 3, new Osoba("Mirko", "Ivanic", "623456789876")));
		writeIznajmljivanjeObject(jsonGenerator, new Iznajmljivanje("0004", "Smederevo", "25.12.2012.", "29.12.2012.", 34, 650, 4, new Osoba("Deki", "Stankovic", "723456789876")));
		writeIznajmljivanjeObject(jsonGenerator, new Iznajmljivanje("0005", "Kraljevo", "26.12.2012.", "27.12.2012.", 53, 650, 1, new Osoba("Milan", "Pavkov", "823456789876")));	
		writeIznajmljivanjeObject(jsonGenerator, new Iznajmljivanje("0006", "Beograd", "27.12.2012.", "29.12.2012.", 21, 250, 2, new Osoba("Milan", "Borjan", "923456789876")));		
		jsonGenerator.writeEndArray();
		jsonGenerator.writeEndObject();
		jsonGenerator.close();
	}


	private static void writeIznajmljivanjeObject(JsonGenerator jsonGenerator, Iznajmljivanje iznajmljivanje) throws IOException {
		jsonGenerator.writeStartObject();
		writeBasicData(jsonGenerator, iznajmljivanje);
		if (iznajmljivanje.getDatumVracanja() != null) {
			jsonGenerator.writeStringField("datumVracanja", iznajmljivanje.getDatumVracanja());
			jsonGenerator.writeNumberField("predjenoKilometara", iznajmljivanje.getPredjenoKilometara());
			jsonGenerator.writeNumberField("dani", iznajmljivanje.getDani());
		}
		jsonGenerator.writeEndObject();
	}


	private static void writeBasicData(JsonGenerator jsonGenerator, Iznajmljivanje iznajmljivanje) throws IOException {
		jsonGenerator.writeStringField("sifra", iznajmljivanje.getSifra());
		jsonGenerator.writeStringField("mjesto", iznajmljivanje.getMjesto());
		jsonGenerator.writeStringField("datumIznajmljivanja", iznajmljivanje.getDatumIznajmljivanja());
		jsonGenerator.writeNumberField("cijenaPoDanu", iznajmljivanje.getCijenaPoDanu());
		
		jsonGenerator.writeObjectFieldStart("osoba");
		jsonGenerator.writeStringField("ime", iznajmljivanje.getOsoba().getIme());
		jsonGenerator.writeStringField("prezime", iznajmljivanje.getOsoba().getPrezime());
		jsonGenerator.writeStringField("jmbg", iznajmljivanje.getOsoba().getJmbg());
		jsonGenerator.writeEndObject();
	}

}
