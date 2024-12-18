package ejercicio3;

public class AppGestion {

		    static Producto[] inventario = new Producto[100];
		    static final int STOCK_SEGURIDAD = 50;
		    static int contadorProductos = 0;

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        int opcion;

		        do {
		            mostrarMenu();
		            opcion = scanner.nextInt();
		            scanner.nextLine(); // Consumir la línea en blanco

		            switch (opcion) {
		                case 1:
		                    rellenarInventario(scanner);
		                    break;
		                case 2:
		                    agregarProducto(scanner);
		                    break;
		                case 3:
		                    buscarYModificarProducto(scanner);
		                    break;
		                case 4:
		                    eliminarProducto(scanner);
		                    break;
		                case 5:
		                    mostrarValorTotalInventario();
		                    break;
		                case 6:
		                    mostrarInformeRoturaStock();
		                    break;
		                case 7:
		                    System.out.println("Saliendo del programa...");
		                    break;
		                default:
		                    System.out.println("Opción no válida. Intente de nuevo.");
		            }
		        } while (opcion != 7);

		        scanner.close();
		    }

		    public static void mostrarMenu() {
		        System.out.println("\n--- Menú de Gestión de Inventario ---");
		        System.out.println("1. Introducir datos nuevo inventario");
		        System.out.println("2. Nuevo producto");
		        System.out.println("3. Buscar producto y modificar información");
		        System.out.println("4. Eliminar producto");
		        System.out.println("5. Mostrar valor total del inventario");
		        System.out.println("6. Informe rotura de stock");
		        System.out.println("7. Salir");
		        System.out.print("Seleccione una opción: ");
		    }

		    public static void rellenarInventario(Scanner scanner) {
		        System.out.print("¿Cuántos productos desea añadir? ");
		        int cantidad = scanner.nextInt();
		        scanner.nextLine(); // Consumir la línea en blanco

		        if (cantidad + contadorProductos > inventario.length) {
		            System.out.println("No se pueden añadir tantos productos. Máximo permitido: " + inventario.length);
		            return;
		        }

		        for (int i = 0; i < cantidad; i++) {
		            System.out.println("Producto " + (i + 1) + ":");
		            System.out.print("Nombre: ");
		            String nombre = scanner.nextLine();
		            System.out.print("Stock: ");
		            int stock = scanner.nextInt();
		            System.out.print("Precio: ");
		            double precio = scanner.nextDouble();
		            scanner.nextLine(); // Consumir la línea en blanco

		            inventario[contadorProductos++] = new Producto(nombre, stock, precio);
		        }

		        System.out.println("Productos añadidos al inventario.");
		    }

		    public static void agregarProducto(Scanner scanner) {
		        if (contadorProductos >= inventario.length) {
		            System.out.println("No se pueden añadir más productos. Inventario lleno.");
		            return;
		        }

		        System.out.print("Nombre del producto: ");
		        String nombre = scanner.nextLine();
		        System.out.print("Stock: ");
		        int stock = scanner.nextInt();
		        System.out.print("Precio: ");
		        double precio = scanner.nextDouble();
		        scanner.nextLine(); // Consumir la línea en blanco

		        inventario[contadorProductos++] = new Producto(nombre, stock, precio);
		        System.out.println("Producto añadido correctamente.");
		    }

		    public static void buscarYModificarProducto(Scanner scanner) {
		        System.out.print("Ingrese el nombre del producto a buscar: ");
		        String nombre = scanner.nextLine();

		        for (int i = 0; i < contadorProductos; i++) {
		            if (inventario[i].nombre.equalsIgnoreCase(nombre)) {
		                System.out.println("Producto encontrado: " + inventario[i].nombre);
		                System.out.print("Nuevo stock: ");
		                inventario[i].stock = scanner.nextInt();
		                System.out.print("Nuevo precio: ");
		                inventario[i].precio = scanner.nextDouble();
		                scanner.nextLine(); // Consumir la línea en blanco
		                System.out.println("Información del producto actualizada.");
		                return;
		            }
		        }

		        System.out.println("Producto no encontrado.");
		    }

		    public static void eliminarProducto(Scanner scanner) {
		        System.out.print("Ingrese el nombre del producto a eliminar: ");
		        String nombre = scanner.nextLine();

		        for (int i = 0; i < contadorProductos; i++) {
		            if (inventario[i].nombre.equalsIgnoreCase(nombre)) {
		                for (int j = i; j < contadorProductos - 1; j++) {
		                    inventario[j] = inventario[j + 1];
		                }
		                inventario[--contadorProductos] = null;
		                System.out.println("Producto eliminado del inventario.");
		                return;
		            }
		        }

		        System.out.println("Producto no encontrado.");
		    }

		    public static void mostrarValorTotalInventario() {
		        double valorTotal = 0;

		        for (int i = 0; i < contadorProductos; i++) {
		            valorTotal += inventario[i].stock * inventario[i].precio;
		        }

		        System.out.println("El valor total del inventario es: $" + valorTotal);
		    }

		    public static void mostrarInformeRoturaStock() {
		        System.out.println("Productos con stock por debajo de " + STOCK_SEGURIDAD + ":");

		        for (int i = 0; i < contadorProductos; i++) {
		            if (inventario[i].stock < STOCK_SEGURIDAD) {
		                System.out.println("- " + inventario[i].nombre + ": " + inventario[i].stock + " unidades");
		            }
		        }
		    }
		}

	}

}
