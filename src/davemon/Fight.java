
package davemon;

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
        if(playerCreature.getSpeed()>=enemyCreature.getSpeed()){
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
        
        // make accuracy check its own method
        if(move.getName().equalsIgnoreCase("Bite")){
            String hitOrMiss = hitOrMiss(move);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                // hit
                Effect shield = checkForShield(defendingCreature);
                if(shield!=null){
                    int remainder = shield.getValue() - move.getBaseAmount();
                    shield.setValue(shield.getValue() - move.getBaseAmount());
                    if(remainder<0){
                        remainder = remainder * -1;
                        defendingCreature.setHealth(defendingCreature.getHealth() - remainder);
                        defendingCreature.getEffects().remove(shield);
                    }
                }else{
                    defendingCreature.setHealth(defendingCreature.getHealth() - move.getBaseAmount());
                }
                
            }else{
                // miss
            }
        }else if(move.getName().equalsIgnoreCase("Quick Attack")){
            String hitOrMiss = hitOrMiss(move);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                
                int dmg = move.getBaseAmount();
                if(attackingCreature.getSpeed()>=defendingCreature.getSpeed()){
                    dmg = dmg * 2;
                }
                
                Effect shield = checkForShield(defendingCreature);
                if(shield!=null){
                    int remainder = shield.getValue() - dmg;
                    shield.setValue(shield.getValue() - dmg);
                    if(remainder<0){
                        remainder = remainder * -1;
                        defendingCreature.setHealth(defendingCreature.getHealth() - remainder);
                        defendingCreature.getEffects().remove(shield);
                    }
                }else{
                    defendingCreature.setHealth(defendingCreature.getHealth() - dmg);
                }
            }else{
                
            }
        }else if(move.getName().equalsIgnoreCase("Stab")){
            String hitOrMiss = hitOrMiss(move);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                Effect shield = checkForShield(defendingCreature);
                if(shield!=null){
                    int remainder = shield.getValue() - move.getBaseAmount();
                    shield.setValue(shield.getValue() - move.getBaseAmount());
                    if(remainder<0){
                        remainder = remainder * -1;
                        defendingCreature.setHealth(defendingCreature.getHealth() - remainder);
                        defendingCreature.getEffects().remove(shield);
                    }
                }else{
                    defendingCreature.setHealth(defendingCreature.getHealth() - move.getBaseAmount());
                }
            }else{
                
            }
            
        }else if(move.getName().equalsIgnoreCase("Shield")){
            String hitOrMiss = hitOrMiss(move);
            if(hitOrMiss.equalsIgnoreCase("Hit")){
                Effect e = new Effect();
                e.setName("Shield");
                e.setDuration(999);
                e.setValue(move.getBaseAmount());
            }else{
                
            }
        }
        
        move.setTimesUsed(move.getTimesUsed()+1);
        
    }
    
    public Effect checkForShield(Creature c){
        for(Effect e : c.getEffects()){
            if(e.getName().equalsIgnoreCase("Shield")){
                return e;
            }
        }
        return null;
    }
    
    // gotta check for confuses here
    public String hitOrMiss(Move move){
        Random rando = new Random();
        int accSeed = rando.nextInt(move.getAccuracy());
        int randSeed = rando.nextInt(100 - move.getAccuracy());
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
