import java.util.HashSet;

public class Ristorante {

	private String nome;
	private int caricoLavoroPersona;
	private int numPosti;
	private double caricoLavoroRistorante; 
	private HashSet<GenereExtra> insiemeGE;
	private HashSet<Bevanda> insiemeB;

	//costruttore
	public Ristorante(String nome, int caricoLavoroPersona, int numPosti) {
		this.nome = nome;
		this.caricoLavoroPersona = caricoLavoroPersona;
		this.numPosti = numPosti;
		this.caricoLavoroRistorante = 0;
		this.insiemeGE = new HashSet<>();
		this.insiemeB = new HashSet<>();
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

	public void setCaricoLavoroRistorante(double caricoLavoroPersona, int numPosti) {
		double temp = caricoLavoroPersona * numPosti;
		this.caricoLavoroRistorante = (0.2 * temp) + temp;
	}

	public HashSet<GenereExtra> getInsiemeGE() {
		return insiemeGE;
	}
	
	public HashSet<Bevanda> getInsiemeB() {
		return insiemeB;
	}

	

}
