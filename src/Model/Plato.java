/**
 * 
 */
package Model;

/**
 * @author Lenovo
 *
 */
public class Plato extends Servicio {

	/**
	 * 
	 */
	private int id;
	private String nombre;
	private int costo;
	private boolean habitacion;

	public Plato(int id, String nombre, int costo, boolean habitacion) {
		
		super(nombre, costo);
		
		this.id = id;
		this.habitacion = habitacion;
	}

	
	@Override
	public String toString() {
		String mensaje = "Comida [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", habitacion=" + habitacion;
		return mensaje += "]";
	}
}
