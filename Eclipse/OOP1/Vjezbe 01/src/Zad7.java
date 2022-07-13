
public class Zad7 {

	public static void main(String[] args) {
		
		int x = -4, y = 3, min, max;
		
		max = Math.max(x, y);
		min = Math.min(x, y);
		
		if (x < y) 
			min = Math.abs(min);
		
		double z = max / (1.0 + min);
		System.out.println(z);
		
		
		
	}

}
