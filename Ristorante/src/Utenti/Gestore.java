package Utenti;

public class Gestore extends Utente{

	private static String etichettaG = "gestore";

	public Gestore(String nome) {
		super(nome, etichettaG);
		//azioni.put("inizializza", /*this::inizializzaParametri*/);
	}
	
}
