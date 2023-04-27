/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_tower_defense;

/**
 *
 * @author jenny
 */
/* Movimientos del juego*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public abstract class Juego extends JFrame implements ActionListener {

    // MARCO DE LA APP
    JFrame ventana;

    // PANEL DE PRESENTACIîN
    JPanel panelPresentacion;
    JButton iniciar;
    JLabel fondoPresentacion;
    ImageIcon imagenFondoPres;

    // PANEL MENU: VA SOBRE EL PANEL DE PRESENTACIîN
    JPanel panelMenu;
    JLabel fondoMenu;
    ImageIcon imagenFondoMenu;
    String jugador;
    JLabel nombre;
    JLabel cpu;

    // COMBO BOX
    private JLabel label1, label2;
    private JComboBox<String> combo1, combo2;
    private JButton boton1;

    // PANEL JUEGO
    static JPanel panelJuego;
    JLabel fondoJuego;
    ImageIcon imagenFondoJuego;
    
  
    
    // TORRE
    JLabel puntajeTorre1;
    JLabel puntajeTorre2;

    // TIEMPO

    
    public Juego() {
        //CREAR EL MARCO DE LA APP
        ventana = new JFrame("Tower Defense");
        ventana.setSize(1200, 750); // Tama–o de la ventana
        /*Permite poner botones e imagenes en la posici—n que queramos, de lo
        contrario el sistema lo pone por defecto
         */
        ventana.setLayout(null);
        //Colocar la ventana principal en el medio
        ventana.setLocationRelativeTo(null);
        // Permite que cuando le demos "x" la app termine
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Es para desactivar el boton de agradar la pesta–a(el amarillo)
        ventana.setResizable(false);

        // CREAR PANEL DE PRESENTACIîN
        panelPresentacion = new JPanel();
        panelPresentacion.setLayout(null);
        /*Lo vamos a poner en la posici—n (0,0) es decir en la esquina superior 
        izq de nuestra ventana y el panel va a ser del tama–o de la ventana 
        (tomamos el ancho y alto de la ventana principal)*/
        panelPresentacion.setBounds(0, 0, ventana.getWidth(),
                ventana.getHeight());
        panelPresentacion.setVisible(true); //Para que el panel sea visible

        // DARLE UNA IMAGEN DE FONDO AL PANEL DE PRESENTACIîN
        fondoPresentacion = new JLabel();
        /* le damos posicion y el tama–o a la imagen que vamos a poner
        entre el parentesis se da la ruta de donde se encuentra la imagen */
        fondoPresentacion.setBounds(0, 0, ventana.getWidth(),
                ventana.getHeight());
        imagenFondoPres = new ImageIcon("Imagen/fondo1.png");
        /* (getImage: es para coger la imagen) 
        (.getScaleInstance: le vamos a dar una nueva escala) 
        (ventana.getWidth: del tama–o/marco de la ventana) 
        (Image.SCALE_DEFAULT): Ayuda a adaptar el tama–o de la imagen a nuestro marco */
        imagenFondoPres = new ImageIcon(imagenFondoPres.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        //le agregamos la imagen al Label
        fondoPresentacion.setIcon(imagenFondoPres);
        //Para poder ver la imagen
        fondoPresentacion.setVisible(true);
        //Agregamos la imagen a la posicion cero
        panelPresentacion.add(fondoPresentacion, 0);

        //Dentro del parentesis se pone el texto que va a contener el boton
        iniciar = new JButton("Iniciar");
        iniciar.setBounds(ventana.getWidth() - 120, 20, 90, 40);
        iniciar.setVisible(true); //Para que el boton sea visible
        /*Aqui estamos montandolo encima de nuestro marco y lo colocamos como una capa, va a ser la parte de abajo
        Debo agregar los componenetes al panel, no la a ventana*/
        panelPresentacion.add(iniciar, 0);

        //MENU, darle memoria al boton
        boton1 = new JButton();
        
        // El boton por ahora no hace nada por tanto se crea un evento del boton
        iniciar.addMouseListener(new MouseAdapter() {
            //Funci—n del mouse
            public void mousePressed(MouseEvent e) {
                // Al dale click a iniciar deber’a aparecer el panel de menu
                menu();
            }
        });


