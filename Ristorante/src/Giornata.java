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
	
	public void ritornaListaSpesa() {
		for (Prenotazione pren : prenotazioni) {
			
		}
	}
	
}
