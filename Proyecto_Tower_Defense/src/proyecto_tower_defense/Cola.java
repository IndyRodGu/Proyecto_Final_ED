/* Clase utilizada para la gestion de la Cola de tropas del CPU*/
package proyecto_tower_defense;

import java.util.Random;

public class Cola {

    private Nodo cabeza;
    private Nodo cola;
    private int qtyTropa;

    public Cola() {
        this.cabeza = null;
        this.cola = null;
        this.qtyTropa = 0;
    }

    // Metodo para agregar las tropas
    public void agregaTropaJugador(int personaje, TipoTropa tipo) {
        // Recibe la cantidad de tropas, tipo tropa
        // Asignación de id (impares para jugador)
        int id;
        if (cabeza == null) {
            id = 1;
        } else {
            id = cola.getTropa().getId() + 2;
        }

        // Agregar a la cola
        for (int i = 0; i < personaje; i++) {
            Tropa t = new Tropa(tipo, id, 1); // tropa para jugadores
            Nodo nodo = new Nodo(t);  // se crea nodo
            if (cabeza == null) {                // Vierfica la cabeza este vacia   
                cabeza = nodo;                // cabeza y cola son el mismo nodo
                cola = cabeza;
            } else if (cabeza != null && cabeza.getSiguiente() == null) {
                cola.setSiguiente(nodo); //atrás del último es el nuevo nodo
                cola = nodo;
                cabeza.setSiguiente(cola);
            } else {
                cola.setSiguiente(nodo); //atrás del último es el nuevo nodo
                cola = nodo;   // nuevo nodo es nuevo atrás
            }
            id += 2;
            this.qtyTropa++;
        }
    }

    // Método para escoger y agregar aleatoriamente
    public void agregaTropaCPU(int dispCPU) {

        int id;
        if (cabeza == null) {
            id = 0;
        } else {
            id = cola.getTropa().getId() + 2;
        }

        TipoTropa personajes[] = new TipoTropa[3];
        personajes[0] = TipoTropa.ARQUERO;
        personajes[1] = TipoTropa.CABALLERO;
        personajes[2] = TipoTropa.MAGO;

        for (int i = 0; i < dispCPU; i++) {
            int aleatorio = (int) (Math.random() * 3);
            Tropa t = new Tropa(personajes[aleatorio], id, 2); // tropa para CPU
            Nodo nodo = new Nodo(t);  // se crea nodo
            if (cabeza == null) {                // Verifica la cabeza este vacia   
                cabeza = nodo;                // cabeza y cola son el mismo nodo
                cola = cabeza;
            } else if (cabeza != null && cabeza.getSiguiente() == null) {
                cola.setSiguiente(nodo); //atrás del último es el nuevo nodo
                cola = nodo;
                cabeza.setSiguiente(cola);
            } else {
                cola.setSiguiente(nodo); //atrás del último es el nuevo nodo
                cola = nodo;   // nuevo nodo es nuevo atrás
            }
            System.out.println(nodo.getTropa().toString());
            id += 2;
            this.qtyTropa++;
        }
    }

    public Nodo atiende() {
        Nodo aux = cabeza;
        if (cabeza != null) {
            cabeza = cabeza.getSiguiente();
            aux.setSiguiente(null);
            //qtyTropa--;
        }
        return aux;
    }

    public String imprimir() {
        String lista = "";
        Nodo aux = cabeza;
        while (aux != null) {
            lista += aux.getTropa().toString() + '\n';
            aux = aux.getSiguiente();
        }
        return lista;
    }
    
    //Seleccionar el Camino 
    public void SelecCaminoCPU(Cola CPU){
        int tropaTotal = qtyTropa; // Cantidad total de tropas del CPU
         //Número aleatorio entre 0 y totalTropas
        int tropasCaminoSuperior = new Random().nextInt(tropaTotal + 1);
        int tropasCaminoInferior = tropaTotal - tropasCaminoSuperior;
        if (tropasCaminoSuperior > tropaTotal * 0.75) {
            // Restringe el número de tropas al 75% del total x camino
            tropasCaminoSuperior = (int) (tropaTotal * 0.75); 
            tropasCaminoInferior = tropaTotal - tropasCaminoSuperior;
        }
        System.out.println("El CPU envía " + tropasCaminoSuperior + " tropas por el camino superior y " + tropasCaminoInferior + " tropas por el camino inferior.");

        int caminoCPU = new Random().nextInt(2); // Generar un número aleatorio entre 0 y 1
        if (caminoCPU == 0) {
            System.out.println("El CPU ha elegido el camino superior.");
        } else {
            System.out.println("El CPU ha elegido el camino inferior.");
    }
    }
}
