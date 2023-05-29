import java.util.HashSet;

public class SceltaPiatto extends Scelta {

	private HashSet<Piatto> piatti;

	public SceltaPiatto(HashSet<Piatto> piatti) {
		this.piatti = piatti;
	}

	public HashSet<Piatto> getPiatto() {
		return piatti;
	}

}
