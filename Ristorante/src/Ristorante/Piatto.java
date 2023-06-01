package Ristorante;

public class Piatto {

	private String denominazione;
	private double caricoLavoro;
	private Periodo validita;

	public Piatto(String denominazione, double caricoLavoro) {
		this.denominazione = denominazione;
		this.caricoLavoro = caricoLavoro;
		this.validita = new Periodo();
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public double getCaricoLavoro() {
		return caricoLavoro;
	}

	public void setCaricoLavoro(double caricoLavoro) {
		this.caricoLavoro = caricoLavoro;
	}

	public Periodo getValidita() {
		return validita;
	}

	public void setValidita(Periodo validita) {
		this.validita = validita;
	}

}
