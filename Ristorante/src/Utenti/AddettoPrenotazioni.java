package Utenti;

import Prenotazioni.Giorno;
import Prenotazioni.Prenotazione;
import Prenotazioni.SceltaPrenotazione;
import Ristorante.Giornata;
import Ristorante.Ristorante;
import Util.InputDati;

import java.util.TreeSet;
import java.util.HashSet;

public class AddettoPrenotazioni extends Utente {

	private static String etichettaAP = "addetto alle prenotazioni";
	private static String[] voci = {"Accetta le prenotazioni", "Visualizza le prenotazioni dato il giorno"};

	public AddettoPrenotazioni(String nome) {
		super(nome, etichettaAP, voci);
	}

	public void accettazionePrenotazione(Ristorante ristorante) {
		String messaggioSuccessoAccettazione = "La prenotazione è avvenuta con successo";
		String messaggioErrAccettazione = "La prenotazione non si può accettare";
		
		Prenotazione prenotazione = Prenotazione.creaPrenotazioneVuota(ristorante.getNumPosti());

		aggiungiScelte(ristorante, prenotazione);

		Giorno dataPrenotazione = prenotazione.getData();
		TreeSet<Giornata> calendario = ristorante.getCalendario();

		int postiRimasti = ristorante.getNumPosti();

		for (Giornata giornata : calendario) {
			if (giornata.getGiorno().equals(dataPrenotazione)) {
				if (controlloVincoli(giornata.numCopertiPrenotati(), postiRimasti, prenotazione, ristorante.getCaricoLavoroRistorante())) {
					giornata.getPrenotazioni().add(prenotazione);
					postiRimasti-=prenotazione.getNumCoperti();
					System.out.println(messaggioSuccessoAccettazione);
				} else {
					System.out.println(messaggioErrAccettazione);
				}
			}
		}
	}

	public void aggiungiScelte(Ristorante ristorante, Prenotazione prenotazione) {
		String messaggioNomeScelta = "Inserire il nome del menu tematico o del piatto scelto: ";
		String messaggioNumScelta = "Inserire per quante persone vale la scelta: ";
		String messaggioRichiestaAltreScelte = "Vuoi inserire altri elementi in questa prenotazione?";

		String messaggioErrAltriPiatti = "Vanno inseriti almeno altre %d scelte";

		boolean risposta = false;
		do {
			System.out.println(ristorante.getMenuTematici().toString());
			System.out.println(ristorante.getGiornata(prenotazione.getData()).getMenuCarta().toString());

			String nomeScelta = InputDati.leggiStringaNonVuota(messaggioNomeScelta);
			int numScelta = InputDati.leggiInteroConMinimo(messaggioNumScelta, 1);

			//	*aggiungi SceltaPrenotazione all'hashmap della prenotazione*
			HashSet<SceltaPrenotazione> insiemeTotale = new HashSet<>(ristorante.getMenuTematici());
			insiemeTotale.addAll(ristorante.getPiatti());

			SceltaPrenotazione scelta = SceltaPrenotazione.trovaDaNome(nomeScelta, insiemeTotale);
			if (scelta!=null) {
				prenotazione.addScelta(scelta, numScelta);	
			}

			risposta = InputDati.yesOrNo(messaggioRichiestaAltreScelte);
			int piattiMinDaInserire= numScelta-prenotazione.getNumCoperti();
			if (piattiMinDaInserire>0) {
				System.out.printf(messaggioErrAltriPiatti, piattiMinDaInserire);
				risposta = true;
			}
		} while (risposta);

	}
	
	public boolean controlloVincoli(int copertiGiornata, int postiRistorante, Prenotazione prenotazione, double caricoLavoroRistorante) {
		boolean cond1 = (copertiGiornata <= postiRistorante);

		double caricoLavoroPrenotazione = 0.0;

		for (SceltaPrenotazione scelta : prenotazione.getElenco().keySet()) {
			caricoLavoroPrenotazione = scelta.getCaricoLavoro()*prenotazione.getElenco().get(scelta);
		}

		boolean cond2 = caricoLavoroPrenotazione < caricoLavoroRistorante;
		
		if(cond1 & cond2) {
			return true;
		} else		
			return false;
	}

	public void visualizzaPrenotazioni(Ristorante ristorante) {
		String messaggioGiornata = "Inserire la giornata di cui si vuole vedere le prenotazioni";
		
		System.out.println(messaggioGiornata);
		Giorno giornoScelto = Giorno.richiestaCreaGiorno();
		
		for (Giornata giornata : ristorante.getCalendario()) {
			if (giornoScelto.equals(giornata.getGiorno())) {
				System.out.println(giornata.stampaPrenotazioni());
			}
		}
	}

	@Override
	public void eseguiMetodi(Ristorante ristorante, int scelta) {
		switch (scelta) {
		case 1: 
			accettazionePrenotazione(ristorante);
			break;
		case 2:
			visualizzaPrenotazioni(ristorante);
			break;
		}
	}

}
