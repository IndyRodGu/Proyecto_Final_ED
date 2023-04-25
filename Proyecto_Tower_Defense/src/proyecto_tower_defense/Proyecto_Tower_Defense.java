package proyecto_tower_defense;

import javax.swing.JOptionPane;

public class Proyecto_Tower_Defense {
       
    // Construcción de torres
        public static Torre TorreCPU = new Torre();     // Torre CPU
        public static Torre TorreJug = new Torre();     // Torre Jugador
        
    public static void main(String[] args) {
        // Variables -----------------------------------------------------------
        int ronda = 1;              // Número de ronda inicial
        int disponibles;            // Cantidad de tropas disponibles
        Cola colaJug = new Cola();  // Se crea cola para jugadores
        Cola colaCPU = new Cola();  // Se crea cola para cpu 
        int contador = 0;
        
        // Menu principal ------------------------------------------------------
        boolean juego = true;       // Mientras el juego esté en curso
        // Solicita al usuario acción inicial
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Tower Defense\n"         
                    + "1- Iniciar juego\n" 
                    + "2- Salir"));
        do {
            disponibles = ronda + 4;   
            switch (op) {
                // ------------------ Escena 1: Selección de tropas
                case (1): 
                    // 1. Creación de colas
                    colaJug = menuJuego(disponibles);        // Cola jugadores
//                    colaCPU.agregaTropaCPU(disponibles - 1); // Agrega tropas
//                    colaCPU.SelecCaminoCPU();
//                    System.out.println(colaCPU.verLista());
//                   // Asignar caminos
                    System.out.println(colaJug.verLista());
                    contador = 0;
                    op = 2;                                  // 3 = juego
                    ronda++;                                 // Agrega ronda
                    break;

                // ------------------ Escena 2: Termina juego
                case (2): 
                    juego = false;                          // Juego es false  
                    break;
                
                // ------------------ Escena 3: Desarrollo del juego
                case (3):
                    op = juego(colaJug, colaCPU, contador); // Presenta juego                           
                    contador ++;
                    break;
                    
                // ----------------- Escena 4: Gana Jugador 
                case (4):
                    JOptionPane.showMessageDialog(null, "¡Ganaste!.");
                    break;
                    
                // ----------------- Escena 5: Gana CPU (Jugador pierde)
                case (5):
                    JOptionPane.showMessageDialog(null, "Perdiste. Mejor suerte la próxima.");
                    break;
                    
                // ----------------- Escena 6: Se acabó el tiempo (Timeout) 
                case (6):
                     //if ( >= 300000) {
                    //if ( >= 300000) {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Se acabó el tiempo. ¿Qué desea hacer?\n\n"
                        + "1. Reintentar\n"
                        + "2. Terminar el juego"));
                
                if (opcion == 1) {
                    //tiempo = 0;
                    ronda=1;
                    op = 1;//se regresa al menu del juego 
                } else {
                    op = 6;
                }
                     JOptionPane.showMessageDialog(null, "Perdiste por timeout.");
                    break;
                    
                // ----------------- Escena 7: SE acaba el tiempo (Timeout)
                default:
                    JOptionPane.showMessageDialog(null,
                            "Ingrese una opcion valida");
                    break;
            }
        } while (juego); // Mientras el juego sea vigente
    }
    
    
    
    // Selección de Tropas -----------------------------------------------------

    public static Cola menuJuego(int disp) { // disp = Cant. tropas disponibles
        Cola colaJug = new Cola();           // se crea cola de jugadores
        int arq, cab, mag;                   // Mostrar cant de miemb escogidos.
        int total = disp;                    // Cuantos hay disp. al inicio
        // ------------------- Selección
        while (disp > 0) { // Mientras haya tropas disponibles
            String op = JOptionPane.showInputDialog(null,
                    "Número de Tropas disponibles: " + disp + "\n"
                    + "A - Arqueros\n"
                    + "C - Caballeros\n"
                    + "M - Magos\n"
                    + "S - Salir").toUpperCase();

            switch (op) {
                // ----------------------- Arqueros 
                case ("A"):
                    arq = Integer.parseInt(JOptionPane.showInputDialog
                        ("Ingrese la cantidad de arqueros deseados\n"));
                    if (arq <= disp) {      // Sobran disponibles
                        // agregar los arqueros a la cola**
                        for (int i = 0; i < arq; i++){
                        colaJug.agregaTropaJugador(1, TipoTropa.ARQUERO);
                        colaJug.SelecCaminosJug();
                    } 
                   disp = disp - arq; //Resta de disp los miemb ingresados
                   }
                    else {                 // Más que disponibles
                        JOptionPane.showMessageDialog(null,
                                "Cantidad ingresada supera los disponibles, "
                                + "intentelo de nuevo");
                    }
                    break;
                // ----------------------- Caballeros
                case ("C"):
                    cab = Integer.parseInt(JOptionPane.showInputDialog
                        ("Ingrese la cantidad de caballeros deseados\n"));
                    if (cab <= disp) {       // Sobran disponibles
                        // agregar los arqueros a la cola**
                       for (int i = 0; i < cab; i++){
                        colaJug.agregaTropaJugador(1, TipoTropa.CABALLERO);
                        colaJug.SelecCaminosJug();
                    } 
                   disp = disp - cab; //Resta de disp los miemb ingresados
                   }
                    else {                // Más que disponibles
                        JOptionPane.showMessageDialog(null,
                                "Cantidad ingresada supera los disponibles, "
                                + "intentelo de nuevo");
                    }
                    break;
                // ----------------------- Magos
                case ("M"):
                    mag = Integer.parseInt(JOptionPane.showInputDialog
                        ("Ingrese la cantidad de magos deseados\n"));
                    if (mag <= disp) {           // Menos que disponibles
                        // agregar los arqueros a la cola**
                       for (int i = 0; i < mag; i++){
                        colaJug.agregaTropaJugador(1, TipoTropa.MAGO);
                        colaJug.SelecCaminosJug();
                    } 
                   disp = disp - mag; //Resta de disp los miemb ingresados
                   }
                    else {                      // Más que disponibles
                        JOptionPane.showMessageDialog(null,
                                "Cantidad ingresada supera los disponibles, "
                                + "intentelo de nuevo");
                    }
                    break;
                // ------------- Salida
                case ("S"):
                    JOptionPane.showMessageDialog(null,
                            "Ha seleccionado "+(total-disp)+" tropas.");
                    disp = 0;
                    break;
                // ------------- Otras entradas
                default:
                    JOptionPane.showMessageDialog(null, 
                        "Ingrese una opcion valida");
                    break;
            }                   
            System.out.println(colaJug.verLista());
        }
        return colaJug;
    }
    
    
    
    // Juego principal----------------------------------------------------------
    
    public static int juego(Cola jugador, Cola cpu, int contador) { 
        
    // -------------------------------- Variables
        // Asignación de colas
        Cola colaJug = jugador;           // Se toman las colas creadas
        Cola colaCPU = cpu;               
        
        // Construcción de caminos
        Camino superior = new Camino(6);   // Camino superior
        Camino inferior = new Camino(6);   // Camino inferior
        
        // Lista de jugadores en juego
        ListaSimple todosJug = new ListaSimple ();
        
        // Tablero de juego
        // Recibe 5 filas, 6 columnas y caminos superior e inferior
        Tablero tab = new Tablero(5,6,superior,inferior); 
        System.out.println("tablero");
 
    // --------------------------------------- Desarrollo del juego
        Nodo aux = null;
        
        // si todavía hay en cola
        if (!colaJug.vacia() || !colaCPU.vacia()) {
            if (contador % 2 == 0 && !colaJug.vacia()) { // Si es par entra (JUGADORES) al juego
                aux = colaJug.atiende();
            } 
            else if (contador % 2 != 0 && !colaCPU.vacia())  { // Si es impar entra (CPU) al juego
                aux = colaCPU.atiende();
            }

            todosJug.agregar(aux.getTropa()); // Se agrega a la lista

            // Se agrega el camino correspondiente
            if(aux.getTropa().getCamino() == 1){  
                superior.ingresa(aux.getTropa());
            }
            else if (aux.getTropa().getCamino() == 2){
                inferior.ingresa(aux.getTropa());
            }
        }
        
     
        
        for(int i = 0; i < todosJug.getEnjuego(); i++){
            System.out.println(todosJug.getTropa(i).getPlayer());  
            Torre enemTorre = new Torre();
            if (todosJug.getTropa(i).getPlayer() == 1) enemTorre = TorreCPU;
            else enemTorre = TorreJug;
            
            if(todosJug.getCamino(i) == 1){
                superior.avanza(todosJug.getTropa(i), enemTorre);
            }
            else{
                inferior.avanza(todosJug.getTropa(i), enemTorre);
            }
            JOptionPane.showMessageDialog(null, tab.show());
            
        }
        
       
        
        
        
        // ------------------------------------------- Verificación de escena
        int resultado; // Para saber resultado
        if (TorreCPU.isDestruido())  resultado = 4;    // Jugador gana
        else if(TorreJug.isDestruido()) resultado = 5; // CPU gana 
        else resultado = 3;                            // Continua el juego
        
        return resultado;
        
    }
    
}
