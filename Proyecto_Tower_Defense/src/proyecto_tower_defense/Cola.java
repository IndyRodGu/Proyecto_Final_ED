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

    // Para definir si la cola está vacía
    public boolean vacia(){
        if (cabeza == null) return true;
        else return false;
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
            id = 2;
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
        System.out.println("Tropa  camino \n----------------");
        while (aux != null) {
            if (aux.getTropa().getId() >= 8 && aux.getTropa().getPlayer() == 2) {
                s += "********";
            } else {
                s += aux.getTropa().getTipoTropa() + "  "
                        +aux.getTropa().getCamino()+"\n";
            }
            aux = aux.getSiguiente();
        }
        s+="\n";
        return s;
    }
    
    // CPU Selecciona el Camino ( Envia no + 75% de las tropas x camino)
    public void SelecCaminoCPU(){
        // Número aleatorio entre 0 y el total de Tropas
        int tropCamSuperior = new Random().nextInt(qtyTropa + 1);
        int tropCamInferior = qtyTropa - tropCamSuperior;
        // Verificar que el valor sea menor a los 75
        int calculo = (int) Math.floor(qtyTropa * 0.75); //Redondeo del calculo
        if (tropCamSuperior > calculo) {
            // Restringe el número de tropas al 75% del total x camino
            tropCamSuperior = calculo; 
            tropCamInferior = qtyTropa - tropCamSuperior;
        }
        
        // Asignación de los caminos de los 
        Nodo aux =  cabeza; // Nodo para recorrer    
        int camSup = 0; // Verifica si camino sup llega al 75
        int camInf = 0; // Verifica si camino inf llega al 75
        while(aux != null){
            // Generar un número aleatorio entre 0 y 1 para asignar 
            int caminoCPU = new Random().nextInt(2); 
            // Si random es 0 ---> Cam superior, mientras menor al valor asig.
            if (caminoCPU == 0 && camSup <= tropCamSuperior) {
                aux.getTropa().setCamino(1); // Camino superior es 1 en tropa
                camSup++; //Se agrega a la cuenta de superior
            } 
            // Si random es 1 ---> Cam inferior, mientras menor al valor total
            else if (caminoCPU == 1 && camInf <= tropCamInferior) {
                aux.getTropa().setCamino(2); // En tropa, 2 es cam inferior
                camInf++; // Se agrega a la cuenta de camino inferior
            }
            else {
            // si random es de un camino que ya llegó a máximo
            // se invierte el valor
                if (caminoCPU == 1) aux.getTropa().setCamino(1);
                else aux.getTropa().setCamino(2);
            }
            aux  = aux.getSiguiente(); // continua al siguiente
        }
    }
    
    // // Jugador selecciona el Camino por el que envia sus tropas
    public void SelecCaminosJug() {
        boolean selecionado = false;
        while(selecionado == false) {
            int camino = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "Seleccione un camino\n "
                    + "1- Camino Superior "
                    + "\n2- Camino Inferior"));
            switch (camino) {
                case 1:
                    cola.getTropa().setCamino(camino);
                    // Camino superior
                    //System.out.println("Camino Superior");
                    selecionado = true;
                    break;
                case 2:
                    cola.getTropa().setCamino(camino);
                    // Camino inferior
                    //System.out.println("Camino Inferior");
                    selecionado = true;
                    break;
                    // Otras entradas
                default:
                    JOptionPane.showMessageDialog(null,"Ingrese una opción válida");
                    break;
            }
        }
    }
    
    
    // SETS y GETS -------------------------------------------------------------

    public int getQtyTropa() {
        return qtyTropa;
    }

}
