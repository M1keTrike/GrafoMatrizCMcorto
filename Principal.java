import java.util.Scanner;

public class Principal {
    public static void main(String[] args) { 
        Scanner entrada = new Scanner(System.in);
        int cantidad;

        System.out.println("Indica la cantidad de vertices del grafo");
        cantidad= entrada.nextInt();
        Grafo grafo = new Grafo(cantidad);
        for(int i=0; i<cantidad;i++){
            System.out.println("Ingrese el valor del vertice");
            grafo.agregarVertice(entrada.next(), i);
        }
        grafo.agregarAristas();
        grafo.imprimir();
    }
}
