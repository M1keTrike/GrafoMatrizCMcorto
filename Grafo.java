import java.util.*;

public class Grafo {
   
    Vertice[] listaVertices;
    private int[][] matrizAdyacencia;

    public Grafo(int cantidadVertices) {
        matrizAdyacencia = new int[cantidadVertices][cantidadVertices];
        listaVertices = new Vertice[cantidadVertices];

        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                matrizAdyacencia[i][j] = 0; // inicia la matriz en ceros
            }
        }
    }

    public void agregarVertice(String etiqueta, int numero) {
        Vertice nuevoVertice = new Vertice(etiqueta);
        nuevoVertice.asigVert(numero);
        listaVertices[numero] = nuevoVertice;
    }

    public void agregarAristas() {
        Scanner entrada = new Scanner(System.in);
        int origen, destino, opcion, peso;
        do {
            for (int i = 0; i < listaVertices.length; i++) {
                System.out.println((i + 1) + ") " + listaVertices[i].getNombre());
            }
            System.out.println("Ingresa el vértice origen");
            origen = entrada.nextInt();
            System.out.println("Ingrese el valor del destino");
            destino = entrada.nextInt();
            System.out.println("Ingrese el peso de la arista");
            peso = entrada.nextInt();
            matrizAdyacencia[origen - 1][destino - 1] = peso;
            System.out.println("Agregar más aristas: 1) Sí\t2) No");
            opcion = entrada.nextInt();
        } while (opcion == 1);
    }

    public void imprimir() {
        System.out.println("Matriz de adyacencia");
        System.out.println();
        System.out.print("  ");
        for (int k = 0; k < listaVertices.length; k++) {
            System.out.print(listaVertices[k].getNombre() + " ");
        }
        System.out.println();
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            System.out.print(listaVertices[i].getNombre() + " ");
            for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getNumeroVertices() {
        return this.listaVertices.length;
    }

    public int[][] getMatrizAdyacencia() {
        return this.matrizAdyacencia;
    }
}
