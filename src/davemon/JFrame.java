package davemon;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrame extends javax.swing.JFrame {

    // if steps on grassy array / coordinates and user location = "roscoe warren" then generate roscoe warren mobs :)
    
    private Player player;
    private Board board;
    
    /**
     * Creates new form JFrame
     */
    public JFrame() {
        initComponents();
        // board = new Board(this);
        setTitle("Davemon");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        playerCreatureIcon = new javax.swing.JLabel();
        enemyCreatureIcon = new javax.swing.JLabel();
        move1button = new javax.swing.JButton();
        move2button = new javax.swing.JButton();
        move3button = new javax.swing.JButton();
        move4button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        playerCreatureHealth = new javax.swing.JLabel();
        playerCreatureMaxHealth = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        enemyCreatureHealth = new javax.swing.JLabel();
        enemyCreatureMaxHealth = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        enemyCreatureName = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setSize(new java.awt.Dimension(800, 800));
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel1.setText("Davemon");

        jButton2.setText("New game");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jButton2)))
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addGap(135, 135, 135)
                .addComponent(jButton2)
                .addContainerGap(625, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        jLabel2.setText("FIGHT PANEL 0.0.1");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        move1button.setText("Move1");
        move1button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                move1buttonActionPerformed(evt);
            }
        });

        move2button.setText("Move2");
        move2button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                move2buttonActionPerformed(evt);
            }
        });

        move3button.setText("Move3");

        move4button.setText("Move4");

        jLabel6.setText("Health: ");

        playerCreatureHealth.setText("jLabel7");

        playerCreatureMaxHealth.setText("jLabel7");

        jLabel7.setText("/");

        jLabel8.setText("Health:");

        enemyCreatureHealth.setText("jLabel9");

        enemyCreatureMaxHealth.setText("jLabel9");

        jLabel9.setText("/");

        enemyCreatureName.setText("jLabel10");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enemyCreatureIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerCreatureIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(move1button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(move2button))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(enemyCreatureHealth))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(playerCreatureHealth)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enemyCreatureMaxHealth)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(move3button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(move4button))
                            .addComponent(playerCreatureMaxHealth)))
                    .addComponent(enemyCreatureName))
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(enemyCreatureIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(enemyCreatureName)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(enemyCreatureHealth)
                            .addComponent(jLabel9)
                            .addComponent(enemyCreatureMaxHealth))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(playerCreatureIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(241, 241, 241))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(playerCreatureHealth)
                            .addComponent(jLabel7)
                            .addComponent(playerCreatureMaxHealth))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(move1button)
                            .addComponent(move2button)
                            .addComponent(move3button)
                            .addComponent(move4button))
                        .addGap(351, 351, 351))))
        );

        getContentPane().add(jPanel2, "card3");

        jLabel3.setText("Name");

        jTextField1.setText("-");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(319, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(326, 326, 326))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(147, 147, 147))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(292, 292, 292))
        );

        getContentPane().add(jPanel3, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jLabel4.setIcon(Constant.CREATURE_UNIRU);
        repaint();
        switchToAnotherPanel(jPanel1,jPanel3);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        switchToAnotherPanel(jPanel2, jPanel1);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jTextField1.getText().length()>0){
            createPlayer();
            // add creature
            CreatureCreator cc = new CreatureCreator();
            Creature c = cc.getCreature("Uniru", 1);
            player.addToActiveDavemon(c);
            initBoard(player.getLocation());
        }else{
            System.out.println("name not long enough");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void move1buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_move1buttonActionPerformed
        // TODO add your handling code here:
        // player attack
        board.playerAtk(0);
        // enemy attack is called from the player attack method
    }//GEN-LAST:event_move1buttonActionPerformed

    private void move2buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_move2buttonActionPerformed
        // TODO add your handling code here:
        board.playerAtk(1);
    }//GEN-LAST:event_move2buttonActionPerformed
    
    public void createPlayer(){
        player = new Player();
        player.setName(jTextField1.getText());
        player.setDavemon(new ArrayList<>());
        player.setGymBattlesCleared(new ArrayList<>());
        player.setActiveDavemon(new ArrayList<>());
        player.setLocation("Homestead");
        player.setMoney(1000);
    }
    
    /**
     * Switches to a panel while the user is in the open world
     * 
     * @param jpanel is the panel to show 
     */
    public void openPanelFromWorld(JPanel jpanel){
        setContentPane(jpanel);
        jpanel.show();
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    /**
     * Switches from one panel to another
     * 
     * @param currentPanel
     * @param newPanel 
     */
    public void switchToAnotherPanel(JPanel currentPanel, JPanel newPanel){
        setContentPane(newPanel);
        currentPanel.hide();
        newPanel.show();
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    
    /**
     * Initializes the board based on the location of the player
     * 
     * @param location 
     */
    public void initBoard(String location){
        // put it in the panel, like the board
        setVisible(false);
        board = new Board(this, location);
        setContentPane(board);  
        getContentPane().revalidate();
        getContentPane().repaint();
        setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enemyCreatureHealth;
    private javax.swing.JLabel enemyCreatureIcon;
    private javax.swing.JLabel enemyCreatureMaxHealth;
    private javax.swing.JLabel enemyCreatureName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton move1button;
    private javax.swing.JButton move2button;
    private javax.swing.JButton move3button;
    private javax.swing.JButton move4button;
    private javax.swing.JLabel playerCreatureHealth;
    private javax.swing.JLabel playerCreatureIcon;
    private javax.swing.JLabel playerCreatureMaxHealth;
    // End of variables declaration//GEN-END:variables

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public JLabel getPlayerCreatureIcon() {
        return playerCreatureIcon;
    }

    public void setPlayerCreatureIcon(JLabel playerCreatureIcon) {
        this.playerCreatureIcon = playerCreatureIcon;
    }

    public JButton getMove1button() {
        return move1button;
    }

    public void setMove1button(JButton move1button) {
        this.move1button = move1button;
    }

    public JButton getMove2button() {
        return move2button;
    }

    public void setMove2button(JButton move2button) {
        this.move2button = move2button;
    }

    public JButton getMove3button() {
        return move3button;
    }

    public void setMove3button(JButton move3button) {
        this.move3button = move3button;
    }

    public JButton getMove4button() {
        return move4button;
    }

    public void setMove4button(JButton move4button) {
        this.move4button = move4button;
    }

    public JLabel getPlayerCreatureHealth() {
        return playerCreatureHealth;
    }

    public void setPlayerCreatureHealth(JLabel playerCreatureHealth) {
        this.playerCreatureHealth = playerCreatureHealth;
    }

    public JLabel getPlayerCreatureMaxHealth() {
        return playerCreatureMaxHealth;
    }

    public void setPlayerCreatureMaxHealth(JLabel playerCreatureMaxHealth) {
        this.playerCreatureMaxHealth = playerCreatureMaxHealth;
    }

    public JLabel getEnemyCreatureHealth() {
        return enemyCreatureHealth;
    }

    public void setEnemyCreatureHealth(JLabel enemyCreatureHealth) {
        this.enemyCreatureHealth = enemyCreatureHealth;
    }

    public JLabel getEnemyCreatureIcon() {
        return enemyCreatureIcon;
    }

    public void setEnemyCreatureIcon(JLabel enemyCreatureIcon) {
        this.enemyCreatureIcon = enemyCreatureIcon;
    }

    public JLabel getEnemyCreatureMaxHealth() {
        return enemyCreatureMaxHealth;
    }

    public void setEnemyCreatureMaxHealth(JLabel enemyCreatureMaxHealth) {
        this.enemyCreatureMaxHealth = enemyCreatureMaxHealth;
    }

    public JLabel getEnemyCreatureName() {
        return enemyCreatureName;
    }

    public void setEnemyCreatureName(JLabel enemyCreatureName) {
        this.enemyCreatureName = enemyCreatureName;
    }

    
    
}
