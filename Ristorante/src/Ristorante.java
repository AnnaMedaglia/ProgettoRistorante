import java.util.HashSet;

public class Ristorante {
	
	private String nome;
	private int caricoLavoroPersona;
	private int numPosti;
	private double caricoLavoroRistorante; 
	private HashSet<GenereExtra> insiemeGE;
	private HashSet<Bevanda> insiemeB;
	
	//costruttore
	public Ristorante(String nome, int caricoLavoroPersona, int numPosti, double caricoLavoroRistorante) {
		this.nome = nome;
		this.caricoLavoroPersona = caricoLavoroPersona;
		this.numPosti = numPosti;
		this.caricoLavoroRistorante = caricoLavoroRistorante;
		this.insiemeGE = new HashSet<>();
		this.insiemeB = new HashSet<>();
	}
	
}
