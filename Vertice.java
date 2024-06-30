public class Vertice {
    private String nombre;
    private int numVertice;

    public Vertice(String x) {
        this.nombre = x;
        this.numVertice = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public void asigVert(int n) {
        this.numVertice = n;
    }
}
