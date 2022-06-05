

package davemon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
    
    // FIGHT
    private Fight fight;
    private Trainer trainer;

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
                
                trainer = new Trainer();
                trainer.setActiveDavemon(new ArrayList<>());
                trainer.setName("Wild");
                trainer.addToActiveDavemon(enemyCreature);
                
                setFightPanel(enemyCreature);
                
                jframe.openPanelFromWorld(jframe.getjPanel2());
                
                // NEW FIGHT OBJECT SHOULD BE RIGHT HERE AFTER CREATING THE ENEMY DAVEMON AND SETTING THE PANEL
                
                fight = new Fight(jframe.getPlayer());
                
                fight.speedCheck(jframe.getPlayer().getActiveDavemon().get(0), trainer.getActiveDavemon().get(0));
                if(fight.getTurn()==0){
                    // enemy is attacking
                    enemyAtk();
                }
                
                // determine who won based on whether player surrendered, or they have no active davemon left
                
                backToMain = true;
            }
        }
        
        repaint();
        repaint(sprite.getX()-1, sprite.getY()-1, sprite.getWidth()+2, sprite.getHeight()+2);  
    }    
    
    
    // enemies can change stuff based on their name
    public void enemyAtk(){
        Random rando = new Random();
        int moveSeed = rando.nextInt(trainer.getActiveDavemon().get(0).getMoveset().size());
        String move = trainer.getActiveDavemon().get(0).getMoveset().get(moveSeed).toString();
        fight.attack(trainer.getActiveDavemon().get(0), jframe.getPlayer().getActiveDavemon().get(0), trainer.getActiveDavemon().get(0).getMoveset().get(moveSeed));
        
        // IF someone switches, remake the fight object like this: fight = new Fight(jframe.getPlayer());
        
        setFightPanel(trainer.getActiveDavemon().get(0));
        jframe.getContentPane().repaint();
        // need to see if fight is over here
    }
    
    /**
     * 
     * @param moveId is the move to use in an attack from player creature's moveset
     */
    public void playerAtk(int moveId){
        fight.attack(jframe.getPlayer().getActiveDavemon().get(0), trainer.getActiveDavemon().get(0), jframe.getPlayer().getActiveDavemon().get(0).getMoveset().get(moveId));
        // need to see if fight is over here
        
        // repaint right here
        System.out.println("ENEMY POKE HEALTH: " + trainer.getActiveDavemon().get(0).getHealth());
        setFightPanel(trainer.getActiveDavemon().get(0));
        jframe.getContentPane().repaint();
        enemyAtk();
        
        
    }
    
    /**
     * 
     * @param p player
     * @param t trainer
     * @return 1 for player defeat, 2 for trainer defeat, 0 for still fighting
     */
    public int didSomeoneLose(Player p, Trainer t){
        int counter = 0;
        for(Creature c : p.getActiveDavemon()){
            if(c.getHealth() <= 0){
                counter++;
            }
        }
        
        if(counter==p.getActiveDavemon().size()){
            return 1;
        }
        
        int enemyCounter = 0;
        for(Creature c : t.getActiveDavemon()){
            if(c.getHealth() <= 0){
                enemyCounter++;
            }
        }
        if(enemyCounter==t.getActiveDavemon().size()){
            return 2;
        }
        
        return 0;
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