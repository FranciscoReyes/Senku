
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.time.StopWatch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Francisco A. Reyes
 */
public class WindowSenku extends javax.swing.JFrame {

    //Cosas que hacer, Idioma automatico, CSV, ContadordeTiempo

    Senku game = new Senku();
    StopWatch timeCounter = new StopWatch();
    
    private static Locale locale = Locale.getDefault();
    
    

    /**
     *
     */
        public WindowSenku() {
        initComponents();
        timeCounter.start();
        this.writeTablero();
        setDefaultCloseOperation(WindowSenku.DO_NOTHING_ON_CLOSE);
        
        ResourceBundle bundle = ResourceBundle.getBundle("res/strings", locale);
            System.out.println(locale.getDisplayCountry());
    }

    private void writeTablero() {
        area.setText(null);
        area.setText("(Y)\n");

        for (int i = 0; i < game.getBuildedTablero().length; i++) {
            for (int j = 0; j < game.getBuildedTablero().length; j++) {

                if (j == 0) {
                    area.append(" " + i + "  ");
                }

                if (j == game.getSizeTablero() - 1) {
                    area.append(game.getBuildedTablero()[i][j] + "\n");
                } else {
                    area.append(game.getBuildedTablero()[i][j]);
                }
            }
        }

        switch (game.getSizeTablero()) {
            case 7:
                area.append("      0 1  2  3 4  5  6 (X)");
                break;
            case 8:
                area.append("      0 1  2  3 4  5  6 7 (X)");
                break;
            case 9:
                area.append("      0 1  2  3 4  5  6 7  8 (X)");
                break;
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        coordX1 = new javax.swing.JTextField();
        coordY1 = new javax.swing.JTextField();
        coordX2 = new javax.swing.JTextField();
        coordY2 = new javax.swing.JTextField();
        Mover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonBack = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        selectNewBoard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        area.setEditable(false);
        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("res/strings"); // NOI18N
        jLabel1.setText(bundle.getString("mov")); // NOI18N

        Mover.setText(bundle.getString("moverbola")); // NOI18N
        Mover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoverActionPerformed(evt);
            }
        });

        jLabel2.setText("Y");

        jLabel3.setText("X");

        jLabel4.setText(bundle.getString("posini")); // NOI18N

        jLabel5.setText(bundle.getString("posdes")); // NOI18N

        botonBack.setText(bundle.getString("volv")); // NOI18N
        botonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBackActionPerformed(evt);
            }
        });

        restartButton.setText(bundle.getString("rein")); // NOI18N
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        selectNewBoard.setText(bundle.getString("nwtablero")); // NOI18N
        selectNewBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectNewBoardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(selectNewBoard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(restartButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(coordX1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(29, 29, 29)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(coordY1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(coordX2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(coordY2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(Mover))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addGap(31, 31, 31))))
                            .addComponent(botonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(coordY1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coordX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(coordX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coordY2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addComponent(Mover))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(138, 138, 138)))
                        .addComponent(botonBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restartButton)
                    .addComponent(selectNewBoard))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoverActionPerformed

        try {
            int x1 = Integer.valueOf(coordX1.getText());
            int y1 = Integer.valueOf(coordY1.getText());
            int x2 = Integer.valueOf(coordX2.getText());
            int y2 = Integer.valueOf(coordY2.getText());

            game.moverFicha(x1, y1, x2, y2);

            area.setText(null);
            this.writeTablero();

            if (game.checkWin() != 0) {
                if (game.checkWin() == 1) {
                    JOptionPane.showMessageDialog(this, "Enhorabuena, has ganado", "Genial", JOptionPane.INFORMATION_MESSAGE, null);
                } else {
                    if (game.checkWin() == 2)
                    JOptionPane.showMessageDialog(this, "Lo siento, no lo has conseguido", "Derrota", JOptionPane.INFORMATION_MESSAGE, null);
                }
            }

        } catch (NumberFormatException e1) {
            Logger.getLogger(WindowSenku.class.getName()).log(Level.WARNING, "Caracter no valido", e1);
            JOptionPane.showMessageDialog(this, "Caracter no válido", "ERROR", JOptionPane.WARNING_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException e2) {
            Logger.getLogger(WindowSenku.class.getName()).log(Level.WARNING, "Posición no válida", e2);
            JOptionPane.showMessageDialog(this, "Posición no válida", "ERROR", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_MoverActionPerformed

    private void botonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBackActionPerformed
        try {
            game.goBack();
            this.writeTablero();
        } catch (IndexOutOfBoundsException e3) {
            Logger.getLogger(WindowSenku.class.getName()).log(Level.WARNING, "No puedes retorceder más", e3);
            JOptionPane.showMessageDialog(this, "No puedes retroceder más", "ERROR", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_botonBackActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        if (!timeCounter.isStopped()) {
            timeCounter.stop();
            timeCounter.reset();
        }
        game.restartBoard();
        this.writeTablero();
        
        if(!timeCounter.isStarted()) {
            timeCounter.start();
        }
        
    }//GEN-LAST:event_restartButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int reply = JOptionPane.showConfirmDialog(
                this, "¿Desea salir del juego?", "¿Estas seguro?",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
                
        if (reply == JOptionPane.OK_OPTION) {
            game.createMovesHistoryXML();
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void selectNewBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectNewBoardActionPerformed
        if (!timeCounter.isStopped()) {
            timeCounter.stop();
            timeCounter.reset();
        }
        
        String[] levels = {"STANDARD", "FRENCH", "ASIMETRIC", "DIAMANT", "JCW"};
        int result = JOptionPane.showOptionDialog(this, "Elige nivel", "Selección niveles", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, levels, levels[0]);
        
        game.selectBoard(result);
        this.writeTablero();
        if(!timeCounter.isStarted()) {
            timeCounter.start();
        }
        //SEGUIR
    }//GEN-LAST:event_selectNewBoardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WindowSenku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowSenku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowSenku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowSenku.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowSenku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Mover;
    private javax.swing.JTextArea area;
    private javax.swing.JButton botonBack;
    private javax.swing.JTextField coordX1;
    private javax.swing.JTextField coordX2;
    private javax.swing.JTextField coordY1;
    private javax.swing.JTextField coordY2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton restartButton;
    private javax.swing.JButton selectNewBoard;
    // End of variables declaration//GEN-END:variables
}
