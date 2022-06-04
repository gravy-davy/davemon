
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
            
            // can make these random range for diff creatures
            c.setHealth(90);
            c.setSpeed(65);
            
            c.setImage(Constant.CREATURE_UNIRU);
            
            Move m1 = new Move();
            m1.setName("Confuse"); // makes opponent creature need to flip a coin when they attack
            m1.setTimesUsed(0);
            m1.setMaxUses(10);
            m1.setBaseAmount(50);
            m1.setType("Mind");
            
            Move m2 = new Move();
            m2.setName("Stab");
            m2.setTimesUsed(0);
            m2.setMaxUses(20);
            m2.setBaseAmount(20);
            m2.setType("Physical");
            
            c.getMoveset().add(m2);
            c.getMoveset().add(m1);
            
        }
        
        return c;
    }
    
}
