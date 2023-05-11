import java.util.HashSet;
public class ListaSpesa {
	
	private Giorno data;
	private HashSet<Merce> lista;
	
	public ListaSpesa(Giorno data) {
		this.data = data;
		this.lista = new HashSet<>();
	}

	public Giorno getData() {
		return data;
	}

	public void setData(Giorno data) {
		this.data = data;
	}

	public HashSet<Merce> getLista() {
		return lista;
	}

	public void setLista(HashSet<Merce> lista) {
		this.lista = lista;
	}
	
	
	
	
}
