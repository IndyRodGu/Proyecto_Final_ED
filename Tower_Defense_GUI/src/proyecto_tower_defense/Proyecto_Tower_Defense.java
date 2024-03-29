package proyecto_tower_defense;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Proyecto_Tower_Defense {
       
    // Construcción de torres
        public static Torre TorreCPU = new Torre();     // Torre CPU
        public static Torre TorreJug = new Torre();     // Torre Jugador
        
        
    public static void main(String[] args) {
        
        // Variables -----------------------------------------------------------
        int ronda = 1;              // Número de ronda inicial
        int disponibles = ronda + 4;// Cantidad de tropas disponibles
        Cola colaJug = new Cola();  // Se crea cola para jugadores
        Cola colaCPU = new Cola();  // Se crea cola para cpu 
        int opcion = 0;
        
        Juego game=new Juego(colaJug, colaCPU,ronda+4, ronda) {
             //@Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
    
        };
        
        
        // Menu principal ------------------------------------------------------
        boolean juego = true;       // Mientras el juego esté en curso
        // Solicita al usuario acción inicial
        int op = game.getEscena();
        
        do {
            op = game.getEscena();
            disponibles = ronda + 4;   
            switch (op) {
                // Pantalla de bienvenida
                 case(0):
                    break;
                // ------------------ Escena 1: Selección de tropas
                case (1): 
                    // 1. Creación de colas
                    game.menu(colaCPU,colaJug,disponibles,ronda);
                   // op = 3;                                  // 3 = juego
                    ronda++;                                 // Agrega ronda
                    break;

                // ------------------ Escena 2: Termina juego
                case (2): 
                    juego = false;                          // Juego es false  
                    break;
                
                // ------------------ Escena 3: Desarrollo del juego
                case (3):
                    game.juego(ronda);
                    op = juego(colaJug, colaCPU, disponibles); // Presenta juego                           
                    break;
                    
                // ----------------- Escena 4: Gana Jugador 
                case (4):
                    opcion = Integer.parseInt(JOptionPane.showInputDialog
                        ("¡Ganaste! :) \n¿Qué deseas hacer?\n\n"
                        + "1. Juegar de nuevo\n"
                        + "2. Terminar el juego"));
                
                    if (opcion == 1) {
                        ronda=1;    // Devuelve a ronda 1
                        op = 1;     //se regresa al menu del juego 
                    } 
                    else {
                        op = 2;     // Cierra la lata
                    }
                    break;
                    
                // ----------------- Escena 5: Gana CPU (Jugador pierde)
                case (5):
                    opcion = Integer.parseInt(JOptionPane.showInputDialog
                        ("¡Perdiste! :( \n¿Qué deseas hacer?\n\n"
                        + "1. Reintentar \n"
                        + "2. Salir del juego"));
                
                    if (opcion == 1) {
                        ronda=1;    // Devuelve a ronda 1
                        op = 1;     //se regresa al menu del juego 
                    } 
                    else {
                        op = 2;     // Cierra la lata
                    }
                    
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
            
        }
        return colaJug;
    }
    
    
    
    // Juego principal----------------------------------------------------------
    
    public static int juego(Cola jugador, Cola cpu, int disp) { 
        
    // -------------------------------- Variables
                
        // Construcción de caminos
        Camino superior = new Camino(6);   // Camino superior
        Camino inferior = new Camino(6);   // Camino inferior
        
        // Lista de jugadores en juego
        ListaSimple todosJug = new ListaSimple ();
        
        // Tablero de juego
        // Recibe 5 filas, 6 columnas y caminos superior e inferior
        Tablero tab = new Tablero(5,6,superior,inferior); 
        
        // Sistema de Juego
        int contador = 1; // cuenta la cantidad de vueltas que tiene el programa
        int max = disp + (disp - 1);
        int resultado = 0; // Para saber resultado (ir a qué escena)
        boolean play = true;
        int rev = 0;
        int agregar = jugador.getQtyTropa()+cpu.getQtyTropa();
        
    // --------------------------------------- Desarrollo del juego
    
        while (play){  // Mientras el juego esté en curso
            
            if(contador <= max){ // mientras el contador sea menos que el max
                Nodo aux = null; // Nodo aux que toma los datos
                
               // 1. Se asigna valor a nodo aux -------------------    
                // si son pares y la cola de CPU no está vacía
                if(contador %2 == 0 && !cpu.vacia()){
                    aux = cpu.atiende();// auxiliar toma cabeza de cpu
                }
                // Si son impares y la cola de jugador no esta vacía
                else if (contador %2 != 0 && !jugador.vacia()){
                    aux = jugador.atiende();// auxliar toma cabeza de jugador
                }
                
                // 2. Se adiciona a la lista -----------------------
                if (aux != null){ // Si el nodo no está vacío
                    
                    Tropa t = aux.getTropa(); // Valor de la tropa
                    todosJug.agregar(t);      // Se agrega a la lista de objetos
                    int cami = t.getCamino(); // Valor del camino de t
                    if(cami == 1) superior.ingresa(t);  // si 1: superior
                    else inferior.ingresa(t);           // si 2: inferior
                    
                // 3. Imprimir en consola para visualizar ----------
                    superior.imprimirA();
                    inferior.imprimirA();
                    todosJug.imprimir();
                    JOptionPane.showMessageDialog(null, tab.show()); // se ve adición
                }  

            }
            
            System.out.println("Ciclo: "+contador);
            
            // Proceso de movimiento -------------------------------------------
      
            //while(todosJug.getNodo(rev)!= null){
            while(rev < todosJug.getEnjuego()){
                Tropa tropa = todosJug.getTropa(rev);   // tomamos la tropa
                if(todosJug.existe(tropa, superior, inferior)){
                    int cami = tropa.getCamino();       // Valor del camino de t
                    // ----------------------------------- Mover en los caminos
                    if(tropa.getPlayer() == 1){         // Si es el jugador          
                        if(cami == 1) superior.avanza(tropa, TorreCPU,todosJug);
                        else inferior.avanza (tropa, TorreCPU,todosJug);     
                    }
                    else{                               // Si es el cpu
                        if(cami == 1) superior.avanza(tropa, TorreJug,todosJug);
                        else inferior.avanza (tropa, TorreJug,todosJug);    
                    } 
                    superior.imprimirA();
                    inferior.imprimirA();
                    todosJug.imprimir();
                    JOptionPane.showMessageDialog(null, tab.show()); // se ve adición
                }
                todosJug.check(tropa, superior, inferior); // Revisar
                rev++;
                // Verificar si la torre muere ---------------------------------
                if (TorreCPU.isDestruido()){ // Jugador gana
                    resultado = 4;
                    play = false;
                }    
                else if(TorreJug.isDestruido()){ // CPU gana 
                    resultado = 5;
                    play = false;
                }
            }
            
            System.out.println("Todos Jug: "+todosJug.getEnjuego());
            System.out.println("Vida Torre Jug: " +TorreJug.getVida());
            System.out.println("Vida Torre CPU: " +TorreCPU.getVida());
            System.out.println("\n");
            //JOptionPane.showMessageDialog(null, tab.show()); // se ve adición
            rev = 0;
            
            
            // ------------------------------------------- Verificación de escena           
            if(todosJug.getEnjuego() == 0 && contador > max ) {
                JOptionPane.showMessageDialog(null, "Nadie ha sido derrotado. Nueva Ronda");
                resultado = 2; //1
                play = false;
            }
           
            contador ++;
        } // fin while
        
        
        return resultado;
        
    }
    
}
