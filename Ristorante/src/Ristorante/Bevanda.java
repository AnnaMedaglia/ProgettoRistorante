package Ristorante;
import Prenotazioni.Giorno;

public class Bevanda extends Extra {

	private static String tipoB = "bevanda";
	private static String unitaMisuraB = "l";

	public Bevanda(String nome, double consumoProCapite) {
		super(nome, tipoB, unitaMisuraB, consumoProCapite);
	}

	public Bevanda (String nome, Giorno scadenza, double consumoProCapite) {
		super(nome, tipoB, unitaMisuraB, scadenza, consumoProCapite);
	}

}
