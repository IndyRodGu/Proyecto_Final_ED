
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
    
     // Vaciar camino -----------------------------------------------------------
    
    public void vaciarCamino(){ // talvez un restart?
        NodoCam aux = cabeza;
        while(aux != null){
            aux.setDato(null);
            aux = aux.getNext();
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

    public void imprimirJug(){ // Imprime de la cabeza al último ******
        NodoCam aux = cabeza;
        while(aux != null){
            if(aux.getDato()== null) System.out.println("nulo");
            else System.out.println(aux.getDato().toString()+" ");
            aux = aux.getNext();
        }
        System.out.println("");
    }
    
    
    // Buscar en el tablero ----------------------------------------------------
    
    public int localizar(int id){ // Busca el "adoquin" en que está el jugador
        NodoCam aux = cabeza;                        
        // Evalua si id del jugador es igual
        while(aux.getDato() == null || aux.getDato().getId() != id){ 
            aux = aux.getNext();
        }
        int pos = aux.getAdoquin();         // indica la posición (adoquin)
        return pos;
    } 
     
    // Avanza el Jugador -------------------------------------------------------
    
    public void avanzaJug(Tropa tropa, Torre torreEnemiga){
        int posActual = localizar(tropa.getId()); // Localizar tropa en camino
        NodoCam aux = cabeza;                     // Nodo para recorrer
        while(posActual != aux.getAdoquin()){     // Recorrer hasta encontrar
            aux = aux.getNext();
        }
        if(aux.getNext().getDato() != null){
            Tropa A = aux.getDato();             // Jugador (se puede mover)
            Tropa B = aux.getNext().getDato();   // CPU (No se mueve) 
        // ----- A derrota a B
            if (A.getTipoTropa() == B.getVulnerability()){
                aux.getNext().setDato(null); // quita siguiente
                aux.getNext().setDato(A);    // asigna al siguiente
                aux.setDato(null);           // anterior nulo (cambio de campo)
                posActual++;                 // cambia de posición
                // NOTA: Borrar B en lista
            }
        // ---- B derrota a A
            else if (B.getTipoTropa() == A.getVulnerability()){
                aux.setDato(null);          // se borra jugador de camino
                // NOTA: Borrar A en lista
            }
        // ---- A == B - se acaban entre sí
            else{
                aux.getNext().setDato(null); // Borra enemigo
                aux.setDato(null);           // Borra jugador
                // NOTA: Borrar A y B en lista
            }      
        }
        else{ // Solo se mueve si no hay nada adelante
            Tropa p = aux.getDato();        // Se copia dato tropa a t
            aux.getNext().setDato(p);       // Se pega al siguiente nodo
            aux.setDato(null);              // Actual se vacía
            posActual++;                    // Se suma posición
        }
        // Si ahora está en el último lugar, ataca la torre
        if (posActual == ultimo.getAdoquin()){
            torreEnemiga.danio(tropa.getTowerWreckage()); // hace daño
            ultimo.setDato(null); // quita del tablero
           // NOTA: Borrar 
        }
    }

    // Movimiento del CPU ------------------------------------------------------   
    
    public void avanzaCPU(Tropa tropa, Torre torreEnemiga){
        int posActual = localizar(tropa.getId()); // Localizar tropa en camino
        NodoCam aux = cabeza;                     // Nodo para recorrer
        while(posActual != aux.getAdoquin()){     // Recorrer hasta encontrar 
            aux = aux.getNext();
        }
        if(aux.getBack().getDato() != null){     // Si adoquin anterior ocupado 
            Tropa A = aux.getDato();             // CPU (se puede mover)
            Tropa B = aux.getBack().getDato();   // Jugador (No se mueve) 
        // ----- A derrota a B
            if (A.getTipoTropa() == B.getVulnerability()){
                aux.getBack().setDato(null); // quita anterior
                aux.getBack().setDato(A);    // asigna cpu a anterior
                aux.setDato(null);           // se hace nulo (cambio de campo)
                posActual--;                 // cambia de posición
                // NOTA: Borrar B en lista
            }
        // ---- B derrota a A
            else if (B.getTipoTropa() == A.getVulnerability()){
                aux.setDato(null);          // se borra cpu de camino
                // NOTA: Borrar A en lista
            }
        // ---- A == B - se acaban entre sí
            else{
                aux.getBack().setDato(null); // Borra jugador
                aux.setDato(null);           // Borra cpu
                // NOTA: Borrar A y B en lista
            }   
        }
        else{ // Solo se mueve si no hay nada 'atrás'
            Tropa t = aux.getDato();        // Se copia dato tropa a t
            aux.getBack().setDato(t);       // Se pega al nodo anterior
            aux.setDato(null);              // Actual se vacía
            posActual--;                    // Se resta posición
        }
        // Si ahora está en la cabeza, ataca la torre del jugador
        if (posActual == ultimo.getAdoquin()){
            torreEnemiga.danio(tropa.getTowerWreckage()); // hace daño
            cabeza.setDato(null); // quita del tablero
           // NOTA: Borrar en lista
        }
        
    }
    
    
}