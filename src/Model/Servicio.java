package Model;

public class Servicio {

	
		private String nombre;
		protected double costo;
		
		
		
		
		public Servicio(String nombre, double costo) {
			
			this.nombre = nombre;
			this.costo = costo;
		}
		
		
		public double getCosto() {
			return this.costo;
		}
		
		public String getNombre() {
			return this.nombre;
		}


		public void setCosto(double nuevoCosto) {
			this.costo = nuevoCosto;
		}
}
