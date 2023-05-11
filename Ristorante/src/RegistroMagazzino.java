import java.util.HashMap;

public class RegistroMagazzino {
	
	private HashMap<Merce, Integer> registro;
	private Giorno data;
	
	public RegistroMagazzino(HashMap<Merce, Integer> registro, Giorno data) {
		this.registro = registro;
		this.data = data;
	}

	public RegistroMagazzino(Giorno data) {
		this.registro = new HashMap<>();
		this.data = data;
	}

	public HashMap<Merce, Integer> getRegistro() {
		return registro;
	}

	public void setRegistro(HashMap<Merce, Integer> registro) {
		this.registro = registro;
	}

	public Giorno getData() {
		return data;
	}

	public void setData(Giorno data) {
		this.data = data;
	}
	
	public void acquistatiI (ListaSpesa lista) {
	//	registro.putAll(lista.getLista());
	}
	
}
