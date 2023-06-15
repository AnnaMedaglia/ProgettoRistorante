package Ristorante;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import Prenotazioni.Giorno;
import Util.InputDati;
import Util.ServizioFile;

public class Ristorante {

	private String nome;
	private int caricoLavoroPersona;
	private int numPosti;
	private double caricoLavoroRistorante; 
	private TreeSet<Giornata> calendario;
	private HashMap<String, Double> insiemeGE;
	private HashMap<String, Double> insiemeB;
	private HashSet<Ricetta> ricettario;
	private HashSet<Piatto> piatti;
	private HashSet<MenuTematico> menuTematici;

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
		this.piatti = new HashSet<>();
		this.menuTematici = new HashSet<>();
	}

	public Ristorante(String nome) {
		this.nome = nome;
	}

	public static Ristorante accessoRistorante() {
		String messaggioNome = "Inserisci il nome del ristorante: ";
		
		String percorsoCartellaApp = System.getProperty("user.dir");
		String nome = InputDati.leggiStringaNonVuota(messaggioNome);
		
		ServizioFile.accediFile(percorsoCartellaApp, nome);

		return new Ristorante(nome);
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
	
	public Giornata getGiornata (Giorno giorno) {
		for (Giornata giornata : calendario) {
			if (giornata.getGiorno().equals(giorno)) {
				return giornata;
			}
		}
		return null;
	}

	public HashMap<String, Double> getInsiemeGE() {
		return insiemeGE;
	}

	public void setInsiemeGE(HashMap<String, Double> insiemeGE) {
		this.insiemeGE = insiemeGE;
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

	public HashMap<String, Double> getInsiemeB() {
		return insiemeB;
	}

	public void setInsiemeB(HashMap<String, Double> insiemeB) {
		this.insiemeB = insiemeB;
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
	public HashSet<Ricetta> getRicettario() {
		return ricettario;
	}

	public void setRicettario(HashSet<Ricetta> ricettario) {
		this.ricettario = ricettario;
	}

	public void aggiungiRicetta(Ricetta ricetta) {
		this.ricettario.add(ricetta);
	}

	public HashSet<Piatto> getPiatti() {
		return piatti;
	}

	public void setPiatti(HashSet<Piatto> piatti) {
		this.piatti = piatti;
	}

	public void aggiungiPiatto(Piatto piatto) {
		this.piatti.add(piatto);
	}

	public HashSet<MenuTematico> getMenuTematici() {
		return menuTematici;
	}

	public void setMenuTematici(HashSet<MenuTematico> menuTematici) {
		this.menuTematici = menuTematici;
	}
	
	public void aggiungiMenuTematico (MenuTematico menu) {
		this.menuTematici.add(menu);
	}

}
