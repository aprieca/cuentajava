
public class Ingreso extends Dinero {
// Inicializamos el constructor con los parametros heredados de Dinero
	 public Ingreso(double ingreso, String description) {
		 
		 super.dinero = ingreso;
		 super.description = description; 
	 }
	 
// Metodo to String
	@Override
	public String toString() {
		return "\nIngreso "+ description+", "+"cantidad="+dinero+"€";
	}

}
