package Ristorante;
public class MenuCarta extends Menu {

	public MenuCarta(Periodo validita) {
		super(validita);
	}

	@Override
	public String toString() {
		String stringa = "Menu alla carta:\nPiatti:\n";
		for (Piatto piatto : super.getElenco()) {
			stringa += piatto.getDenominazione() + "\n";
		}
		return stringa;
	}

	
	
}
