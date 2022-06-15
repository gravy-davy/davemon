
package davemon;

import java.util.ArrayList;
import java.util.Random;

public class Fight {
    
    
    private Player p;
    
    private Integer turn; // 0 for enemy, 1 for player turn
    private boolean isFightOver;
    
    private String moveSummary;
    
    // enemy creature fight. panels essentially are used to modify this object.
    // fight panel creates a fight object and just calls these methods.
    // might have to pass the jframe in here or can just repaint it in the board class

    public Fight(Player p) {
        this.p = p;
        isFightOver = false;
        moveSummary = "";
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
        String flavorText = "";
        
        // can use some ifs for other moves with the same exact flow. like other basic physical attacks.
        if(move.getName().equalsIgnoreCase("Bite")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                // hit
                int dmg = rando.nextInt(attackingCreature.getTempPhysicalAtk());
                int maxDmg = move.getBaseAmount();
                if(dmg>maxDmg){
                    dmg = maxDmg;
                }
                flavorText = flavorText + attackingCreature.getName() + " hit " + defendingCreature.getName() + " with a " + move.getName() + ". ";
                
                if(defendingCreature.getWeaknesses().contains(move.getType())){
                    dmg = dmg * 2;
                    flavorText = flavorText + defendingCreature.getName() + " is vulnerable to the damage! ";
                }else if(defendingCreature.getResistances().contains(move.getType())){
                    dmg = dmg / 2;
                    flavorText = flavorText + defendingCreature.getName() + " is resistant to the attack! ";
                }
                
                int def = rando.nextInt(defendingCreature.getTempPhysicalDef());
                int totalDmg = dmg - def;
                if(totalDmg>0){
                    defendingCreature.setHealth(defendingCreature.getHealth() - totalDmg);
                    flavorText = flavorText + defendingCreature.getName() + " took " + totalDmg + " damage! ";
                }else{
                    flavorText = flavorText + defendingCreature.getName() + " blocked the attack! ";
                }

            }else{
                // miss
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Quick Attack")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                
                int dmg = rando.nextInt(attackingCreature.getTempPhysicalAtk());
                int maxDmg = move.getBaseAmount();
                if(dmg>maxDmg){
                    dmg = maxDmg;
                }
                
                flavorText = flavorText + attackingCreature.getName() + " hit " + defendingCreature.getName() + " with a " + move.getName() + ". ";
                
                if(defendingCreature.getWeaknesses().contains("Physical")){
                    dmg = dmg * 2;
                    flavorText = flavorText + defendingCreature.getName() + " is vulnerable to the damage! ";
                }else if(defendingCreature.getResistances().contains("Physical")){
                    dmg = dmg / 2;
                    flavorText = flavorText + defendingCreature.getName() + " is resistant to the attack! ";
                }
                
                if(attackingCreature.getTempSpeed()>=defendingCreature.getTempSpeed()){
                    dmg = dmg * 2;
                    flavorText = flavorText + attackingCreature.getName() + " damage DOUBLED since it has higher speed! ";
                }else{
                    dmg = dmg / 2;
                    flavorText = flavorText + attackingCreature.getName() + " damage HALVED since it has lower speed! ";
                }
                
                int def = rando.nextInt(defendingCreature.getTempPhysicalDef());
                int totalDmg = dmg - def;
                
                if(totalDmg>0){
                    defendingCreature.setHealth(defendingCreature.getHealth() - totalDmg);
                    flavorText = flavorText + defendingCreature.getName() + " took " + totalDmg + " damage! ";
                }else{
                    flavorText = flavorText + defendingCreature.getName() + " blocked the attack! ";
                }

            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Stab")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                int dmg = rando.nextInt(attackingCreature.getTempPhysicalAtk());
                int maxDmg = move.getBaseAmount();
                if(dmg>maxDmg){
                    dmg = maxDmg;
                }
                
                flavorText = flavorText + attackingCreature.getName() + " hit " + defendingCreature.getName() + " with a " + move.getName() + ". ";
                
                if(defendingCreature.getWeaknesses().contains("Physical")){
                    dmg = dmg * 2;
                    flavorText = flavorText + defendingCreature.getName() + " is vulnerable to the damage! ";
                }else if(defendingCreature.getResistances().contains("Physical")){
                    dmg = dmg / 2;
                    flavorText = flavorText + defendingCreature.getName() + " is resistant to the attack! ";
                }
                
                int def = rando.nextInt(defendingCreature.getTempPhysicalDef());
                int totalDmg = dmg - def;
                
                if(totalDmg>0){
                    defendingCreature.setHealth(defendingCreature.getHealth() - totalDmg);
                    flavorText = flavorText + defendingCreature.getName() + " took " + totalDmg + " damage! ";
                    
                    int bleedSeed = rando.nextInt(100);
                    if(bleedSeed<=90){
                        Effect e = new Effect();
                        e.setDuration(3);
                        e.setName("Bleed");
                        e.setValue(move.getBaseAmount()/3);
                        flavorText = flavorText + " Bleed effect has been applied on " + defendingCreature.getName() + "! ";
                        defendingCreature.getEffects().add(e);
                    }
                    
                }else{
                    flavorText = flavorText + defendingCreature.getName() + " blocked the attack! ";
                }
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
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
                    Effect e = findEffectToBeReplaced("Harden", attackingCreature);
                    if(e!=null){
                        attackingCreature.getEffects().remove(e);
                    }
                    Effect eff = new Effect();
                    eff.setName("Harden");
                    eff.setDuration(move.getDuration());
                    eff.setValue(move.getBaseAmount());
                    attackingCreature.addEffect(eff);
                }
                flavorText = flavorText + attackingCreature.getName() + " used Harden on itself! ";
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Confuse") || move.getName().equalsIgnoreCase("Shock")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                
                if(defendingCreature.getResistances().contains(move.getType())){
                    flavorText = flavorText + defendingCreature.getName() + " resisted " + move.getName() + "! ";
                }else{
                    if(!doesAlreadyHaveEffect(move.getName(), defendingCreature)){
                        Effect e = new Effect();
                        e.setName(move.getName());
                        e.setDuration(move.getDuration());
                        e.setValue(move.getBaseAmount());
                        defendingCreature.addEffect(e);
                    }else{
                        Effect e = findEffectToBeReplaced(move.getName(), defendingCreature);
                        if(e!=null){
                            defendingCreature.getEffects().remove(e);
                        }
                        Effect eff = new Effect();
                        eff.setName(move.getName());
                        eff.setDuration(move.getDuration());
                        eff.setValue(move.getBaseAmount());
                        defendingCreature.addEffect(eff);
                    }
                    flavorText = flavorText + attackingCreature.getName() + " hit " + defendingCreature.getName() + " with a " + move.getName() + ". ";
                }
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Heal")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                // the effect is just so it gets removed once the duration is over. it gets increased here on activation.
                
                int heal = move.getBaseAmount();
                int newHealth = heal + attackingCreature.getHealth();
                
                if(newHealth>attackingCreature.getTempMaxHealth()){
                    newHealth = attackingCreature.getTempMaxHealth();
                }
                
                
                attackingCreature.setHealth(newHealth);
                flavorText = flavorText + attackingCreature.getName() + " used Heal on itself! ";
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
            // special basic attacks go here
        }else if(move.getName().equalsIgnoreCase("Light beam") || move.getName().equalsIgnoreCase("Water gun") || move.getName().equalsIgnoreCase("Water cannon")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                // hit
                int dmg = rando.nextInt(attackingCreature.getTempSpecialAtk());
                int maxDmg = move.getBaseAmount();
                if(dmg>maxDmg){
                    dmg = maxDmg;
                }
                flavorText = flavorText + attackingCreature.getName() + " hit " + defendingCreature.getName() + " with a " + move.getName() + ". ";
                
                if(defendingCreature.getWeaknesses().contains(move.getType())){
                    dmg = dmg * 2;
                    flavorText = flavorText + defendingCreature.getName() + " is vulnerable to the damage! ";
                }else if(defendingCreature.getResistances().contains(move.getType())){
                    dmg = dmg / 2;
                    flavorText = flavorText + defendingCreature.getName() + " is resistant to the attack! ";
                }
                
                int def = rando.nextInt(defendingCreature.getTempSpecialDef());
                int totalDmg = dmg - def;
                if(totalDmg>0){
                    defendingCreature.setHealth(defendingCreature.getHealth() - totalDmg);
                    flavorText = flavorText + defendingCreature.getName() + " took " + totalDmg + " damage! ";
                }else{
                    flavorText = flavorText + defendingCreature.getName() + " blocked the attack! ";
                }

            }else{
                // miss
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }
        
        move.setTimesUsed(move.getTimesUsed()+1);
        // active status effects proc at the end of the attacking character's turn
        applyEndOfTurnEffects(attackingCreature);
        decrementActiveEffects(attackingCreature);
        moveSummary = flavorText;
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
            if(e.getName().equalsIgnoreCase("Bleed")){
                c.setHealth(c.getHealth()-e.getValue());
            }
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
    
    public Effect checkForShock(Creature c){
        for(Effect e : c.getEffects()){
            if(e.getName().equalsIgnoreCase("Shock")){
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
            int debAcc = move.getAccuracy() - accDebuff.getValue();
            if(debAcc<0){
                debAcc = 1;
            }
            accSeed = rando.nextInt(debAcc);
        }else{
            accSeed = rando.nextInt(move.getAccuracy());
        }
        int randSeed = rando.nextInt(100 - accSeed);
        if(accSeed>=randSeed){
            return "Hit";
        }else{
            Effect shock = checkForShock(c);
            if(shock!=null){
                c.setHealth(c.getHealth()-shock.getValue());
            }
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

    public String getMoveSummary() {
        return moveSummary;
    }

    public void setMoveSummary(String moveSummary) {
        this.moveSummary = moveSummary;
    }
    
}
