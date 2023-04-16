package proyecto_tower_defense;

import javax.swing.JOptionPane;

public class Proyecto_Tower_Defense {
        // TORRE
        public static Torre TorreCPU = new Torre();
        public static Torre TorreJug = new Torre();
        public static Miscelaneos msn= new Miscelaneos();
        //msn.SelecCaminos();
        //System.out.println(msn);
        public static Camino superior = new Camino();
        public static Camino inferior = new Camino();
        
    public static void main(String[] args) {
        

//        superior.construirCamino(6);
//        superior.imprimirA();
//        System.out.println("");
//        superior.imprimirB();
//        System.out.println("");
//        
//        Tropa t = new Tropa(TipoTropa.ARQUERO,1,1);
//        superior.ingresaTropaJug(t);
//        superior.imprimirJug();
        int disponibles;
        int ronda = 1;

        // Menu principal ------------------------------------------------------
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Tower Defense\n" + "1- Iniciar juego\n"
                + "2- Salir"));

        // Lógica de escenas -------------------------------------
        boolean juego = true; // Mientras el juego esté en curso
        do {
            disponibles = ronda + 4;
            switch (op) {
                case (1): // Escena 1: se escogen las tropas
                    // Cola colaJug = menuJuego(disponibles);
                    Cola colaCPU = new Cola();
                    //Calculo de disponibles para el CPU.
                    colaCPU.agregaTropaCPU(disponibles - 1);

                    // ColaCPU.aleatorio()
                    op = 3; // para "cambiar de escena"
                    ronda++; // Aumenta una ronda para la siguiente
                    break;

                case (2): // Termina 

                    juego = false;
                    break;
                    
                case (3):
                    juego();
                    if (TorreCPU.isDestruido() || TorreJug.isDestruido()) {
                        op=2;
                    }
                    break;
                 ///desarrolo de loas casos faltantes    
                default:
                    JOptionPane.showMessageDialog(null,
                            "Ingrese una opcion valida");
                    break;
            }

        } while (juego);

    }

    // Escena 1 -----------
    public static Cola menuJuego(int disp) { // Cant. tropas disponibles

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
                    arq = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de arqueros deseados\n"));

                    if (arq < disp) {
                        // agregar los arqueros a la cola**
                        // System.out.println("arq:" + arq); // PRUEBA
                        colaJug.agregaTropaJugador(arq, TipoTropa.ARQUERO);
                        disp = disp - arq; //Resta de disp los miemb ingresados
                    } else if (arq == disp) {
                        // agregar los arqueros a la cola**
                        // System.out.println("arq:" + arq); // PRUEBA
                        colaJug.agregaTropaJugador(arq, TipoTropa.ARQUERO);
                        disp = disp - arq;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Cantidad ingresada supera los disponibles, "
                                + "intentelo de nuevo");
                    }

                    break;

                case ("C"):
                    cab = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de caballeros deseados\n"));

                    if (cab < disp) {
                        // agregar los arqueros a la cola**
                        colaJug.agregaTropaJugador(cab, TipoTropa.CABALLERO);

                        disp = disp - cab; //Resta de disp los miemb ingresados
                    } else if (cab == disp) {
                        // agregar los arqueros a la cola**
                        colaJug.agregaTropaJugador(cab, TipoTropa.CABALLERO);
                        disp = disp - cab;

                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Cantidad ingresada supera los disponibles, "
                                + "intentelo de nuevo");
                    }

                    break;

                case ("M"):
                    mag = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de magos deseados\n"));
                    if (mag < disp) {
                        // agregar los arqueros a la cola**
                        colaJug.agregaTropaJugador(mag, TipoTropa.MAGO);

                        disp = disp - mag; //Resta de disp los miemb ingresados
                    } else if (mag == disp) {
                        // agregar los arqueros a la cola**
                        colaJug.agregaTropaJugador(mag, TipoTropa.MAGO);
                        disp = disp - mag;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Cantidad ingresada supera los disponibles, "
                                + "intentelo de nuevo");
                    }
                    break;

                case ("S"):

                    break;

                default:

                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                    //menu();

                    break;
            }
            //JOptionPane.showMessageDialog(null, colaJug.imprimir());                    
            System.out.println(colaJug.imprimir());
        }
        return colaJug;
    }
    
        public static void juego() {
        System.out.println("hola");
    }

}
