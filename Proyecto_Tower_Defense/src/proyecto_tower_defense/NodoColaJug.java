/* Nodo utilizado para la gestion de la Cola de tropas del CPU */

package proyecto_tower_defense;

public class NodoColaJug {
    private Tropa tropa;    
    private NodoColaJug siguiente;
    //int qtyTropa;

    public NodoColaJug(Tropa tropa) {
        this.tropa = tropa;
        this.siguiente = null;
        //this.qtyTropa = qtyTropa;
    }

    public NodoColaJug getsiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoColaJug atras) {
        this.siguiente = siguiente;
    }
    
    public Tropa getTropa() {
        return tropa;
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
