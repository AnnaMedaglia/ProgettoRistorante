import java.util.HashSet;

public abstract class Merce {
	
	private String nome;
	protected String tipo;
	protected String unitàMisura;
	private double dose; //dose per ingrediente, consumoProCapite per Bevanda e Genere Extra
	private Giorno scadenza;
	private boolean qualità = true;
	
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

	public boolean getQualità() {
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
	
	
	public static void gestioneDuplicati(HashSet<Merce> noDuplicati, HashSet<? extends Merce> conDuplicati){
		for (Merce merce : conDuplicati) {
			if (noDuplicati.contains(merce)) {
				Merce esistente = trovaMerceDaNome(noDuplicati, merce.getNome());
				esistente.setDose(esistente.getDose()+merce.getDose());
			} else {
				noDuplicati.add(merce);
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
