package test01.igraci;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ManagerIgraci {
	
	private List<Igrac> igraci;

	public ManagerIgraci(String file) {

		igraci = new ArrayList<Igrac>();
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || (line.startsWith("#")))
					continue;
				Igrac ig = parseIgrac(line);
				igraci.add(ig);
				System.out.println(ig);
				
			}
			
			
			in.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Igrac parseIgrac(String line) {
		// Nikola;Jokic;19-02-1995;Nuggets;26.4;10.8;8.3
		String[] tokens = line.split(";");
		String ime = tokens[0].trim();
		String prezime = tokens[1].trim();
		String datum = tokens[2].trim();
		String klub = tokens[3].trim();
		double prosekPoena = Double.parseDouble(tokens[4].trim());
		double prosekSkokova = Double.parseDouble(tokens[5].trim());
		double prosekAsistencija = Double.parseDouble(tokens[6].trim());
		Igrac ret = new Igrac(ime, prezime, datum, klub, prosekPoena, prosekSkokova, prosekAsistencija);
		return ret;
	}

	public List<Igrac> getIgraci() {
		return this.igraci;
	}
	
	
	
}
