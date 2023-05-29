import java.util.HashMap;
import java.util.HashSet;

public abstract class Extra extends Merce {

	private double consumoProCapite; 

	//costruttore per inizializzare gli attributi
	public Extra(String nome, String tipo, String unitaMisura, double consumoProCapite) {
		super (nome, tipo, unitaMisura);
		this.consumoProCapite = consumoProCapite;
	}

	public Extra(String nome, String tipo, String unitaMisura, Giorno scadenza, double consumoProCapite) {
		super (nome, tipo, unitaMisura, scadenza);
		this.consumoProCapite = consumoProCapite;
	}

	public double getConsumoProCapite() {
		return consumoProCapite;
	}

	public void setConsumoProCapite(double consumoProCapite) {
		this.consumoProCapite = consumoProCapite;
	}

	//questo metodo vale sia per l'insieme delle Bevande, sia per quello dei generi Extra
	public static HashMap<String, Double> creaListaExtraDaPrenotazione (Prenotazione prenotazione, HashSet<? extends Extra> insieme){
		HashMap<String, Double> listaExtra = new HashMap<>();		
		int num = prenotazione.getNumCoperti(); 

		for (Extra extra : insieme) {
			listaExtra.put(extra.getNome(), num*extra.getConsumoProCapite());
		}

		return listaExtra;	
	}
}
