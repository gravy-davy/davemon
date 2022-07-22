

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    // CORE
    private Timer timer;
    private Sprite sprite;
    private final int DELAY = 10;
    
    private final CreatureCreator cc = new CreatureCreator();
    private final TrainerCreator tc = new TrainerCreator();
    
    // PARAMS
    private JFrame jframe;
    private String location;
    
    // CONTROL
    private boolean backToMain = false;
    
    // FIGHT
    private Fight fight;
    private Trainer trainer;
    private Integer levelOfLastCreature; // for xp 

    public Board(JFrame jframe, String location) {
        this.jframe = jframe;
        this.location = location;
        initBoard();
        jframe.getPlayerSummaryLabel().setText("-");
        jframe.getEnemySummaryLabel().setText("-");
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
        // when outlining a map's coordinates, uncomment the line below and walk along the walls of buildings
        // System.out.println("sprite x and y coords: " + sprite.getX() + " - " + sprite.getY());
        if(location.equalsIgnoreCase("Homestead")){
            g2d.drawImage(Constant.MAP_TEST.getImage(),0,0,this);
        }else if(location.equalsIgnoreCase("Hooligan Street")){
            g2d.drawImage(Constant.MAP_HOOLIGAN_STREET.getImage(),0,0,this);
        }
        
        // can change position of sprite based on location
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
        if(location.equalsIgnoreCase("Homestead")){
            if(sprite.getX()>72 && sprite.getX()<294 && sprite.getY()>480 && sprite.getY()<680){
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
                trainer.setLogo(Constant.TRAINER_WILD_LOGO);
                levelOfLastCreature = trainer.getActiveDavemon().get(0).getLevel();
                
                setFightPanel(enemyCreature);
                
                jframe.openPanelFromWorld(jframe.getjPanel2());
                
                fight = new Fight(jframe.getPlayer());
                
                fight.speedCheck(jframe.getPlayer().getActiveDavemon().get(0), trainer.getActiveDavemon().get(0));
                if(fight.getTurn()==0){
                    // enemy is attacking
                    enemyAtk();
                }
                
                backToMain = true;
            }else if(sprite.getX()>=512 && sprite.getX()<=546 && sprite.getY()==526){
                if(jframe.getPlayer().getGymBattlesCleared().contains(1)){
                    System.out.println("already fought this trainer");
                }else{
                    trainer = tc.createTrainer("Cater");
                    setTrainerDialogPanel();
                    backToMain = true;
                }    
            }else if(sprite.getX()>=592 && sprite.getX()<=738 && sprite.getY()>=174 && sprite.getY()<=418){
                jframe.setupBankPanel();
                jframe.openPanelFromWorld(jframe.getBankPanel());
                backToMain = true;
            }else if(sprite.getX()>=52 && sprite.getX()<=300 && sprite.getY()>=140 && sprite.getY()<=356){
                jframe.openPanelFromWorld(jframe.getjPanel4());
                backToMain = true;
            }else if(sprite.getX()>=806 && sprite.getY()>=564 && sprite.getY()<=620){
                jframe.initBoard("Hooligan Street");
                backToMain = true;
            }
        }else if(location.equalsIgnoreCase("Hooligan Street")){
            if(sprite.getX()>=132 && sprite.getX()<=162 && sprite.getY()>=478 && sprite.getY()<=490){
                if(jframe.getPlayer().getGymBattlesCleared().contains(2)){
                    System.out.println("already fought this trainer");
                }else{
                    trainer = tc.createTrainer("Lil Punk #1");
                    setTrainerDialogPanel();
                    backToMain = true;
                }    
            }else if(sprite.getX()>=274 && sprite.getX()<=316 && sprite.getY()>=478 && sprite.getY()<=490){
                if(jframe.getPlayer().getGymBattlesCleared().contains(1)){
                    System.out.println("already fought this trainer");
                }else{
                    trainer = tc.createTrainer("Lil Punk #2");
                    setTrainerDialogPanel();
                    backToMain = true;
                }    
            }else if(sprite.getX()>=122 && sprite.getX()<=316 && sprite.getY()>=694 && sprite.getY()<=830){
                // wild fight  
            }
        }
        
        repaint();
        repaint(sprite.getX()-1, sprite.getY()-1, sprite.getWidth()+2, sprite.getHeight()+2);  
    }    
    
    
    public void setTrainerDialogPanel(){
        jframe.getTrainerFullPic().setIcon(trainer.getFullLogo());
        jframe.getTrainerFullPic().setBorder(BorderFactory.createLineBorder(Color.black));
        jframe.getTrainerDialogText().setText(trainer.getIntroText());
        
        jframe.openPanelFromWorld(jframe.getTrainerDialogPanel());
    }
    
    // this should remain the same the rest of the way
    public void trainerFightSetup(){
        setFightPanel(trainer.getActiveDavemon().get(0)); // can make this random if hp > 0 later  
        jframe.openPanelFromWorld(jframe.getjPanel2());

        fight = new Fight(jframe.getPlayer());

        fight.speedCheck(jframe.getPlayer().getActiveDavemon().get(0), trainer.getActiveDavemon().get(0));
        if(fight.getTurn()==0){
            // enemy is attacking
            enemyAtk();
        }

        backToMain = true;
    }
    
    
    // enemies can change stuff based on their name
    public void enemyAtk(){
        // check to see if they need to swap davemon here and at the end
        doesTrainerSwap();
        fight.setMoveSummary("");
        Random rando = new Random();
        int moveSeed = rando.nextInt(trainer.getActiveDavemon().get(0).getMoveset().size());
        String move = trainer.getActiveDavemon().get(0).getMoveset().get(moveSeed).toString();
        fight.attack(trainer.getActiveDavemon().get(0), jframe.getPlayer().getActiveDavemon().get(0), trainer.getActiveDavemon().get(0).getMoveset().get(moveSeed));
        
        // IF someone switches, remake the fight object like this: fight = new Fight(jframe.getPlayer());. or just set the new active davemon to 0 index.
        
        jframe.getEnemySummaryLabel().setText("<html><br/>" + fight.getMoveSummary() + "</html>");
        
        doesTrainerSwap();
        checkForLoser();
        
        setFightPanel(trainer.getActiveDavemon().get(0));
        jframe.getContentPane().repaint();
        // need to see if fight is over here
    }
    
    public void doesTrainerSwap(){
        if(trainer.getActiveDavemon().get(0).getHealth()<=0 && trainer.getActiveDavemon().size()>1){
            // swap it
            levelOfLastCreature = trainer.getActiveDavemon().get(0).getLevel();
            trainer.getActiveDavemon().remove(0);
        }
    }
    
    /**
     * 
     * @param moveId is the move to use in an attack from player creature's moveset
     */
    public void playerAtk(int moveId){
        
        checkForLoser();
        
        if(jframe.getPlayer().getActiveDavemon().get(0).getHealth()<=0){
            JOptionPane.showMessageDialog(null, "You must swap to another Davemon, this one has fainted.");
            return;
        }
        
        
        
        fight.setMoveSummary("");
        fight.attack(jframe.getPlayer().getActiveDavemon().get(0), trainer.getActiveDavemon().get(0), jframe.getPlayer().getActiveDavemon().get(0).getMoveset().get(moveId));
        setFightPanel(trainer.getActiveDavemon().get(0));
        jframe.getContentPane().repaint();
        
        jframe.getPlayerSummaryLabel().setText("<html><br/>" + fight.getMoveSummary() + "</html>");
        // if killed enemy davemon, check if enemy trainer has more davemon. if they do, put that one in and speedcheck and new fight.
        int keepGoing = checkForLoser();
        if(keepGoing!=0){
            // if current enemy davemon hp is 0, enemy must pick a new one from their inventory, just set it the active davemon 0. 
        }else{
            enemyAtk();
        }
    }
    
    public void setTrainerOutroPanel(){
        jframe.getTrainerDialogOutroFullImage().setIcon(trainer.getFullLogo());
        jframe.getTrainerOutroText().setText(trainer.getDefeatText());
        
        String rewardText = "";
        if(trainer.getRewardMoney()>0){
            rewardText = "You got $" + trainer.getRewardMoney() + " for winning the duel!";
        }
        
        if(null != trainer.getRewardCreature()){
            rewardText = rewardText + " You also got " + trainer.getRewardCreature().getName() + " for winning!";
        }
        
        jframe.getTrainerRewardText().setText(rewardText);
    }
    
    // 0 = keep going, 1 stop
    public int checkForLoser(){
        int lost = didSomeoneLose(jframe.getPlayer(), trainer);
        if(lost==2){
            System.out.println("Player won the entire duel."); // entire duel as in beat ALL enemy davemon.
            // if not wild, goto outro panel
            if(!trainer.getName().equalsIgnoreCase("Wild")){
                setTrainerOutroPanel();
                jframe.switchToAnotherPanel(this, jframe.getTrainerDialogOutro());
            }else{
                jframe.initBoard(jframe.getPlayer().getLocation());
            }
            JOptionPane.showMessageDialog(null, "You won the duel!");
            // can add rewards based on trainer player beat here. like beating some gym leader gives their badge, for ex.
            // also xp gained = level of enemy creature * 5 
            getTrainerReward();
            getXpIncrease();
            return 1;
        }else if(lost==1){
            System.out.println("Enemy won the entire duel.");
            jframe.initBoard(jframe.getPlayer().getLocation());
            JOptionPane.showMessageDialog(null, "Enemy won the duel.");
            return 1;
        }
        return 0;
    }
    
    public void getXpIncrease(){
        int inc = levelOfLastCreature * 5;
        jframe.getPlayer().getActiveDavemon().get(0).incXp(inc);
    }
    
    public void getTrainerReward(){
        if(null != trainer.getRewardCreature()){
            jframe.getPlayer().addToDavemon(trainer.getRewardCreature());
        }
        if(null != trainer.getRewardMoney()){
            jframe.getPlayer().setMoney(jframe.getPlayer().getMoney()+trainer.getRewardMoney());
        }
        if(null != trainer.getId()){
            jframe.getPlayer().getGymBattlesCleared().add(trainer.getId()); // so they cant be fought again
        }
        
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
        
        if(null!=t && !t.getActiveDavemon().isEmpty()){
            for(Creature c : t.getActiveDavemon()){
                if(c.getHealth() <= 0){
                    enemyCounter++;
                }
            }
            if(enemyCounter==t.getActiveDavemon().size()){
                return 2;
            }
        }
        
        
        return 0;
    }
    
    public void refreshFightPanel(){
        setFightPanel(trainer.getActiveDavemon().get(0));
        jframe.getContentPane().repaint();
    }
    
    public void setFightPanel(Creature enemyCreature){
        // when player subs in a davemon, they should be in spot 0 in the array list. so swap current davemon aka 0 spot with new subbed in davemon.
        
        jframe.getTranerFightLogo().setIcon(trainer.getLogo());
        jframe.getTranerFightLogo().setBorder(BorderFactory.createLineBorder(Color.black));
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
        
        
        try{
            jframe.getMove3button().setText(jframe.getPlayer().getActiveDavemon().get(0).getMoveset().get(2).getName());
        }catch(Exception e){
            jframe.getMove3button().setText("N/A");
        }
        try{
            jframe.getMove4button().setText(jframe.getPlayer().getActiveDavemon().get(0).getMoveset().get(3).getName());
        }catch(Exception e){
            jframe.getMove4button().setText("N/A");
        }
        
        try{
            jframe.getjButton5().setText(jframe.getPlayer().getActiveDavemon().get(1).getName());
        }catch(Exception e){
            jframe.getjButton5().setText("N/A");
        }
        try{
            jframe.getjButton6().setText(jframe.getPlayer().getActiveDavemon().get(2).getName());
        }catch(Exception e){
            jframe.getjButton6().setText("N/A");
        }
        try{
            jframe.getjButton7().setText(jframe.getPlayer().getActiveDavemon().get(3).getName());
        }catch(Exception e){
            jframe.getjButton7().setText("N/A");
        }
        
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
                    JOptionPane.showMessageDialog(null, "You caught the " + trainer.getActiveDavemon().get(0).getName());
                    jframe.getPlayer().addToDavemon(trainer.getActiveDavemon().get(0));
                    jframe.initBoard(jframe.getPlayer().getLocation());
                }else{
                    JOptionPane.showMessageDialog(null, "You don't have enough Daveballs!");
                    setFightPanel(trainer.getActiveDavemon().get(0));
                    jframe.getContentPane().repaint();
                }
            }else if(hpPercent<.25){
                seed = rando.nextInt(100);
                if(seed<=50){
                    // catch
                    System.out.println("You caught the Davemon!");
                    jframe.getPlayer().addToDavemon(trainer.getActiveDavemon().get(0));
                    jframe.initBoard(jframe.getPlayer().getLocation());
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