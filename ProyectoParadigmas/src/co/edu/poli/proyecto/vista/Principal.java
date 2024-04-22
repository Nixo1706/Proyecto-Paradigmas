package co.edu.poli.proyecto.vista;
import java.time.*;
import java.util.Scanner;

import co.edu.poli.proyecto.modelo.*;
import co.edu.poli.proyecto.servicios.*;
public class Principal {

    public Principal() {
    }

    public static void main(String [ ] args) {
        Scanner sc = new Scanner(System.in);
        ImpleOperacion operacion = new ImpleOperacion();
        OperacionArchivo operacionArchivo = new ImpleOperacionArchivo();
        
        System.out.println("Menú de reservas");
        while (true) {
        	System.out.println("Seleccione una opción:");
            System.out.println("1. Crear reserva");
            System.out.println("2. Eliminar reserva");
            System.out.println("3. Actualizar reserva");
            System.out.println("4. Leer reserva");
            System.out.println("5. Serealizar");
            System.out.println("6. Deserealizar");
            System.out.println("7. Salir");
            
            int opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
			case 1: {
				System.out.println("Crear reserva");
				Reserva reserva;
				reserva = crearReserva(sc);
				System.out.println(operacion.create(reserva));
				break;
			}
			case 2: {
				System.out.println("Eliminar reserva");
				System.out.println("Ingrese el ID de la reserva a eliminar:");
                int idEliminar = sc.nextInt();
                System.out.println(operacion.delete(idEliminar));
				break;
			}
			case 3: {
				System.out.println("Actualizar reserva:");
                System.out.println("Ingrese el ID de la reserva a actualizar:");
                int idActualizar = sc.nextInt();
                sc.nextLine(); 

                System.out.println("Ingrese los nuevos detalles de la reserva:");
                Reserva reservaActualizada;
                reservaActualizada = crearReserva(sc);
                if (reservaActualizada.getId() != idActualizar) {
                    System.out.println("No se puede cambiar el ID, asegúrate de digitar el mismo");
                    continue; 
                }
                operacion.update(idActualizar, reservaActualizada);
                System.out.println("Reserva actualizada: " + operacion.read(idActualizar));
				break;
			}
			case 4: {
				System.out.println("Leer reserva:");
                System.out.println("Ingrese el ID de la reserva:");
                int idLeer = sc.nextInt();
                Reserva reservaLeida = operacion.read(idLeer);
                if (reservaLeida != null) {
                    System.out.println("Transacción encontrada: " + reservaLeida);
                } else {
                    System.out.println("No se encontró la reserva con ID " + idLeer);
                }
				break;
			}
			case 5: {
				System.out.println("Serealizar");
            	operacionArchivo.serealizar(operacion.reservas, "", "file.txt");
                System.out.println("Reservas serializadas correctamente en 'file.txt'");
				break;
			}
			case 6: {
				System.out.println("Deserealizar");
            	Reserva[] reservasDeserializadas = operacionArchivo.deserealizar("", "file.txt");
                if (reservasDeserializadas != null) {
                    System.out.println("Reservas deserializadas correctamente:");
                    for (Reserva r : reservasDeserializadas) {
                        System.out.println(r);
                    }
                } else {
                    System.out.println("No se pudo deserializar ninguna reserva.");
                }
				break;
			}
			case 7: {
				System.out.println("Saliendo del programa...");
                sc.close();
                System.exit(0);
			}
			default:
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
			
		}
    }
    
    //Método auxiliar
    private static Reserva crearReserva(Scanner sc) {
    	System.out.println("Ingrese los detalles de la reserva: ");
    	System.out.println("Id: ");
    	int id = sc.nextInt();
    	sc.nextLine();
    	
    	System.out.println("Ingrese los detalles del laboratorio: ");
    	System.out.println("Salón: ");
    	String salon = sc.nextLine();
    	System.out.println("Cantidad de reservas: ");
    	int cantidadReservas = sc.nextInt();
    	sc.nextLine();
    	System.out.println("Capacidad de usuarios: ");
    	int cantidadUsuarios = sc.nextInt();
    	sc.nextLine();
    	
    	System.out.println("Ingrese los detalles del ususario: ");
    	System.out.println("Nombre: ");
    	String nombre = sc.nextLine();
    	System.out.println("Id: ");
    	int idUsuario = sc.nextInt();
    	sc.nextLine();
    	System.out.println("Correo: ");
    	String correo = sc.nextLine();
    	
    	System.out.println("Ingrese los detalles de la hora de la reserva: ");
    	System.out.println("Día: ");
    	int dia = sc.nextInt();
    	sc.nextLine();
    	System.out.println("Mes: ");
    	int mes = sc.nextInt();
    	sc.nextLine();
    	System.out.println("Hora (en formato HH:mm): ");
    	String horaStr = sc.nextLine();
    	LocalTime hora = LocalTime.parse(horaStr);
    	
    	Laboratorio laboratorio = new Laboratorio (salon, cantidadReservas, cantidadUsuarios);
    	Usuario reservaUsuario = new Usuario (nombre, idUsuario, correo);
    	TiempoReserva horaReserva = new TiempoReserva (dia, mes, hora);
    	return new Reserva (id, laboratorio, reservaUsuario, horaReserva);
    }
    //Actualización en todas las clases del paquete servicios, 
    //actualización en Laboratorio
    // se importó el Serializable en todas las clases del paquete modelo
}