package rs.ac.uns.ftn.siit.op.json.zadatak3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import rs.ac.uns.ftn.siit.op.json.zadatak2.Country;


public class Zadatak3 {
	
	static final String FEELINGS_FILE = "resources/zadatak3/AFINN-111.txt";
	static final String TWEETS_FILE = "resources/Africa.json";
	
	static Map<String, Integer> feelingsMap = new HashMap<String, Integer>();
	//			id_str	text
	static Map<String, String> tweetMap = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		createFeelengsMap(FEELINGS_FILE);
		createTweetMap(TWEETS_FILE);
		
		System.out.println(tweetMap);
	}

	private static void createTweetMap(String tweetsFile) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			JsonNode root = mapper.readTree(new File(tweetsFile));
			String id_str = root.at("/continent").textValue();
			
			String text = root.at("/countries/countryCapital").textValue();
			tweetMap.put(id_str, text);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createFeelengsMap(String file) {
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			
			String line;
			while ((line = in.readLine()) != null) {
				String[] tokens = line.split("\t");
				String feeling = tokens[0].trim();
				int feelingValue = Integer.parseInt(tokens[1].trim());
				feelingsMap.put(feeling, feelingValue);
			}
			
			in.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Greska u encoding-u!");
		} catch (FileNotFoundException e) {
			System.out.println("Fajl nije pronadjen!");
		} catch (IOException e) {
			System.out.println("Desila se greska!");
		}
		
	}

}
