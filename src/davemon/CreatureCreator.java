
package davemon;

import java.util.ArrayList;

/**
 * 
 * Creates and returns creature objects
 */
public class CreatureCreator {
    
    
    public Creature getCreature(String name, int level){
        Creature c = new Creature();
        
        c.setName(name);
        c.setMoveset(new ArrayList<>());
        c.setLevel(level);
        c.setCurrentXp(0);
        c.setXpNeeded(25 * level);
        c.setEffects(new ArrayList<>());
        
        if(name.equalsIgnoreCase("Uniru")){
            c.setEvolutionLevel(25);
            c.setType("Water");
            
            // in this case, 40 is the minimum health
            c.setHealthPerLevel(1);
            c.setHealth(32 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(65);
            c.setPhysicalDef(10);
            c.setSpecialDef(20);
            
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_UNIRU);
            
            Move m1 = new Move();
            m1.setName("Confuse"); // reduces accuracy of opponent
            m1.setTimesUsed(0);
            m1.setMaxUses(10);
            m1.setBaseAmount(25);
            m1.setType("Mind");
            m1.setAccuracy(50);
            m1.setDuration(3);
            
            Move m2 = new Move();
            m2.setName("Stab");
            m2.setTimesUsed(0);
            m2.setMaxUses(20);
            m2.setBaseAmount(20);
            m2.setType("Physical");
            m2.setAccuracy(50);
            
            c.getMoveset().add(m2);
            c.getMoveset().add(m1);
            
        } else if(name.equalsIgnoreCase("Irax")){
            c.setEvolutionLevel(32);
            c.setType("Metal");
            
            // in this case, 40 is the minimum health
            c.setHealthPerLevel(3);
            c.setHealth(50 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(30);
            c.setPhysicalDef(40);
            c.setSpecialDef(5);
            
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_IRAX);
            
            Move m1 = new Move();
            m1.setName("Bite"); // makes opponent creature need to flip a coin when they attack
            m1.setTimesUsed(0);
            m1.setMaxUses(25);
            m1.setBaseAmount(15);
            m1.setType("Physical");
            m1.setAccuracy(60);
            
            Move m2 = new Move();
            m2.setName("Harden");
            m2.setTimesUsed(0);
            m2.setMaxUses(10);
            m2.setBaseAmount(20);
            m2.setType("Physical");
            m2.setAccuracy(90);
            m2.setDuration(3);
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Mowl")){
            c.setEvolutionLevel(32);
            c.setType("Physical");
            
            // in this case, 40 is the minimum health
            c.setHealthPerLevel(1);
            c.setHealth(30 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(90);
            c.setPhysicalDef(10);
            c.setSpecialDef(10);
            
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_MOWL);
            
            Move m1 = new Move();
            m1.setName("Bite"); // makes opponent creature need to flip a coin when they attack
            m1.setTimesUsed(0);
            m1.setMaxUses(25);
            m1.setBaseAmount(10);
            m1.setType("Physical");
            m1.setAccuracy(70);
            
            Move m2 = new Move();
            m2.setName("Quick Attack");
            m2.setTimesUsed(0);
            m2.setMaxUses(10);
            m2.setBaseAmount(10);
            m2.setType("Physical");
            m2.setAccuracy(70);
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }
        
        return c;
    }
    
}
