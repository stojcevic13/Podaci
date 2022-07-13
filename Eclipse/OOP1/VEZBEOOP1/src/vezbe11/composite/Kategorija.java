package vezbe11.composite;

import java.util.ArrayList;
import java.util.List;

public class Kategorija {

	private String naziv;
	private int stepen = 1;
	private List<Kategorija> potkategorije;

	public Kategorija(String naziv) {
		this.naziv = naziv;
		this.potkategorije = new ArrayList<Kategorija>();
	}

	public void add(Kategorija pkat) {
		pkat.stepen++;
		this.potkategorije.add(pkat);
	}

	public void remove(Kategorija pkat) {
		this.potkategorije.remove(pkat);
	}

	public List<Kategorija> getPotkategorije() {
		return potkategorije;
	}

	@Override
	public String toString() {
		StringBuilder pkat = new StringBuilder();
		if (potkategorije.size() > 0) {
			pkat.append(", sadrzi potkategorije:\n");
			String tabs = new String(new char[stepen]).replace("\0", "\t");
			for (Kategorija k : potkategorije) {
				pkat.append(tabs + k + "\n");
			}
			pkat.replace(pkat.length() - 1, pkat.length(), "");
		}
		return "Kategorija: " + naziv + pkat.toString();
	}

}
