package zadatak01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVParser;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class Zadatak01 {

	static final String DATA_CSV_FILE = "resources/zadatak01/podaci_autobuske_stanice.csv";
	static final String JSON_FILE = "resources/zadatak01/podaci_autobuske_stanice2.json";
	
	static List<Putovanje> putovanja;
	
	
	public static void main(String[] args) {

		createCsvData(DATA_CSV_FILE);
		loadToBeans(DATA_CSV_FILE);
		saveToJson(JSON_FILE);
		saveToJson2(JSON_FILE);
		
		System.out.println("Podaci su uspjesno sacuvani.");
	}
	
	
	
	private static void saveToJson2(String jsonFile) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile), putovanja);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



	private static void saveToJson(String jsonFile) {
			
		try {
			
			JsonFactory jsonFactory = new JsonFactory();
			
			JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(jsonFile), JsonEncoding.UTF8).useDefaultPrettyPrinter();
			
			
			//	sifra  grad1	grad2	datum	  vrijeme  dolazimo  peron  cijena  koliko 	
			jsonGenerator.writeStartObject(); 	// {
			jsonGenerator.writeArrayFieldStart("putovanja");	// [
			
			for (Putovanje p : putovanja) {
				jsonGenerator.writeStartObject();   // {
				
				jsonGenerator.writeStringField("sifra", p.getSifra());
				jsonGenerator.writeStringField("mjestoPolaska", p.getMjestoPolaska());
				jsonGenerator.writeStringField("mjestoDolaska", p.getMjestoDolaska());
				jsonGenerator.writeStringField("datumPolaska", p.getDatumPolaska());
				jsonGenerator.writeStringField("vrijemePolaska", p.getVrijemePolaska());
				jsonGenerator.writeStringField("vrijemeDolaska", p.getVrijemeDolaska());
				jsonGenerator.writeNumberField("peron", p.getPeron());
				jsonGenerator.writeNumberField("cijena", p.getCijena());
				jsonGenerator.writeNumberField("prodatihKarata", p.getProdatihKarata());
				
				jsonGenerator.writeEndObject();     // }
			}
			
			jsonGenerator.writeEndArray();		// ]
			jsonGenerator.writeEndObject();     // }
			
			jsonGenerator.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



	private static void loadToBeans(String dataCsvFile) {

		try(Reader reader = new FileReader(dataCsvFile)){
			
			CsvToBean<Putovanje> csvToBean = new CsvToBeanBuilder<Putovanje>(reader)
					.withType(Putovanje.class).withSeparator(',').withQuoteChar(ICSVParser.DEFAULT_QUOTE_CHARACTER).withSkipLines(1).build();
			putovanja = csvToBean.parse();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private static void createCsvData(String dataCsvFile) {
		
		try(CSVWriter csvWriter = (CSVWriter) new CSVWriterBuilder(new FileWriter(dataCsvFile))
				.withSeparator(',').withQuoteChar(ICSVWriter.DEFAULT_QUOTE_CHARACTER) .build() ){
			
//			mesto dolaska, datum polaska,
//			vreme polaska, planirano vreme dolaska, stanični peron
//			polaska, cena karte, broj prodatih karata
			csvWriter.writeNext("sifra_relacije,mjesto_polaska,mjesto_dolaska,datum_polaska,vrijeme_polaska,vrijeme_dolaska,peron,cijena,prodatih_karata".split(","));
							 //	sifra  grad1	grad2	datum	  vrijeme  dolazimo  peron  cijena  koliko 		
			csvWriter.writeNext("0000,Beograd,Novi Sad,21.12.2012,13:00,14:00,5,400.0,10".split(","));
			csvWriter.writeNext("0000,Beograd,Novi Sad,22.12.2012,14:00,15:00,6,400.0,15".split(","));
			csvWriter.writeNext("0002,Brcko,Bijeljina,21.12.2013,11:00,13:00,3,500.0,20".split(","));
			csvWriter.writeNext("0003,Subotica,Novi Sad,21.12.2014,15:00,16:00,2,450.0,20".split(","));
			csvWriter.writeNext("0004,Kikinda,Zajecar,21.12.2015,13:00,14:00,5,400.0,10".split(","));
			csvWriter.writeNext("0005,Zrenjanin,Pozarevac,21.12.2016,13:00,14:00,5,400.0,10".split(","));
			csvWriter.writeNext("0006,Vranje,Golubac,21.12.2017,13:00,14:00,5,900.0,10".split(","));
			csvWriter.writeNext("0007,Kragujevac,Cetinje,21.12.2018,13:00,14:00,5,4000.0,10".split(","));
			csvWriter.writeNext("0008,Valjevo,Kraljevo,21.12.2019,13:00,14:00,5,400.0,10".split(","));
			csvWriter.writeNext("0009,Cacak,Krusevac,21.12.2020,13:00,14:00,5,500.0,10".split(","));
			csvWriter.writeNext("0010,Kosovska Mitrovica,Smederevo,21.12.2021,13:00,14:00,5,800.0,10".split(","));
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
