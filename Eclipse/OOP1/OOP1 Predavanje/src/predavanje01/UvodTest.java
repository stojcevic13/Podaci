package predavanje01;

public class UvodTest {

	public static void main(String[] args) {
		double broj;
		int i = 1, j = 0;

		do {
			broj = Math.random();
			j++;

			if (broj <= 0.2 || broj >= 0.4)
				continue;
			
			System.out.println(j + ". Nasumicno generisani broj: " + broj);
			i ++;

		} while (i <= 10);
	}

}
