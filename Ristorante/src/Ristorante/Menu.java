package Ristorante;

import java.util.HashSet;
import Ristorante.Periodo;

public abstract class Menu {

	private HashSet<Piatto> elenco;
	private Periodo validita;
	
	
	public Menu(Periodo validita) {
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
