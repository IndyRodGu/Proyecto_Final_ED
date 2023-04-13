/*Cronometro que indica el tiempo transcurrido en el juego */
package proyecto_tower_defense;

import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Cronometro {
    
        private int delay = 1000; // En milisegundos
        private int segundos = 0;
        private int minutos = 0;
        private Timer timer;
        
        public void mostrarCronometro(){
            timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                if (segundos == 60) {
                    minutos++;
                    segundos = 0;
                }
            }
        });
        timer.start(); // Mover al main
        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, "Tiempo transcurri"
                    + "do: " + minutos + " min " + segundos + " seg. ¿Desea "
                            + "continuar?", "Cronómetro", 
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.NO_OPTION) {
                timer.stop();
                break;
            }
        }
    }
}
