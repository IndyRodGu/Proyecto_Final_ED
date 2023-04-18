package proyecto_tower_defense;

import java.util.Random;
import javax.swing.JOptionPane;

public class Miscelaneos {

        
    public void Tablero() {
        int filas = 5;
        int columnas = 6;
        String tablero[][] = new String[filas][columnas];

        String JP = "";
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // tablero [i][j]="| __ | ";

                if (i == 2 && j == 0) {
                    tablero[i][j] = "|T / J    ";
                } else if (i == 1 && j == 0) {
                    tablero[i][j] = "|Pts: 10";
                } else if (i == 2 && j == 5) {
                    tablero[i][j] = "|T / C";
                } else {
                    tablero[i][j] = "|           ";
                }
                JP += tablero[i][j];
            }
            JP += "\n";
        }

        tablero[2][0] = "T/J";
        JOptionPane.showMessageDialog(null, JP);

    }

    public void SelecCaminosJug(int disp) { 
        for (int i = 0; i < disp; i++) {
            int camino = Integer.parseInt(JOptionPane.showInputDialog("Elija su camino \n"
                    + "1- Arriba \n" + "2- Abajo"));

            switch (camino) {
                case 1:
                    // Camino de arriba
                    System.out.println("arriba");
                    break;
                case 2:
                    // Camino de abajo
                    System.out.println("abajo");
                    break;
            }
        }
    }
    
    /*//Seleccionar el Camino 
    public void SelecCaminoCPU(Cola CPU){
        int tropaTotal = ; // Cantidad total de tropas del CPU
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
    }*/
    }

