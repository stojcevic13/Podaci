package drzave;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class Zadatak {
	
	static final String CSV_INPUT_FILE = "resources/drzave/drzave_svijeta.csv";
	static final String CSV_OUTPUT_FILE = "resources/drzave/prosjecna_povrsina.csv";
	static final String JSON_OUTPUT_FILE = "resources/drzave/sortirani_kontinenti.json";
	static final String YAML_OUTPUT_FILE = "resources/drzave/najveca_gustina.yaml";
	
	static List<Drzava> drzave;
	static Map<String, Integer> mapContinents = new HashMap<String, Integer>();
	
	

	public static void main(String[] args) {
		try {
			createCsvInputFile(CSV_INPUT_FILE);
			loadData(CSV_INPUT_FILE);
			
			double totalSurface = 0, maxGustina = 0, gustina;
			Drzava najguscaDrzava = null;
			for (Drzava d : drzave) {
				totalSurface += d.getPovrsina();
				if ((gustina = d.getBrStanovnika()*1.0 / d.getPovrsina()) > maxGustina) {
					maxGustina = gustina;
					najguscaDrzava = d;
				}
				if (!mapContinents.containsKey(d.getKontinent()))
					mapContinents.put(d.getKontinent(), 0);
				mapContinents.put(d.getKontinent(), mapContinents.get(d.getKontinent()) + d.getBrStanovnika());
			}
			
			double averageSurface = totalSurface*1.0 / drzave.size();
			saveToCsv(averageSurface);
			saveToYaml(najguscaDrzava);
			saveToJson();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	private static void saveToJson() throws IOException {
//		JsonFactory jsonFactory = new JsonFactory();
//		JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(JSON_OUTPUT_FILE), JsonEncoding.UTF8).useDefaultPrettyPrinter();
//		jsonGenerator.writeStartObject();
//		for (String continent : mapContinents.keySet()) {
//			jsonGenerator.writeNumberField(continent, mapContinents.get(continent));
//		}
//		jsonGenerator.writeEndObject();
//		jsonGenerator.close();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_OUTPUT_FILE), mapContinents);
	}



	private static void saveToYaml(Drzava najguscaDrzava) throws IOException {

		DumperOptions dumperOptions = new DumperOptions();
		dumperOptions.setDefaultFlowStyle(FlowStyle.BLOCK);
		dumperOptions.setIndent(4);
		Yaml yaml = new Yaml(dumperOptions);
		yaml.dump(najguscaDrzava, new FileWriter(YAML_OUTPUT_FILE));
	}



	private static void saveToCsv(double averageSurface) throws IOException {
		try(CSVWriter csvWriter = (CSVWriter) new CSVWriterBuilder(new FileWriter(CSV_OUTPUT_FILE))
				.withSeparator(',').withQuoteChar(ICSVWriter.NO_QUOTE_CHARACTER).build()){
			String[] izlaz = {"" + averageSurface};
			csvWriter.writeNext(izlaz);
		}
	}



	private static void averageSurface() throws IOException {
		



	}



	private static void loadData(String csvInputFile) throws FileNotFoundException, IOException {

		try(Reader reader = new FileReader(csvInputFile)){
			CsvToBean<Drzava> csvToBean = new CsvToBeanBuilder<Drzava>(reader).withType(Drzava.class).withSeparator(',').withSkipLines(1).build();
			drzave = csvToBean.parse();
		}
		
	}



	private static void createCsvInputFile(String csvInputFile) throws IOException {

		try(CSVWriter csvWriter = (CSVWriter) new CSVWriterBuilder(new FileWriter(csvInputFile))
				.withSeparator(',').withQuoteChar(ICSVWriter.NO_QUOTE_CHARACTER).build()){
			
			csvWriter.writeNext("naziv,glavniGrad,povrsina,brStanovinika,kontinent,datumOsnivanja".split(","));
			csvWriter.writeNext("Srbija,Beograd,12,7,Evropa,05.06.2006.".split(","));
			csvWriter.writeNext("Francuska,Pariz,40,50,Evropa,12.03.1921.".split(","));
			csvWriter.writeNext("Nemacka,Berlin,35,78,Evropa,21.12.2011.".split(","));
			csvWriter.writeNext("Egipat,Kairo,50,100,Afrika,21.12.2000.".split(","));
			csvWriter.writeNext("Togo,Lome,4,4,Afrika,03.01.1990.".split(","));
			csvWriter.writeNext("Kina,Peking,700,1300,Azija,04.05.1920.".split(","));
			csvWriter.writeNext("Indija,Delhi,400,1100,Azija,12.07.1952.".split(","));
			csvWriter.writeNext("Australija,Kanbera,500,100,Australija,12.12.1912.".split(","));
			csvWriter.writeNext("Brazil,Brazilija,502,400,Juzna Amerika,12.12.1912.".split(","));
			csvWriter.writeNext("Argentina,Buenos Aires,320,320,Juzna Amerika,12.12.1912.".split(","));
			csvWriter.writeNext("Amerika,Vasington,700,900,Sjeverna Amerika,12.12.1912.".split(","));
		}
	}
	
	
	
	

}
