import java.util.HashMap;

public class RegistroMagazzino {
	
	private HashMap<Merce, Double> registro;
	private Giorno data;
	
	public RegistroMagazzino(Giorno data) {
		this.registro = new HashMap<>();
		this.data = data;
	}

	public HashMap<Merce, Double> getRegistro() {
		return registro;
	}

	public void setRegistro(HashMap<Merce, Double> registro) {
		this.registro = registro;
	}

	public Giorno getData() {
		return data;
	}

	public void setData(Giorno data) {
		this.data = data;
	}
	
	public void acquistatiI (ListaSpesa lista) {
		for (Merce merce : lista.getLista()) {
			registro.put(merce, registro.getOrDefault(merce, (double) 0) + merce.getDose());
		}
	}
	

}
