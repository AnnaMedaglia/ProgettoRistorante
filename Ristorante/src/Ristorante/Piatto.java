package Ristorante;

import java.util.HashSet;

import Prenotazioni.SceltaPrenotazione;

public class Piatto implements SceltaPrenotazione{

	private String nome;
	private double caricoLavoro;
	private Periodo validita;

	public Piatto(String nome, double caricoLavoro) {
		this.nome = nome;
		this.caricoLavoro = caricoLavoro;
		this.validita = new Periodo();
	}

	@Override
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCaricoLavoro() {
		return caricoLavoro;
	}

	public void setCaricoLavoro(double caricoLavoro) {
		this.caricoLavoro = caricoLavoro;
	}

	public Periodo getValidita() {
		return validita;
	}

	public void setValidita(Periodo validita) {
		this.validita = validita;
	}
	
	public static Piatto trovaPiattoDaNome(String piatto, HashSet<Piatto> piatti) {
		for (Piatto p : piatti) {
			if (p.getNome().equals(piatto)) {
				return p;
			}
		}
		// Se il piatto non viene trovato si ritorna null
		throw null;
	}

	@Override
	public HashSet<Piatto> getPiatti() {
		HashSet<Piatto> piatti = new HashSet<Piatto>();
		piatti.add(this);
		return piatti;
	}

	
}
