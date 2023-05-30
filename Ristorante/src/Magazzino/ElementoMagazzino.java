package Magazzino;
import Ristorante.Merce;

public class ElementoMagazzino {

	private Merce merce;
	private double quantita;

	public ElementoMagazzino(Merce merce, double quantita) {
		this.merce = merce;
		this.quantita = quantita;
	}

	public Merce getMerce() {
		return merce;
	}

	public double getQuantita() {
		return quantita;
	}

	public void setMerce(Merce merce) {
		this.merce = merce;
	}

	public void setQuantita(double quantita) {
		this.quantita = quantita;
	}

}
