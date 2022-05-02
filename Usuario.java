public class Usuario {
	
	private String nombre;
	private int edad;
	private String DNI;
	
	public Usuario() {
		
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	public int getEdad() {
		
		return edad;
	}
	
	public void setEdad(int edad) {
		
		this.edad = edad;
	}
	
	public String getDNI() {
		
		return DNI;
	}
	
	//M�todo para comprobar el DNI con un regex y asignarlo si es v�lido
	//La expresi�n tiene en cuenta si la letra es may�scula o min�cula o
	//el gui�n.
	
	public boolean setDNI(String DNI) {
		
		if (DNI.matches("(\\d{8})(-?)([a-zA-Z]{1})$")) {
			
			this.DNI = DNI;
			return true;
		}
		
		else {
			return false;
		}
							
	}
	//M�todo to String
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + "]";
	}
	
	
	
	
	
	
}
