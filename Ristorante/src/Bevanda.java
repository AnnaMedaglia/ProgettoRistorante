public class Bevanda extends Extra {

	private static String tipoB = "bevanda";
	private static String unitàMisuraB = "l";
	
	public Bevanda(String nome, double consumoProCapite) {
		super(nome, tipoB, unitàMisuraB, consumoProCapite);
	}
	
	public Bevanda (String nome, Giorno scadenza, double consumoProCapite) {
		super(nome, tipoB, unitàMisuraB, scadenza, consumoProCapite);
	}

}
