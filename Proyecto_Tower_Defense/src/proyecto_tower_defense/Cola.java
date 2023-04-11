/* Clase utilizada para la gestion de la Cola de tropas del CPU*/
package proyecto_tower_defense;

public class Cola {
    
    private NodoCola cabeza;
    private NodoCola cola;
    private int qtyTropa;
  
    
    public Cola() {
            this.cabeza = null;
            this.cola = null;
            this.qtyTropa = 0;
        }
     
    // Metodo para agregar las tropas
    public void agregaTropaJugador(int personaje, TipoTropa tipo){ 
        // Recibe la cantidad de tropas, tipo tropa
        
        // Asignación de id (impares para jugador)
        int id;
        if(cabeza == null)  id = 1;
        else id = cola.getTropa().getId() + 2;
        
        // Agregar a la cola
        for(int i = 0; i < personaje; i++){
            Tropa t = new Tropa(tipo, id, 1); // tropa para jugadores
            NodoCola nodo = new NodoCola(t);  // se crea nodo
            if (cola == null){                // Vierfica la cabeza este vacia   
                cabeza = nodo;                // cabeza y cola son el mismo nodo
                cola = nodo;
            } 
            else{
                cola.setSiguiente(nodo); //atrás del último es el nuevo nodo
                cola = nodo;   // nuevo nodo es nuevo atrás
            }
            id+=2;
            this.qtyTropa++;
        }
    }
    
//    // Metodo para obtener la tropa
//    public int getTropa(){ 
//        if (cabeza == null) {
//            System.out.println("Seleccione una tropa");
//        }
//        
//        int qtyTropa = cabeza.qtyTropa; // Devuelve la cantidad de tropas en la
//        cabeza = cabeza.getsiguiente(); // cabeza y se mueve al siguiente nodo
//        if (cabeza == null) {
//            cola = null;
//        }
//        return qtyTropa;
//    }

    
    public void to_String() {
        
        NodoCola aux = cabeza;
        for (int i = 0; i < this.qtyTropa;i++){
            System.out.println(aux.getTropa().toString());
            aux = aux.getsiguiente();
        }
        
    //"Cola{" + "cabeza=" + cabeza + ", cola=" + cola + '}';
    }
    
    
    
    }

