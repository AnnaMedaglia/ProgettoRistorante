import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class RegistroMagazzino {
	
	private HashMap<String, PriorityQueue<ElementoMagazzino>> registro;

 	private Giornata giornata;
	
	

	public RegistroMagazzino(Giornata giornata) {
		this.registro = new HashMap<>();
		this.giornata = giornata;
	}

	
	public HashMap<String, PriorityQueue<ElementoMagazzino>> getRegistro() {
		return registro;
	}

	public void setRegistro(HashMap<String, PriorityQueue<ElementoMagazzino>> registro) {
		this.registro = registro;
	}

	public Giornata getGiornata() {
		return giornata;
	}

	public void setGiornata(Giornata giornata) {
		this.giornata = giornata;
	}
	
	public void aggiungiMerce(Merce merce, double quantità) {
		String nomeMerce = merce.getNome();

        if (registro.containsKey(nomeMerce)) {
            PriorityQueue<ElementoMagazzino> codaMerce = registro.get(nomeMerce);

            // Controllo se esiste un elemento con la stessa scadenza
            for (ElementoMagazzino elemento : codaMerce) {
                if (elemento.getMerce().getScadenza().equals(merce.getScadenza())) {
                    // Aggiorno la quantità se la scadenza è la stessa
                    elemento.setQuantità(elemento.getQuantità() + quantità);
                    return;
                }
            }
            // Se non esiste un elemento con la stessa scadenza, aggiungo un nuovo elemento nella coda
            ElementoMagazzino nuovoElemento = new ElementoMagazzino(merce, quantità);
            codaMerce.add(nuovoElemento); //il vincolo sulla scadenza è rispettato per default
        } else {
            // Se la merce non è ancora presente nel magazzino, creo una nuova coda e aggiungo il primo elemento
            PriorityQueue<ElementoMagazzino> nuovaCoda = new PriorityQueue<>((em1, em2) -> em1.getMerce().getScadenza().confrontoScadenza(em2.getMerce().getScadenza()));
            ElementoMagazzino nuovoElemento = new ElementoMagazzino(merce, quantità);
            nuovaCoda.add(nuovoElemento);
            registro.put(nomeMerce, nuovaCoda);
        }
    }

	//per ogni merce della lista dei prodotti acquistati inseriamo nel registro la merce con la dose aggiornata
	public void acquistatiI () {
		ListaSpesa lista = giornata.getDaComprare();
		for (Merce merce : lista.getLista()) {
			aggiungiMerce(merce, merce.getDose());
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
