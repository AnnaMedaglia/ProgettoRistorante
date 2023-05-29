public class Gestore extends Utente{

	private static String etichettaG = "gestore";

	public Gestore(String nome) {
		super(nome, etichettaG);
	}
	
	public Ristorante creazioneRistorante() {
		Ristorante ristorante = new Ristorante();
	}
	
}
