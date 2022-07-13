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

import entiteti.Jezik;


public class JezikManager {

	private List<Jezik> jezici;
	private Map<String, Jezik> mapJezici;

	private String jeziciFile;
	
	public JezikManager() {
		this.jezici = new ArrayList<Jezik>();
		this.mapJezici = new HashMap<String, Jezik>();
	}

	public JezikManager(String jeziciFile) {
		this();
		this.jeziciFile = jeziciFile;
		loadData(jeziciFile);
	}

   

	public boolean loadData(String file) {
		if (this.jeziciFile == null)
			this.jeziciFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.jeziciFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				Jezik jezik = parseJezik(linija);
				this.jezici.add(jezik);
				this.mapJezici.put(jezik.getJezik(), jezik);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Jezik parseJezik(String linija) {
		String[] tokens = linija.split(";");
		String jezik = tokens[0].trim();
		boolean aktivan = Boolean.parseBoolean(tokens[1].trim());
		Jezik jez = new Jezik(jezik, aktivan);
		return jez;
	}
	

	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.jeziciFile), "utf-8"));

			out.println("# JEZIK_ID; AKTIVAN");
			for (Jezik jez : this.jezici) {
//				System.out.println(uc.toFileString());
				out.println(jez.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public boolean addJezik(Jezik jez) {
		if (mapJezici.containsKey(jez.getJezik()))
			return false;
		this.jezici.add(jez);
		this.mapJezici.put(jez.getJezik(), jez);
		return true;
	}
	
	public boolean removeJezik(Jezik jez) {
		if (!mapJezici.containsKey(jez.getJezik()))
			return false;
		this.jezici.remove(jez);
		this.mapJezici.remove(jez.getJezik());
		return true;
	}
	
	
	public Map<String, Jezik> getMapJezici() {
		return mapJezici;
	}
	
	
	public List<Jezik> getJezici() {
		return jezici;
	}

	
	
	
	
	public static void main(String[] args) {
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");
		for (Jezik jez : jezikManager.getJezici())
			System.out.println(jez);
	}
	
}
