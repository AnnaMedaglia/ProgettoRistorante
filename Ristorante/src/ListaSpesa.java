import java.util.HashMap;
import java.util.HashSet;
public class ListaSpesa {
	
	private HashMap<Merce, Double> lista;
	
	public ListaSpesa(Giorno data) {
		this.lista = new HashMap<>();
	}
	
	public HashMap<Merce, Double> getLista() {
		return lista;
	}

	public void setLista(HashMap<Merce, Double> lista) {
		this.lista = lista;
	}

	public HashSet<Ingrediente> getIngredienti () {
		HashSet<Ingrediente> ingredienti = new HashSet<>();
		for (Merce merce : lista.keySet()) {
			if (merce instanceof Ingrediente) {
				ingredienti.add((Ingrediente) merce);
			}
		}
		return ingredienti;
	}
	
}
