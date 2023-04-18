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
    }

