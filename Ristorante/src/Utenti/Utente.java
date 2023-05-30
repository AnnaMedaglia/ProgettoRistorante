package Utenti;

import java.util.HashMap;
import Util.*;

public abstract class Utente implements MenuUtente {

	private String nome;
	private String etichetta;
	protected HashMap<String, Runnable> azioni;

	public Utente(String nome, String etichetta) {
		this.nome = nome;
		this.etichetta = etichetta;
		azioni = new HashMap<>();
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
	
	public HashMap<String, Runnable> getAzioni() {
		return azioni;
	}
	
	public void setAzioni(HashMap<String, Runnable> azioni) {
		this.azioni = azioni;
	}
	
	public void menu() {
        // Mostra il menu all'utente
		int i=1;
		for (String nomeAzione : azioni.keySet()) {
			i++;
			System.out.printf("%d: %s", i, nomeAzione);
		}
		
        // Leggi l'input dell'utente
		String messaggio = "inserisci il numero dell'azione da eseguire";
        int sceltaUtente = InputDati.leggiIntero(messaggio, 1, azioni.size());
//!!!!!
        // Esegui l'azione corrispondente
        if (azioni.containsKey(sceltaUtente)) {
            azioni.get(sceltaUtente).run();
        } else {
            System.out.println("Azione non valida!");
        }
    }

	
}
