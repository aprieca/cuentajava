
public class Gasto extends Dinero {
// Inicializamos el constructor con los parametros heredados de Dinero
	 public Gasto(double gasto, String description) {

		 super.dinero = gasto;
		 super.description = description;
		 
	 }
// Método to String
	@Override
	public String toString() {
		return "\nGasto "+ description+", "+"cantidad="+dinero+"€";
	}
	 
	 
	
}
