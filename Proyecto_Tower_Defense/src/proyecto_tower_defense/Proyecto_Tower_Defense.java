package proyecto_tower_defense;

import javax.swing.JOptionPane;

public class Proyecto_Tower_Defense {
       
    public static void main(String[] args) {
        // Variables -----------------------------------------------------------
        int ronda = 1;              // Número de ronda inicial
        int disponibles;            // Cantidad de tropas disponibles
        Cola colaJug = new Cola();  // Se crea cola para jugadores
        Cola colaCPU = new Cola();  // Se crea cola para cpu 
        
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
                    colaCPU.agregaTropaCPU(disponibles - 1); // Agrega tropas
                    // ColaCPU.aleatorio()                   // Asigna caminos
                    op = 3;                                  // 3 = juego
                    ronda++;                                 // Agrega ronda
                    break;

                // ------------------ Escena 2: Termina juego
                case (2): 
                    juego = false;                          // Juego es false  
                    break;
                
                // ------------------ Escena 3: Desarrollo del juego
                case (3):
                    op = juego();                           // Presenta juego                           
                    break;
                    
                // ----------------- Escena 4: Gana Jugador 
                case (4):
                    break;
                    
                // ----------------- Escena 5: Gana CPU (Jugador pierde)
                case (5):
                    break;
                    
                // ----------------- Escena 6: Se acabó el tiempo (Timeout) 
                case (6):
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
                    if (arq < disp) {      // Sobran disponibles
                        // agregar los arqueros a la cola**
                        colaJug.agregaTropaJugador(arq, TipoTropa.ARQUERO);
                        disp = disp - arq; //Resta de disp los miemb ingresados
                    } 
                    else if (arq == disp){ // Igual a disponibles
                        // agregar los arqueros a la cola**
                        colaJug.agregaTropaJugador(arq, TipoTropa.ARQUERO);
                        disp = disp - arq; // Resta a disp el num arqueros
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
                    if (cab < disp) {       // Sobran disponibles
                        // agregar los arqueros a la cola**
                        colaJug.agregaTropaJugador(cab, TipoTropa.CABALLERO);
                        disp = disp - cab; //Resta de disp los miemb ingresados
                    } 
                    else if (cab == disp) { // Igual a disponibles
                        // agregar los arqueros a la cola**
                        colaJug.agregaTropaJugador(cab, TipoTropa.CABALLERO);
                        disp = disp - cab; // Resta todo

                    } else {                // Más que disponibles
                        JOptionPane.showMessageDialog(null,
                                "Cantidad ingresada supera los disponibles, "
                                + "intentelo de nuevo");
                    }
                    break;
                // ----------------------- Magos
                case ("M"):
                    mag = Integer.parseInt(JOptionPane.showInputDialog
                        ("Ingrese la cantidad de magos deseados\n"));
                    if (mag < disp) {           // Menos que disponibles
                        // agregar los arqueros a la cola**
                        colaJug.agregaTropaJugador(mag, TipoTropa.MAGO);
                        disp = disp - mag; //Resta de disp los miemb ingresados
                    } 
                    else if (mag == disp) {     // Igual a disponibles
                        // agregar los arqueros a la cola**
                        colaJug.agregaTropaJugador(mag, TipoTropa.MAGO);
                        disp = disp - mag;      // Resta todo
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
            System.out.println(colaJug.imprimir());
        }
        return colaJug;
    }
    
    
    // Juego principal----------------------------------------------------------
    
    public static int juego(Cola jugador, Cola cpu) { 
        // -------------------------------- Variables
        // Asignación de colas
        Cola colaJug = jugador;           // Se toman las colas creadas
        Cola colaCPU = cpu;               
        // Construcción de torres
        Torre TorreCPU = new Torre();     // Torre CPU
        Torre TorreJug = new Torre();     // Torre Jugador
        // Construcción de caminos
        Camino superior = new Camino();   // Camino superior
        Camino inferior = new Camino();   // Camino inferior
        superior.construirCamino(6);      // Agrega nodos vacíos a ambos caminos
        inferior.construirCamino(6);
        // Tablero de juego
        // **
        System.out.println("tablero");
        
        // --------------------------------------- Desarrollo del juego
        
        
        
        // ------------------------------------------- Verificación de escena
        int resultado; // Para saber resultado
        if (TorreCPU.isDestruido())  resultado = 4;    // Jugador gana
        else if(TorreJug.isDestruido()) resultado = 5; // CPU gana 
        else resultado = 3;                            // Continua el juego
        
        return resultado;
        
    }

    
    //public static Miscelaneos msn= new Miscelaneos();
    //msn.SelecCaminos();
    //System.out.println(msn);
    
}
