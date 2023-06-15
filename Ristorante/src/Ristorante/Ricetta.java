package Ristorante;
import java.util.HashMap;
import java.util.HashSet;

import Util.Formattazione;

public class Ricetta {

	private String nome;
	private HashMap<String,Double> ingredienti; 
	private int numPorzioni;
	private double caricoLavoroPorzione;

	public Ricetta(String nome, int numPorzioni, double caricoLavoroPorzione) {
		this.nome = nome;
		this.ingredienti = new HashMap<>();
		this.numPorzioni = numPorzioni;
		this.caricoLavoroPorzione = caricoLavoroPorzione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HashMap<String, Double> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(HashMap<String, Double> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	public void aggiungiIngrediente(String nome, double dose) {
		this.ingredienti.put(nome, dose);
	}
	
	public int getNumPorzioni() {
		return numPorzioni;
	}

	public void setNumPorzioni(int numPorzioni) {
		this.numPorzioni = numPorzioni;
	}

	public double getCaricoLavoroPorzione() {
		return caricoLavoroPorzione;
	}

	public void setCaricoLavoroPorzione(double caricoLavoroPorzione) {
		this.caricoLavoroPorzione = caricoLavoroPorzione;
	}

	//metodo che associa un piatto a una ricetta
	public static Ricetta trovaRicetta(String piatto, HashSet<Ricetta> ricettario){
		for (Ricetta ric : ricettario) {
			if (ric.getNome().equalsIgnoreCase(piatto)) {
				return ric;
			}
		}
		// Se la ricetta non viene trovata si ritorna null
		return null;
	}

	@Override
	public String toString() {
		String descrizione = "Ricetta: "+ nome + "\nNumero di porzioni previste: " + numPorzioni + "\nIngredienti:\n";
		for (String nome : ingredienti.keySet()) {
			descrizione += "- " + nome + ", dose: " + Formattazione.ritornaDoubleFormattato(ingredienti.get(nome)) + "\n";
		}
		descrizione += "Carico di lavoro per porzione: " + Formattazione.ritornaDoubleFormattato(caricoLavoroPorzione) + "\n";
		return descrizione;
	}


}
