package proyecto_tower_defense;

import javax.swing.JOptionPane;

public class Proyecto_Tower_Defense {

    public static void main(String[] args) {

        int disponibles;
        int ronda = 1;

        // Menu principal ------------------------------------------------------
        int op = Integer.parseInt(JOptionPane.showInputDialog
        (null, "Tower Defense\n" + "1- Iniciar juego\n" 
         + "2- Salir"));

        // Lógica de escenas -------------------------------------
        boolean juego = true; // Mientras el juego esté en curso
        do {
            disponibles = ronda + 4;
            switch (op) {
                case (1): // Escena 1: se escogen las tropas
                    Cola colaJug = menuJuego(disponibles);
                    //op = 2; // para "cambiar de escena"
                    ronda++; // Aumenta una ronda para la siguiente
                    break;

                case (2): // Termina 
                    juego = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Ingrese una opcion valida");
                    break;
            }

        } while (juego);

        //menu();
        // Cola para el jugador
        // ColaJug -> [ ] [ ]
        // Cola para CPU
//        do{
//            escena1();
//            
//            
//        }while();
//        
        /*
        
        // Tablero
        int filas = 5;
        int columnas = 6;
        String tablero[][] = new String[filas][columnas];
        
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                tablero[i][j]=" 0 ";
            }
        }
        JOptionPane.showMessageDialog(null,tablero); // formato
        
        
         */
    }

    public static Cola menuJuego(int disp) { // Cant. tropas disponibles
        // Escena 1 -----------

        // Tropas disponibles 5: cuantos Arqueros desea
        // Tropas disponible 3: cuantos Magos
        // Tropas disponible 3: cuantos Magos
        // Verificar si es mayor -> Alerta
        // ColaCPU.aleatorio()
        Cola colaJug = new Cola();
        int arq, cab, mag; // Mostrar cant de miemb escogidos.

        while (disp > 0) {
            String op = JOptionPane.showInputDialog(null,
                    "Número de Tropas disponibles: " + disp + "\n"
                    + "A - Arqueros\n"
                    + "C - Caballeros\n"
                    + "M - Magos\n"
                    + "S - Salir").toUpperCase();

            switch (op) {

                case ("A"):
                    arq = Integer.parseInt(JOptionPane.showInputDialog
                    ("Ingrese la cantidad de arqueros deseados\n"));
                    
                    if (arq < disp) {
                       // agregar los arqueros a la cola**
                       // System.out.println("arq:" + arq); // PRUEBA
                       disp = disp - arq; //Resta de disp los miemb ingresados
                    } else if (arq == disp){
                        // agregar los arqueros a la cola**
                        // System.out.println("arq:" + arq); // PRUEBA
                        disp = disp - arq; 
                    } else {
                        String limSup= JOptionPane.showInputDialog
                        ("Cantidad ingresada supera los disponibles, "
                        + "intentelo de nuevo");
                    }
                    
                    break;

                case ("C"):
                    cab = Integer.parseInt(JOptionPane.showInputDialog
                    ("Ingrese la cantidad de caballeros deseados\n"));
                    
                    if (cab < disp) {
                       // agregar los arqueros a la cola**
                       disp = disp - cab; //Resta de disp los miemb ingresados
                    } else if (cab == disp){
                        // agregar los arqueros a la cola**
                        disp = disp - cab; 
                        
                    } else {
                        String limSup= JOptionPane.showInputDialog
                        ("Cantidad ingresada supera los disponibles, "
                                + "intentelo de nuevo");
                    }
                    
                    break;

                case ("M"):
                    mag = Integer.parseInt(JOptionPane.showInputDialog
                    ("Ingrese la cantidad de magos deseados\n"));
                    if (mag < disp) {
                       // agregar los arqueros a la cola**
                       disp = disp - mag; //Resta de disp los miemb ingresados
                    } else if (mag == disp){
                        // agregar los arqueros a la cola**
                        disp = disp - mag; 
                    } else {
                        String limSup= JOptionPane.showInputDialog
                        ("Cantidad ingresada supera los disponibles, "
                        + "intentelo de nuevo");
                    }
                    break;

                case ("S"):

                    break;

                default:

                    JOptionPane.showMessageDialog
                    (null, "Ingrese una opcion valida");
                    //menu();

                    break;
            }
        }
        return colaJug;
    }

}
