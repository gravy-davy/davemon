

package davemon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    // CORE
    private Timer timer;
    private Sprite sprite;
    private final int DELAY = 10;
    
    // PARAMS
    private JFrame jframe;
    private String location;
    
    // CONTROL
    private boolean backToMain = false;

    public Board(JFrame jframe, String location) {
        this.jframe = jframe;
        this.location = location;
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.MAGENTA);
	setFocusable(true);

        sprite = new Sprite();
        

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite.getImage(), sprite.getX(), 
            sprite.getY(), this);
        
        if(location.equalsIgnoreCase("Homestead")){
            g2d.drawImage(Constant.GRASS.getImage(), 300, 0, this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!backToMain){
            step();
        }
        
    }
    
    private void step() {
        sprite.move();
        
        if(location.equalsIgnoreCase("Homestead")){
            if(sprite.getX()>300 && sprite.getY()<195 && sprite.getX()<580){
                
                
                ImageIcon img = new ImageIcon(jframe.getPlayer().getActiveDavemon().get(0).getImage().getImage());
                jframe.getPlayerCreatureIcon().setIcon(img);
                jframe.openPanelFromWorld(jframe.getjPanel2());
                
                // NEW FIGHT OBJECT SHOULD BE RIGHT HERE AFTER CREATING THE ENEMY DAVEMON AND SETTING THE PANEL
                
                backToMain = true;
            }
        }
        
        repaint();
        repaint(sprite.getX()-1, sprite.getY()-1, sprite.getWidth()+2, sprite.getHeight()+2);  
    }    

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            sprite.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            sprite.keyPressed(e);
        }
    }
}