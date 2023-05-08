public class MenuCarta extends Menu {
	
	private Giorno data;

	public MenuCarta(Giorno data) {
		super();
		this.creaElenco();
		this.data = data;
	}

	public Giorno getData() {
		return data;
	}

	public void setData(Giorno data) {
		this.data = data;
	}
	
	
}
