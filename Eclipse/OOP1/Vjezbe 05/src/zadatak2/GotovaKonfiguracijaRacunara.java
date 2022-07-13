package zadatak2;

import java.util.Arrays;

public class GotovaKonfiguracijaRacunara extends Artikal {
	
	KomponentaRacunara[] komponente;
	
	public GotovaKonfiguracijaRacunara() {}
	
	public GotovaKonfiguracijaRacunara(String sifra, String naziv, double cijena, int kolicina, String opis, KomponentaRacunara[] komponente) {
		super(sifra, naziv, cijena, kolicina, opis);
		this.komponente = komponente;
	}
	
	public GotovaKonfiguracijaRacunara(GotovaKonfiguracijaRacunara gkr) {
		this(gkr.getSifra(), gkr.getNaziv(), gkr.getCijena(), gkr.getKolicina(), gkr.getOpis(), gkr.komponente);
	}

	// getteri i setteri
	public KomponentaRacunara[] getKomponente() {
		return komponente;
	}
	public void setKomponente(KomponentaRacunara[] komponente) {
		this.komponente = komponente;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(komponente);
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GotovaKonfiguracijaRacunara other = (GotovaKonfiguracijaRacunara) obj;
		if (!Arrays.equals(komponente, other.komponente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", komponente=" + Arrays.toString(komponente);
	}
	
	
	
	
	

}
