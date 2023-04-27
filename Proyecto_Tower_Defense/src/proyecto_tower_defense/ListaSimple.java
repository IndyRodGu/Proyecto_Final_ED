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
//        Tropa valor = cabeza.getTropa();
//        cabeza = cabeza.getSiguiente();
        Nodo aux = cabeza;
        while (aux.getSiguiente() != null && 
                id != aux.getSiguiente().getTropa().getId()) {
            aux = aux.getSiguiente(); // Toma el siguiente
        }
        if(cabeza==aux) cabeza = cabeza.getSiguiente();  // si es la cabeza
        else aux.setSiguiente(aux.getSiguiente().getSiguiente());
        enjuego--;
        //return valor;
    }

    public void check(Nodo aux, Camino sup, Camino inf){
        boolean up = false;
        boolean down = false;
        if (cabeza != null){
            if(sup.existe(aux.getTropa().getId())) up = true;
            if(inf.existe(aux.getTropa().getId())) down = true;
        }
        if(!up && !down) extraer(aux.getTropa().getId());
        
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
            while(aux.getSiguiente() != null){
                if (encuentra == pos) break;
                encuentra++;
                aux = aux.getSiguiente();
            }
            return aux.getTropa();
        }
        else return null;
    }
    
    public Tropa getTorreEnem(int i){
        Nodo aux = cabeza;
        int encuentra = 0;
        while(encuentra != 1 && aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        return aux.getTropa();
    }
    
    
    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public int getEnjuego() {
        return enjuego;
    }

    public void setEnjuego(int enjuego) {
        this.enjuego = enjuego;
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

