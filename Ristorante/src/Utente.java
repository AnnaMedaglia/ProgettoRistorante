public abstract class Utente {

	private String nome;
	private String etichetta;

	public Utente(String nome, String etichetta) {
		this.nome = nome;
		this.etichetta = etichetta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEtichetta() {
		return etichetta;
	}
	public void setEtichetta(String etichetta) {
		this.etichetta = etichetta;
	}


}
