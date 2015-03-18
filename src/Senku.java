
import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

    /**
     *
     */
    public static final String STANDARD = "7EstandarLEVEL.txt";

    /**
     *
     */
    public static final String FRENCH = "7FrenchLEVEL.txt";

    /**
     *
     */
    public static final String ASIMETRIC = "8AsimetricLEVEL.txt";

    /**
     *
     */
    public static final String DIAMANT = "9DiamantLEVEL.txt";

    /**
     *
     */
    public static final String JCW = "9JCWLEVEL.txt";

    private String[][] tableroEdit;

    private ArrayList<Moves> movesSaved = new ArrayList();

    private String bola = "O ";
    private String vacio = "    ";
    private String hueco = " .  ";

    private int coordXWin;
    private int coordYWin;
    private int countO = 0;
    private int youWin = 0;

    private FileReader fr;
    private BufferedReader br;
    private int sizeTablero;
    private String idBoard;
    /**
     *
     */
    public Senku() {
        this.buildTablero(Senku.STANDARD);
    }
    

    /**
     *
     * @param fileName
     */
    public void buildTablero(String fileName) {
        this.leerTablero(fileName);
        if (!this.movesSaved.isEmpty()) {
            this.movesSaved.clear();
        }
        
        this.idBoard = fileName;
        
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
    
    private void leerTablero(String fileName) {
        try {
            br = new BufferedReader(fr = new FileReader(fileName));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Senku.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        this.setSizeTablero(fileName);
    }
    
    /**
     *
     */
    public void restartBoard () {
        this.buildTablero(this.idBoard);
        this.movesSaved.clear();
    }
    
    /**
     *
     * @return
     */
    public int checkWin() {
        int X = -1;
        int Y = -1;
        this.countO = 0;
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
            youWin = 1;
        } else {
            if (this.countO == 1 && X != this.coordXWin && Y != this.coordYWin) {
                youWin = 2;
            }
        }
        return youWin;
    }

    /**
     *
     * @return
     */
    public String[][] getBuildedTablero() {
        return this.tableroEdit;
    }

    

    private void setSizeTablero(String fileName) {
        this.sizeTablero = Integer.valueOf(String.valueOf(fileName.charAt(0)));
    }

    /**
     *
     * @return
     */
    public int getSizeTablero() {
        return this.sizeTablero;
    }

    /**
     *
     * @param coordX1
     * @param coordY1
     * @param coordX2
     * @param coordY2
     */
    public void moverFicha(int coordX1, int coordY1, int coordX2, int coordY2) {

        int x3 = -1;
        int y3 = -1;
        boolean bola1;
        boolean bola2 = true;

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
            if (tableroEdit[coordX2][coordY2].contains(".")) {
                 bola2 = false;
            } 
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

    /**
     *
     */
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

    /**
     *
     * @return
     */
    public ArrayList getMovesList() {
        return this.movesSaved;
    }

    /**
     *
     */
    public void createMovesHistoryXML() {

        try {
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            Document documento = creadorDocumento.newDocument();
            
            Element root = documento.createElement("SENKU");
            documento.appendChild(root);
            
            for (int i=0; i<this.movesSaved.size(); i++) {
                Element move = documento.createElement("MOVE");
                root.appendChild(move);
                
                Element pos = documento.createElement("MOVE_LIST");
                pos.appendChild(documento.createTextNode(String.valueOf(i + 1)));
                move.appendChild(pos);
                
                
                Element coords = documento.createElement("COORDINATES");
                move.appendChild(coords);
                              
                
                Element x1 = documento.createElement("INITIAL_X");
                Element y1 = documento.createElement("INITIAL_Y");
                Element x2 = documento.createElement("DESTINY_X");
                Element y2 = documento.createElement("DESTINY_Y");
                x1.appendChild(documento.createTextNode(""+this.movesSaved.get(i).getX1()));
                y1.appendChild(documento.createTextNode(""+this.movesSaved.get(i).getY1()));
                x2.appendChild(documento.createTextNode(""+this.movesSaved.get(i).getX2()));
                y2.appendChild(documento.createTextNode(""+this.movesSaved.get(i).getY2()));
                
                coords.appendChild(x1);
                coords.appendChild(y1);
                coords.appendChild(x2);
                coords.appendChild(y2);
                
            }
            
            TransformerFactory fábricaTransformador = TransformerFactory.newInstance();
            Transformer transformador = fábricaTransformador.newTransformer();
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
            transformador.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "3");
            Source origen = new DOMSource(documento);

            Result destino = new StreamResult("historic.xml");
            transformador.transform(origen, destino);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Senku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Senku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Senku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param boardName
     */
    public void selectBoard(int boardName) {
        switch (boardName) {
            case 0:
                this.buildTablero(Senku.STANDARD);
                break;
            case 1:
                this.buildTablero(Senku.FRENCH);
                break;
            case 2:
                this.buildTablero(Senku.ASIMETRIC);
                break;
            case 3:
                this.buildTablero(Senku.DIAMANT);
                break;
            case 4:
                this.buildTablero(Senku.JCW);
                break;
        }
        this.movesSaved.clear();
    }
}
