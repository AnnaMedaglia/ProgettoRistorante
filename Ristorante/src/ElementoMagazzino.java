public class ElementoMagazzino {
	 
	private Merce merce;
	private double quantità;

	    public ElementoMagazzino(Merce merce, double quantità) {
	        this.merce = merce;
	        this.quantità = quantità;
	    }
    
	    public Merce getMerce() {
	        return merce;
	    }

	    public double getQuantità() {
	        return quantità;
	    }

		public void setMerce(Merce merce) {
			this.merce = merce;
		}

		public void setQuantità(double quantità) {
			this.quantità = quantità;
		}
	    
}
