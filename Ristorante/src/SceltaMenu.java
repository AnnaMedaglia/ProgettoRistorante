import java.util.HashSet;

public class SceltaMenu extends Scelta {
	
	private Menu menu;

    public SceltaMenu(Menu menu) {
        this.menu = menu;
    }
    
    public HashSet<Piatto> getPiatto() {
        return menu.getPiatto();
    }
}
