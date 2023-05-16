import java.util.HashSet;
public class ListaSpesa {
	
	private HashSet<Merce> lista;
	
	public ListaSpesa(Giorno data) {
		this.lista = new HashSet<>();
	}


	public HashSet<Merce> getLista() {
		return lista;
	}

	public void setLista(HashSet<Merce> lista) {
		this.lista = lista;
	}
	
	public HashSet<Ingrediente> getIngredienti () {
		HashSet<Ingrediente> ingredienti = new HashSet<>();
		for (Merce merce : lista) {
			if (merce instanceof Ingrediente) {
				ingredienti.add((Ingrediente) merce);
			}
		}
		return ingredienti;
	}
	
}
