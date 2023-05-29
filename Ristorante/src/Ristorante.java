import java.util.HashSet;
import java.util.TreeSet;

public class Ristorante {

	private String nome;
	private int caricoLavoroPersona;
	private int numPosti;
	private double caricoLavoroRistorante; 
	private TreeSet<Giornata> giornata;
	private HashSet<GenereExtra> insiemeGE;
	private HashSet<Bevanda> insiemeB;
	private HashSet<Ricetta> ricettario;

	//costruttore
	public Ristorante(String nome, int caricoLavoroPersona, int numPosti) {
		this.nome = nome;
		this.caricoLavoroPersona = caricoLavoroPersona;
		this.numPosti = numPosti;
		this.caricoLavoroRistorante = (0.2 * (caricoLavoroPersona * numPosti)) + (caricoLavoroPersona * numPosti);
		this.giornata = new TreeSet<>();
		this.insiemeGE = new HashSet<>();
		this.insiemeB = new HashSet<>();
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

	public TreeSet<Giornata> getGiornata() {
		return giornata;
	}

	public void setGiornata(TreeSet<Giornata> giornata) {
		this.giornata = giornata;
	}

	public HashSet<GenereExtra> getInsiemeGE() {
		return insiemeGE;
	}

	public void setInsiemeGE(HashSet<GenereExtra> insiemeGE) {
		this.insiemeGE = insiemeGE;
	}


	public HashSet<Bevanda> getInsiemeB() {
		return insiemeB;
	}

	public void setInsiemeB(HashSet<Bevanda> insiemeB) {
		this.insiemeB = insiemeB;
	}

	public HashSet<Ricetta> getRicettario() {
		return ricettario;
	}

	public void setRicettario(HashSet<Ricetta> ricettario) {
		this.ricettario = ricettario;
	}


}
