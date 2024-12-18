package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca una frase: ");
		String frase = sc.nextLine().trim();

		if (frase.isEmpty()) {
			System.out.println("La frase está vacía.");
			return;
		}

		String[] palabras = frase.split("\\s+");
		int cantidadPalabras = palabras.length;
		System.out.println("Cantidad de palabras: " + cantidadPalabras);

		String palabraMayor = "";
		String palabraMenor = "";
		int maxLongitud = 0;
		int minLongitud = Integer.MAX_VALUE;

		for (String palabra : palabras) {
			int longitud = palabra.length();
			if (longitud > maxLongitud) {
				maxLongitud = longitud;
				palabraMayor = palabra;
			}
			if (longitud < minLongitud) {
				minLongitud = longitud;
				palabraMenor = palabra;
			}
		}

		System.out.println("Palabra de mayor longitud: " + palabraMayor + " (" + maxLongitud + " caracteres)");
		System.out.println("Palabra de menor longitud: " + palabraMenor + " (" + minLongitud + " caracteres)");
	}
}
