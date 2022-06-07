
package davemon;

import java.util.ArrayList;
import java.util.Random;

public class Fight {
    
    
    private Player p;
    
    private Integer turn; // 0 for enemy, 1 for player turn
    private boolean isFightOver;
    
    // enemy creature fight. panels essentially are used to modify this object.
    // fight panel creates a fight object and just calls these methods.
    // might have to pass the jframe in here or can just repaint it in the board class

    public Fight(Player p) {
        this.p = p;
        isFightOver = false;
    }
    
    public void speedCheck(Creature playerCreature, Creature enemyCreature){
        if(playerCreature.getTempSpeed()>=enemyCreature.getTempSpeed()){
            turn = 1;
        }else{
            turn = 0;
        }
    }
    
    // a fight can finish if: either creature is defeated OR if a trainer swaps a davemon for another one.
    // so fights are just between TWO creatures, not full length 4v4s. so trainers keep fighting until ALL their active davemons have fainted.
    /*
    public void checkIfFightIsDone(){
        
        
    }
    */
    
    public void attack(Creature attackingCreature, Creature defendingCreature, Move move){
        Random rando = new Random();
        
        // can use some ifs for other moves with the same exact flow. like a stronger bite can be with bite flow.
        if(move.getName().equalsIgnoreCase("Bite")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                // hit
                int dmg = rando.nextInt(attackingCreature.getTempPhysicalAtk());
                int maxDmg = move.getBaseAmount();
                if(dmg>maxDmg){
                    dmg = maxDmg;
                }
                
                if(defendingCreature.getWeaknesses().contains("Physical")){
                    dmg = dmg * 2;
                }else if(defendingCreature.getResistances().contains("Physical")){
                    dmg = dmg / 2;
                }
                
                System.out.println("dmg roll = " + dmg + " / " + maxDmg);
                int def = rando.nextInt(defendingCreature.getTempPhysicalDef());
                System.out.println("def = " + def);
                int totalDmg = dmg - def;
                if(totalDmg>0){
                    defendingCreature.setHealth(defendingCreature.getHealth() - totalDmg);
                }else{
                    System.out.println("BLOCKED");
                }

            }else{
                // miss
            }
        }else if(move.getName().equalsIgnoreCase("Quick Attack")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                
                int dmg = rando.nextInt(attackingCreature.getTempPhysicalAtk());
                int maxDmg = move.getBaseAmount();
                if(dmg>maxDmg){
                    dmg = maxDmg;
                }
                
                if(defendingCreature.getWeaknesses().contains("Physical")){
                    dmg = dmg * 2;
                }else if(defendingCreature.getResistances().contains("Physical")){
                    dmg = dmg / 2;
                }
                
                System.out.println("dmg roll = " + dmg + " / " + maxDmg);
                if(attackingCreature.getTempSpeed()>=defendingCreature.getTempSpeed()){
                    dmg = dmg * 2;
                }else{
                    dmg = dmg / 2;
                }
                
                int def = rando.nextInt(defendingCreature.getTempPhysicalDef());
                System.out.println("def = " + def);
                int totalDmg = dmg - def;
                
                if(totalDmg>0){
                    defendingCreature.setHealth(defendingCreature.getHealth() - totalDmg);
                }else{
                    System.out.println("BLOCKED");
                }

            }else{
                
            }
        }else if(move.getName().equalsIgnoreCase("Stab")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                int dmg = rando.nextInt(attackingCreature.getTempPhysicalAtk());
                int maxDmg = move.getBaseAmount();
                if(dmg>maxDmg){
                    dmg = maxDmg;
                }
                
                if(defendingCreature.getWeaknesses().contains("Physical")){
                    dmg = dmg * 2;
                }else if(defendingCreature.getResistances().contains("Physical")){
                    dmg = dmg / 2;
                }
                
                System.out.println("dmg roll = " + dmg + " / " + maxDmg);
                int def = rando.nextInt(defendingCreature.getTempPhysicalDef());
                System.out.println("def = " + def);
                int totalDmg = dmg - def;
                
                if(totalDmg>0){
                    defendingCreature.setHealth(defendingCreature.getHealth() - totalDmg);
                }else{
                    System.out.println("BLOCKED");
                }
            }else{
                
            }
            
        }else if(move.getName().equalsIgnoreCase("Harden")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                // the effect is just so it gets removed once the duration is over. it gets increased here on activation.
                
                if(!doesAlreadyHaveEffect("Harden", attackingCreature)){
                    Effect e = new Effect();
                    e.setName("Harden");
                    e.setDuration(move.getDuration());
                    e.setValue(move.getBaseAmount());
                    attackingCreature.addEffect(e);
                    attackingCreature.setTempPhysicalDef(attackingCreature.getTempPhysicalDef()+move.getBaseAmount());
                }else{
                    System.out.println("already has harden");
                    Effect e = findEffectToBeReplaced("Harden", attackingCreature);
                    if(e!=null){
                        System.out.println("removed effect: " + e.getName());
                        attackingCreature.getEffects().remove(e);
                    }
                    Effect eff = new Effect();
                    eff.setName("Harden");
                    eff.setDuration(move.getDuration());
                    eff.setValue(move.getBaseAmount());
                    attackingCreature.addEffect(eff);
                }
                
            }else{
                
            }
        }else if(move.getName().equalsIgnoreCase("Confuse")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                
                if(!doesAlreadyHaveEffect("Confuse", defendingCreature)){
                    Effect e = new Effect();
                    e.setName("Confuse");
                    e.setDuration(move.getDuration());
                    e.setValue(move.getBaseAmount());
                    defendingCreature.addEffect(e);
                }else{
                    Effect e = findEffectToBeReplaced("Confuse", defendingCreature);
                    if(e!=null){
                        System.out.println("removed effect: " + e.getName());
                        defendingCreature.getEffects().remove(e);
                    }
                    Effect eff = new Effect();
                    eff.setName("Confuse");
                    eff.setDuration(move.getDuration());
                    eff.setValue(move.getBaseAmount());
                    defendingCreature.addEffect(eff);
                }
                
                
            }else{
                
            }
        }
        
        move.setTimesUsed(move.getTimesUsed()+1);
        // apply poison / dot effects here so after the creature does their turn they eat a bleed, for ex.
        decrementActiveEffects(attackingCreature);
    }
    
    public Effect findEffectToBeReplaced(String effName, Creature creature){
        for(Effect e : creature.getEffects()){
            if(e.getName().equalsIgnoreCase(effName)){
                return e;
            }
        }
        return null;
    }
    
    
    public void applyEndOfTurnEffects(Creature c){
        
        for(Effect e : c.getEffects()){
            
        }
        
    }
    
    public boolean doesAlreadyHaveEffect(String effName, Creature c){
        for(Effect e : c.getEffects()){
            if(e.getName().equalsIgnoreCase(effName)){
                return true;
            }
        }
        
        return false;
    }
    
    public void decrementActiveEffects(Creature c){
        
        ArrayList<Effect> deadEffects = new ArrayList<>();
        
        for(Effect e : c.getEffects()){
            System.out.println("EFFECT NAME: " + e.getName());
            e.setDuration(e.getDuration()-1);
            if(e.getDuration()<=0){
                deadEffects.add(e);
            }
        }
        
        // if effect is harden/shield, remove defense from effect
        for(Effect e : deadEffects){
            if(c.getEffects().contains(e)){
                if(e.getName().equalsIgnoreCase("Harden")){
                    c.setTempPhysicalDef(c.getTempPhysicalDef()-e.getValue());
                    System.out.println("def without harden is = " + c.getTempPhysicalDef());
                }
                c.getEffects().remove(e);
            }
        }
        
    }
    
    public Effect checkForAccuracyDebuff(Creature c){
        for(Effect e : c.getEffects()){
            if(e.getName().equalsIgnoreCase("Confuse")){
                return e;
            }
        }
        return null;
    }
    
    
    // gotta check for confuses here
    public String hitOrMiss(Move move, Creature c){
        Random rando = new Random();
        Effect accDebuff = checkForAccuracyDebuff(c);
        int accSeed;
        if(accDebuff!=null){
            System.out.println("accuracy without debuff: " + move.getAccuracy());
            int debAcc = move.getAccuracy() - accDebuff.getValue();
            System.out.println("accuracy after debuff = " + debAcc);
            if(debAcc<0){
                debAcc = 1;
            }
            accSeed = rando.nextInt(debAcc);
        }else{
            accSeed = rando.nextInt(move.getAccuracy());
        }
        int randSeed = rando.nextInt(100 - accSeed);
        if(accSeed>=randSeed){
            System.out.println("hit with a " + move.getName());
            return "Hit";
        }else{
            System.out.println("missed with a " + move.getName());
            return "Miss";
        }
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public boolean isIsFightOver() {
        return isFightOver;
    }

    public void setIsFightOver(boolean isFightOver) {
        this.isFightOver = isFightOver;
    }
    
    
    
    
}
