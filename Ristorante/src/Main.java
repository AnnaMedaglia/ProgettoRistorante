
public class Main {

	public static void main(String[] args) {
		
		String nome = "patate";
		String unitàMisura = "hg";
		double dose = 1.0;
		Giorno scadenza = new Giorno(null);
		
		Ingrediente ingr = new Ingrediente(nome, scadenza, dose);
		ingr.setUnitàMisura(unitàMisura);
		
		System.out.printf("nome: %s\ntipo: %s\nunità di misura: %s\nqualità: %s", ingr.getNome(), ingr.getTipo(), ingr.getUnitàMisura(), ingr.getQualità());
	}

}
