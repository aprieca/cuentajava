import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	
	// Declaro variables e inicio los Arraylist.
	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos = new ArrayList<>();
	private List<Ingreso> ingresos = new ArrayList<>();
	
	public Cuenta(Usuario usuario) {
		this.saldo = 0;
		this.usuario = usuario;
	}
	
	
	public double getSaldo() {
		
		return this.saldo;
		
	}
	
	public void setSaldo(double saldo) {
		
		this.saldo = saldo;
		
	}
	
	public Usuario getUsuario() {
		
		return usuario;
		
	}
	
	public void setUsuario(Usuario usuario) {
		
		this.usuario = usuario;
	}
	
	public double addIngresos (String description, double cantidad) {
		
		ingresos.add(new Ingreso(cantidad, description));
		this.saldo += cantidad;
		return saldo;
	}
	// Función para añadir gastos al arraylist, si el saldo es menor que el gasto
	// que se quiere añadir, lanza la excepción gasto exception.
	public double addGastos (String description, double cantidad) throws GastoException {
		
		try {
		
		if(this.saldo < cantidad) {
			
			throw new GastoException();
		}
		
		else {
		
		gastos.add(new Gasto(cantidad, description));
		this.saldo -= cantidad;
		
		}
		
		}
		
		catch(GastoException ex) {
			
			System.out.println("El gasto es mayor que el saldo disponible");
		}
		
		return saldo;
			

	}
	
	public List<Ingreso> getIngresos() {
		
		return ingresos;
	}
	
	public List<Gasto> getGastos() {
		
		return gastos;
	}


	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", usuario=" + usuario + ", \ngastos=" + getGastos() + ", \ningresos=" + getIngresos()
				+ "]";
	}
	
	
}
