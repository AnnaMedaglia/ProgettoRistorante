package Ristorante;

import java.util.HashSet;
import Prenotazioni.SceltaPrenotazione;

public class MenuTematico extends Menu implements SceltaPrenotazione{

	private String nome;
	private double caricoLavoro;

	public MenuTematico(String nome,Periodo validita) {
		super(validita);
		this.nome = nome;
		this.caricoLavoro = 0.0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCaricoLavoro() {
		return caricoLavoro;
	}

	public void aggiungiPiatto (Piatto piatto) {
		this.caricoLavoro += piatto.getCaricoLavoro();
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
		String stringa = "Menu Tematico: "+ nome + "\nCarico di lavoro del menu tematico: " + caricoLavoro + "\nPiatti:\n";
		for (Piatto piatto : getElenco()) {
			stringa += piatto.getNome() + "\n";
		}
		return stringa;
	}

	@Override
	public HashSet<Piatto> getPiatti() {
		return this.getElenco();
	}

}
