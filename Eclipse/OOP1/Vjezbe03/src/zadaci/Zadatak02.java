package zadaci;

public class Zadatak02 {
	
	static void parsirajMatricu(String s) {
		String[] matricaStr = s.split(";");
		
		int[][] matrica = new int[matricaStr.length][];
		
		for (int i = 0; i < matricaStr.length; i++) {
			String[] red = matricaStr[i].split(",");
			matrica[i] = new int[red.length];
			
			for (int j = 0; j < red.length; j++) {
				matrica[i][j] = Integer.parseInt(red[j]);
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		String s = "4,3,2,1;0,1,0;1,2,3,4";
		
		parsirajMatricu(s);
		
		
	}

}
