/* Clase utilizada para la gestion de la Cola de tropas del CPU*/
package proyecto_tower_defense;

<<<<<<< Updated upstream:Proyecto_Tower_Defense/src/proyecto_tower_defense/Cola.java
public class Cola {
=======
public class ColaJug {
    
    private NodoColaJug cabeza;
    int largo;
>>>>>>> Stashed changes:Proyecto_Tower_Defense/src/proyecto_tower_defense/ColaJug.java
    
    private NodoCola cabeza;
    int largo;
    
    public Cola() {
            this.cabeza = null;
            this.largo = 0;
        }
     
    // Metodo para agregar las tropas
    
    public void agregaTropa(Tropa t){ 
<<<<<<< Updated upstream:Proyecto_Tower_Defense/src/proyecto_tower_defense/Cola.java
        NodoCola nodo = new NodoCola(t);
        
        //nodo.qtyTropa = qtyTropa;
        nuevoNodoColaJug.setSiguiente; = null; // Agrega la cantidad de tropas
=======
        NodoColaJug nodo = new NodoColaJug(t);
        
        //nodo.qtyTropa = qtyTropa;
      /*  nuevoNodoColaJug.setSiguiente; = null; // Agrega la cantidad de tropas
>>>>>>> Stashed changes:Proyecto_Tower_Defense/src/proyecto_tower_defense/ColaJug.java
        // a la cola
          
        if (cola == null){  // Verifica que la cabeza este vacia   
            cabeza = nuevoNodoColaJug;   // cabeza y cola son el mismo nodo
            cola = nuevoNodoColaJug;
        } 
        else{
            cola.setSiguiente(nuevoNodoColaJug); //atrás del último es el nuevo nodo
            cola = nuevoNodoColaJug;   // nuevo nodo es nuevo atrás
        }
    */
    }
    
    // Metodo para obtener la tropa
    public int getTropa(){ 
        if (cabeza == null) {
            System.out.println("Seleccione una tropa");
        }
        
        int qtyTropa = cabeza.qtyTropa; // Devuelve la cantidad de tropas en la
        cabeza = cabeza.getsiguiente(); // cabeza y se mueve al siguiente nodo
        if (cabeza == null) {
            //cola = null;
        }
        return qtyTropa;
    }
    }

