package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	private static final int CAPACIDAD_PRINCIPAL = 1000;
	private static final int CAPACIDAD_PLATEA = 200;
	private static final int CAPACIDAD_VIP = 25;

	private int entradasPrincipal;
	private int entradasPlatea;
	private int entradasVip;

	public ConcertSala() {
	        this.entradasPrincipal = CAPACIDAD_PRINCIPAL;
	        this.entradasPlatea = CAPACIDAD_PLATEA;
	        this.entradasVip = CAPACIDAD_VIP;
	    }

	public void mostrarEntradasLibres() {
		System.out.println("Entradas disponibles:");
		System.out.println("Zona principal: " + entradasPrincipal);
		System.out.println("Zona platea: " + entradasPlatea);
		System.out.println("Zona VIP: " + entradasVip);
	}

	public void venderEntradas(String zona, int cantidad) {
		switch (zona.toLowerCase()) {
		case "principal":
			if (cantidad <= entradasPrincipal) {
				entradasPrincipal -= cantidad;
				System.out.println("Se han vendido " + cantidad + " entradas para la zona principal.");
			} else {
				System.out.println("No hay suficientes entradas disponibles en la zona principal.");
			}
			break;

		case "platea":
			if (cantidad <= entradasPlatea) {
				entradasPlatea -= cantidad;
				System.out.println("Se han vendido " + cantidad + " entradas para la zona platea.");
			} else {
				System.out.println("No hay suficientes entradas disponibles en la zona platea.");
			}
			break;

		case "vip":
			if (cantidad <= entradasVip) {
				entradasVip -= cantidad;
				System.out.println("Se han vendido " + cantidad + " entradas para la zona VIP.");
			} else {
				System.out.println("No hay suficientes entradas disponibles en la zona VIP.");
			}
			break;

		default:
			System.out.println("Zona no válida. Por favor, elija entre 'principal', 'platea' o 'VIP'.");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ConcertSala sala = new ConcertSala();

		int opcion;

		do {
			System.out.println("\n--- Menú ---");
			System.out.println("1. Mostrar número de entradas libres");
			System.out.println("2. Vender entradas");
			System.out.println("3. Salir");
			System.out.print("Elija una opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer

			switch (opcion) {
			case 1:
				sala.mostrarEntradasLibres();
				break;

			case 2:
				System.out.print("¿Para qué zona desea las entradas (principal, platea, VIP)?: ");
				String zona = scanner.nextLine();
				System.out.print("¿Cuántas entradas desea?: ");
				int cantidad = scanner.nextInt();
				scanner.nextLine(); // Limpiar el buffer
				sala.venderEntradas(zona, cantidad);
				break;

			case 3:
				System.out.println("Gracias por usar el sistema de gestión de entradas.");
				break;

			default:
				System.out.println("Opción no válida. Por favor, elija una opción del 1 al 3.");
			}

		} while (opcion != 3);

		scanner.close();
	}
}
