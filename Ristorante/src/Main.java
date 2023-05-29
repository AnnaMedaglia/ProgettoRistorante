
public class Main {

	public static void main(String[] args) {
		
		String nome = "patate";
		String unitaMisura = "hg";
		double dose = 1.0;
		Giorno scadenza = new Giorno(null);
		
		Ingrediente ingr = new Ingrediente(nome, scadenza, dose);
		ingr.setUnitaMisura(unitaMisura);
		
		System.out.printf("nome: %s\ntipo: %s\nunita' di misura: %s\nqualita': %s", ingr.getNome(), ingr.getTipo(), ingr.getUnitaMisura(), ingr.getQualita());
	}

}
