/* Clase utilizada para la gestion de la Cola de tropas del CPU*/
package proyecto_tower_defense;

import java.util.Random;
import javax.swing.JOptionPane;

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
            nodo.getTropa().setId(id);
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
            nodo.getTropa().setId(id);
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
    
    public String verLista() {
        Nodo aux = cabeza;
        String s = "";

        while (aux != null) {
            if (aux.getTropa().getId() >= 6 && aux.getTropa().getPlayer() == 2) {
                s += "--------";
            } else {
                s += aux.getTropa().getTipoTropa() + "\n";
            }
            aux = aux.getSiguiente();
        }
        return s;
    }
    
    // CPU Selecciona el Camino ( Envia no + 75% de las tropas x camino)
    public void SelecCaminoCPU(){
        //Número aleatorio entre 0 y el total de Tropas
        int tropCamSuperior = new Random().nextInt(qtyTropa + 1);
        int tropCamInferior = qtyTropa - tropCamSuperior;
        if (tropCamSuperior > qtyTropa * 0.75) {
            // Restringe el número de tropas al 75% del total x camino
            tropCamSuperior = (int) (qtyTropa * 0.75); 
            tropCamInferior = qtyTropa - tropCamSuperior;
        }
        System.out.println("Tropas CPU: \nCamino Superior" + tropCamSuperior + ""
                + " y Camino Inferior " + tropCamInferior);
        int caminoCPU = new Random().nextInt(2); // Generar un número aleatorio entre 0 y 1
        if (caminoCPU == 0) {
            System.out.println("Camino superior elegido");
        } else {
            System.out.println("Camino inferior elegido");
    }
    }
    
    // // Jugador selecciona el Camino por el que envia sus tropas
    public void SelecCaminosJug(int disp) { 
        for (int i = 0; i < disp; i++) {
            int camino = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "Seleccione un camino\n 1- Camino Superior "
                    + "\n2- Camino Inferior"));
            switch (camino) {
                case 1:
                    // Camino superior
                    
                    System.out.println("Camino Superior");
                    break;
                case 2:
                    // Camino inferior
                    System.out.println("Camino Inferior");
                    break;
                    // Otras entradas
                default:
                    JOptionPane.showMessageDialog(null,"Ingrese una opción válida");
                    break;
            }
        }
    }
}
