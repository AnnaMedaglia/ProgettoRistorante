package Ristorante;
import java.util.HashSet;

public class SceltaMenu extends Scelta {

	private MenuTematico menu;

	public SceltaMenu(MenuTematico menu) {
		this.menu = menu;
	}

	public HashSet<Piatto> getPiatto() {
		return menu.getPiatto();
	}
}
