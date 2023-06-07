import Ristorante.Ristorante;
import Utenti.Gestore;

public class Main {

	public static void main(String[] args) {

		Ristorante rist = Ristorante.creaRistorante();
		Gestore gest1 = new Gestore("Gennaro");
		gest1.verificaEsistenzaRicetta(rist);
		
	}

}
