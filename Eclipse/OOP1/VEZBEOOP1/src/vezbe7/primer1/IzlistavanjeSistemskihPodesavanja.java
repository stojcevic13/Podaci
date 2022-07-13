package vezbe7.primer1;

public class IzlistavanjeSistemskihPodesavanja {

	public static void main(String[] args) {

		System.out.println("Izlistavanje svih podesavanja OS-a");
		System.getProperties().list(System.out);
		//preuzimanje odredjenog podesavanja - naziva OS-a
		System.out.println(System.getProperty("os.name"));
		//preuzimanje separatora putanje
		String separatorPutanje = System.getProperty("file.separator");
		//apsolutna putanja u windows os: d:\\userName
		String winAbsPath = "d:" + separatorPutanje + System.getProperty("user.name");
		//apsolutna putanja u unix os: /home/userName
		String unixAbsPath = "/home" + separatorPutanje + System.getProperty("user.name");
		//ispis apsolutnih putanja
		System.out.println("Apsolutne putanje:\n" + winAbsPath + "\n" + unixAbsPath);
		//ispis relativnih putanja
		String relPath = "." + separatorPutanje + "Direktorijum";
		System.out.println("Relativna putanja:\n" + relPath);
	}

}
