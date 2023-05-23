import java.util.HashMap;
import java.util.HashSet;
public class ListaSpesa {
	
	private HashMap<String, Double> lista;
	
	public ListaSpesa(Giorno data) {
		this.lista = new HashMap<>();
	}
	
	public HashMap<String, Double> getLista() {
		return lista;
	}

	public void setLista(HashMap<String, Double> lista) {
		this.lista = lista;
	}

	/*public HashSet<String> getIngredienti () {
		HashSet<String> ingredienti = new HashSet<>();
		for (String merce : lista.keySet()) {
			if (merce instanceof Ingrediente) {
				ingredienti.add(merce);
			}
		}
		return ingredienti;
	}
*/	
}
