package Ristorante;

import java.util.TreeSet;

import Prenotazioni.Giorno;
import Util.InputDati;

public class Periodo {
	private TreeSet<Giorno> periodoValidita;
	
	private final static String messaggioPiuGiorni = "\nVuoi inserire altri giorni di validita'? [S/N]";

	public Periodo () {
		this.periodoValidita = new TreeSet<>();
	}

	public TreeSet<Giorno> getPeriodoValidita() {
		return periodoValidita;
	}

	public void setPeriodoValidita(TreeSet<Giorno> periodoValidita) {
		this.periodoValidita = periodoValidita;
	}
	
	public void creaPeriodoValidita() {
		boolean rispostaGiorno = false;
		
		do {
			Giorno giorno = Giorno.richiestaCreaGiorno();
			periodoValidita.add(giorno);
			
			rispostaGiorno = InputDati.yesOrNo(messaggioPiuGiorni);
		} while(rispostaGiorno);
	}
}
