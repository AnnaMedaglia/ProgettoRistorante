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
	
	//metodo che associa un piatto a una ricetta
	public Ricetta trovaRicetta(Piatto piatto, HashSet<Ricetta> ricettario) {
		Ricetta trovata;
		String nome = piatto.getDenominazione();
		for (Ricetta ric : ricettario) {
			if (ric.getNome()==nome) {
				trovata = ric;
				return trovata;
			}
		}
		System.out.println("Non esiste una ricetta con questo nome");
		return null;
	}
}
