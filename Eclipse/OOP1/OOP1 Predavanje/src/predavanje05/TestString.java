package predavanje05;

import predavanje04.Auto;

public class TestString {
	
	static void print(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		
		Auto a = new Auto();
		print(a.toString());

	}

}
