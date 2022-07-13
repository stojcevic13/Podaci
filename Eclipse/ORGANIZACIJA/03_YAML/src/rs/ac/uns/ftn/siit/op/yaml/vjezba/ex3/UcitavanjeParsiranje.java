package rs.ac.uns.ftn.siit.op.yaml.vjezba.ex3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class UcitavanjeParsiranje {

	static final String YAML_FILE = "resources/invoice.yaml";
	
	static Invoice invoice = null;
	
	public static void main(String[] args) {

		try(InputStream input = new FileInputStream(new File(YAML_FILE))){
			
			Yaml yaml = new Yaml(new Constructor(Invoice.class));
			invoice = (Invoice) yaml.load(input);
			System.out.println(invoice);
			
			invoice.setInvoice("promijenjeno");
			
			DumperOptions dumperOptions = new DumperOptions();
			dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
			dumperOptions.setIndent(4);
			yaml = new Yaml(dumperOptions);
			yaml.dump(invoice, new FileWriter("resources/invoice_changed.yaml"));
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl nije pronadjen!");
		} catch (IOException e) {
			System.out.println("Desila se greska!");
		}
		
		
	}

}
