import java.util.HashMap;
import java.util.Set;

public abstract class Merce {

	private String nome;
	protected String tipo;
	protected String unitàMisura;
	private Giorno scadenza;
	private boolean qualità = true;

	//creiamo un costruttore per inizializzare alcuni gli attributi → l'unità di misura andrà settata con il set
		public Merce(String nome, String tipo, Giorno scadenza) {
			this.nome = nome;
			this.tipo = tipo;
			this.scadenza = scadenza;
			this.qualità = true;
		}
	
	//creiamo un costruttore per inizializzare alcuni gli attributi
	public Merce(String nome, String tipo, String unitàMisura) {
		this.nome = nome;
		this.tipo = tipo;
		this.unitàMisura = unitàMisura;
		this.qualità = true;
	}

	//creiamo un costruttore per inizializzare tutti gli attributi
	public Merce(String nome, String tipo, String unitàMisura, Giorno scadenza) {
		this.nome = nome;
		this.tipo = tipo;
		this.unitàMisura = unitàMisura;
		this.scadenza = scadenza;
		this.qualità = true;
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

	public String getUnitàMisura() {
		return unitàMisura;
	}

	public void setUnitàMisura(String unitàMisura) {
		this.unitàMisura = unitàMisura;
	}

	public Giorno getScadenza() {
		return scadenza;
	}

	public void setScadenza(Giorno scadenza) {
		this.scadenza = scadenza;
	}

	public boolean getQualità() {
		return qualità;
	}

	public void setQualità(boolean qualità) {
		this.qualità = qualità;
	}

	public static Merce trovaMerceDaNome(Set<? extends Merce> insieme, String nome){
		Merce trovata;
		for(Merce merce : insieme) {
			if (merce.getNome()==nome) {
				trovata = merce;
				return trovata;
			}
		}
		return null;
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
			new Ingrediente (nome, scadenza, consumoProCapite); //il consumo pro capite = dose. unitàMisura con set poi
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

	public boolean èScaduto(Giorno giornoAttuale) {
		if (giornoAttuale.getGiorno().isAfter(scadenza.getGiorno()) || giornoAttuale.getGiorno().isEqual(scadenza.getGiorno())) {
			qualità = false; //se il prodotto è scaduto, la qualità = false 
		}
		return qualità;
	}
}
