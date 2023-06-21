package Utenti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import Magazzino.ElementoMagazzino;
import Magazzino.ListaSpesa;
import Magazzino.RegistroMagazzino;
import Prenotazioni.Giorno;
import Ristorante.Giornata;
import Ristorante.Merce;
import Ristorante.Ristorante;
import Util.InputDati;

public class Magazziniere extends Utente {

	private static String etichettaM = "magazziniere";
	private static String[] voci = {"Aggiungi al magazzino i prodotti acquistati", "Preleva dal magazzino gli ingredienti da portare in cucina",
			"Preleva bevande e generi extra da portare in sala", "Aggiungi al magazzino le merci inutilizzate", "Elimina dal magazzino gli scarti",
	"Genera lista della spesa per il prossimo giorno"};

	public Magazziniere(String nome) {
		super(nome, etichettaM, voci);
	}

	@Override
	public void eseguiMetodi(Ristorante ristorante, int scelta) {
		Giorno giornoCorrente = Giorno.ritornaGiornoCorrente();
		switch(scelta) {
		case 1: 
			aggiuntaProdottiAcquistati(ristorante);
			break;
		case 2:
			prelievoIngredientiPerCucina(giornoCorrente, ristorante);
			break;
		case 3:
			prelievoExtraPerTavoli(giornoCorrente, ristorante);
			break;
		case 4:
			aggiuntaMerciInutilizzati(ristorante);
			break;
		case 5:
			eliminazioneScarti(giornoCorrente, ristorante);
			break;
		case 6:
			generaListaSpesa(giornoCorrente, ristorante);
			break;
		}
	}


	public void aggiuntaProdottiAcquistati(Ristorante ristorante) {
		HashSet<ElementoMagazzino> comprati = elementiMagazzinoComprati();
		ristorante.getRegistroMagazzino().acquistatiI(comprati);
	}

	public HashSet<ElementoMagazzino> elementiMagazzinoComprati(){
		HashSet<ElementoMagazzino> comprati = new HashSet<>();
		
		String messaggioQuantita = "Inserisci quante merci hanno queste caratteristiche: ";
		String messaggioAltreMerci = "Vuoi aggiungere altre merci? ";
		
		boolean scelta = false;
		do {
			Merce merce = creaMerce();
			double quantita = InputDati.leggiDoubleConMinimo(messaggioQuantita, 0.0);
			
			ElementoMagazzino elemento = new ElementoMagazzino(merce, quantita);
			comprati.add(elemento);
			
			scelta = InputDati.yesOrNo(messaggioAltreMerci);
		} while (scelta);
		
		return comprati;
	}

	public void prelievoIngredientiPerCucina(Giorno giornoCorrente, Ristorante ristorante) {
		Giornata giornataCorrente = ristorante.getGiornata(giornoCorrente);
		ristorante.getRegistroMagazzino().inCucinaO(giornataCorrente);
	}

	public void prelievoExtraPerTavoli(Giorno giornoCorrente, Ristorante ristorante) {
		Giornata giornataCorrente = ristorante.getGiornata(giornoCorrente);
		ristorante.getRegistroMagazzino().extraO(ristorante, giornataCorrente);

	}

	public void aggiuntaMerciInutilizzati(Ristorante ristorante) {
		HashMap<Merce, Double> avanzi = new HashMap<>();
		
		String messaggioQuantita = "Inserisci quante merci hanno queste caratteristiche: ";
		String messaggioAltreMerci = "Vuoi aggiungere altre merci? ";
		
		boolean scelta = false;
		do {
			Merce merce = creaMerce();
			double quantita = InputDati.leggiDoubleConMinimo(messaggioQuantita, 0.0);
			
			avanzi.put(merce, quantita);
			
			scelta = InputDati.yesOrNo(messaggioAltreMerci);
		} while (scelta);
		
		ristorante.getRegistroMagazzino().avanziI(avanzi);
	}

	public Merce creaMerce() {
		String messaggioNome = "Inserisci il nome della merce: ";
		String messaggioUnitaMisura = "Inserisci l'unita' di misura della merce: ";
		String messaggioScadenza = "Inserisci la scadenza della merce: ";
		String messaggioTipo = "Inserire il tipo della merce [ingrediente/bevanda/genere extra]: ";
		String messaggioConsumoProCapite = "Inserire il consumo pro capite: ";
		String messaggioErrTipo = "ATTENZIONE! Il tipo inserito non è valido. Riprovare";

		String nomeMerce = InputDati.leggiStringaNonVuota(messaggioNome);
		String unitaMisura = InputDati.leggiStringaNonVuota(messaggioUnitaMisura);
		System.out.println(messaggioScadenza);
		Giorno scadenza = Giorno.richiestaCreaGiorno();

		String tipo = "";
		boolean controllo = false;
		do {
			tipo = InputDati.leggiStringaNonVuota(messaggioTipo);

			if (tipo != "ingrediente" || tipo != "bevanda" || tipo != "genere extra") {
				controllo = true;
				System.out.println(messaggioErrTipo);
			}
		} while (controllo);

		double consumoProCapite = 0.0;
		if (tipo == "bevanda" || tipo == "genere extra") {
			consumoProCapite = InputDati.leggiDoubleConMinimo(messaggioConsumoProCapite, 0.0);
		}

		return Merce.creaMerceDaTipo(nomeMerce, tipo, unitaMisura, scadenza, consumoProCapite);
	}
	
	public void eliminazioneScarti(Giorno giornoCorrente, Ristorante ristorante) {
		Giornata giornataCorrente = ristorante.getGiornata(giornoCorrente);
		Merce merceNonDiQualita = dichiarazioneMerceDeteriorata();
		ristorante.getRegistroMagazzino().setFalseQualitaMerce(merceNonDiQualita);
		ristorante.getRegistroMagazzino().scartiO(giornataCorrente);
	}
	
	public Merce dichiarazioneMerceDeteriorata() {
		String messaggioDichiarazione = "Definisci la merce deteriorata: ";
		
		System.out.println(messaggioDichiarazione);
		return creaMerce();
	}
	

	public void generaListaSpesa(Giorno giornoCorrente, Ristorante ristorante) {
		Giornata giornataCorrente = ristorante.getGiornata(giornoCorrente);
		RegistroMagazzino registroMagazzino = ristorante.getRegistroMagazzino();
		giornataCorrente.creaListaSpesa(ristorante);
		ListaSpesa lista = giornataCorrente.getDaComprare(); 
		for (String nome : lista.getLista().keySet()) {
			if (registroMagazzino.getRegistro().containsKey(nome)) {
				double effettivoDaComprare = (lista.getLista().get(nome)*1.1) - (registroMagazzino.ritornaQuantitaDatoNome(nome));
				lista.getLista().put(nome, effettivoDaComprare);
			} else {
				lista.getLista().put(nome, lista.getLista().get(nome) * 1.1);
			}
		}
	}
}
