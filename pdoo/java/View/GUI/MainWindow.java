/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI;

import Deepspace.SpaceStationToUI;
import View.View;
import controller.Controllerv2;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Deepspace.CombatResult;
import Deepspace.GameState;

/**
 *
 * @author diagmatrix
 */
public class MainWindow extends javax.swing.JFrame implements View {

    static Controllerv2 controller;
    private static MainWindow instance = null;
    private StationToGUI sp = new StationToGUI();
    private EnemyToGUI _enemy = new EnemyToGUI();
    private ArrayList<SpaceStationToUI> stations = new ArrayList<>();
     
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        setTitle("Deepspace");
        station.add(sp);
        enemy.add(_enemy);
    }
    
    public static MainWindow getInstance() {
        if (instance==null) {
            instance = new MainWindow();
        }
        return instance;
    }
    
    @Override
    public void updateView() {
        // Desbloqueo de botones y paneless
        pass_turn.setEnabled(controller.getState()==GameState.AFTERCOMBAT);
        combat.setEnabled(controller.getState()==GameState.BEFORECOMBAT || controller.getState()==GameState.INIT);
        enemy.setVisible(controller.getState()==GameState.AFTERCOMBAT);
        // Actualizamos nave y enemigo
        sp.setStationToGUI(controller.getModelUIversion().getCurrentStation());
        _enemy.setEnemyToGUI(controller.getModelUIversion().getCurrentEnemy());
        repaint();
        revalidate();
    }
        
    @Override
    public void showView() { this.setVisible(true); }
    
    @Override
    public ArrayList<String> getNames() {
        NamesCapture namesCapt = new NamesCapture(this);
        return namesCapt.getNames();
    }
    
    @Override
    public void setController(Controllerv2 c) { controller = c; }

    @Override
    public boolean confirmExitMessage() {
        return (JOptionPane.showConfirmDialog(this, "¿Estás segur@ que deseas salir?", "Deepspace", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        w_discard = new javax.swing.JButton();
        s_discard = new javax.swing.JButton();
        exit_game = new javax.swing.JButton();
        h_discard = new javax.swing.JButton();
        combat = new javax.swing.JButton();
        pass_turn = new javax.swing.JButton();
        scroll1 = new javax.swing.JScrollPane();
        station = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enemy = new javax.swing.JPanel();
        w_add = new javax.swing.JButton();
        s_add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        w_discard.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        w_discard.setText("Descartar armas");
        w_discard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w_discardActionPerformed(evt);
            }
        });

        s_discard.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        s_discard.setText("Descartar escudos");
        s_discard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_discardActionPerformed(evt);
            }
        });

        exit_game.setText("Salir del Juego");
        exit_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_gameActionPerformed(evt);
            }
        });

        h_discard.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        h_discard.setText("Descartar hangar");
        h_discard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h_discardActionPerformed(evt);
            }
        });

        combat.setText("COMBATIR");
        combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatActionPerformed(evt);
            }
        });

        pass_turn.setText("Pasar turno");
        pass_turn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_turnActionPerformed(evt);
            }
        });

        station.setBorder(javax.swing.BorderFactory.createTitledBorder("Nave Espacial"));
        scroll1.setViewportView(station);

        enemy.setBorder(javax.swing.BorderFactory.createTitledBorder("Enemigo"));
        jScrollPane1.setViewportView(enemy);

        w_add.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        w_add.setText("Montar armas");
        w_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w_addActionPerformed(evt);
            }
        });

        s_add.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        s_add.setText("Montar escudos");
        s_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(combat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(exit_game, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addComponent(pass_turn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(h_discard, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(w_discard, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(w_add, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(s_discard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s_add, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(w_discard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(w_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(s_discard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h_discard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pass_turn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exit_game))
                            .addComponent(combat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(scroll1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void w_discardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w_discardActionPerformed
        ArrayList<Integer> w_mounted = sp.getSelectedWeapons();
        ArrayList<Integer> w_hangar = sp.getHangar().getSelectedWeapons();
        controller.discardWeapons(w_mounted);
        controller.discardWeaponsInHangar(w_hangar);
    }//GEN-LAST:event_w_discardActionPerformed

    private void exit_gameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_gameActionPerformed
        controller.finish(0);
    }//GEN-LAST:event_exit_gameActionPerformed

    private void pass_turnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_turnActionPerformed
        boolean can_pass = controller.nextTurn();
        if (!can_pass)
            JOptionPane.showMessageDialog(this, "No puedes pasar el turno, cumple tu castigo", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_pass_turnActionPerformed

    private void w_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w_addActionPerformed
        ArrayList<Integer> weaps = sp.getHangar().getSelectedWeapons();
        controller.mountWeapons(weaps);
    }//GEN-LAST:event_w_addActionPerformed

    private void s_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_addActionPerformed
        ArrayList<Integer> shieldsB = sp.getHangar().getSelectedShields();
        controller.mountShields(shieldsB);
    }//GEN-LAST:event_s_addActionPerformed

    private void combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatActionPerformed
        CombatResult result= controller.combat();
        switch (result) {
            case ENEMYWINS:
                JOptionPane.showMessageDialog(this, "¡Has perdido el combate!\nCUMPLE TU CASTIGO", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
                break;
            case NOCOMBAT:
                JOptionPane.showMessageDialog(this, "Vaya...\nEl combate no ha podido realizar", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
                break;
            case STATIONESCAPES:
                JOptionPane.showMessageDialog(this, "¡Has conseguido escapar!\nCOMO ERES UN COBARDE NO RECIBES NADA", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
                break;
            case STATIONWINS:
                JOptionPane.showMessageDialog(this, "¡Has ganado el combate!\nDISFRUTA DEL BOTÍN", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
            case STATIONWINSANDCONVERTS:
                if(controller.getModelUIversion().getCurrentEnemy().getLoot().isGetEfficient())
                    JOptionPane.showMessageDialog(this, "¡Has ganado el combate!\nTU ESTACIÓN ES MÁS EFICIENTE", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
                if(controller.getModelUIversion().getCurrentEnemy().getLoot().isSpaceCity())
                    JOptionPane.showMessageDialog(this, "¡Has ganado el combate!\nTE HAS CONVERTIDO EN UNA CIUDAD ESPACIAL", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
break;
        }
        if (controller.haveAWinner()) {
            JOptionPane.showMessageDialog(this, "¡Has ganado la partida!", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        updateView();
    }//GEN-LAST:event_combatActionPerformed

    private void s_discardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_discardActionPerformed
        ArrayList<Integer> s_mounted = sp.getSelectedShields();
        ArrayList<Integer> s_hangar = sp.getHangar().getSelectedShields();
        controller.discardShields(s_mounted);
        controller.discardShieldsInHangar(s_hangar);
    }//GEN-LAST:event_s_discardActionPerformed

    private void h_discardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h_discardActionPerformed
        controller.discardHangar();
    }//GEN-LAST:event_h_discardActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combat;
    private javax.swing.JPanel enemy;
    private javax.swing.JButton exit_game;
    private javax.swing.JButton h_discard;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pass_turn;
    private javax.swing.JButton s_add;
    private javax.swing.JButton s_discard;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JPanel station;
    private javax.swing.JButton w_add;
    private javax.swing.JButton w_discard;
    // End of variables declaration//GEN-END:variables
}
