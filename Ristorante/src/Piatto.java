import java.util.HashSet;

public class Piatto {
	
	private String denominazione;
	private double caricoLavoro;
	
	public Piatto(String denominazione, double caricoLavoro, Ricetta ricetta) {
		this.denominazione = denominazione;
		this.caricoLavoro = ricetta.getCaricoLavoroPorzione();
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
	
	
}
