/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francisco A. Reyes
 */
public class Moves {

    int x1;
    int x2;
    int y1;
    int y2;

    Moves(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    
    /**
     * Devuelve coordenada X1
     * @return int coordenada origen X1 (fila matriz)
     */
    public int getX1 () {
        return this.x1;
    }
    
    /**
     * Devuelve coordenada Y1
     * @return int coordenada origen Y1 (columna matriz)
     */
    public int getY1 () {
        return this.y1;
    }
    
    /**
     * Devuelve coordenada X2
     * @return int coordenada destino X2 (fila matriz)
     */
    public int getX2 () {
        return this.x2;
    }
    
    /**
     * Devuelve coordenada Y1 
     * @return int coordenada destino Y2(columna matriz)
     */
    public int getY2 () {
        return this.y2;
    }
}
