

package davemon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Sprite sprite;
    private final int DELAY = 10;
    private JFrame jframe;
    private boolean backToMain = false;

    // this can eventually take parameters and draw images on the screen according to what area the user is in
    public Board(JFrame jframe) {
        this.jframe = jframe;
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
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
        // can just draw images based on area of user
        g2d.drawImage(sprite.getImage(), sprite.getX(), 
            sprite.getY(), this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!backToMain){
            step();
        }
        
    }
    
    private void step() {
        
        sprite.move();
        if(sprite.getX()>300){
            // x greater than 300 so backToMain. backToMain in the future will have param to load a specific panel. like a fight, for example.
            jframe.backToMain();
            backToMain = true;
        }else{
            repaint(); // clear the screen and then we repaint with sprite YEET
        
            repaint(sprite.getX()-1, sprite.getY()-1, sprite.getWidth()+2, sprite.getHeight()+2);  
        }
        
         
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