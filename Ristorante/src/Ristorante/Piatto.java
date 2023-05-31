package Ristorante;

import java.util.TreeSet;
import Prenotazioni.Giorno;

public class Piatto {

	private String denominazione;
	private double caricoLavoro;
	private TreeSet<Giorno> validità;

	public Piatto(String denominazione, double caricoLavoro) {
		this.denominazione = denominazione;
		this.caricoLavoro = caricoLavoro;
		this.validità = new TreeSet<>();
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

	public TreeSet<Giorno> getValidità() {
		return validità;
	}

	public void setValidità(TreeSet<Giorno> validità) {
		this.validità = validità;
	}
	
	public void aggiungiGiorno (Giorno giorno) {
		validità.add(giorno);
	}

}
