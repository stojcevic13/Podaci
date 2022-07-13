package vezbe8.testiranje.primer3.managers;

import java.util.ArrayList;
import java.util.List;

import vezbe8.testiranje.primer3.models.TipKorisnika;

public class TipKorisnikaManager {

	private static TipKorisnikaManager instance = new TipKorisnikaManager();
	private String tipKorisnikaFile;
	private List<TipKorisnika> tipoviKorisnika;

	public TipKorisnikaManager() {
		this.tipoviKorisnika = new ArrayList<TipKorisnika>();
	}

	public void addTipKorisnika(String tip, boolean b) {
		TipKorisnika tk = new TipKorisnika(tip, b);
		this.tipoviKorisnika.add(tk);
	}

	public String getTipKorisnikaFile() {
		return tipKorisnikaFile;
	}

	public void setTipKorisnikaFile(String tipKorisnikaFile) {
		this.tipKorisnikaFile = tipKorisnikaFile;
	}

	public List<TipKorisnika> getTipoviKorisnika() {
		return tipoviKorisnika;
	}

	public void setTipoviKorisnika(List<TipKorisnika> tipoviKorisnika) {
		this.tipoviKorisnika = tipoviKorisnika;
	}

	public static TipKorisnikaManager getInstance() {
		if (instance == null) {
			instance = new TipKorisnikaManager();
		}
		return instance;
	}

}
