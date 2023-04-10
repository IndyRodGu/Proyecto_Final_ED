
package proyecto_tower_defense;

public class Torre {
    //Cantidad de vidas total de la torre
    private double vida = 10;
    
    // Método para restar las vidas según el daño causado
    public void danio (double danio) {
        vida = vida - danio;
    }
    
    // Método para comprobar si la torre ha sido destruido
    public boolean isDestruido(){
        // 
        if (vida <= 0){ // Cuando el castillo ya no tenga vidas, 
                        // devuelve verdadero
            return true;
        } // Si la torre todavía tiene vidas, devuelve falso
        return false;
}
}
