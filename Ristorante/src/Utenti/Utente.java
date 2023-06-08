package Utenti;

import Ristorante.Ristorante;
import Util.*;

public abstract class Utente implements MenuUtente {

	private String nome;
	private String etichetta;
	
	//ci serve per il metodo del menu
	private String[] azioni;
	private MyMenu menu;
	
	
	public Utente(String nome, String etichetta, String[] azioni) {
		this.nome = nome;
		this.etichetta = etichetta;
		this.azioni = azioni;
		this.menu = new MyMenu("menu "+ etichetta, azioni);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEtichetta() {
		return etichetta;
	}
	
	public void setEtichetta(String etichetta) {
		this.etichetta = etichetta;
	}
	
	public String[] getAzioni() {
		return azioni;
	}

	public void setAzioni(String[] azioni) {
		this.azioni = azioni;
	}

	public void menu(Ristorante ristorante) {
		int scelta = menu.scegli();
        eseguiMetodi(ristorante, scelta);
   }

	public abstract void eseguiMetodi(Ristorante ristorante, int scelta); 
}
