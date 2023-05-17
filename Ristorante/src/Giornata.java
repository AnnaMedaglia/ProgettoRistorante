import java.util.HashSet;

public class Giornata {
	
	private Giorno giorno;
	private HashSet<Prenotazione> prenotazioni;
	private ListaSpesa daComprare;
	private MenuCarta menuCarta;
	private HashSet<MenuTematico> menuTematici;
	
	public Giornata(Giorno giorno, HashSet<Prenotazione> prenotazioni, MenuCarta menuCarta,
			HashSet<MenuTematico> menuTematici) {
		this.giorno = giorno;
		this.prenotazioni = new HashSet<>();
		this.menuCarta = menuCarta;
		this.menuTematici = new HashSet<>();
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
	
	public void ritornaListaSpesa(Ristorante ristorante) {
		HashSet<Merce> conDuplicati = new HashSet<>();
		HashSet<Merce> noDuplicati = new HashSet<>();
		
		for (Prenotazione pren : prenotazioni) {
			conDuplicati.addAll(Ingrediente.creaListaIngredientiDaPrenotazione(pren, ristorante.getRicettario()));
			conDuplicati.addAll(Bevanda.creaListaExtraDaPrenotazione(pren, ristorante.getInsiemeB()));
			conDuplicati.addAll(GenereExtra.creaListaExtraDaPrenotazione(pren, ristorante.getInsiemeGE()));
			
			//gestione dei duplicati che toglie i duplicati
			Merce.gestioneDuplicati(noDuplicati, conDuplicati);
		}
		
		//settiamo la lista della spesa dalla lista senza duplicati
		daComprare.setLista(noDuplicati);
	}
	
	
	//metodo che ci ritorna il numero totale dei coperti della giornata
	public int numCopertiPrenotati () {
		int num = 0;
		for (Prenotazione pren : prenotazioni) {
			num += pren.getNumCoperti();
		}
		return num;
	}
	
}
