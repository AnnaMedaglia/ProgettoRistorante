package Prenotazioni;
import Utenti.Utente;

public class AddettoPrenotazioni extends Utente {

	private static String etichettaAP = "addetto alle prenotazioni";
	
	public AddettoPrenotazioni(String nome) {
		super(nome, etichettaAP);
	}

}
