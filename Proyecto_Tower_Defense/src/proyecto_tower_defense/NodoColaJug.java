/* Nodo utilizado para la gestion de la Cola de tropas del CPU */

package proyecto_tower_defense;

public class NodoColaJug {
        
    private NodoColaJug siguiente;
    int qtyTropa;

    public NodoColaJug(NodoColaJug atras, int qtyTropa) {
        this.siguiente = siguiente;
        this.qtyTropa = qtyTropa;
    }

    public NodoColaJug getsiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoColaJug atras) {
        this.siguiente = siguiente;
    }

    public int getQtyTropa() {
        return qtyTropa;
    }

    public void setQtyTropa(int qtyTropa) {
        this.qtyTropa = qtyTropa;
    }
}
