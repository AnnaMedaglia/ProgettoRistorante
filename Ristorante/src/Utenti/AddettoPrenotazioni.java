package Utenti;

import Prenotazioni.Giorno;
import Prenotazioni.Prenotazione;
import Ristorante.Giornata;
import Ristorante.Ristorante;
import Util.InputDati;

import java.util.TreeSet;

public class AddettoPrenotazioni extends Utente {

	private static String etichettaAP = "addetto alle prenotazioni";
	private static String[] voci = {""};

	public AddettoPrenotazioni(String nome) {
		super(nome, etichettaAP, voci);
	}

	public void accettazionePrenotazione(Ristorante ristorante) {
		Prenotazione prenotazione = Prenotazione.creaPrenotazioneVuota(ristorante.getNumPosti());

		aggiungiScelte(ristorante, prenotazione);

		Giorno dataPrenotazione = prenotazione.getData();
		TreeSet<Giornata> calendario = ristorante.getCalendario();

		for (Giornata giornata : calendario) {
			if (giornata.getGiorno().equals(dataPrenotazione)) {
				if (controlloVincoli(giornata, ristorante)) {
					giornata.getPrenotazioni().add(prenotazione);
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
			//setElenco in prenotazione
			
			risposta = InputDati.yesOrNo(messaggioRichiestaAltreScelte);
			int piattiMinDaInserire= numScelta-prenotazione.getNumCoperti();
			if (piattiMinDaInserire>0) {
				System.out.printf(messaggioErrAltriPiatti, piattiMinDaInserire);
				risposta = true;
			}
		} while (risposta);

	}

	public boolean controlloVincoli(Giornata giornata, Ristorante ristorante) {

		return false;
	}

	@Override
	public void eseguiMetodi(Ristorante ristorante, int scelta) {
		switch (scelta) {
		case 1: 

			break;
		}
	}

}
