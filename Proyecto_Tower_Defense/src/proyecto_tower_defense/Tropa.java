
package proyecto_tower_defense;

import javax.swing.ImageIcon;

/* Clase Tropa, define y compara los tipos de tropas entre si*/

public class Tropa {
    private TipoTropa TipoTropa;
    private TipoTropa vulnerability;
    private Double towerWreckage; // hay danio de 1.5 a la torre
    private boolean isPlayeTroop=  false;
    private ImageIcon image; /// Agrega las imagenes de las tropas

// Constructor
    public Tropa(TipoTropa TipoTropa) {
        this.TipoTropa = TipoTropa;

/* Asigna una debilidad, su imagen y el danio que causa */

        switch (TipoTropa) {
            
            case WARLOCK:
                this.vulnerability = TipoTropa.ARCHER; // ARCHER gana WARLOCK
                this.towerWreckage = 1.5;
                this.image = new ImageIcon("src/images/warlock.png");
                break;
                
            case KNIGHT:
                this.vulnerability = TipoTropa.WARLOCK; // WARLOCK gana KNIGHT
                this.towerWreckage = 2.0;
                this.image = new ImageIcon("src/images/knight.png");
                break;
                
            case ARCHER:
                this.vulnerability = TipoTropa.KNIGHT; // KNIGHT gana ARCHER
                this.towerWreckage = 1.0;
                this.image = new ImageIcon("src/images/archer.png");
                break;
                      
            default:
                break;
        }
    }

    //Gets and Sets
    public TipoTropa getTroopType() {
        return TipoTropa;
    }

    public void setTroopType(TipoTropa TipoTropa) {
        this.TipoTropa = TipoTropa;

/*Para cambiar el tipo de tropa, cada uno tiene debilidad,imagen y nivel danio*/
        switch (TipoTropa) {
            
            case WARLOCK:
                this.vulnerability = TipoTropa.ARCHER; // ARCHER gana WARLOCK
                this.towerWreckage = 1.5;
                this.image = new ImageIcon("src/images/warlock.png");
                break;
                
             case KNIGHT:
                this.vulnerability = TipoTropa.WARLOCK; // WARLOCK gana KNIGHT
                this.towerWreckage = 2.0;
                this.image = new ImageIcon("src/images/knight.png");
                break;
                
            case ARCHER:
                this.vulnerability = TipoTropa.KNIGHT ; // KNIGHT gana ARCHER
                this.towerWreckage = 1.0;
                this.image = new ImageIcon("src/images/archer.png");
                break;     
           
            default:
                break;
        }
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

    public boolean getIsPlayerTropa() {
        return isPlayerTroop;
    }
    
// Colocar las imagenes de las tropas
    public void setIsPlayerTropa(boolean isPlayerTroop) {
        this.isPlayerTropa = isPlayerTroop;
        
        switch (TipoTropa) {
            
            case ARCHER:
                this.image = new ImageIcon("src/image/Archer Rotated.png");
                break;
                
            case KNIGHT:
                this.image = new ImageIcon("src/image/Warrior Rotated.png");
                break;
                
            case WARLOCK:
                this.image = new ImageIcon("src/image/Wizard Rotated.png");
                break;
                
            default:
                break;
        }
    }
}
    

