/* Clase utilizada para la gestion de la Cola de tropas del CPU*/

package proyecto_tower_defense;
import java.util.Random;

public class ColaCPU {
    private NodoColaCPU frente;
    private NodoColaCPU last;
    private Random aleatorio;
    private int tamano;
    private int ronda;
    
    // Asigna las tropas por ronda de manera aleatoria
    public ColaCPU (int ronda){
        this.frente = null;
        this.last = null;
        this.tamano = 0;
        this.ronda = ronda;
        this.aleatorio = new Random();
        for (int i = 0; i < this.ronda +3; i++) {
            this.crearTropa();            
        }
    }
    
    public void crearTropa(){
        
        TipoTropa[] tiposTropa = TipoTropa.values();
        TipoTropa tipo = tiposTropa[aleatorio.nextInt(tiposTropa.length)];
        Tropa tropa = new Tropa(tipo);
        NodoColaCPU nuevoNodo = new NodoColaCPU(tropa);
        
        if (this.empty()) { // Verifica que el nodo este vacio
            this.frente = nuevoNodo;
            this.last = nuevoNodo;
        } else {
            this.last.setSiguiente(nuevoNodo);
            this.last = nuevoNodo;
        }
        this.tamano++;
    }
    
    // Eliminar las tropas
    public Tropa eliminarTropa() {
        if (this.empty()) { // Verifica si el nodo esta vacio
            return null;
        }
        Tropa tropaEliminada = this.frente.getTropa();
        this.frente = this.frente.getSiguiente();
        this.tamano--;
        return tropaEliminada;
    }
    
    public boolean empty(){ // Si la cola esta vacia
        return this.frente == null;
    }
    
    public int getTamano(){ // Almacena el tamano
        return this.tamano;
    }
    
    private class NodoColaCPU {
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
}
