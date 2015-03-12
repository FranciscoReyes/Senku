
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Francisco A. Reyes
 */
public class Senku {
    
    public static final String STANDARD = "7EstandarLEVEL.txt";
    public static final String FRENCH = "7FrenchLEVEL.txt";
    public static final String ASIMETRIC = "8AsimetricLEVEL.txt";
    public static final String DIAMANT = "9DiamantLEVEL.txt";
    public static final String JCW = "9JCWLEVEL.txt";

    private String[][] tablero = new String[7][7];
    private String[][] tableroEdit;

    private ArrayList<int[]> movesSaved = new ArrayList();

    private String bola = "O ";
    private String vacio = "    ";
    private String hueco = " .  ";
    
    private FileReader fr;
    private BufferedReader br;
    private int sizeTablero;

    public Senku() {
       this.buildTablero(Senku.STANDARD);
    }

    public void buildTablero(String fileName) {
        this.leerTablero(fileName);
        this.tableroEdit = new String[this.sizeTablero][this.sizeTablero];

        for (int i = 0; i < this.sizeTablero; i++) {
            try {
                String linea = br.readLine();
                for (int j= 0; j< this.sizeTablero; j++) {
                    if (linea.charAt(j) == ' ' ){
                        tableroEdit[i][j] = this.vacio;
                    } else {
                        if (linea.charAt(j) == 'O'){
                            tableroEdit[i][j] = this.bola;
                        } else {
                            if (linea.charAt(j) == '.'){
                                tableroEdit[i][j] = this.hueco;
                            }
                        }
                    }
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Senku.class.getName()).log(Level.SEVERE, null, ex);
            }
                                                                                                                                       
        }

    }
    
    public String[][] getBuildedTablero () {
        return this.tableroEdit;
    }
    
    private void leerTablero(String fileName) {
        try {
            br = new BufferedReader(fr = new FileReader(fileName));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Senku.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setSizeTablero(fileName);
    }

    private void setSizeTablero(String fileName) {
        this.sizeTablero = Integer.valueOf(String.valueOf(fileName.charAt(0)));
    }
    
    public int getSizeTablero() {
        return this.sizeTablero;
    }
    
    public String[][] getTablero() {
        String[][] newtablero = tablero;

        return newtablero;
    }

    public void moverFicha(int coordX1, int coordY1, int coordX2, int coordY2) {
        int x3 = -1;
        int y3 = -1;
        boolean bola1;
        boolean bola2;

        if (coordX1 == coordX2) {
            x3 = coordX1;
            if (coordY1 > coordY2) {
                y3 = coordY1 - 1;
            } else {
                y3 = coordY2 - 1;
            }
        } else {
            if (coordY1 == coordY2) {
                y3 = coordY1;
                if (coordX1 > coordX2) {
                    x3 = coordX1 - 1;
                } else {
                    x3 = coordX2 - 1;
                }
            }
        }

        if (tableroEdit[coordX1][coordY1].contains("O")) {
            bola1 = true;
        } else {
            bola1 = false;
        }

        if (tableroEdit[coordX2][coordY2].contains("O")) {
            bola2 = true;
        } else {
            bola2 = false;
        }

        if (bola1 == true && bola2 == false) {
            if (tableroEdit[x3][y3].contains("O")) {
                tableroEdit[x3][y3] = " .  ";
                tableroEdit[coordX2][coordY2] = "O ";
                tableroEdit[coordX1][coordY1] = " .  ";
            }
        }

        this.saveMove(coordX1, coordY1, coordX2, coordY2);
    }

    private void saveMove(int x1, int y1, int x2, int y2) {
        int[] move = new int[4];

        for (int i = 0; i < move.length; i++) {
            switch (i) {
                case 0:
                    move[i] = x1;
                    break;
                case 1:
                    move[i] = y1;
                    break;
                case 2:
                    move[i] = x2;
                    break;
                case 3:
                    move[i] = y2;
                    break;
            }
        }

        movesSaved.add(move);
    }

}
