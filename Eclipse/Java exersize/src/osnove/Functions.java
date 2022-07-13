package osnove;

public class Functions {

	/**
	 *  Calculates average value for forwarded arguments
	 *  */
	static double calcAverage(double... numbers) {
		double average = 0;	
		
		for (double num : numbers) {
			average += num;
		}

		average /= numbers.length;
		
		return average;
	}
	
	
	static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%d  ", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	
	private static void initializeMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (i+1) * (j+1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		double avg = calcAverage(3, 4, 5, 6, 7, 1, 2, 3);
		System.out.printf("Average is: %.2f\n", avg);
		
		int[][] matrix = new int[4][4];
		initializeMatrix(matrix);
		printMatrix(matrix);
	}




}
