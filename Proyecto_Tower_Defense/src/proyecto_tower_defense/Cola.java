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
            if (cabeza == null){                // Vierfica la cabeza este vacia   
                cabeza = nodo;                // cabeza y cola son el mismo nodo
                cola = cabeza;
            } 
            else if(cabeza != null && cabeza.getSiguiente()== null){
                cola.setSiguiente(nodo); //atrás del último es el nuevo nodo
                cola = nodo;
                cabeza.setSiguiente(cola);
            }
            else{
                cola.setSiguiente(nodo); //atrás del último es el nuevo nodo
                cola = nodo;   // nuevo nodo es nuevo atrás
            }
            id+=2;
            this.qtyTropa++;
        }
    }
    // Metodo para utilizar el primer elemento de la cola
    public NodoCola atiende(){
        NodoCola aux = cabeza;
        if (cabeza != null) {
            cabeza = cabeza.getSiguiente();
            aux.setSiguiente(null);
            //qtyTropa--;
        }
        return aux;
    }
    
    // Metodo para eliminar toda la cola al finalizar el juego
    public NodoCola eliminar(){
        if (cabeza != null && cola != null) {
            cabeza = null;
            cola = null;
            qtyTropa = 0;
        }
        return cola;
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

    
    public String imprimir(){
        String lista = "";
        NodoCola aux = cabeza;
        while(aux!= null){
            lista += aux.getTropa().toString()+'\n';
            aux = aux.getSiguiente();
        }
        return lista;
    }
        
}

