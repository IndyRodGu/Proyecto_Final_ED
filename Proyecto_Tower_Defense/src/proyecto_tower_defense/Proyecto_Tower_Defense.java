
package proyecto_tower_defense;
import javax.swing.JOptionPane;

public class Proyecto_Tower_Defense {

    public static void main(String[] args) {
        
        
        menu();

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
    
    
    
    public void escena1(){
        // Escena 1 -----------
        
        // Tropas disponibles 5: cuantos Arqueros desea
        // Tropas disponible 3: cuantos Magos
        // Tropas disponible 3: cuantos Magos
        // Verificar si es mayor -> Alerta
        // ColaCPU.aleatorio()
        
        // boton aceptar
    }
    
    public static void menu() {

        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Tower Defense\n"
                + "1- Iniciar\n"
                + "2- Salir"));

        switch (op) {

            case (1):

                break;

            case (2):

                break;

            default:

                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                menu();

                break;
        }

    }
    
     public static void menuJuego() {

        int op = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                + "Escoger\n"
                + "2- Salir"));

        switch (op) {

            case (1):

                break;

            case (2):

                break;

            default:

                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                menu();

                break;
        }

    }
    
    
    
}



