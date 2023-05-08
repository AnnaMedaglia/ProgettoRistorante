import java.util.HashSet;

public abstract class Merce {
	
	private String nome;
	private String tipo;
	protected String unitàMisura;
	private double consumoProCapite;
	
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
	
	public double getConsumoProCapite() {
		return consumoProCapite;
	}

	public void setConsumoProCapite(double consumoProCapite) {
		this.consumoProCapite = consumoProCapite;
	}

	public void addMerce(HashSet<Merce> insieme, Merce merce) {
		insieme.add(merce);
	}

	public void removeMerce(HashSet<Merce> insieme, Merce merce) {
		insieme.remove(merce);
	}

	}
