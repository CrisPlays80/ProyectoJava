package proyect;

class Nodo {
    public Aerogenerador aero;
    public Nodo siguiente;

    public Nodo(Aerogenerador aero) {
        this.aero = aero;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void agregarElemento(Aerogenerador aero) {
        Nodo nuevoNodo = new Nodo(aero);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo nodoActual = cabeza;
            while (nodoActual.siguiente != null) {
                nodoActual = nodoActual.siguiente;
            }
            nodoActual.siguiente = nuevoNodo;
        }
    }

    public void imprimirLista() {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            System.out.print(nodoActual.aero + " ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.println();
    }

}
