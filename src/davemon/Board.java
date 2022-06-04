

package davemon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    // CORE
    private Timer timer;
    private Sprite sprite;
    private final int DELAY = 10;
    
    private final CreatureCreator cc = new CreatureCreator();
    
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
                
                // if grass procs a fight, then do all this code. otherwise nothing.
                Random rando = new Random();
                int seed = rando.nextInt(5);
                Creature enemyCreature;
                if(seed == 0){
                    enemyCreature = cc.getCreature("Irax", rando.nextInt(3)+1);
                }else{
                    enemyCreature = cc.getCreature("Mowl", rando.nextInt(3)+1);
                }
                
                setFightPanel(enemyCreature);
                
                jframe.openPanelFromWorld(jframe.getjPanel2());
                
                // NEW FIGHT OBJECT SHOULD BE RIGHT HERE AFTER CREATING THE ENEMY DAVEMON AND SETTING THE PANEL
                
                backToMain = true;
            }
        }
        
        repaint();
        repaint(sprite.getX()-1, sprite.getY()-1, sprite.getWidth()+2, sprite.getHeight()+2);  
    }    
    
    public void setFightPanel(Creature enemyCreature){
        // when player subs in a davemon, they should be in spot 0 in the array list. so swap current davemon aka 0 spot with new subbed in davemon.
        ImageIcon img = new ImageIcon(jframe.getPlayer().getActiveDavemon().get(0).getImage().getImage());
        jframe.getPlayerCreatureIcon().setIcon(img);
        jframe.getPlayerCreatureIcon().setBorder(BorderFactory.createLineBorder(Color.black));
        jframe.getPlayerCreatureHealth().setText(jframe.getPlayer().getActiveDavemon().get(0).getHealth().toString());
        jframe.getPlayerCreatureMaxHealth().setText(jframe.getPlayer().getActiveDavemon().get(0).getMaxHealth().toString());

        // each davemon should have at least 1 move, after that, try/catch to print the other moves. if caught, hide the button.
        jframe.getMove1button().setText(jframe.getPlayer().getActiveDavemon().get(0).getMoveset().get(0).getName());
        jframe.getMove2button().setText(jframe.getPlayer().getActiveDavemon().get(0).getMoveset().get(1).getName());
        
        // enemy creature info on panel
        ImageIcon enemyImg = new ImageIcon(enemyCreature.getImage().getImage());
        jframe.getEnemyCreatureIcon().setIcon(enemyImg);
        jframe.getEnemyCreatureIcon().setBorder(BorderFactory.createLineBorder(Color.black));
        jframe.getEnemyCreatureName().setText(enemyCreature.getName());
        jframe.getEnemyCreatureHealth().setText(enemyCreature.getHealth().toString());
        jframe.getEnemyCreatureMaxHealth().setText(enemyCreature.getMaxHealth().toString());
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