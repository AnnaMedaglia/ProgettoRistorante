package Ristorante;
import java.util.HashSet;

public class MenuTematico extends Menu {

	private static String tipoMT = "menu tematico";

	private String nome;
	private double caricoLavoroMenuT;

	public MenuTematico(String nome) {
		super(tipoMT);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
