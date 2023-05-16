import java.util.HashMap;
import java.util.HashSet;

public class Prenotazione {
	
	private String cliente;
	private int numCoperti;
	private Giorno data;
	private HashMap<Scelta, Integer> elenco; 
	
	public Prenotazione(String cliente, int numCoperti, Giorno data) {
		this.cliente = cliente;
		this.numCoperti = numCoperti;
		this.data = data;
		this.elenco = new HashMap<>();
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNumCoperti() {
		return numCoperti;
	}

	public void setNumCoperti(int numCoperti) {
		this.numCoperti = numCoperti;
	}

	public Giorno getData() {
		return data;
	}

	public void setData(Giorno data) {
		this.data = data;
	}

	public HashMap<Scelta, Integer> getElenco() {
		return elenco;
	}
	
	public void setElenco(HashMap<Scelta, Integer> elenco) {
		this.elenco = elenco;
	}
	
	public void addScelta (Scelta scelta, int numPersone) {
		elenco.put(scelta, numPersone);
	}
	
	//ritorna il numero di Persone (= valore) dato il primo elemento della coppia 
	public int getNumeroPersone(Scelta ordine) {
        return elenco.get(ordine);
    }

	//ritorna la somma del numero dei piatti totali ordinati in una prenotazione → su questo va imposto il vincolo <= numCoperti
	public int ritornaNumPersone () {
		int temp = 0;
		for (Integer ordine : elenco.values()) {
			temp += ordine;
		}
		return temp;
	}
	
	
	//metodo che servirà per la lista della spesa relativa alla singola prenotazione
	public HashMap <Piatto, Integer> elencoPiatti () {
		HashMap<Piatto, Integer> conteggio = new HashMap<>();
        for (Scelta scelta : elenco.keySet()) {
            for (Piatto piatto : scelta.getPiatto()) {
                conteggio.put(piatto, conteggio.getOrDefault(piatto, 0) + elenco.get(scelta));
            }
        }
        return conteggio;
	}
	
}


