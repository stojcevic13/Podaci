package vezbe7.primer6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vezbe4.primer5.Student;

public class UpisICitanjeObjekata {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String sp = System.getProperty("file.separator");
		ArrayList<Student> stud = new ArrayList<Student>();
	
		//ObjectOutputStream za upis objekata
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("." + sp + "stud.dat"));
		
		//upis razlicitih vrsta objekata
		out.writeObject(stud);
		out.writeBoolean(true);
		out.writeInt(new Integer(123456));
		out.flush();
		out.close();
		
		//ObjectInputStream za citanje objekata
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("." + sp + "stud.dat"));
		
		stud = (ArrayList<Student>) in.readObject();
		System.out.println(in.readBoolean());
		System.out.println(in.readInt());
		in.close();
	}

}
