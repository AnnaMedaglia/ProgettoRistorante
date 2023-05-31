package Utenti;

import Ristorante.Ristorante;
import Util.InputDati;

public class Gestore extends Utente{

	private static String etichettaG = "gestore";

	public Gestore(String nome) {
		super(nome, etichettaG);
		//azioni.put("inizializza", /*this::inizializzaParametri*/);
	}

	public Ristorante creaRistorante() {
		String messaggioNome = "Inserisci il nome del ristorante: ";
		String messaggioCarico = "Inserisci il carico di lavoro per persona: ";
		String messaggioNumPosti = "Inserisci il numero di posti a sedere disponibili del ristorante: ";

		String nome = InputDati.leggiStringaNonVuota(messaggioNome);
		int caricoLavoroPersona = InputDati.leggiInteroNonNegativo(messaggioCarico);
		int numPosti = InputDati.leggiInteroPositivo(messaggioNumPosti);

		return new Ristorante(nome, caricoLavoroPersona, numPosti);
	}

	public void visualizzaRistorante(Ristorante ristorante) {
		System.out.printf("Nome del ristorante: %s\n", ristorante.getNome());
		System.out.printf("Carico di lavoro per persona: %d\n", ristorante.getCaricoLavoroPersona());
		System.out.printf("Carico di lavoro sostenibile dal ristorante: %.2f\n", ristorante.getCaricoLavoroRistorante());
		System.out.printf("Numeri di posti a sedere nel ristorante: %d\n", ristorante.getNumPosti());
	}
	
	
	
	public void rimuoviBevande() {
		
	}
	
	public void aggiungiBevande(Ristorante ristorante) {
		String messaggioNome = "Inserisci il nome della bevanda: ";
		String messaggioCarico = "Inserisci il consumo pro capite della bevanda: ";

		
	}
}
