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
	
	//per ogni merce della lista dei prodotti acquistati inseriamo nel registro la merce con la dose aggiornata
	public void acquistatiI (ListaSpesa lista) {
		for (Merce merce : lista.getLista()) {
			double daAggiungere = merce.getDose() + (0.1 * merce.getDose()); //consideriamo l'incremento 
			registro.put(merce, registro.getOrDefault(merce, 0.0) + daAggiungere);
		}
	}
	
	public void inCucinaO (ListaSpesa lista) {
		for (Merce ingrediente : lista.getIngredienti()) {
			double daTogliere = ingrediente.getDose() + (0.1 * ingrediente.getDose()); //consideriamo l'incremento
			registro.put(ingrediente, registro.getOrDefault(ingrediente, 0.0) - daTogliere);
		}
	}

	public void extraO () {
		
	}

}
