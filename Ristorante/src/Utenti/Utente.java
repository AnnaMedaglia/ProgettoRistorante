package Utenti;

import java.util.HashMap;

import Util.*;

public abstract class Utente implements MenuUtente {

	private String nome;
	private String etichetta;
	protected HashMap<String, Runnable> azioni;
  
	//ci serve per il metodo del menu
	private String[] azioniPossibili;

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
		int i=0;
		azioniPossibili = new String[azioni.size()];
		
		for (String nomeAzione : azioni.keySet()) {
			i++;
			System.out.printf("%d: %s", i, nomeAzione);
			azioniPossibili[i-1] = nomeAzione;
		}
		
        // Leggi l'input dell'utente
		String messaggio = "inserisci il numero dell'azione da eseguire";
        int interoScelto = InputDati.leggiIntero(messaggio, 1, azioni.size());

        // Esegui l'azione corrispondente
        String sceltaUtente = azioniPossibili[interoScelto];
        if (azioni.containsKey(sceltaUtente)) {
            azioni.get(sceltaUtente).run();
        } else {
            System.out.println("Azione non valida!");
        }
    }

	
}
