package vezbe7.primer4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UpisICitanjeUzDISiDOS {

	public static void main(String[] args) throws IOException {
		String sp = System.getProperty("file.separator");
		//kreiranje DataOutputStream-a
		DataOutputStream dataOutputStream = 
				new DataOutputStream(
						new FileOutputStream("." + sp + "tmp.bin"));
		
		//ispis odredjenih podataka
		dataOutputStream.writeInt(12);
		dataOutputStream.writeFloat(12.34F);
		dataOutputStream.writeDouble(3.1456778);
		
		dataOutputStream.close();
		
		//kreiranje DataInputStream-a za prethodno kreiran fajl
		DataInputStream dataInputStream = 
				new DataInputStream(
						new FileInputStream("." + sp + "tmp.bin"));
		
		
		//ispis podataka iz fajla
		System.out.println("int: " + dataInputStream.readInt());
		System.out.println("float: " + dataInputStream.readFloat());
		System.out.println("double: " + dataInputStream.readLong()); // <-
	
		dataInputStream.close();
		
	}

}
