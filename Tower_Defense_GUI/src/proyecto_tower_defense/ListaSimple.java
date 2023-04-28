/* Clase ListaSimple con un atributo cabeza que apunta al primer nodo de la 
lista, Si la lista está vacía, cabeza es None*/
package proyecto_tower_defense;
 
public class ListaSimple {
    private Nodo cabeza;
    private int enjuego;

    // Constructor de la clase ListaSimple
    public ListaSimple() {
        cabeza = null; // La lista está vacía al inicio
        enjuego = 0;
    }

    // Método para agregar un nuevo nodo al final de la lista
    public void agregar(Tropa dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) { // Si lista vacía,nuevo nodo es cabeza
            cabeza = nuevoNodo;
        } else {
            // Recorremos la lista hasta encontrar el último nodo 
            //y agregamos el nuevo nodo al final
            Nodo nodoActual = cabeza;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
        enjuego++;
    }

    // Método para extraer y eliminar el primer nodo de la lista
    public void extraer(int id) {
        if (cabeza == null) {
            // Si la lista está vacía, devolvemos null
            //return null;
            System.out.println("No hay nada que extraer");
        }
        else{
            // Si cabera es el id buscado
            if(cabeza.getTropa().getId() == id){
                cabeza = cabeza.getSiguiente();
                enjuego--;
            }  // si es la cabeza
            else{
                Nodo aux = cabeza;
                while (aux.getSiguiente() != null && 
                        id > aux.getSiguiente().getTropa().getId()) {
                    aux = aux.getSiguiente(); // Toma el siguiente
                }
                if(aux.getSiguiente() != null && aux.getSiguiente().getTropa().getId() == id){
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    enjuego--;
                }
            }
            
        }
        
        
    }   

    /*Revisa la tropa en evalluacion y va por cada camino para llamar a
    existe para ver donde existe la tropa, si no existe pide a extraer que
    quite la tropa de la lista TodosJug*/
    public void check(Tropa t, Camino sup, Camino inf){
        if(!existe(t,sup,inf)){ 
            extraer(t.getId());
        }
    }
    
    public boolean existe(Tropa t, Camino sup, Camino inf){
        boolean up = false;
        boolean down = false;
        if (cabeza != null){
            if(sup.existe(t.getId())) up = true;
            if(inf.existe(t.getId())) down = true;
        }
        if(up || down){ 
            
            return true;
        }
        return false;
        
    }
    
    
    // Gets y Sets -------------------------------------------------------------

    
    public int getCamino(int i){
        Nodo aux = cabeza;
        int encuentra = 0;
        while(encuentra != 1 && aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        return aux.getTropa().getCamino();
    }

    public Tropa getTropa(int pos){
        Nodo aux = cabeza;
        if(aux != null){
            int encuentra = 0;
            while(aux.getSiguiente() != null && encuentra != pos ){
                encuentra++;
                aux = aux.getSiguiente();
            }
            return aux.getTropa();
        }
        else return null;
    }

    public int getEnjuego() {
        return enjuego;
    }

    public void imprimir(){
        String lista = "";
        Nodo aux = cabeza;
        if (aux == null) System.out.println("No han ingresado tropas");
        else{
            while(aux != null){
                lista += aux.getTropa().getTipoTropa() 
                        + "   "+ aux.getTropa().getId()
                        + "   "+ aux.getTropa().getCamino()+"\n";
                aux = aux.getSiguiente();
            }
        }    
        System.out.println(lista);
    }
    
}

