/* Nodo utilizado para la gestion de la Cola de tropas del CPU */

package proyecto_tower_defense;

public class Nodo {
    private Tropa tropa; 
    private Nodo siguiente;
    
  
    public Nodo(Tropa tropa) {
        this.tropa = tropa;
        this.siguiente = null;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
 
    public Tropa getTropa() {
        return tropa;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
  
    public void setTropa(Tropa tropa) {
        this.tropa = tropa;
    }
        

}
