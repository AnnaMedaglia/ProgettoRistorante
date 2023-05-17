import java.util.HashMap;
import java.util.HashSet;

public class RegistroMagazzino {
	
	private HashMap<Merce, Double> registro;
	private Giornata giornata;
	
	

	public RegistroMagazzino(Giornata giornata) {
		this.registro = new HashMap<>();
		this.giornata = giornata;
	}

	public HashMap<Merce, Double> getRegistro() {
		return registro;
	}

	public void setRegistro(HashMap<Merce, Double> registro) {
		this.registro = registro;
	}

	
	public Giornata getGiornata() {
		return giornata;
	}

	public void setGiornata(Giornata giornata) {
		this.giornata = giornata;
	}

	//per ogni merce della lista dei prodotti acquistati inseriamo nel registro la merce con la dose aggiornata
	public void acquistatiI () {
		ListaSpesa lista = giornata.getDaComprare();
		for (Merce merce : lista.getLista()) {
			double daAggiungere = merce.getDose() + (0.1 * merce.getDose()); //consideriamo l'incremento 
			registro.put(merce, registro.getOrDefault(merce, 0.0) + daAggiungere);
		}
	}
	
	public void inCucinaO () {
		//facciamo riferimento alla lista della spesa della giornata perchè i prodotti vengono acquistati giorno per giorno 
		//e quindi quelli portati in cucina sono per forza quelli comprati per quella giornata
		ListaSpesa lista = giornata.getDaComprare();
		for (Merce ingrediente : lista.getIngredienti()) {
			double daTogliere = ingrediente.getDose() + (0.1 * ingrediente.getDose()); //consideriamo l'incremento
		
			//POX MODIFICA
			//ingrediente2 = ingrediente che scade prima tra tutti gli ingredienti nel registro a parità di nome
			//registro.put(ingrediente2 ...)
			
			registro.put(ingrediente, registro.getOrDefault(ingrediente, 0.0) - daTogliere);
		}
	}

	public void extraO (Ristorante ristorante) {
		HashSet<Bevanda> bevande = ristorante.getInsiemeB();
		HashSet<GenereExtra> generiExtra= ristorante.getInsiemeGE();
		
		for (Bevanda bev : bevande) {
			registro.put(bev, registro.getOrDefault(bev, 0.0) - giornata.numCopertiPrenotati());
		}
		
		for (GenereExtra gen : generiExtra) {
			registro.put(gen, registro.getOrDefault(gen, 0.0) - giornata.numCopertiPrenotati());
		}
	}
	
	public void avanziI (HashSet<Ingrediente> avanzi) {
		for (Ingrediente ingr : avanzi) {
			registro.put(ingr, registro.getOrDefault(ingr, 0.0) + ingr.getDose());
		}
	}
	
	public void scartiO () {
		Giorno giornoAttuale = giornata.getGiorno();
		for (Merce merce : registro.keySet()) {
			if (!merce.èScaduto(giornoAttuale)) { //se è scaduto
				registro.put(merce, registro.getOrDefault(merce, 0.0)-1);
			}
		}
	}

}
