/* Nodo utilizado para la gestion de la Cola de tropas del CPU*/

package proyecto_tower_defense;

public class NodoColaCPU {
    private Tropa tropa;
    private NodoColaCPU siguiente;
    
    public NodoColaCPU (Tropa tropa){
        this.tropa = tropa;
        this.siguiente = null;
    }

    public Tropa getTropa() {
        return tropa;
    }

    public void setTropa(Tropa tropa) {
        this.tropa = tropa;
    }

    public NodoColaCPU getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoColaCPU siguiente) {
        this.siguiente = siguiente;
    }
    
}
