import java.time.LocalDate;

public class Progetto {
	
	LocalDate inizio;
	LocalDate fine;
	
	public Progetto(LocalDate inizio, LocalDate fine) {
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
