package Ristorante;
import java.util.HashSet;

import Magazzino.ElementoMagazzino;
import Magazzino.ListaSpesa;
import Prenotazioni.Giorno;
import Prenotazioni.Prenotazione;

import java.util.HashMap;

public class Giornata {

	private Giorno giorno;
	private HashSet<Prenotazione> prenotazioni;
	private ListaSpesa daComprare; //per quel giorno solo in base alle prenotazioni
	private MenuCarta menuCarta;
	private HashSet<MenuTematico> menuTematici;

	public Giornata(Giorno giorno, ListaSpesa daComprare, MenuCarta menuCarta) {
		super();
		this.giorno = giorno;
		this.prenotazioni = new HashSet<>();
		this.daComprare = daComprare;
		this.menuCarta = menuCarta;
		this.menuTematici =  new HashSet<>();
	}

	public Giorno getGiorno() {
		return giorno;
	}

	public void setGiorno(Giorno giorno) {
		this.giorno = giorno;
	}

	public HashSet<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(HashSet<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public ListaSpesa getDaComprare() {
		return daComprare;
	}

	public void setDaComprare(ListaSpesa daComprare) {
		this.daComprare = daComprare;
	}

	public MenuCarta getMenuCarta() {
		return menuCarta;
	}

	public void setMenuCarta(MenuCarta menuCarta) {
		this.menuCarta = menuCarta;
	}

	public HashSet<MenuTematico> getMenuTematici() {
		return menuTematici;
	}

	public void setMenuTematici(HashSet<MenuTematico> menuTematici) {
		this.menuTematici = menuTematici;
	}

	public void creaListaSpesa(Ristorante ristorante) {
		HashMap<String, Double> conDuplicati = new HashMap<>();
		HashMap<String, Double> noDuplicati = new HashMap<>();

		for (Prenotazione pren : prenotazioni) {
			conDuplicati.putAll(Ingrediente.creaListaIngredientiDaPrenotazione(pren, ristorante.getRicettario()));
			conDuplicati.putAll(Extra.creaListaExtraDaPrenotazione(pren, ristorante.getInsiemeB()));
			conDuplicati.putAll(Extra.creaListaExtraDaPrenotazione(pren, ristorante.getInsiemeGE()));

			//gestione dei duplicati che toglie i duplicati
			Merce.gestioneDuplicati(noDuplicati, conDuplicati);
		}

		//settiamo la lista della spesa dalla lista senza duplicati → non tiene conto delle merci già presenti nel magazzino
		daComprare.setLista(noDuplicati);
	}


	//metodo che ci ritorna il numero totale dei coperti della giornata → <= num posti a sedere del ristorane
	public int numCopertiPrenotati () {
		int num = 0;
		for (Prenotazione pren : prenotazioni) {
			num += pren.getNumCoperti();
		}
		return num;
	}

	public String stampaPrenotazioni() {
		String daStampare="Prenotazioni:\n";
		for (Prenotazione pren : prenotazioni) {
			daStampare += pren.toString() + "\n"; 
		}
		return daStampare;
	}
}
