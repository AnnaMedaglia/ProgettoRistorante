import java.util.HashSet;

public class Ricetta {
	
	private String nome;
	private HashSet<Ingrediente> ingredienti; 
	private int numPorzioni;
	private double caricoLavoroPorzione;
	
	public Ricetta(String nome, int numPorzioni, double caricoLavoroPorzione) {
		this.nome = nome;
		this.ingredienti = new HashSet<>();
		this.numPorzioni = numPorzioni;
		this.caricoLavoroPorzione = caricoLavoroPorzione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HashSet<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(HashSet<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
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
		public static Ricetta trovaRicetta(Piatto piatto, HashSet<Ricetta> ricettario) {
			Ricetta trovata;
			String nome = piatto.getDenominazione();
			for (Ricetta ric : ricettario) {
				if (ric.getNome()==nome) {
					trovata = ric;
					return trovata;
				}
			}
			System.out.println("Non esiste una ricetta con questo nome");
			return null;
		}
	
}
