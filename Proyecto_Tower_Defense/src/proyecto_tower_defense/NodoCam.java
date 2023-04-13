
package proyecto_tower_defense;


public class NodoCam { // Nodo para los caminos
    
    Tropa dato;
    NodoCam back;
    NodoCam next;
    int adoquin;
    

    public NodoCam(int ad) {
        this.dato = null;
        this.back = null;
        this.next = null;
        this.adoquin = ad;
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
    
     public int getAdoquin() {
        return adoquin;
    }

    public void setAdoquin(int adoquin) {
        this.adoquin = adoquin;
    }
}
