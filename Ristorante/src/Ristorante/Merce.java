package Ristorante;
import java.util.HashMap;

import Prenotazioni.Giorno;

public abstract class Merce {

	private String nome;
	protected String tipo;
	protected String unitaMisura;
	private Giorno scadenza;
	private boolean qualita = true;

	//creiamo un costruttore per inizializzare alcuni gli attributi → l'unità di misura andra' settata con il set
	public Merce(String nome, String tipo, Giorno scadenza) {
		this.nome = nome;
		this.tipo = tipo;
		this.scadenza = scadenza;
		this.qualita = true;
	}

	//creiamo un costruttore per inizializzare alcuni gli attributi
	public Merce(String nome, String tipo, String unitaMisura) {
		this.nome = nome;
		this.tipo = tipo;
		this.unitaMisura = unitaMisura;
		this.qualita = true;
	}

	//creiamo un costruttore per inizializzare tutti gli attributi
	public Merce(String nome, String tipo, String unitaMisura, Giorno scadenza) {
		this.nome = nome;
		this.tipo = tipo;
		this.unitaMisura = unitaMisura;
		this.scadenza = scadenza;
		this.qualita = true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUnitaMisura() {
		return unitaMisura;
	}

	public void setUnitaMisura(String unitaMisura) {
		this.unitaMisura = unitaMisura;
	}

	public Giorno getScadenza() {
		return scadenza;
	}

	public void setScadenza(Giorno scadenza) {
		this.scadenza = scadenza;
	}

	public boolean getQualita() {
		return qualita;
	}

	public void setQualita(boolean qualita) {
		this.qualita = qualita;
	}

	//metodo per "registrare" i prodotti acquistati che dovranno essere poi inseriti dal magazziniere nel magazzino
	public void creaMerce (String nome, String tipo, Giorno scadenza, double consumoProCapite) {
		switch(tipo) {
		case "bevanda" :  
			new Bevanda (nome, scadenza, consumoProCapite);
			break;
		case "genere extra" :
			new GenereExtra (nome, scadenza, consumoProCapite);
			break;
		case "ingrediente" :
			new Ingrediente (nome, scadenza, consumoProCapite); //il consumo pro capite = dose. unita'�Misura con set poi
			break;
		default :
			throw new IllegalArgumentException("tipo della merce non valido");
		}
	};

	public static void gestioneDuplicati(HashMap<String, Double> noDuplicati, HashMap<String, Double> conDuplicati){
		for (String merce : conDuplicati.keySet()) {
			if (noDuplicati.keySet().contains(merce)) {
				noDuplicati.put(merce, noDuplicati.get(merce)+ conDuplicati.get(merce));
			} else {
				noDuplicati.put(merce, conDuplicati.get(merce));
			}
		}
	}

	public boolean eScaduto(Giorno giornoAttuale) {
		if (giornoAttuale.getGiorno().isAfter(scadenza.getGiorno()) || giornoAttuale.getGiorno().isEqual(scadenza.getGiorno())) {
			qualita = false; //se il prodotto e' scaduto, la qualita'� = false 
		}
		return qualita;
	}
}
