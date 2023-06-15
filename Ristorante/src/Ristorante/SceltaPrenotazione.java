package Ristorante;
import java.util.HashSet;

public abstract class SceltaPrenotazione {

	private HashSet<Piatto> elenco;
	private Periodo validita;
	
	
	public SceltaPrenotazione(Periodo validita) {
		this.elenco =  new HashSet<>();
		this.validita = validita;
	}

	public HashSet<Piatto> getElenco() { 
		return elenco;
	}

	public void setElenco(HashSet<Piatto> elenco) {
		this.elenco = elenco;
	}


	public Periodo getValidita() {
		return validita;
	}

	public void setValidita(Periodo validita) {
		this.validita = validita;
	}
	
	public void aggiungiPiatto(Piatto piatto) {
		this.elenco.add(piatto);
	}
}
