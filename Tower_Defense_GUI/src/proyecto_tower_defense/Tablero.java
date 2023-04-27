
package proyecto_tower_defense;


public class Tablero {
 
    Camino sup;             // Camino superior
    Camino inf;             // Camino inferior
    int filas;              // filas en tablero    
    int columnas;           // columnas de tablero
    String tablero[][];     // matriz tablero
    
    
    public Tablero(int filas, int columnas, Camino sup, Camino inf){
        // va a recibir el num de filas, columnas, y 2 los caminos
        this.filas = filas;
        this.columnas = columnas;
        this.tablero = new String[filas][columnas];
        this.sup = sup;
        this.inf = inf;
    }
    
    public String show(){ // Impresión de matriz en JOPtionPane
        String JP = "";
        for(int i = 0; i < filas; i ++){
            for(int j = 0; j < columnas; j ++){
                // --------------------------------- Torres: [2][0] y [2][5]
                if (i == 2 && (j == 0 || j == 5)){ 
                    tablero[i][j] = " _T_ ";
                }
                // --------------------------------- Camino superior 
                else if (i == 1){
                    tablero[i][j]=this.personaje(sup,j);
                } 
                // --------------------------------- Camino inferior 
                else if (i==3){
                    tablero[i][j]=this.personaje(inf,j);
                } 
                else{
                    tablero[i][j] = " ___ ";
                }
                JP += tablero[i][j];
            }
            //Lo agrega al string JP
            JP += "\n";
        }
        return JP;
    }

    
    public String personaje(Camino camino, int pos){ // devuelve quien es el personaje
        NodoCam aux = camino.cabeza; 
        int adoquin = 0;
        while(adoquin < pos){ 
            aux = aux.getNext();
            adoquin++;
        }
        if(aux.getDato() == null){
            return " ___ ";
        }
        else{
            switch (aux.getDato().getTipoTropa()) {
                case ARQUERO: 
                    return " _A_ ";
                case MAGO: 
                    return " _M_ ";
                default:
                    return " _C_ ";
            }
        }
    } 
    
    
    
}
