import java.util.HashSet;

public abstract class Extra extends Merce {
	
	private double consumoProCapite; 
	
	public double getConsumoProCapite() {
		return consumoProCapite;
	}

	public void setConsumoProCapite(double consumoProCapite) {
		this.consumoProCapite = consumoProCapite;
	}

			//questo metodo vale sia per l'insieme delle Bevande, sia per quello dei generi Extra
			public static HashSet<Merce> creaListaExtraDaPrenotazione (Prenotazione prenotazione, HashSet<? extends Extra> insieme){
				HashSet<Merce> listaExtra = new HashSet<>();
				
				int num = prenotazione.getNumCoperti();
				
				for (Merce merce : insieme) {
					merce.setDose((merce.getDose()*num));
					listaExtra.add(merce);
				}		
				
				return listaExtra;
			}
}
