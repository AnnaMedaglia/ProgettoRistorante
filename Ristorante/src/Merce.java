import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class Merce {
	
	private String nome;
	protected String tipo;
	protected String unitàMisura;
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
	
	
	
	public boolean èScaduto(Giorno giornoAttuale) {
		if (giornoAttuale.getGiorno().isAfter(scadenza.getGiorno()) || giornoAttuale.getGiorno().isEqual(scadenza.getGiorno())) {
			qualità = false; //se il prodotto è scaduto, la qualità = false 
		}
		return qualità;
	}
}
