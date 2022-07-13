package rs.ac.uns.ftn.siit.op.yaml.vjezba.ex01;

import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Ucitavanje {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Yaml yaml = new Yaml();
		
		String text = "\n- A\n- B\n- C";
		System.out.println(text);
		
		List<String> content = (List<String>) yaml.load(text);
		System.out.println(content);
		
		
		System.out.println("\n\n\n\n");
		
		
		String text2 = "country: Serbia\ncapital: Belgrade";
		Map<String, String> countries = (Map<String, String>) yaml.load(text2);
		System.out.println(countries);
		
	}

}
