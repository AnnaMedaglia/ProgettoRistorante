import java.util.HashSet;
import java.util.TreeSet;

public class Piatto {
	
	private String denominazione;
	private TreeSet<Periodo> durata;
	private double caricoLavoro;
	
	public Piatto(String denominazione, double caricoLavoro, Ricetta ricetta) {
		this.denominazione = denominazione;
		this.durata = new TreeSet<>();
		this.caricoLavoro = ricetta.getCaricoLavoroPorzione();
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public TreeSet<Periodo> getDurata() {
		return durata;
	}

	public void setDurata(TreeSet<Periodo> durata) {
		this.durata = durata;
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
