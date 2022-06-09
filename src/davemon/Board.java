

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
        fight.setMoveSummary("");
        Random rando = new Random();
        int moveSeed = rando.nextInt(trainer.getActiveDavemon().get(0).getMoveset().size());
        String move = trainer.getActiveDavemon().get(0).getMoveset().get(moveSeed).toString();
        fight.attack(trainer.getActiveDavemon().get(0), jframe.getPlayer().getActiveDavemon().get(0), trainer.getActiveDavemon().get(0).getMoveset().get(moveSeed));
        
        // IF someone switches, remake the fight object like this: fight = new Fight(jframe.getPlayer());
        
        jframe.getEnemySummaryLabel().setText("<html><br/>" + fight.getMoveSummary() + "</html>");
        setFightPanel(trainer.getActiveDavemon().get(0));
        jframe.getContentPane().repaint();
        // need to see if fight is over here
    }
    
    /**
     * 
     * @param moveId is the move to use in an attack from player creature's moveset
     */
    public void playerAtk(int moveId){
        fight.setMoveSummary("");
        fight.attack(jframe.getPlayer().getActiveDavemon().get(0), trainer.getActiveDavemon().get(0), jframe.getPlayer().getActiveDavemon().get(0).getMoveset().get(moveId));
        setFightPanel(trainer.getActiveDavemon().get(0));
        jframe.getContentPane().repaint();
        
        jframe.getPlayerSummaryLabel().setText("<html><br/>" + fight.getMoveSummary() + "</html>");
        // if killed enemy davemon, check if enemy trainer has more davemon. if they do, put that one in and speedcheck and new fight.
        
        int lost = didSomeoneLose(jframe.getPlayer(), trainer);
        if(lost==2){
            System.out.println("Player won the entire duel."); // entire duel as in beat ALL enemy davemon.
            jframe.initBoard(jframe.getPlayer().getLocation());
        }else if(lost==1){
            System.out.println("Enemy won the entire duel.");
            jframe.initBoard(jframe.getPlayer().getLocation());
        }else{
            // if current davemon hp is 0, enemy must pick a new one from their inventory, just set it the active davemon 0. 
            // if player davemon hp is 0, open another panel with active davemon for player to pick. if they pick 0 hp one from active list, just say you cant do that or sumn
            enemyAtk();
        }
        

        //jframe.getTurnSummaryLabel().setText("<html>" + myString.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
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
        jframe.getPlayerCreatureLevel().setText(jframe.getPlayer().getActiveDavemon().get(0).getLevel().toString());
        jframe.getDaveballsLeft().setText("Daveballs: " + jframe.getPlayer().getDaveballs().toString());

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
        jframe.getEnemyCreatureLevel().setText(enemyCreature.getLevel().toString());
        
        if(enemyCreature.getEffects().isEmpty()){
            jframe.getEnemyCreatureEffects().setText("Effects: none");
        }else{
            jframe.getEnemyCreatureEffects().setText("Effects: ");
            for(Effect e : enemyCreature.getEffects()){
                jframe.getEnemyCreatureEffects().setText(jframe.getEnemyCreatureEffects().getText() + " - " + e.getName() + " / " + e.getDuration().toString() + "\n");
            }
        }
        
        if(jframe.getPlayer().getActiveDavemon().get(0).getEffects().isEmpty()){
            jframe.getPlayerCreatureEffectsLabel().setText("Effects: none");
        }else{
            jframe.getPlayerCreatureEffectsLabel().setText("Effects: ");
            for(Effect e : jframe.getPlayer().getActiveDavemon().get(0).getEffects()){
                jframe.getPlayerCreatureEffectsLabel().setText(jframe.getPlayerCreatureEffectsLabel().getText() + " - " + e.getName() + " / " + e.getDuration().toString() + "\n");
            }
        }
        
        
    }
    
    public void catchCreature(){
        if(trainer.getName().equalsIgnoreCase("Wild")){
            double hpPercent = trainer.getActiveDavemon().get(0).getHealth() / trainer.getActiveDavemon().get(0).getMaxHealth();
            
            int seed;
            Random rando = new Random();
            
            if(hpPercent <= 0.5 && hpPercent>.25){
                seed = rando.nextInt(100);
                if(seed<=30){
                    // catch
                    System.out.println("You caught the Davemon!");
                    jframe.getPlayer().addToDavemon(trainer.getActiveDavemon().get(0));
                    // switch to another panel right here to exit the fight
                }else{
                    System.out.println("Failed to catch the Davemon.");
                    setFightPanel(trainer.getActiveDavemon().get(0));
                    jframe.getContentPane().repaint();
                }
            }else if(hpPercent<.25){
                seed = rando.nextInt(100);
                if(seed<=50){
                    // catch
                    System.out.println("You caught the Davemon!");
                    jframe.getPlayer().addToDavemon(trainer.getActiveDavemon().get(0));
                }else{
                    System.out.println("Failed to catch the Davemon.");
                    setFightPanel(trainer.getActiveDavemon().get(0));
                    jframe.getContentPane().repaint();
                }
            }else{
                System.out.println("Failed to catch the Davemon that has more than 50% hp.");
                setFightPanel(trainer.getActiveDavemon().get(0));
                jframe.getContentPane().repaint();
            }
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

    public Trainer getTrainer() {
        return trainer;
    }
    
    
}