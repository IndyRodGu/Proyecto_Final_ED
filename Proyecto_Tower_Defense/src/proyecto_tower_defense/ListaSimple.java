/* Clase ListaSimple con un atributo cabeza que apunta al primer nodo de la 
lista, Si la lista está vacía, cabeza es None*/
package proyecto_tower_defense;
 
public class ListaSimple {
    private Nodo cabeza;

    // Constructor de la clase ListaSimple
    public ListaSimple() {
        cabeza = null; // La lista está vacía al inicio
    }

    // Método para agregar un nuevo nodo al final de la lista
    public void agregar(Tropa dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
 // Si la lista está vacía, el nuevo nodo se convierte en la cabeza de la lista
            cabeza = nuevoNodo;
        } else {
            // Recorremos la lista hasta encontrar el último nodo y agregamos el nuevo nodo al final
            Nodo nodoActual = cabeza;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
    }

    // Método para extraer y eliminar el primer nodo de la lista
    public Object extraer() {
        if (cabeza == null) {
    // Si la lista está vacía, devolvemos null
            return null;
        }
        Object valor = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        return valor;
    }
}

