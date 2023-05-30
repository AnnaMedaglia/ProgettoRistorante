package Util;
import java.util.Scanner;

public class Interazioni {

	private static Scanner lettore = creaScanner();

	private static Scanner creaScanner ()
	{
		Scanner creato = new Scanner(System.in);
		creato.useDelimiter(System.getProperty("line.separator"));
		return creato;
	}
	public static void richiesta(String nomeParamRichiesto) {
		System.out.printf("Inserire: %s", nomeParamRichiesto);
	}


}
