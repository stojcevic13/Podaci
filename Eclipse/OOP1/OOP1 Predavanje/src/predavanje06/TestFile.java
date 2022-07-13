package predavanje06;

import java.io.File;

public class TestFile {

	public static void main(String[] args) {
		try {
			File[] roots = File.listRoots();
			for (File f : roots)
				System.out.println(f.getCanonicalPath());
			System.out.println();
			
			File curr = new File(".");
			System.out.println("Trenutno se nalazimo u: " + curr.getCanonicalPath());
			System.out.println("Da li je fajl: " + curr.isFile());
			System.out.println("Da li je folder: " + curr.isDirectory());
			System.out.println();
			
			File[] files = curr.listFiles();
			System.out.println("Svi fajlovi:");
			for (File f : files)
				if (f.isFile())
					System.out.println(f.getName() + "(" + f.length() + ")");
			System.out.println("Svi Folderi:");
			for (File f : files)
				if (f.isDirectory())
					System.out.println("<" + f.getName() + ">");
			
			
			
			
			
			}
			catch (Exception e) {
				e.printStackTrace();
		}
	}

}
