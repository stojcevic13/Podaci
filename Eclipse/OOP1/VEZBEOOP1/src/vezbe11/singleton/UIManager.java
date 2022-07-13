package vezbe11.singleton;

import java.util.ArrayList;
import java.util.Scanner;

public class UIManager {

	private static UIManager instance = new UIManager();
	private static Scanner sc = new Scanner(System.in);
	public static ArrayList<Object> lista = new ArrayList<Object>();

	private UIManager() {
		System.out.println("const");
	}

	public static UIManager getInstance() {
		if (instance == null) {
			instance = new UIManager();
		}
		return instance;
	}

	public boolean readFromFile(String filename) {
		sc.nextLine();
		return true;
	}

	public boolean writeToFile(String filename) {
		return true;
	}
}
