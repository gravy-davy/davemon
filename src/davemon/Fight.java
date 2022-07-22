
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
        int defCurrHp = defendingCreature.getHealth();
        
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
                    
                    int effectSeed = rando.nextInt(100);
                    if(effectSeed<=move.getEffectChance()){
                        Effect e = new Effect();
                        e.setDuration(move.getDuration());
                        e.setName(move.getEffectName());
                        e.setValue(move.getEffectAmount());
                        flavorText = flavorText + " " + e.getName() + " effect has been applied on " + defendingCreature.getName() + "! ";
                        defendingCreature.getEffects().add(e);
                    }
                    
                }else{
                    flavorText = flavorText + defendingCreature.getName() + " blocked the attack! ";
                }
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
            
        }else if(move.getName().equalsIgnoreCase("Harden") || move.getName().equalsIgnoreCase("Thorns") || move.getName().equalsIgnoreCase("Aegis")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                // the effect is just so it gets removed once the duration is over. it gets increased here on activation.
                
                if(!doesAlreadyHaveEffect(move.getName(), attackingCreature)){
                    Effect e = new Effect();
                    e.setName(move.getName());
                    e.setDuration(move.getDuration());
                    e.setValue(move.getBaseAmount());
                    attackingCreature.addEffect(e);
                    if(move.getName().equalsIgnoreCase("Harden")){
                        attackingCreature.setTempPhysicalDef(attackingCreature.getTempPhysicalDef()+move.getBaseAmount());
                    }else if(move.getName().equalsIgnoreCase("Aegis")){
                        attackingCreature.setTempPhysicalDef(attackingCreature.getTempPhysicalDef()+move.getBaseAmount());
                        attackingCreature.setTempSpecialDef(attackingCreature.getTempSpecialDef()+move.getBaseAmount());
                    }
                }else{
                    Effect e = findEffectToBeReplaced(move.getName(), attackingCreature);
                    if(e!=null){
                        attackingCreature.getEffects().remove(e);
                    }
                    Effect eff = new Effect();
                    eff.setName(move.getName());
                    eff.setDuration(move.getDuration());
                    eff.setValue(move.getBaseAmount());
                    attackingCreature.addEffect(eff);
                }
                flavorText = flavorText + attackingCreature.getName() + " used " + move.getName() + " on itself! ";
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
                
                if(doesAlreadyHaveEffect("Poison", attackingCreature) || doesAlreadyHaveEffect("Venom", attackingCreature)){
                    flavorText = flavorText + attackingCreature.getName() + " used " + move.getName() + " on itself but it did nothing! ";
                }else{
                    int heal = move.getBaseAmount();
                    int newHealth = heal + attackingCreature.getHealth();

                    if(newHealth>attackingCreature.getTempMaxHealth()){
                        newHealth = attackingCreature.getTempMaxHealth();
                    }


                    attackingCreature.setHealth(newHealth);
                    flavorText = flavorText + attackingCreature.getName() + " used " + move.getName() + " on itself! ";
                }  
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
            // special basic attacks go here
        }else if(move.getName().equalsIgnoreCase("Light beam") || move.getName().equalsIgnoreCase("Water gun") || move.getName().equalsIgnoreCase("Water cannon") || 
                move.getName().equalsIgnoreCase("Spark") || move.getName().equalsIgnoreCase("Fireball") || move.getName().equalsIgnoreCase("Absorb life") || 
                move.getName().equalsIgnoreCase("Psywave") || move.getName().equalsIgnoreCase("Blood curl") || move.getName().equalsIgnoreCase("Voltage overload")
                || move.getName().equalsIgnoreCase("Wing slice") || move.getName().equalsIgnoreCase("Fracture")){
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
                
                if(move.getName().equalsIgnoreCase("Blood curl") && doesAlreadyHaveEffect("Bleed", defendingCreature)){
                    dmg = dmg * 2;
                }
                
                if(move.getName().equalsIgnoreCase("Voltage overload")){
                    int seedy = rando.nextInt(80);
                    int chanceToZapSelf = rando.nextInt(20);
                    if(chanceToZapSelf>=seedy){
                        attackingCreature.setHealth(attackingCreature.getHealth()-10);
                        flavorText = flavorText + attackingCreature.getName() + " hit themselves for 10 damage! ";
                    }
                }
                
                int def = rando.nextInt(defendingCreature.getTempSpecialDef());
                
                // pierce moves here
                if(move.getName().equalsIgnoreCase("Wing slice")){
                    int seed = rando.nextInt(100);
                    if(seed<=10){
                        flavorText = flavorText + defendingCreature.getName() + " had their DEF pierced! ";
                        def = 0;
                    }
                }else if(move.getName().equalsIgnoreCase("Fracture")){
                    defendingCreature.setTempPhysicalDef(defendingCreature.getTempPhysicalDef()-dmg/2);
                    flavorText = flavorText + defendingCreature.getName() + " had their physical DEF lowered by " + dmg/2;
                }
                
                if(defendingCreature.getTempPhysicalDef()<=0){
                        defendingCreature.setTempPhysicalDef(1);
                }
                if(defendingCreature.getTempSpecialDef()<=0){
                        defendingCreature.setTempSpecialDef(1);
                }
                
                int totalDmg = dmg - def;
                if(totalDmg>0){
                    defendingCreature.setHealth(defendingCreature.getHealth() - totalDmg);
                    flavorText = flavorText + defendingCreature.getName() + " took " + totalDmg + " damage! ";
                    if(move.getName().equalsIgnoreCase("Absorb life")){
                        attackingCreature.setHealth(attackingCreature.getHealth()+(totalDmg/2));
                        flavorText = flavorText + attackingCreature.getName() + " absorbed " + totalDmg/2 + " HP from their attack!";
                    }
                }else{
                    flavorText = flavorText + defendingCreature.getName() + " blocked the attack! ";
                }

            }else{
                // miss
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
            // special attacks w/ chance of end of turn effect here. stackables.
        }else if(move.getName().equalsIgnoreCase("Fire claw") || move.getName().equalsIgnoreCase("Poisonous Bite") || move.getName().equalsIgnoreCase("Venom fang") || 
                move.getName().equalsIgnoreCase("Electric current")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
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
                    
                    int effectSeed = rando.nextInt(100);
                    if(effectSeed<=move.getEffectChance()){
                        Effect e = new Effect();
                        e.setDuration(move.getDuration());
                        e.setName(move.getEffectName());
                        e.setValue(move.getEffectAmount());
                        flavorText = flavorText + " " + e.getName() + " effect has been applied on " + defendingCreature.getName() + "! ";
                        defendingCreature.getEffects().add(e);
                    } 
                }else{
                    flavorText = flavorText + defendingCreature.getName() + " blocked the attack! ";
                }
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Apex predator")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                
                int boost = 0;
                double percentOfHpLeft = defendingCreature.getHealth() / defendingCreature.getMaxHealth();
                
                if(percentOfHpLeft>=.5){
                    boost = 5;
                }else if(percentOfHpLeft>=.25 && percentOfHpLeft<.5){
                    boost = 10;
                }else{
                    boost = 20;
                }
                attackingCreature.setTempPhysicalAtk(attackingCreature.getPhysicalAtk()+boost);
                flavorText = flavorText + attackingCreature.getName() + " used " + move.getName() + " and increased their attack by " + boost + "!";

            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Lunar tribute")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){ 
                double healthCut = ((double) move.getBaseAmount() / 100.0) * attackingCreature.getTempMaxHealth();
                attackingCreature.setHealth(attackingCreature.getHealth()- (int) healthCut);
                flavorText = flavorText + attackingCreature.getName() + " used " + move.getName() + " to clear all effects and dropped their health by " + (int) healthCut 
                        + "!";          
                attackingCreature.getEffects().clear();
                defendingCreature.getEffects().clear();
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Psych out")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){ 
                flavorText = flavorText + attackingCreature.getName() + " used " + move.getName() + "! ";
                int lowerSpecAmount = move.getBaseAmount();
                if(defendingCreature.getWeaknesses().contains("Mind")){
                    flavorText = flavorText + defendingCreature.getName() + " is vulnerable to its effects! ";
                    lowerSpecAmount = lowerSpecAmount * 2;
                }else if(defendingCreature.getResistances().contains("Mind")){
                    flavorText = flavorText + defendingCreature.getName() + " is resistant to its effects! ";
                    lowerSpecAmount = 0;
                }

                defendingCreature.setTempSpecialAtk(defendingCreature.getSpecialAtk()-lowerSpecAmount);
                
                if(defendingCreature.getTempSpecialAtk()<=0){
                    defendingCreature.setTempSpecialAtk(1);
                }
                flavorText = flavorText + defendingCreature.getName() + " special attack reduced by " +  lowerSpecAmount + "! ";

            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Enrage")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){ 
                attackingCreature.setTempPhysicalAtk(attackingCreature.getTempPhysicalAtk()+move.getBaseAmount());
                attackingCreature.setHealth(attackingCreature.getHealth()-move.getBaseAmount());
                flavorText = flavorText + attackingCreature.getName() + " used " + move.getName() + " to increase their physical attack by " + move.getBaseAmount()
                        + " and decrease their health by " + move.getBaseAmount() + "!";
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Execute")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){ 
                
                double healthPercentage = defendingCreature.getHealth() / defendingCreature.getMaxHealth();
                double threshold = move.getBaseAmount() / 100;
                if(healthPercentage <= threshold){
                    defendingCreature.setHealth(0);
                    flavorText = flavorText + attackingCreature.getName() + " executed " + defendingCreature.getName() + "! ";
                }else{
                    flavorText = flavorText + defendingCreature.getName() + " doesn't have low enough HP to use this move! ";
                }
                
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Shatter")){
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
                
                int totalDmg = dmg;
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
        }else if(move.getName().equalsIgnoreCase("Insane bolt")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){ 
                int dmg = move.getBaseAmount();
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
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + " and it backfired for " + move.getBaseAmount() + " damage! ";
                attackingCreature.setHealth(attackingCreature.getHealth() - move.getBaseAmount());
            }
        }else if(move.getName().equalsIgnoreCase("Clear mind")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){ 
                
                if(doesAlreadyHaveEffect("Poison", attackingCreature) || doesAlreadyHaveEffect("Venom", attackingCreature)){
                    flavorText = flavorText + attackingCreature.getName() + " used " + move.getName() + " on itself but it did nothing! ";
                }else{
                    double heal = move.getBaseAmount() * attackingCreature.getTempMaxHealth();
                    attackingCreature.setHealth(attackingCreature.getHealth() + (int)heal);

                    if(attackingCreature.getHealth()>attackingCreature.getTempMaxHealth()){
                        attackingCreature.setHealth(attackingCreature.getTempMaxHealth());
                    }
                    flavorText = flavorText + attackingCreature.getName() + " used " + move.getName() + " and healed for " + (int)heal + "! ";
                }
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }else if(move.getName().equalsIgnoreCase("Agility")){
            String hitOrMiss = hitOrMiss(move, attackingCreature);
            if(hitOrMiss.equalsIgnoreCase("Hit")){ 
                
                attackingCreature.setTempSpeed(attackingCreature.getSpeed()+move.getBaseAmount());
                flavorText = flavorText + attackingCreature.getName() + " used " + move.getName() + " and increased their speed by " + move.getBaseAmount() + "! ";
            }else{
                flavorText = flavorText + attackingCreature.getName() + " missed their " + move.getName() + "! ";
            }
        }
        
        
        move.setTimesUsed(move.getTimesUsed()+1);
        // active status effects proc at the end of the attacking character's turn
        applyEndOfTurnEffects(attackingCreature);
        decrementActiveEffects(attackingCreature);
        
        if(doesAlreadyHaveEffect("Thorns", defendingCreature) && defendingCreature.getHealth()<defCurrHp){
            System.out.println("creature with thorns lost hp");
            int reflectDmg = (defCurrHp - defendingCreature.getHealth()) / 2;
            // hard coding the max value here for now
            if(reflectDmg > 20){
                reflectDmg = 20;
            }
            System.out.println("reflect dmg = " + reflectDmg);
            attackingCreature.setHealth(attackingCreature.getHealth()-reflectDmg);
            flavorText = flavorText + attackingCreature.getName() + " took " + reflectDmg + " reflect damage!";
        }
        moveSummary = flavorText;
    }
    
    // can use this to count the burns, or 'wet' stacks for gnivia, for ex.
    public int countTheEffect(Creature c, String effName){
        int counter = 0;
        for(Effect e : c.getEffects()){
            if(e.getName().equalsIgnoreCase(effName)){
                counter++;
            }
        }
        return counter;
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
            if(e.getName().equalsIgnoreCase("Bleed") || e.getName().equalsIgnoreCase("Burn") || e.getName().equalsIgnoreCase("Venom")){
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
                }else if(e.getName().equalsIgnoreCase("Aegis")){
                    c.setTempPhysicalDef(c.getTempPhysicalDef()-e.getValue());
                    c.setTempSpecialDef(c.getTempSpecialDef()-e.getValue());
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
