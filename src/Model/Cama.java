package Model;

public class Cama {
	private int capacidad;
	private boolean ninio;
	
	public Cama(String entrada) {
		
		String ultimo = entrada.substring(entrada.length()-1);
		
		if (ultimo.compareTo("n") == 0) {
			this.ninio = true;
			String cap = entrada.substring(0,entrada.length()-1);
			this.capacidad = Integer.parseInt(cap);
			
		} else {
			this.ninio = false;
			this.capacidad = Integer.parseInt(entrada);
		}
		
	}
	
	
	public int getCantidad() {
		return this.capacidad;
	}

	
	public boolean getNinio() {
		return this.ninio;
	}
	
	
	@Override
	public String toString() {
		return "Comida [capacidad=" + capacidad + ", ninio=" + ninio + "]";
	}

}
