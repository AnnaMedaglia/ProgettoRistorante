import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class RegistroMagazzino {

	private HashMap<String, PriorityQueue<ElementoMagazzino>> registro;

	public RegistroMagazzino() {
		this.registro = new HashMap<>();
	}


	public HashMap<String, PriorityQueue<ElementoMagazzino>> getRegistro() {
		return registro;
	}

	public void setRegistro(HashMap<String, PriorityQueue<ElementoMagazzino>> registro) {
		this.registro = registro;
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
	public void acquistatiI (Giornata giornata) {	
		//i prodotti comprati vanno inseriti nel magazzino
		for (ElementoMagazzino merce : giornata.getComprate()) {
			aggiungiMerce(merce.getMerce(), merce.getQuantità());
		}
	}

	//metodo richiamato per togliere merci dal registro magazzino
	public void togliMerce (String nomeMerce, double quantità) {
		//se il registro contiene la merce
		if (registro.containsKey(nomeMerce)) {
			//ottengo la codaMerce relativa a quella merce
			PriorityQueue<ElementoMagazzino> codaMerce = registro.get(nomeMerce);
			//devo aggiornare la quantità prelevando gli elementi a partire da quello che scade prima

			//se la coda non è vuota e la quantità del primo elemento è minore della quantità data (= non ci sono 
			//abbastanza merci di quella scadenza) allora continuo a prelevare elementi e a rimuoverli
			//dalla coda
			while (!codaMerce.isEmpty() && codaMerce.peek().getQuantità() <= quantità){
				codaMerce.poll();
			}

			//se la coda non è vuota e quindi c'è un elemento con quantità > della quantità da prelevare
			if (!codaMerce.isEmpty()) {
				ElementoMagazzino elemento = codaMerce.peek();
				//si setta la nuova quantità
				elemento.setQuantità(elemento.getQuantità() - quantità);
			} else { 
				//se la coda è vuota vuol dire che non ci sono più elementi con quel nome nel magazzino
				//quindi va rimossa anche l'etichetta che li rappresenta nella mappa
				registro.remove(nomeMerce);
			}
		}
	}

	//metodo che ritorna un hashmap di stringhe relative alle merci da togliere dal magazzino (per portarle nel ristorante) 
	//e le rispettive quantità
	public HashMap<String, Double> solo1Tipo(ListaSpesa listaSpesa, String tipo) {
		//inizializiamo una mappa che contenga solo gli ingredienti della lista della spesa
		HashMap<String, Double> solo1Tipo = new HashMap<>();
		//per ogni elemento nella lista della spesa
		for (String nomeMerce : listaSpesa.getLista().keySet()) {
			//otteniamo la relativa priorityqueue
			PriorityQueue<ElementoMagazzino> codaMerce = registro.get(nomeMerce);
			Merce trovata = codaMerce.peek().getMerce();
			//se la merce trovata è del tipo passato
			if (trovata.getTipo() == tipo) {
				//salviamo la quantità dalla lista della spesa
				double quantità = listaSpesa.getLista().get(nomeMerce);
				solo1Tipo.put(nomeMerce, quantità);
			}
		}
		return solo1Tipo;
	}

	public void inCucinaO (Giornata giornata) {
		//in cucina vanno portati gli ingredienti della lista della spesa relativi a quel giorno
		ListaSpesa listaSpesa = giornata.getDaComprare();

		HashMap<String, Double> soloIngredienti = solo1Tipo(listaSpesa, Ingrediente.getTipoI());

		//per ogni elemento di soloIngredienti applichi togli le merci dal magazzino
		for (String nomeIngrediente : soloIngredienti.keySet()) {
			//la quantità va moltiplicata per 1.1 perchè in cucina si deve portare il 10% in più 
			togliMerce(nomeIngrediente, soloIngredienti.get(nomeIngrediente) * 1.1);
		}			
	}

	public void extraO (Ristorante ristorante, Giornata giornata) {	
		//creiamo un unico insieme di elementi extra
		HashSet<Extra> extra = new HashSet<>(ristorante.getInsiemeB());
		extra.addAll(ristorante.getInsiemeGE());

		//per ogni elemento dell'insieme preleviamo la merce da portare in sala dal magazzino
		for (Extra elemento : extra) {
			togliMerce (elemento.getNome(), elemento.getConsumoProCapite() * giornata.numCopertiPrenotati());
		}
	}

	public void avanziI (HashMap<? extends Merce, Double> avanzi) {
		//per ogni merce avanzata, quindi non solo ingredienti, ma anche bevande e generi extra, li andiamo a rimettere nel registro magazzino
		for (Merce merceAvanzata : avanzi.keySet()) {
			aggiungiMerce(merceAvanzata, avanzi.get(merceAvanzata));
		}
	}

	public void scartiO (Giornata giornata) {
		for (String merce : registro.keySet()) {
			PriorityQueue<ElementoMagazzino> codaMerce = registro.get(merce);
			for (ElementoMagazzino elemento : codaMerce) {
				codaMerce.peek().getMerce().eScaduto(giornata.getGiorno()); //se scaduto setta la qualità a false
				if (!codaMerce.peek().getMerce().getQualita()) { //se è scaduto
					codaMerce.remove(elemento); //viene rimosso l'elemento dalla coda
				}

			}
			if (codaMerce.isEmpty()) { //se la coda è vuota = se non ci sono più elementi
				registro.remove(merce);//si rimuove la chiave dal registro
			}
		}
	}

}
