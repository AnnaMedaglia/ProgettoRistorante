import java.time.LocalDate;

public class Giorno extends Periodo {
		
	private LocalDate giorno;
	
	public Giorno(LocalDate giorno) {
		super (giorno, giorno);
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
}
