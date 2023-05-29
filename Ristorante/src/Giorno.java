import java.time.LocalDate;

public class Giorno {
		
	private LocalDate giorno;
		
	public Giorno(LocalDate giorno) {
		this.giorno = giorno;
	}

	public LocalDate getGiorno() {
		return giorno;
	}

	public void setGiorno(LocalDate giorno) {
		this.giorno = giorno;
	}
	
	public boolean contains (LocalDate data, LocalDate inizio, LocalDate fine) {
        return (data.isEqual(inizio) || data.isAfter(inizio)) &&
               (data.isEqual(fine) || data.isBefore(fine));
    }
	
	public int confrontoScadenza(Giorno giorno2) {
		return giorno.compareTo(giorno2.getGiorno()); //negativo se giorno scade prima di giorno2,	
													  //positivo se giorno scade dopo giorno2, 
												   	  //0 se sono lo stesso giorno
    }
}
