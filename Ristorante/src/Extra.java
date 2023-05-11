import java.util.HashSet;

public abstract class Extra extends Prodotto {
	
	//questo metodo vale sia per l'insieme delle Bevande, sia per quello dei generi Extra
		public HashSet<Merce> creaListaExtra (Prenotazione prenotazione, HashSet<Merce> insieme){
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
