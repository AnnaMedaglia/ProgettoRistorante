import java.util.HashSet;
import java.util.TreeSet;

public class MenuTematico extends Menu {
	
	private String nome;
	private TreeSet<Periodo> durata;
	private double caricoLavoroMenuT;
	
	public MenuTematico(String nome, TreeSet<Periodo> durata) {
		super();
		this.nome = nome;
		this.creaElenco(); //creazione elenco vuoto per i piatti del menu tematico
		this.durata = durata;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TreeSet<Periodo> getDurata() {
		return durata;
	}

	public void setDurata(TreeSet<Periodo> durata) {
		this.durata = durata;
	}

	public double getCaricoLavoroMenuT() {
		return caricoLavoroMenuT;
	}

	public void setCaricoLavoroMenuT(HashSet<Piatto> elenco) {
		double temp = 0;
		for (Piatto piatto : elenco) {
			temp += piatto.getCaricoLavoro();
		};
		this.caricoLavoroMenuT = temp;
	} 
	
	
	
}
