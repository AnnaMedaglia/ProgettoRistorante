package Ristorante;

import java.util.HashSet;

public class MenuTematico extends Menu {

	private String nome;
	private double caricoLavoroMenuT;

	public MenuTematico(String nome,Periodo validita) {
		super(validita);
		this.nome = nome;
		this.caricoLavoroMenuT = 0.0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCaricoLavoroMenuT() {
		return caricoLavoroMenuT;
	}

	public void aggiungiPiatto (Piatto piatto) {
		this.caricoLavoroMenuT += piatto.getCaricoLavoro();
		super.aggiungiPiatto(piatto);
	}

	public static MenuTematico trovaMenuTDaNome(String menu, HashSet<MenuTematico> menuTematici) throws NullPointerException {
		for (MenuTematico m : menuTematici) {
			if (m.getNome().equals(menu)) {
				return m;
			}
		}
		// Se il menu non viene trovato si lancia un'eccezione
		throw new NullPointerException();
	}
	
	
	@Override
	public String toString() {
		String stringa = "Menu Tematico: "+ nome + "\nCarico di lavoro del menu tematico: " + caricoLavoroMenuT + "\nPiatti:\n";
		for (Piatto piatto : getElenco()) {
			stringa += piatto.getDenominazione() + "\n";
		}
		return stringa;
	}

}
