import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws GastoException {
		
		String DNI;
		String nombre;
		int edad;
		int userAction;
		Locale italy = new Locale("it", "IT");
	    NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);

		Scanner scanner = new Scanner(System.in);
		Usuario usuario = new Usuario();
		
		System.out.println("Introduce el nombre de usuario");
		nombre = scanner.nextLine();
		usuario.setNombre(nombre);
		System.out.println("Introduce la edad del usuario");
		edad = scanner.nextInt();
		usuario.setEdad(edad);
		scanner.nextLine();
		System.out.println("Introduce el DNI del usuario");
		DNI = scanner.nextLine();
		usuario.setDNI(DNI);
		
		// Este bucle comprueba el DNI y si es incorrecto llama a la función
		// para que el usuario lo introduzca de nuevo
		while(usuario.setDNI(DNI) == false) {
		System.out.println("El DNI introducido es incorrecto");
		System.out.println("Introduce el DNI Correcto");
		DNI = scanner.nextLine();
		usuario.setDNI(DNI);
		}
		
		Cuenta cuenta = new Cuenta(usuario);
		
		System.out.println("Usuario creado correctamente");

		userAction = 1;
		
		while (userAction !=0) {
			System.out.println("Realiza una nueva accion");
			System.out.println("1 Introduce un nuevo gasto");
			System.out.println("2 Introduce un nuevo ingreso");
			System.out.println("3 Mostrar gastos");
			System.out.println("4 Mostrar ingresos");
			System.out.println("5 Mostrar saldo");
			System.out.println("0 Salir");
			
			userAction = scanner.nextInt();
			
			// Utilizo un switch case para llamar a las funciones y leer los inputs del usuario

			switch(userAction) {
			
			case 1: 
				    // Si el usuario no introduce la cantidad del gasto en formato europeo, se captura la excepción y se le
				    // da la oportunidad de introducir la cantidad de nuevo.
					double gasto;
					String description;
					System.out.println("Introduce el concepto del gasto");
					description = scanner.next();
					scanner.nextLine();
					try {
					System.out.println("Introduce la cantidad");
					gasto = scanner.nextDouble();
					}catch(InputMismatchException ex) {
						System.out.println("Utiliza el formato decimal europeo");
						System.out.println("Introduce la cantidad de nuevo");
						scanner.nextLine();
						gasto = scanner.nextDouble();
						cuenta.addGastos(description, gasto);
						break;}
					cuenta.addGastos(description, gasto);
					break;
					
			case 2: 
				// Si el usuario no introduce la cantidad del ingreso en formato europeo, se captura la excepción y se le
			    // da la oportunidad de introducir la cantidad de nuevo.
					double ingreso;
					System.out.println("Introduce el concepto del ingreso");
					description = scanner.next();
					scanner.nextLine();
					try {
					System.out.println("Introduce la cantidad");
					ingreso = scanner.nextDouble();
					}catch(InputMismatchException ex) {
						System.out.println("Utiliza el formato decimal europeo");
						System.out.println("Introduce la cantidad de nuevo");
						scanner.nextLine();
						ingreso = scanner.nextDouble();
						cuenta.addIngresos(description, ingreso);
						break;}
					cuenta.addIngresos(description, ingreso);
					break;
				    
					
			case 3: 
					// Utilizo una variable String auxiliar para quitar los corchetes y espacios de la colección ademas de covertir
				    // decimales a formato europeo.
					String listgastos = cuenta.getGastos().toString().replace("[", "").replace("]", "").replace(".", ",").trim();
					System.out.println(listgastos);
					break;
			
			case 4:
				    // Utilizo una variable String auxiliar para quitar los corchetes y espacios de la colección ademas de covertir
			        // decimales a formato europeo.
					String listIngresos = cuenta.getIngresos().toString().replace("[", "").replace("]", "").replace(".", ",").trim();
					System.out.println(listIngresos);
					break;
					
			case 5: 
				    //utilizo la clase number format para parsear el double que devuelve el metodo cuenta.getSaldo y convertirlo a formato
				    //europeo
					System.out.println(nf.format(cuenta.getSaldo())+"€");
		
			}
		} 
		    System.out.println("Fin del programa." + "\nGracias por utilizar la aplicación");
	}
}



