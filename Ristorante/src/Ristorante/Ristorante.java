package Ristorante;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Ristorante {

	private String nome;
	private int caricoLavoroPersona;
	private int numPosti;
	private double caricoLavoroRistorante; 
	private TreeSet<Giornata> calendario;
	private HashMap<String, Double> insiemeGE;
	private HashMap<String, Double> insiemeB;
	private HashSet<Ricetta> ricettario;

	//costruttore
	public Ristorante(String nome, int caricoLavoroPersona, int numPosti) {
		this.nome = nome;
		this.caricoLavoroPersona = caricoLavoroPersona;
		this.numPosti = numPosti;
		this.caricoLavoroRistorante = (0.2 * (caricoLavoroPersona * numPosti)) + (caricoLavoroPersona * numPosti);
		this.calendario = new TreeSet<>();
		this.insiemeGE = new HashMap<>();
		this.insiemeB = new HashMap<>();
		this.ricettario = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCaricoLavoroPersona() {
		return caricoLavoroPersona;
	}

	public void setCaricoLavoroPersona(int caricoLavoroPersona) {
		this.caricoLavoroPersona = caricoLavoroPersona;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public double getCaricoLavoroRistorante() {
		return caricoLavoroRistorante;
	}

	public TreeSet<Giornata> getCalendario() {
		return calendario;
	}

	public void setCalendario(TreeSet<Giornata> calendario) {
		this.calendario = calendario;
	}


	public HashMap<String, Double> getInsiemeGE() {
		return insiemeGE;
	}

	public void setInsiemeGE(HashMap<String, Double> insiemeGE) {
		this.insiemeGE = insiemeGE;
	}

	public HashMap<String, Double> getInsiemeB() {
		return insiemeB;
	}

	public void setInsiemeB(HashMap<String, Double> insiemeB) {
		this.insiemeB = insiemeB;
	}

	public HashSet<Ricetta> getRicettario() {
		return ricettario;
	}

	public void setRicettario(HashSet<Ricetta> ricettario) {
		this.ricettario = ricettario;
	}

	public void aggiungiBevanda(String nome, double consumoProCapite) {
		insiemeB.put(nome, consumoProCapite);
	}

	public void rimuoviBevanda(String nome) {
		if (insiemeB.containsKey(nome)) {
			insiemeB.remove(nome);
		}
		else System.out.println("La bevanda non e' presente nell'insieme");
	}

	public void aggiungiGenereExtra(String nome, double consumoProCapite) {
		insiemeGE.put(nome, consumoProCapite);
	}

	public void rimuoviGenereExtra(String nome) {
		if (insiemeGE.containsKey(nome)) {
			insiemeGE.remove(nome);
		}
		else System.out.println("Il genere extra non e' presente nell'insieme");
	}

	public Ricetta getRicetta(Piatto piatto) throws Exception {
		for (Ricetta ricetta : ricettario) {
			if (piatto.getDenominazione().equalsIgnoreCase(ricetta.getNome())) {
				return ricetta;
			}
		}
		throw new Exception("Ricetta non trovata");
	}

}
