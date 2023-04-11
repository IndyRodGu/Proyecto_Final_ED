
package proyecto_tower_defense;

import javax.swing.ImageIcon; // Permite agregar Imagenes

/* Clase Tropa, define y compara los tipos de tropas entre si*/

public class Tropa {
    private TipoTropa TipoTropa;
    private TipoTropa vulnerability;
    private Double towerWreckage; // hay danio de 1.5 a la torre
    private ImageIcon image; /// Agrega las imagenes de las tropas
    private int id;     // identificador
    private int player; //1 = jugador y 2 = cpu (impares jugador, pares CPU)
    
    
// Constructor -----------------------------------------------------------------
    
    public Tropa(TipoTropa TipoTropa, int id, int player) {
        this.TipoTropa = TipoTropa;
        this.id = id;
        this.player = player;
        setTipoTropa(TipoTropa);
    }

//Gets and Sets ---------------------------------------------------------------

    /* Asigna una debilidad, su imagen y el danio que causa */
    public void setTipoTropa(TipoTropa TipoTropa) {
        this.TipoTropa = TipoTropa;
        switch (TipoTropa) {
            case ARQUERO:
                this.image = new ImageIcon("src/images/archer.png");
                this.towerWreckage = 1.0;
                this.vulnerability = TipoTropa.CABALLERO;              
                break;
            case CABALLERO:
                this.image = new ImageIcon("src/images/knight.png");
                this.towerWreckage = 2.0;
                this.vulnerability = TipoTropa.MAGO;
                break;
            case MAGO:
                this.image = new ImageIcon("src/images/warlock.png");
                this.towerWreckage = 1.5;
                this.vulnerability = TipoTropa.ARQUERO;
                break;
            default:
                break;
        }
    }
 
    public TipoTropa getTipoTropa() {
        return TipoTropa;
    }

    public TipoTropa getVulnerability() {
        return vulnerability;
    }

    public Double getTowerWreckage() {
        return towerWreckage;
    }

    public ImageIcon getImage() {
        return image;
    }
    
}
    

