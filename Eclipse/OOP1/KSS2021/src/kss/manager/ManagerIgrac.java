package kss.manager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import kss.model.Igrac;
import kss.model.Klub;

public class ManagerIgrac {

	private String file;
	private List<Igrac> igraci;
	private ManagerKlub mk;

	public ManagerIgrac(String file, ManagerKlub mk) {
		this.file = file;
		this.igraci = new ArrayList<Igrac>();
		this.mk = mk;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			
			String line;
			while((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.startsWith("#"))
					continue;
				Igrac i = parseIgrac(line);
				this.igraci.add(i);
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

	private Igrac parseIgrac(String line) {
		// # ID; Ime; Prezime; Id_Kluba
		String[] tokens = line.split(";");
		
		int id = Integer.parseInt(tokens[0].trim());
		String ime = tokens[1].trim();
		String prezime = tokens[2].trim();
		int idKluba = Integer.parseInt(tokens[3].trim());
		Klub k = mk.getKluboviMap().get(idKluba);
		
		Igrac ret = new Igrac(id, ime, prezime, k);
		k.getIgraci().add(ret);
		
		//this.mk.getKluboviMap().get(idKluba).getIgraci().add(ret);
		
		
		
		return ret;
	}
	
	
	public List<Igrac> getIgraci() {
		return this.igraci;
	}
}
