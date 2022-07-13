package kss.manager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kss.model.Klub;

public class ManagerKlub {

	private String file;
	private List<Klub> klubovi;
	private Map<Integer, Klub> kluboviMap;
	
	public ManagerKlub(String file) {
		this.file = file;
		this.klubovi = new ArrayList<Klub>();
		this.kluboviMap = new HashMap<Integer, Klub>();
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			
			String line;
			while((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.startsWith("#"))
					continue;
				Klub k = parseKlub(line);
				this.klubovi.add(k);
				this.kluboviMap.put(k.getId(), k);
			}
			
			in.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private Klub parseKlub(String line) {
		String[] tokens = line.split(";");
		
		int id = Integer.parseInt(tokens[0].trim());
		String naziv = tokens[1].trim();
		Klub ret = new Klub(id, naziv);
		return ret;
	}

	
	public List<Klub> getKlubovi() {
		return this.klubovi;
	}
	
	public Map<Integer, Klub> getKluboviMap() {
		return this.kluboviMap;
	}

	
	
	
}
