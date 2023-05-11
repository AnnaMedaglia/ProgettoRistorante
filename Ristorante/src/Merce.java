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

	public void addMerce(HashSet<Merce> insieme, Merce merce) {
		insieme.add(merce);
	}

	public void removeMerce(HashSet<Merce> insieme, Merce merce) {
		insieme.remove(merce);
	}

	public boolean contains (HashSet<Merce> insieme, Merce merce) {
		return insieme.contains(merce);
	}
	
}
