package Utenti;

import java.util.HashSet;

import Ristorante.Periodo;
import Ristorante.Piatto;
import Ristorante.Ricetta;
import Ristorante.Ristorante;
import Util.InputDati;

public class Gestore extends Utente{

	private static String etichettaG = "gestore";

	public Gestore(String nome) {
		super(nome, etichettaG);
		Ristorante ristorante = creaRistorante();
		azioni.put("Visualizza i parametri del ristorante", () -> visualizzaRistorante(ristorante));
		azioni.put("Aggiungi bevanda all'insieme delle bevande", () -> aggiungiBevanda(ristorante));
		azioni.put("Rimuovi bevanda dall'insieme delle bevande", () -> rimuoviBevanda(ristorante));
		azioni.put("Aggiungi genere extra all'insieme dei generi extra", () -> aggiungiGenereExtra(ristorante));
		azioni.put("Rimuovi genere extra dall'insieme dei generi extra", () -> rimuoviGenereExtra(ristorante));
		azioni.put("Crea corrispondenza Piatto - Ricetta", () -> corrispondenzaPiattoRicetta(ristorante));
		azioni.put("Crea periodo di validita' dei piatti", () -> (HashSet<Piatto> piatti) -> validitaPiatti (piatti) ); //??
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

		String messaggioValidita = "Vuoi gia' inserire il periodo di validita' per ogni piatto? [S/N] ";

		for (Ricetta ricetta : ristorante.getRicettario()) {
			Piatto piatto = new Piatto (ricetta.getNome(), ricetta.getCaricoLavoroPorzione());

			boolean scelta = InputDati.yesOrNo(messaggioValidita);
			if (scelta) {
				validitaPiatto(piatto);
			}

			piatti.add(piatto);
		}

		return piatti;
	}

	public void validitaPiatto (Piatto piatto) {
		String messaggioValidita = "Inserisci il periodo di validita' del piatto: ";
		System.out.println(messaggioValidita);

		Periodo validita = new Periodo();
		validita.creaPeriodoValidita();
		piatto.setValidita(validita);
	}

	public void validitaPiatti (HashSet<Piatto> piatti) {
		for (Piatto piatto : piatti) {	
			validitaPiatto(piatto);
		}
	}

	public Ricetta trovaRicetta(Piatto piatto, Ristorante ristorante) throws Exception {
		return ristorante.getRicetta(piatto);
	}

}
