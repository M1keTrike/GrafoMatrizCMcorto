public class CaminoMinimo {
    int[][] pesos;
    int[] ultimo; // array de predecesores
    int[] D; // array de distancias mínimas
    int s, n; // vértice origen y número de vértices
    boolean[] F;

    public CaminoMinimo(Grafo g, int origen) {
        n = g.getNumeroVertices(); // Obtiene el número de vértices del grafo
        s = origen;
        pesos = new int[n][n];
        // Copiar matriz de adyacencia
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pesos[i][j] = g.getMatrizAdyacencia()[i][j];
            }
        }; // Copia de la matriz de adyacencia del grafo
        ultimo = new int[n];
        D = new int[n];
        F = new boolean[n];
    }

    void Dijkstra() {
        // valores iniciales
        for (int i = 0; i < n; i++) {
            F[i] = false;
            D[i] = pesos[s][i] == 0 ? Integer.MAX_VALUE : pesos[s][i];
            if (D[i] != Integer.MAX_VALUE) {
                ultimo[i] = s;
            } else {
                ultimo[i] = -1;
            }
        }
        // Marca origen e inicializa distancia
        F[s] = true;
        D[s] = 0;

        // Pasos para marcar los n-1 vértices
        for (int i = 1; i < n; i++) {
            int v = minimo();
            if (v == -1) break; // Si no se encuentra un vértice válido, se sale del bucle
            F[v] = true;

            // actualiza distancia de vértices no marcados
            for (int w = 0; w < n; w++) {
                if (!F[w] && pesos[v][w] != 0 && D[v] + pesos[v][w] < D[w]) {
                    D[w] = D[v] + pesos[v][w];
                    ultimo[w] = v;
                }
            }
        }
    }

    public int minimo() {
        int mx = Integer.MAX_VALUE;
        int v = -1;
        for (int j = 0; j < n; j++) {
            if (!F[j] && D[j] < mx) {
                mx = D[j];
                v = j;
            }
        }
        return v;
    }

    public void imprimirResultados() {
        System.out.println("Distancias mínimas desde el vértice " + s + ":");
        for (int i = 0; i < n; i++) {
            System.out.print("Vértice " + i + ": " + (D[i] == Integer.MAX_VALUE ? "∞" : D[i]));
            System.out.print(" Camino: ");
            imprimirCamino(i);
            System.out.println();
        }
    }

    public void imprimirCamino(int destino) {
        if (destino == s) {
            System.out.print(s);
            return;
        }
        if (ultimo[destino] == -1) {
            System.out.print("No hay camino");
            return;
        }
        imprimirCamino(ultimo[destino]);
        System.out.print(" -> " + destino);
    }
}
