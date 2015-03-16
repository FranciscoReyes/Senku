
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

    private String[][] tableroEdit;

    private ArrayList<Moves> movesSaved = new ArrayList();

    private String bola = "O ";
    private String vacio = "    ";
    private String hueco = " .  ";

    private int coordXWin;
    private int coordYWin;
    private int countO = 0;
    private boolean youWin;

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
                for (int j = 0; j < this.sizeTablero; j++) {
                    if (linea.charAt(j) == ' ') {
                        tableroEdit[i][j] = this.vacio;
                    } else {
                        if (linea.charAt(j) == 'O') {
                            tableroEdit[i][j] = this.bola;
                        } else {
                            if (linea.charAt(j) == '.') {
                                tableroEdit[i][j] = this.hueco;
                            } else {
                                if (linea.charAt(j) == '@') {
                                    tableroEdit[i][j] = this.hueco;
                                    this.coordXWin = i;
                                    this.coordYWin = j;
                                } else {
                                    if (linea.charAt(j) == 'Q') {
                                        tableroEdit[i][j] = this.bola;
                                        this.coordXWin = i;
                                        this.coordYWin = j;
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(Senku.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public boolean checkWin() {
        int X = -1;
        int Y = -1;
        this.countO= 0;
        for (int i = 0; i < this.tableroEdit.length; i++) {
            for (int j = 0; j < this.tableroEdit.length; j++) {
                if (this.tableroEdit[i][j].contains("O")) {
                    this.countO++;
                    X = i;
                    Y = j;
                }
            }
        }

        if (this.countO == 1 && X == this.coordXWin && Y == this.coordYWin) {
            youWin = true;
        } else {
            if(this.countO == 1 && X != this.coordXWin && Y != this.coordYWin) {
                youWin = false;
            }
        }
        return youWin;
    }

    public String[][] getBuildedTablero() {
        return this.tableroEdit;
    }

    private void leerTablero(String fileName) {
        try {
            br = new BufferedReader(fr = new FileReader(fileName));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Senku.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        this.setSizeTablero(fileName);
    }

    private void setSizeTablero(String fileName) {
        this.sizeTablero = Integer.valueOf(String.valueOf(fileName.charAt(0)));
    }

    public int getSizeTablero() {
        return this.sizeTablero;
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
                Moves coordMove = new Moves(coordX1, coordY1, coordX2, coordY2);
                this.saveMove(coordMove);
            }
        }
        

    }

    public void goBack() {

        int newX3 = -1;
        int newY3 = -1;

        this.tableroEdit[this.movesSaved.get(0).getX1()][this.movesSaved.get(0).getY1()] = "O ";
        this.tableroEdit[this.movesSaved.get(0).getX2()][this.movesSaved.get(0).getY2()] = " .  ";

        if (this.movesSaved.get(0).getX1() == this.movesSaved.get(0).getX2()) {
            newX3 = this.movesSaved.get(0).getX1();
            if (this.movesSaved.get(0).getY1() > this.movesSaved.get(0).getY2()) {
                newY3 = this.movesSaved.get(0).getY1() - 1;
            } else {
                newY3 = this.movesSaved.get(0).getY2() - 1;
            }
        } else {
            if (this.movesSaved.get(0).getY1() == this.movesSaved.get(0).getY2()) {
                newY3 = this.movesSaved.get(0).getY1();
                if (this.movesSaved.get(0).getX1() > this.movesSaved.get(0).getX2()) {
                    newX3 = this.movesSaved.get(0).getX1() - 1;
                } else {
                    newX3 = this.movesSaved.get(0).getX2() - 1;
                }
            }
        }

        this.tableroEdit[newX3][newY3] = "O ";
        this.movesSaved.remove(0);

    }

    private void saveMove(Moves name) {
        this.movesSaved.add(0, name);
    }
    
    public ArrayList getMovesList() {
        return this.movesSaved;
    }
    
    

}
