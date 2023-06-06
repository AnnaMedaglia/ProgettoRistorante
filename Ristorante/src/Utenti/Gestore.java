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

	public void inizializzaRistorante(Ristorante ristorante) {
		String msgCarico = "Inserisci il carico di lavoro per persona: ";
		String msgNumPosti = "Inserisci il numero di posti a sedere disponibili del ristorante: ";
		
		int caricoLavoroPersona = InputDati.leggiInteroNonNegativo(msgCarico);
		int numPosti = InputDati.leggiInteroPositivo(msgNumPosti);
		
		ristorante.setCaricoLavoroPersona(caricoLavoroPersona);
		ristorante.setNumPosti(numPosti);
	}
	
	public void visualizzaRistorante(Ristorante ristorante) {
		System.out.printf("Nome del ristorante: %s\n", ristorante.getNome());
		System.out.printf("Carico di lavoro per persona: %d\n", ristorante.getCaricoLavoroPersona());
		System.out.printf("Carico di lavoro sostenibile dal ristorante: %.2f\n", ristorante.getCaricoLavoroRistorante());
		System.out.printf("Numeri di posti a sedere nel ristorante: %d\n", ristorante.getNumPosti());
	}

	public void aggiungiBevanda(Ristorante ristorante) {
		String msgNome = "Inserisci il nome della bevanda da aggiungere: ";
		String msgConsumo = "Inserisci il consumo pro capite della bevanda da aggiungere: ";

		String nome = InputDati.leggiStringaNonVuota(msgNome);
		double consumoProCapite = InputDati.leggiDoubleConMinimo(msgConsumo, 0);

		ristorante.aggiungiBevanda(nome, consumoProCapite);
	}

	public void rimuoviBevanda(Ristorante ristorante) {
		String msgNome = "Inserisci il nome della bevanda da rimuovere: ";

		String nome = InputDati.leggiStringaNonVuota(msgNome);

		ristorante.rimuoviBevanda(nome);
	}
	
	private void visualizzaInsiemeBevande(Ristorante ristorante) {
		for (String elemento : ristorante.getInsiemeB().keySet()) {
			System.out.printf("bevanda: %s\tconsumo pro capite: %f.2\n", elemento, ristorante.getInsiemeB().get(elemento));
		}
	}

	public void aggiungiGenereExtra(Ristorante ristorante) {
		String msgNome = "Inserisci il nome del genere extra da aggiungere: ";
		String msgConsumo = "Inserisci il consumo pro capite del genere extra da aggiungere: ";

		String nome = InputDati.leggiStringaNonVuota(msgNome);
		double consumoProCapite = InputDati.leggiDoubleConMinimo(msgConsumo, 0);

		ristorante.aggiungiGenereExtra(nome, consumoProCapite);
	}

	public void rimuoviGenereExtra(Ristorante ristorante) {
		String msgNome = "Inserisci il nome del genere extra da rimuovere: ";

		String nome = InputDati.leggiStringaNonVuota(msgNome);

		ristorante.rimuoviGenereExtra(nome);
	}
	
	private void visualizzaInsiemeGeneriExtra(Ristorante ristorante) {
		for (String elemento : ristorante.getInsiemeGE().keySet()) {
			System.out.printf("genere extra: %s\tconsumo pro capite: %f.2\n", elemento, ristorante.getInsiemeGE().get(elemento));
		}
	}
	public void corrispondenzaPiattoRicetta (Ristorante ristorante) {
		String msgValidita = "Vuoi gia' inserire il periodo di validita' per ogni piatto? [S/N] ";

		for (Ricetta ricetta : ristorante.getRicettario()) {
			Piatto piatto = new Piatto (ricetta.getNome(), ricetta.getCaricoLavoroPorzione());

			boolean scelta = InputDati.yesOrNo(msgValidita);
			if (scelta) {
				validitaPiatto(piatto);
			}

			ristorante.aggiungiPiatto(piatto);;
		}
	}

	public void validitaPiatto (Piatto piatto) {
		String msgValidita = "Inserisci il periodo di validita' del piatto: ";
		System.out.println(msgValidita);

		Periodo validita = new Periodo();
		validita.creaPeriodoValidita();
		piatto.setValidita(validita);
	}

	public void validitaPiatti (HashSet<Piatto> piatti) {
		for (Piatto piatto : piatti) {	
			validitaPiatto(piatto);
		}
	}

	public void trovaRicetta(Ristorante ristorante){
		String msgNome = "Inserisci il nome del piatto da cercare: ";
		String msgSiRicetta = "Esiste una corrispondenza tra il piatto cercato e una ricetta";
		String msgNoRicetta = "Non esiste una ricetta con questo nome";
		
		String nome = InputDati.leggiStringaNonVuota(msgNome);
		
		Ricetta trovata = Ricetta.trovaRicetta(nome, ristorante.getRicettario());
		
		if (trovata != null) {
			System.out.println(msgSiRicetta);
		}
		else System.out.println(msgNoRicetta);
	}
	
	
	private void visualizzaPiatti(HashSet<Piatto> piatti) {
		for (Piatto piatto : piatti) {
			System.out.printf("nome piatto: %s\tperiodo di validita': %s\n", piatto.getDenominazione(), piatto.getValidita().toString());
		}
	}

	@Override
	public void eseguiMetodi(Ristorante ristorante, int scelta) {
		switch (scelta) {
		case 1: 
			inizializzaRistorante(ristorante);
			break;
		case 2: 
			visualizzaRistorante(ristorante);
			break;
		case 3: 
			aggiungiBevanda(ristorante);
			break;
		case 4: 
			rimuoviBevanda(ristorante);
			break;
		case 5: 
			visualizzaInsiemeBevande(ristorante);
			break;
		case 6: 
			aggiungiGenereExtra(ristorante);
			break;
		case 7: 
			rimuoviGenereExtra(ristorante);
			break;
		case 8: 
			visualizzaInsiemeGeneriExtra(ristorante);
			break;
		case 9: 
			corrispondenzaPiattoRicetta(ristorante);
			break;
		case 10:
			validitaPiatti(ristorante.getPiatti()); //aggiungere piatto al menu alla carta di quel giorno
			break;
		case 11:
			visualizzaPiatti(ristorante.getPiatti());
			break;
		case 12:
			trovaRicetta(ristorante);
			break;
		case 13: 
			creaRicetta(ristorante);
			break;
		case 14:
			visualizzaRicette(ristorante);
			break;
		case 15:
			creaMenuTematico(ristorante); //in ristorante abbiamo calendario, dove abbiamo giornate, aggiungiamo i menu alle rispettive giornate
			break;
		case 16:
			visualizzaMenuTematico(ristorante); //dato un giorno chiesto nel metodo stesso
		}
		

	}

	
	

}
