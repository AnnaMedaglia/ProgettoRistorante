import java.util.HashSet;

public abstract class Merce {
	
	private String nome;
	protected String tipo;
	protected String unitàMisura;
	private double dose; //dose per ingrediente, consumoProCapite per Bevanda e Genere Extra
	private Giorno scadenza;
	private boolean qualità;
	
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
	
	public double getDose() {
		return dose;
	}

	public void setDose(double dose) {
		this.dose = dose;
	}

	
	public Giorno getScadenza() {
		return scadenza;
	}

	public void setScadenza(Giorno scadenza) {
		this.scadenza = scadenza;
	}

	public boolean isQualità() {
		return qualità;
	}

	public void setQualità(boolean qualità) {
		this.qualità = qualità;
	}
	
	public static Merce trovaMerceDaNome(HashSet<? extends Merce> insieme, String nome){
		Merce trovata;
		for(Merce merce : insieme) {
			if (merce.getNome()==nome) {
				trovata = merce;
				return trovata;
			}
		}
	return null;
	}
	
	
	public static HashSet<Merce> gestioneDuplicati(HashSet<? extends Merce> conDuplicati){
		HashSet<Merce> noDuplicati = new HashSet<>();
		for (Merce merce : conDuplicati) {
			Merce merceTrovata = trovaMerceDaNome(conDuplicati, merce.getNome());
			if (conDuplicati.contains(merceTrovata)) { // se lista contiene il nome della merce va aggiornato il numero della quantità
				double doseIniziale = merceTrovata.getDose();
				merce.setDose(doseIniziale+merce.getDose());
				noDuplicati.add(merce);
				} // se lista non contiene l'elemento merce si aggiunge così com'è 
			else noDuplicati.add(merce);
		}
		return noDuplicati;
	}
}
