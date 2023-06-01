package Ristorante;
import java.util.HashSet;

public abstract class Menu {

	protected String tipo;
	private HashSet<Piatto> elenco;
	
	
	public Menu(String tipo) {
		this.tipo = tipo;
		this.elenco =  new HashSet<>();
	}

	//getPiatto e non getElenco per poter sfruttare l'override 
	public HashSet<Piatto> getPiatto() { 
		return elenco;
	}

	public void setElenco(HashSet<Piatto> elenco) {
		this.elenco = elenco;
	}
}
