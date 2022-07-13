package rs.ac.uns.ftn.siit.op.yaml.vjezba.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class UcitavanjeDatoteke {

	static final String YAML_FILE = "resources/log.yaml";
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		try(InputStream input = new FileInputStream(new File(YAML_FILE))){
			
			Yaml yaml = new Yaml();
			int fileCounter = 0;
			for (Object data : yaml.loadAll(input)) {
				Map<String, Object> map = (Map<String, Object>) data;
				System.out.println(map);
				fileCounter++;
				yaml.dump(data, new FileWriter("resources/file" + fileCounter + ".yaml"));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
