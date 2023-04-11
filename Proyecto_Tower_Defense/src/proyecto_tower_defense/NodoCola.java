/* Nodo utilizado para la gestion de la Cola de tropas del CPU */

package proyecto_tower_defense;

public class NodoCola {
    private Tropa tropa; 
    private NodoCola siguiente;
    //int qtyTropa;

    public NodoCola(Tropa tropa) {
        this.tropa = tropa;
        this.siguiente = null;
        //this.qtyTropa = qtyTropa;
    }

    public NodoCola getsiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola atras) {
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
