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
//
//        long t1, t2, dif;
//        String cad;
//        Scanner teclado = new Scanner(System.in);
//
//        // Se toma la hora en el inicio del programa
//        Calendar ahora1 = Calendar.getInstance(); // Crear una instancia de la clase Calendar
//        t1 = ahora1.getTimeInMillis(); // Esta variable guarda la hora actual en milisegundos
//        
//        // Código de lo que se quiere cronometrar
//        System.out.println("Empieza a contar el tiempo.");
//        System.out.println("Pulsa Intro para terminar");
//
//        // Se espera q el usuario pulse Intro
//        cad = teclado.nextLine();
//        
//        // Luego del código se obtiene la nueva hora en ms para posteriormente calcular la diferencia.
//        //Se vuelve a tomar la hora una vez que ha pulsado Intro
//        Calendar ahora2 = Calendar.getInstance();
//        t2 = ahora2.getTimeInMillis();
//
//        /* El tiempo tardado será la diferencia de la hora tomada al final (t2)
//         y la tomada al principio (t1), que se guardará en una variable de 
//         tipo long. */
//        dif = t2 - t1;
//        
//        // Se muestra en pantalla la diferencia de tiempo obtenido
//        System.out.println("Has tardado: " + dif + "milisegundos");
//        System.out.printf("Equivale a: %.3f segundos", (double) dif / 1000);
//        
