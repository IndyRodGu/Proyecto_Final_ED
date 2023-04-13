
package proyecto_tower_defense;


public class Camino {
    
    // basada en las estructuras de lista enlazada simple y lista circular doble 
    NodoCam cabeza;
    NodoCam ultimo;
    int cuenta;
    
    public Camino() {
        this.cabeza = null;
        this.ultimo = null;
        this.cuenta = 0;
    }
    
    // Construir camino --------------------------------------------------------
    
    public void construirCamino(int adoquines){ // cant. adoquines
        for(int i = 0; i < adoquines; i++){
            NodoCam nodo = new NodoCam(i);
            if(cabeza == null){             // Si no hay nada en la cabeza
                cabeza = nodo;
                ultimo = cabeza;
            }
            else {                          // Sino, se agrega lo demás
                nodo.setBack(ultimo);       // Se prepara lo anterior
                ultimo.setNext(nodo);       // Se prepara el siguiente
                ultimo = ultimo.getNext();  // Se redefine último
            }
            cuenta++;
        }
    }
    
    // Imprimir adoquines ------------------------------------------------------
    
    public void imprimirA(){   // Revisa de la cabeza al último
        NodoCam aux = cabeza;
        while(aux != null){
            System.out.print(aux.getAdoquin()+" ");
            aux = aux.getNext();
        }
        System.out.println("");
    }
    
    public void imprimirB(){   // Revisa del último a la cabeza
        NodoCam aux = ultimo;
        while(aux != null){
            System.out.print(aux.getAdoquin()+" ");
            aux = aux.getBack();
        }
        System.out.println("");
    }
    
    
    // Ingresan jugadores al tablero -------------------------------------------
    
    public void ingresaTropaJug(Tropa jug){
        cabeza.setDato(jug);
    }
    
    public void ingresaTropaCPU(Tropa cpu){
        ultimo.setDato(cpu);
    }

    public void imprimirJug(){ // Revisa de la cabeza al último
        NodoCam aux = cabeza;
        while(aux != null){
            if(aux.getDato()== null) System.out.println("nulo");
            else System.out.println(aux.getDato().toString()+" ");
            aux = aux.getNext();
        }
        System.out.println("");
    }
    
    
    // Movimiento en el tablero ------------------------------------------------
    
    public int localizar(int id){ // Busca el "adoquin" en que está el jugador
        NodoCam aux = cabeza;                        
        // Evalua si id del jugador es igual
        while(aux.getDato() == null || aux.getDato().getId() != id){ 
            aux = aux.getNext();
        }
        int pos = aux.getAdoquin();         // indica la posición (adoquin)
        return pos;
    } 
     
     
     
    public void avanzaJug(int id){
        
        // Primero revisar que el siguiente no esté ocupado.
        int posActual = localizar(id);
        
        // Si está en el último lugar, ataca la torre
        if (posActual == ultimo.getAdoquin()){
            // Atacar torre
            // "Eliminar" personaje de la cola de "en juego"
        }
        
        else{
            NodoCam aux = cabeza;
            while(posActual != aux.getAdoquin()){
                aux = aux.getNext();
            }
            
            if(aux.getNext().getDato() != null){
                // revisar quien muere
                // Elimina el que que corresponde -> revisa con tropa
            }
            else{
                // Se mueve al siguiente
                Tropa p = aux.getDato();
                aux.getNext().setDato(p);
                aux.setDato(null);
            }
            
        }
    }
    
    
    
    public void avanzaCPU(){
        
        
    }
    
    
}
