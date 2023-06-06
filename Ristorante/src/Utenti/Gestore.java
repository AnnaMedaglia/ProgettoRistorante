package Utenti;

import java.util.HashSet;

import Ristorante.Periodo;
import Ristorante.Piatto;
import Ristorante.Ricetta;
import Ristorante.Ristorante;
import Util.InputDati;

public class Gestore extends Utente{

	private static String etichettaG = "gestore";
	private static String[] voci = {"Visualizza i parametri del ristorante","Aggiungi bevanda all'insieme delle bevande", 
			"Rimuovi bevanda dall'insieme delle bevande", "Aggiungi genere extra all'insieme dei generi extra",
			"Rimuovi genere extra dall'insieme dei generi extra", "Crea corrispondenza Piatto - Ricetta",
	"Crea periodo di validita' dei piatti"};

	public Gestore(String nome) {
		super(nome, etichettaG, voci);
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

	@Override
	public void eseguiMetodi(Ristorante ristorante, int scelta) {
		switch (scelta) {
		case 1: 
			visualizzaRistorante(ristorante);
			break;
		case 2: 
			aggiungiBevanda(ristorante);
			break;
		case 3: 
			rimuoviBevanda(ristorante);
			break;
		case 4: 
			aggiungiGenereExtra(ristorante);
			break;
		case 5: 
			rimuoviGenereExtra(ristorante);
			break;
		case 6: 
			corrispondenzaPiattoRicetta(ristorante);
			break;
		case 7:
			validitaPiatti();
			break;
		
		}
		

	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub

	}

}
