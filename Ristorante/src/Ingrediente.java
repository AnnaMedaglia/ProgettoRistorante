import java.util.HashMap;
import java.util.HashSet;

public class Ingrediente extends Merce {

	private String tipoI = "ingrediente";
	
	public Ingrediente(){
		super();
		this.tipo = tipoI;
	}

	//servirà per la lista della spesa
	public static HashSet<Merce> creaListaIngredientiDaPrenotazione (Prenotazione prenotazione, HashSet<Ricetta> ricettario){
		HashSet<Merce> listaIngredientiNoDuplicati = new HashSet<>();
		
		HashMap<Piatto, Integer> elencoPiatti= prenotazione.elencoPiatti();
		
		// per ogni piatto di elencoPiatti va trovata la Ricetta associata
		for (Piatto piatto : elencoPiatti.keySet()) {
			Ricetta ricetta = Ricetta.trovaRicetta(piatto, ricettario);
			
			HashSet<Ingrediente> ingredienti = ricetta.getIngredienti(); // dalla ricetta ricaviamo l'elenco di ingredienti (e quindi anche le dosi)
			int numPorzioniRicetta = ricetta.getNumPorzioni(); // dalla ricetta ricaviaamo quante porzioni soddisfa
			int coefficiente = (int) Math.ceil((double) prenotazione.elencoPiatti().get(piatto) / numPorzioniRicetta); //coef. che va moltiplicato per ogni ingrediente
			
			for (Ingrediente ingrediente : ingredienti) {
				ingrediente.setDose(coefficiente * ingrediente.getDose());
			} // così abbiamo la lista degli ingredienti di una ricetta con le dosi aggiornate
			
			//andiamo a eliminare i duplicati dalla lista ingredienti
			Merce.gestioneDuplicati(listaIngredientiNoDuplicati, ingredienti);
		}
		return listaIngredientiNoDuplicati;
	}
	
}
