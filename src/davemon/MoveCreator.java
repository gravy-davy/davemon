
package davemon;


public class MoveCreator {
    
    public Move makeMove(String moveName){
        
        Move move = new Move();
        
        if(moveName.equalsIgnoreCase("Confuse")){
            move.setName("Confuse"); // reduces accuracy of opponent
            move.setTimesUsed(0);
            move.setMaxUses(10);
            move.setBaseAmount(25); // debuff amount
            move.setType("Mind");
            move.setAccuracy(50);
            move.setDuration(5);
        }else if(moveName.equalsIgnoreCase("Stab")){
            move.setName("Stab");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(25); // max damage, reachable by physical atk roll
            move.setType("Physical");
            move.setAccuracy(60);
            move.setDuration(3);
            move.setEffectChance(50);
            move.setEffectAmount(6);
            move.setEffectName("Bleed");
        }else if(moveName.equalsIgnoreCase("Bite")){
            move.setName("Bite"); // makes opponent creature need to flip a coin when they attack
            move.setTimesUsed(0);
            move.setMaxUses(25);
            move.setBaseAmount(30);
            move.setType("Physical");
            move.setAccuracy(70);
        }else if(moveName.equalsIgnoreCase("Harden")){
            move.setName("Harden");
            move.setTimesUsed(0);
            move.setMaxUses(10);
            move.setBaseAmount(20);
            move.setType("Physical");
            move.setAccuracy(90);
            move.setDuration(3); // effect moves need duration
        }else if(moveName.equalsIgnoreCase("Quick attack")){
            move.setName("Quick Attack");
            move.setTimesUsed(0);
            move.setMaxUses(10);
            move.setBaseAmount(10);
            move.setType("Physical");
            move.setAccuracy(70);
        }else if(moveName.equalsIgnoreCase("Heal")){
            move.setName("Heal");
            move.setTimesUsed(0);
            move.setMaxUses(10);
            move.setBaseAmount(20);
            move.setType("Grass");
            move.setAccuracy(70);
        }else if(moveName.equalsIgnoreCase("Water gun")){
            move.setName("Water gun"); 
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10);
            move.setType("Water");
            move.setAccuracy(90);
        }else if(moveName.equalsIgnoreCase("Water cannon")){
            move.setName("Water cannon");
            move.setTimesUsed(0);
            move.setMaxUses(10);
            move.setBaseAmount(50);
            move.setType("Water");
            move.setAccuracy(50);
        }else if(moveName.equalsIgnoreCase("Light beam")){
            move.setName("Light beam");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(30);
            move.setType("Light");
            move.setAccuracy(65);
        }else if(moveName.equalsIgnoreCase("Shock")){
            move.setName("Shock");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10);
            move.setType("Lightning");
            move.setAccuracy(70);
            move.setDuration(5);
        }else if(moveName.equalsIgnoreCase("Fire claw")){
            move.setName("Fire claw");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(20);
            move.setType("Fire");
            move.setAccuracy(68);
            move.setDuration(4);
            move.setEffectChance(30);
            move.setEffectAmount(6);
            move.setEffectName("Burn");
        }else if(moveName.equalsIgnoreCase("Poisonous bite")){
            move.setName("Poisonous bite");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(25);
            move.setType("Poison");
            move.setAccuracy(65);
            move.setDuration(8);
            move.setEffectChance(100);
            move.setEffectAmount(10);
            move.setEffectName("Poison");
        }else if(moveName.equalsIgnoreCase("Spark")){
            move.setName("Spark");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(30);
            move.setType("Lightning");
            move.setAccuracy(60);
        }else if(moveName.equalsIgnoreCase("Apex predator")){
            move.setName("Apex predator");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(20);
            move.setType("Water");
            move.setAccuracy(90);
        }else if(moveName.equalsIgnoreCase("Lunar tribute")){
            move.setName("Lunar tribute");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10); // percentage of health to cut
            move.setType("Light");
            move.setAccuracy(90);
        }
     
        return move;
        
    }
    
}
