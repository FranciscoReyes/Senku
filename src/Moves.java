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
     *
     * @return
     */
    public int getX1 () {
        return this.x1;
    }
    
    /**
     *
     * @return
     */
    public int getY1 () {
        return this.y1;
    }
    
    /**
     *
     * @return
     */
    public int getX2 () {
        return this.x2;
    }
    
    /**
     *
     * @return
     */
    public int getY2 () {
        return this.y2;
    }
}
