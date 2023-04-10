
package proyecto_tower_defense;


public class NodoCam { // Nodo para los caminos
    
    Tropa dato;
    NodoCam back;
    NodoCam next;
    

    public NodoCam() {
        this.dato = null;
        this.back = null;
        this.next = null;
    }

    public NodoCam getBack() {
        return back;
    }

    public void setBack(NodoCam back) {
        this.back = back;
    }

    public Tropa getDato() {
        return dato;
    }

    public void setDato(Tropa dato) {
        this.dato = dato;
    }

    public NodoCam getNext() {
        return next;
    }

    public void setNext(NodoCam next) {
        this.next = next;
    }
    
    
}
