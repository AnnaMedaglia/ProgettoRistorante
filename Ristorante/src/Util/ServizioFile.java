package Util;
import java.io.*;


public class ServizioFile
{
	
	private final static String MSG_SUCCESSO = "Il file è stato creato con successo ";
	private static final String MSG_ESISTE = "ATTENZIONE: il file esiste già ";
	private static final String MSG_NO_CREAZIONE = "ATTENZIONE: si è verificato un errore durante la creazione del file ";
	private final static String MSG_NO_FILE = "ATTENZIONE: non trovo il file ";
	private final static String MSG_NO_LETTURA = "ATTENZIONE: problemi con la lettura del file ";
	private final static String MSG_NO_SCRITTURA = "ATTENZIONE: problemi con la scrittura del file ";
	private final static String MSG_NO_CHIUSURA ="ATTENZIONE: problemi con la chiusura del file ";


	public static void creaFile(String nomeFile) {
		try {
			File file = new File(nomeFile+".txt");
			if (file.createNewFile()) {
				System.out.println(MSG_SUCCESSO);
			} else {
				System.out.println(MSG_ESISTE);
			}
		} catch (IOException e) {
			System.out.println(MSG_NO_CREAZIONE);
			e.printStackTrace();
		}
	}

	public static Object caricaSingoloOggetto (File f){
		Object letto = null;
		ObjectInputStream ingresso = null;

		try{
			ingresso = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));

			letto = ingresso.readObject();

		}
		catch (FileNotFoundException excNotFound){
			System.out.println(MSG_NO_FILE + f.getName() );
		}
		catch (IOException excLettura) {
			System.out.println(MSG_NO_LETTURA + f.getName() );
		}
		catch (ClassNotFoundException excLettura) {
			System.out.println(MSG_NO_LETTURA + f.getName() );
		}
		finally {
			if (ingresso != null) {
				try {
					ingresso.close();
				}
				catch (IOException excChiusura) {
					System.out.println(MSG_NO_CHIUSURA + f.getName() );
				}
			}
		} // finally

		return letto;

	} // metodo caricaSingoloOggetto


	public static void salvaSingoloOggetto (File f, Object daSalvare) {
		ObjectOutputStream uscita = null;

		try {
			uscita = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));

			uscita.writeObject(daSalvare);

		}
		catch (IOException excScrittura) {
			System.out.println(MSG_NO_SCRITTURA + f.getName() );
		}

		finally {
			if (uscita != null) {
				try {
					uscita.close();
				}
				catch (IOException excChiusura) {
					System.out.println(MSG_NO_CHIUSURA + f.getName() );
				}
			}
		} // finally

	} // metodo salvaSingoloOggetto


}

