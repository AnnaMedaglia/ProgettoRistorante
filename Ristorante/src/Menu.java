import java.util.HashSet;

public abstract class Menu {
	
	protected String tipo;
	private HashSet<Piatto> elenco;
	
	//getPiatto e non getElenco per poter sfruttare l'override 
	public HashSet<Piatto> getPiatto() { 
		return elenco;
	}

	public void setElenco(HashSet<Piatto> elenco) {
		this.elenco = elenco;
	}
	
	public void creaElenco() {
		this.elenco = new HashSet<>();
	}

	public void addPiatto(HashSet<Piatto> insieme, Piatto piatto) {
		insieme.add(piatto);
	}

	public void removePiatto(HashSet<Piatto> insieme, Piatto piatto) {
		insieme.remove(piatto);
	}

	public boolean contains(HashSet<Piatto> insieme, Piatto piatto) {
		return insieme.contains(piatto);
	}

}
