import java.util.HashSet;

public abstract class Extra extends Merce {
	
	//questo metodo vale sia per l'insieme delle Bevande, sia per quello dei generi Extra
			public static HashSet<Merce> creaListaExtraDaPrenotazione (Prenotazione prenotazione, HashSet<? extends Extra> insieme){
				HashSet<Merce> listaE = new HashSet<>();
				int num = prenotazione.getNumCoperti();
				for (Merce merce : insieme) {
					Merce daAggiungere = merce;
					daAggiungere.setDose((merce.getDose()*num));
					listaE.add(daAggiungere);
				}		
				return listaE;
			}
}
