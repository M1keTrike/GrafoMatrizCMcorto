import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidad = 0;
        String nombre = "";

        try {
            do {
                System.out.println("Indica la cantidad de vértices del grafo:");
                while (!entrada.hasNextInt()) {
                    System.out.println("Debes ingresar un número entero.");
                    entrada.next(); // limpiar el buffer del scanner
                }
                cantidad = entrada.nextInt();
            } while (cantidad <= 0);

            entrada.nextLine(); // limpiar el buffer del scanner

        } catch (InputMismatchException e) {
            System.out.println("Debes ingresar un número entero válido.");
            System.exit(1);
        }

        Grafo grafo = new Grafo(cantidad);

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingresa el nombre del vértice " + (i + 1) + ":");
            boolean nombreValido = false;
            do {
                nombre = entrada.nextLine();
                if (!nombre.matches("[a-zA-Z]+")) {
                    System.out.println("Debes ingresar un nombre válido (solo letras).");
                } else {
                    nombreValido = true;
                }
            } while (!nombreValido);

            grafo.agregarVertice(nombre, i);
        }

        grafo.agregarAristas();
        grafo.imprimir();

        System.out.println("Ingrese el vértice origen para calcular el camino mínimo:");
        int origen = 0;
        boolean origenValido = false;
        do {
            while (!entrada.hasNextInt()) {
                System.out.println("Debes ingresar un número entero.");
                entrada.next(); // limpiar el buffer del scanner
            }
            origen = entrada.nextInt();
            if (origen < 1 || origen > cantidad) {
                System.out.println("El vértice origen debe estar dentro del rango válido.");
            } else {
                origenValido = true;
            }
        } while (!origenValido);

        entrada.close();

        calcularCostoViaje(grafo);
    }

    private static void calcularCostoViaje(Grafo grafo) {
        Scanner entrada = new Scanner(System.in);
        CaminoMinimo caminoMinimo;

        int continuar = 0, actual, destino, dinero;

        do {
            System.out.println("Ingrese su ubicación actual: ");
            // grafo.imprimirVertices();
            actual = entrada.nextInt();
            System.out.println("Ingrese su destino: ");
            destino = entrada.nextInt();
            System.out.println("Ingrese su presupuesto: ");
            dinero = entrada.nextInt();
            caminoMinimo = new CaminoMinimo(grafo, actual - 1);
            caminoMinimo.Dijkstra();
            caminoMinimo.imprimirResultados();

            int[] caminosMDesdeActual = caminoMinimo.getRutasCortas();
            if (caminosMDesdeActual[destino - 1] < dinero) {
                System.out.println("\nEl dinero es suficiente para realizar el viaje");
            } else {
                System.out.println("\nEl dinero es insuficiente para realizar el viaje");
            }

            System.out.println("Desea hacer otro presupuesto?: 1)Si 2)No");
            continuar = entrada.nextInt();

        } while (continuar == 1);

        System.out.println("\nIngrese la cantidad de dinero: ");

        entrada.close();

    }
}
