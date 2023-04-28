package proyecto_tower_defense;

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
import static proyecto_tower_defense.Proyecto_Tower_Defense.menuJuego;

public abstract class Juego extends JFrame implements ActionListener {

    int escena = 0;

    // MARCO DE LA APP
    JFrame ventana;

    // PANEL DE PRESENTACION
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
    JLabel tropaCPU;
    JLabel tropaJug;

    // COMBO BOX
    JButton boton2;
    private JButton boton1;

    // PANEL JUEGO
    static JPanel panelJuego;
    JLabel fondoJuego;
    ImageIcon imagenFondoJuego;
    JLabel rondaT;

    // TORRE
    JLabel puntajeTorre1;
    JLabel puntajeTorre2;

    // TIEMPO
    public Juego(Cola colaCPU, Cola colaJug, int disponibles, int ronda) {
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
        imagenFondoPres = new ImageIcon("Imagenes/fondo1.png");
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
        iniciar.setBounds(ventana.getWidth()/2-50, ventana.getHeight()/3*2, 100, 40);
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
                //menu();
                menu(colaCPU, colaJug, disponibles, ronda);
                escena = 1;
            }
        });

        ventana.add(panelPresentacion);
        ventana.setVisible(true);
    }

    public void menu(Cola colaCPU, Cola colaJug, int disponibles, int ronda) {
        /*
        Al llamar el método menú, lo primero que va a hacer es ocultar el panelPresentación
        por eso el "false" dentro del paréntesis
         */
        panelPresentacion.setVisible(false);

        // CREAMOS UN PANEL DEL TAMAÑO DE LA VENTNA
        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        panelMenu.setVisible(true);

        // FONDO DEL PANEL
        fondoMenu = new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu = new ImageIcon("Imagenes/fondo.png");
        imagenFondoMenu = new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
        panelMenu.add(fondoMenu, 0);

        colaCPU.agregaTropaCPU(disponibles - 1); // Agrega tropas
        colaCPU.SelecCaminoCPU();                // Asignar caminos           
        System.out.println("** Tropas del CPU **");
        System.out.println(colaCPU.verLista());
       

        // AGREGAR EL PANEL MENU A LA VENTANA
        ventana.add(panelMenu);
        ventana.setVisible(true);
        
        JOptionPane.showMessageDialog(null,"** Tropas del CPU **\n"
                    +colaCPU.verLista());
        
        colaJug = menuJuego(disponibles);        // Cola jugadores
        System.out.println("** Tropas del Jugador **");
        System.out.println(colaJug.verLista());  // Ver listas 

        JOptionPane.showMessageDialog(null,"** Tropas del Jugador **\n"
                    +colaJug.verLista());
       
        juego(ronda);
        escena = 3;
        
        //Dentro del parentesis se pone el texto que va a contener el boton
        boton2 = new JButton("Continuar");
        boton2.setBounds(ventana.getWidth()/2-50, ventana.getHeight()/3*2, 100, 40);
        boton2.setVisible(true); //Para que el boton sea visible
        /*Aqui estamos montandolo encima de nuestro marco y lo colocamos como una capa, va a ser la parte de abajo
        Debo agregar los componenetes al panel, no la a ventana*/
        panelMenu.add(boton2, 0);

        // El boton por ahora no hace nada por tanto se crea un evento del boton
        boton2.addMouseListener(new MouseAdapter() {
            //Funci—n del mouse
            public void mousePressed(MouseEvent e) {
                // Al dale click a iniciar deber’a aparecer el panel de menu
                //menu();
                juego (ronda);
            }
        });
        
    }

    public void juego(int ronda) {
        // CREAR OBJETOS TORRE Y CRONOMETRO
        Torre torre1 = new Torre();
        Torre torre2 = new Torre();
        Cronometro crono = new Cronometro();

        panelMenu.setVisible(false);

        // CREAMOS UN PANEL DEL TAMAÑO DE LA VENTNA
        panelJuego = new JPanel();
        panelJuego.setLayout(null);
        panelJuego.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        panelJuego.setVisible(true);

        // FONDE DEL JUEGO
        fondoJuego = new JLabel();
        fondoJuego.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoJuego = new ImageIcon("Imagenes/fondo.png");
        imagenFondoJuego = new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoJuego.setIcon(imagenFondoJuego);
        fondoJuego.setVisible(true);
        panelJuego.add(fondoJuego, 0);

        // PUNTOS DE LAS TORRES
        // TORRE 1
        puntajeTorre1 = new JLabel("Puntos Torre: " + torre1.getVida());
        puntajeTorre1.setBounds(90, 330, 200, 30);
        puntajeTorre1.setFont(new Font("SANS_SERIF", Font.BOLD, 10));
        panelJuego.add(puntajeTorre1, 0);

        //NOMBRE DEL USUARIO EN TORRE 1
        nombre = new JLabel("Jugador ");
        nombre.setBounds(20, 240, 400, 30);
        nombre.setFont(new Font("SANS_SERIF", Font.BOLD, 15));
        panelJuego.add(nombre, 0);

        // TORRE 2
        puntajeTorre2 = new JLabel("Puntos Torre: " + torre2.getVida());
        puntajeTorre2.setBounds(1025, 330, 200, 30);
        puntajeTorre2.setFont(new Font("SANS_SERIF", Font.BOLD, 10));
        panelJuego.add(puntajeTorre2, 0);

        //NOMBRE DEL CPU EN TORRE 2
        cpu = new JLabel("CPU");
        cpu.setBounds(1127, 240, 70, 30);
        cpu.setFont(new Font("SANS_SERIF", Font.BOLD, 15));
        panelJuego.add(cpu, 0);
        

        // Nombre Ronda
        rondaT = new JLabel ("Ronda: "+ ronda); // Agregar el resto del codigo cuando se haga el merge con el proyecto principal
        rondaT.setBounds(550, 70, 100, 30);
        rondaT.setFont(new Font("SANS_SERIF", Font.BOLD, 15));
        rondaT.setHorizontalAlignment(JLabel.CENTER);
        rondaT.setForeground(Color.BLACK);
        rondaT.setBackground(Color.CYAN);
        rondaT.setOpaque(true);
        rondaT.setVisible(true);
        panelJuego.add(rondaT, 0);

        //Etiqueta donde se colocara el tiempo 
        panelJuego.add(crono.getTiempo(), 0);

        ventana.add(panelJuego);
        ventana.setVisible(true);
    }

    public int getEscena() {
        return escena;

    }

}
