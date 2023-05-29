public class GenereExtra extends Extra {

	protected static String tipoGE = "genere extra";
	private static String unitaMisuraGE = "hg";
	
	public GenereExtra(String nome, double consumoProCapite) {
		super(nome, tipoGE, unitaMisuraGE, consumoProCapite);
	}
		
	public GenereExtra (String nome, Giorno scadenza, double consumoProCapite) {
		super(nome, tipoGE, unitaMisuraGE, scadenza, consumoProCapite);
	}

	
}
