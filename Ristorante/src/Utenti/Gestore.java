package Utenti;

import java.util.HashSet;

import Ristorante.Piatto;
import Ristorante.Ricetta;
import Ristorante.Ristorante;
import Prenotazioni.Giorno;
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

	public void aggiungiBevanda(Ristorante ristorante) {
		String messaggioNome = "Inserisci il nome della bevanda da aggiungere: ";
		String messaggioConsumo = "Inserisci il consumo pro capite della bevanda da aggiungere: ";

		String nome = InputDati.leggiStringaNonVuota(messaggioNome);
		double consumoProCapite = InputDati.leggiDoubleConMinimo(messaggioConsumo, 0);

		ristorante.aggiungiBevanda(nome, consumoProCapite);
	}

	public void rimuoviBevanda(Ristorante ristorante) {
		String messaggioNome = "Inserisci il nome della bevanda da rimuovere: ";

		String nome = InputDati.leggiStringaNonVuota(messaggioNome);

		ristorante.rimuoviBevanda(nome);
	}

	public void aggiungiGenereExtra(Ristorante ristorante) {
		String messaggioNome = "Inserisci il nome del genere extra da aggiungere: ";
		String messaggioConsumo = "Inserisci il consumo pro capite del genere extra da aggiungere: ";

		String nome = InputDati.leggiStringaNonVuota(messaggioNome);
		double consumoProCapite = InputDati.leggiDoubleConMinimo(messaggioConsumo, 0);

		ristorante.aggiungiGenereExtra(nome, consumoProCapite);
	}

	public void rimuoviGenereExtra(Ristorante ristorante) {
		String messaggioNome = "Inserisci il nome del genere extra da rimuovere: ";

		String nome = InputDati.leggiStringaNonVuota(messaggioNome);

		ristorante.rimuoviGenereExtra(nome);
	}

	public HashSet<Piatto> corrispondenzaPiattoRicetta (Ristorante ristorante) {
		HashSet<Piatto> piatti = new HashSet<>(); 

		String messaggioValidità = "Inserisci il periodo di validita' del piatto: ";

		String messaggioAnno = "\nInserisci l'anno di validita' del piatto: ";
		String messaggioMese = "\nInserisci il mese di validita' del piatto: ";
		String messaggioGiorno = "\nInserisci il giorno di validita' del piatto: ";

		String messaggioPiuGiorni = "\nVuoi inserire altri giorni di validita'? [S/N]";


		for (Ricetta ricetta : ristorante.getRicettario()) {
			Piatto piatto = new Piatto (ricetta.getNome(), ricetta.getCaricoLavoroPorzione());
			boolean rispostaGiorno = false;
			System.out.println(messaggioValidità);
			do {
				int anno = InputDati.leggiInteroConMinimo(messaggioAnno, 2023);
				int mese = InputDati.leggiIntero(messaggioMese, 1, 12);
				int giorno = 0;
				if (mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10|| mese == 12) {
					giorno = InputDati.leggiIntero(messaggioGiorno, 1, 31);
				} else if (mese == 4 || mese == 6 || mese == 9 || mese == 11) {
					giorno = InputDati.leggiIntero(messaggioGiorno, 1, 30);
				} else {
					giorno = InputDati.leggiIntero(messaggioGiorno, 1, 29);
				}

				Giorno giornoValido = new Giorno (anno, mese, giorno);
				piatto.aggiungiGiorno(giornoValido);

				piatti.add(piatto);

				rispostaGiorno = InputDati.yesOrNo(messaggioPiuGiorni);
			}
			while (rispostaGiorno);
		}
		
		return piatti;
	}
}
