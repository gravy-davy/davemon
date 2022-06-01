/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davemon;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MovingSpriteEx extends JFrame {

    public MovingSpriteEx() {
        
        initUI();
    }
    
    private void initUI() {

        add(new Board());

        setTitle("Moving sprite");
        setSize(800, 800);
        
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MovingSpriteEx ex = new MovingSpriteEx();
            ex.setVisible(true);
        });
    }
}