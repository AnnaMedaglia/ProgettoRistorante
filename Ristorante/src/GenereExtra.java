public class GenereExtra extends Extra {

	protected static String tipoGE = "genere extra";
	private static String unitàMisuraGE = "hg";
	
	public GenereExtra(String nome, double consumoProCapite) {
		super(nome, tipoGE, unitàMisuraGE, consumoProCapite);
	}
		
	public GenereExtra (String nome, Giorno scadenza, double consumoProCapite) {
		super(nome, tipoGE, unitàMisuraGE, scadenza, consumoProCapite);
	}

	
}
