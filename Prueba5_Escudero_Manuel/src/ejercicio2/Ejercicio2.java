package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		int zonaPrincipal = 1000;
		int zonaPlatea = 200;
		int zonaVip = 25;
		int cantidad = 0;
		int zona = 0;
		
		Scanner sc = new Scanner(System.in);

		int opcion = 0;
		
		do {
			System.out.println("1- Mostrar número de entradas libres");
			System.out.println("2- Vender entradas");
			System.out.println("3- Salir");
			System.out.println("Elige una opcion: ");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				System.out.println("Entradas disponibles: ");
				System.out.println("zona principal " + zonaPrincipal);
				System.out.println("Zona platea " + zonaPlatea);
				System.out.println("zona vip " + zonaVip);
				break;
			case 2:
				System.out.println("¿Para que zona quieres la entrada?: ");
				System.out.println("1- zona principal");
				System.out.println("2- Zona platea");
				System.out.println("3- zona vip");
				System.out.println("Elige una zona: ");
				zona = sc.nextInt();
				
				System.out.println("¿Cuantas entradas quieres?: ");
				cantidad = sc.nextInt();
				
				if (zona == 1) {
					zonaPrincipal -= cantidad;
					System.out.println("Venta realizada");
				}
			}
			if (zona == 2) {
				if (cantidad <= zonaPlatea) {
					zonaPlatea -= cantidad;
					System.out.println("Venta realizada");
				}
				}
			if (zona == 3) {
				if (cantidad <=zonaVip) {
					zonaVip -= cantidad;
					System.out.println("Venta realizada");
				}
				}
				
			break;
			
			}
		 while (opcion != 3);
		
	
		sc.close();
	}
}


