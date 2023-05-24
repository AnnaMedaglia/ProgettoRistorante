import java.util.HashMap;
import java.util.HashSet;

public class Ingrediente extends Merce {

	private static String tipoI = "ingrediente";
	private double dose; 
	
	public Ingrediente(String nome, String unitàMisura, double dose){
		super(nome, tipoI, unitàMisura);
		this.dose = dose;
	}
	
	public Ingrediente (String nome, Giorno scadenza, double dose) {
		super(nome, tipoI, scadenza);
		this.dose = dose;
	}

	public double getDose() {
		return dose;
	}

	public void setDose(double dose) {
		this.dose = dose;
	}
	

	//servirà per la lista della spesa
	public static HashMap<String, Double> creaListaIngredientiDaPrenotazione (Prenotazione prenotazione, HashSet<Ricetta> ricettario){
		HashMap<String,Double> listaIngredientiNoDuplicati = new HashMap<>();
		
		// per ogni piatto è associato il numero di persone che l'ha ordinato
		HashMap<Piatto, Integer> elencoPiatti= prenotazione.elencoPiatti(); 
		
		// per ogni piatto di elencoPiatti va trovata la Ricetta associata
		for (Piatto piatto : elencoPiatti.keySet()) {
			Ricetta ricetta = Ricetta.trovaRicetta(piatto, ricettario);
			
			// dalla ricetta ricaviamo l'elenco di ingredienti (e quindi anche le dosi di ogni ingrediente per una ricetta)
			HashMap<String,Double> ingredienti = ricetta.getIngredienti(); 
			
			// dalla ricetta ricaviaamo quante porzioni soddisfa
			int numPorzioniRicetta = ricetta.getNumPorzioni(); 
			//coef. che va moltiplicato per ogni ingrediente
			int coefficiente = (int) Math.ceil((double) prenotazione.elencoPiatti().get(piatto) / numPorzioniRicetta); 
			
			
			for (String ingrediente : ingredienti.keySet()) {
				ingredienti.put(ingrediente, ingredienti.get(ingrediente) * coefficiente);
			} // così abbiamo la lista degli ingredienti di una ricetta con le dosi aggiornate
			
			//andiamo a eliminare i duplicati dalla lista ingredienti
			Merce.gestioneDuplicati(listaIngredientiNoDuplicati, ingredienti);
		}
		return listaIngredientiNoDuplicati;
	}
	
}
