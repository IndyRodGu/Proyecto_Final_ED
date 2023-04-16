/* Nodo utilizado para la gestion de la Cola de tropas del CPU */

package proyecto_tower_defense;

public class Nodo {
    private Tropa tropa; 
    private Nodo siguiente;
    private Object dato; // Dato que almacena el nodo
    
    //int qtyTropa;

    public Nodo(Tropa tropa) {
        this.tropa = tropa;
        this.siguiente = null;
        //this.qtyTropa = qtyTropa;
    }
    // Constructor Objeto Dato
    public Nodo(Nodo siguiente, Object dato) {
        this.siguiente = null; // El nodo esta vacio al inicio
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
    
    public Object getDato() {
        return dato;
    }
    
    public Tropa getTropa() {
        return tropa;
    }

    public void setSiguiente(Nodo atras) {
        this.siguiente = siguiente;
    }
  
    public void setDato(Object dato) {
        this.dato = dato;
    }
    
    public void setTropa(Tropa tropa) {
        this.tropa = tropa;
    }
        
//    public int getQtyTropa() {
//        return qtyTropa;
//    }
//
//    public void setQtyTropa(int qtyTropa) {
//        this.qtyTropa = qtyTropa;
//    }

}
