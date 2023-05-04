import java.time.LocalDate;

public class Periodo {
	
	LocalDate inizio;
	LocalDate fine;
	
	public Periodo(LocalDate inizio, LocalDate fine) {
		this.inizio = inizio;
		this.fine = fine;
	}
	
	public LocalDate getInizio() {
		return inizio;
	}
	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}
	public LocalDate getFine() {
		return fine;
	}
	public void setFine(LocalDate fine) {
		this.fine = fine;
	}
	
	

}
