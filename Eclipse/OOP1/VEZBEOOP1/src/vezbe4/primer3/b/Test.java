package vezbe4.primer3.b;

public class Test {

	public static void main(String[] args) {

		Krug k = new Krug();
		k.r = 3;
		k.c = new Tacka(); // inicijalizacija centra kruga, po default-u vrednost je null

		System.out.println(k.povrsina());
		System.out.println(k.obim());

		Tacka t = new Tacka();
		t.x = 1;
		t.y = 1;

		k.provera(t);
	}

}
