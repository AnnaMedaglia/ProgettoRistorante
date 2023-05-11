import java.util.HashMap;
import java.util.HashSet;

public class Ingrediente extends Prodotto {

	private String tipoI = "ingrediente";
	
	public Ingrediente(){
		super();
		this.tipo = tipoI;
	}

	public Merce trovaMerceDaNome(HashSet<Ingrediente> insieme, String nome){
		Merce trovata;
		for(Merce merce : insieme) {
			if (merce.getNome()==nome) {
				trovata = merce;
				return trovata;
			}
		}
	return null;
	}
	
	//servirà per la lista della spesa
	public HashSet<Merce> creaListaIngredientiDa (Prenotazione prenotazione, HashSet<Ricetta> ricettario){
		HashSet<Merce> listaI = new HashSet<>();
		HashMap <Piatto, Integer> piatti = prenotazione.elencoPiatti(); //sappiamo quali piatti nelle rispettive quantità
		for (Piatto piatto : piatti.keySet()) { //per ogni piatto valutiamo il nome
			Ricetta ricetta = piatto.trovaRicetta(piatto, ricettario); // vediamo se esiste una ricetta associata
			HashSet<Ingrediente> ingredienti = ricetta.getIngredienti(); // dalla ricetta ricaviamo l'elendo di ingredienti (e quindi anche le dosi)
			int numPorzioniRicetta = ricetta.getNumPorzioni(); // dalla ricetta ricaviaamo quante porzioni soddisfa
			int coefficiente = (int) Math.ceil((double) prenotazione.elencoPiatti().get(piatto) / ricetta.getNumPorzioni()); //coef. che va moltiplicato per ogni ingrediente
			for (Ingrediente ingrediente : ingredienti) {
				ingrediente.setDose(coefficiente * ingrediente.getDose());
			} // così abbiamo la lista degli ingredienti con le dosi aggiornate
			
			//dobbiamo inserire la lista degli ingredienti ottenuta nella listaI → va fatto il controllo dei duplicati
			for (Ingrediente ing : ingredienti) {
				Merce merceTrovata = trovaMerceDaNome(ingredienti, ing.getNome());
				if (listaI.contains(merceTrovata)) { // se listaI contiene il nome dell'ingrediente va aggiornato il numero della quantità
					Ingrediente daModificare = ing;
					double doseIniziale = merceTrovata.getDose();
					daModificare.setDose(doseIniziale+ing.getDose());
				} // se listaI non contiene l'ingrediente si aggiunge così com'è 
				listaI.add(ing);
			}
		}
		return listaI;
	}
	
}
