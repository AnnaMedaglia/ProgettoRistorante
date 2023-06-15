package Utenti;

import Ristorante.Ristorante;

public class Magazziniere extends Utente {

	private static String etichettaM = "magazziniere";
	private static String[] voci = {};

	public Magazziniere(String nome) {
		super(nome, etichettaM, voci);
	}

	@Override
	public void eseguiMetodi(Ristorante ristorante, int scelta) {
		switch(scelta) {
		case 1: 
			
			break;
		}
	}


}
