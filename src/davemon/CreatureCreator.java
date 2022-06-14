
package davemon;

import java.util.ArrayList;

/**
 * 
 * Creates and returns creature objects
 */
public class CreatureCreator {
    
    
    public Creature getCreature(String name, int level){
        Creature c = new Creature();
        MoveCreator mc = new MoveCreator();
        
        c.setName(name);
        c.setMoveset(new ArrayList<>());
        c.setLevel(level);
        c.setCurrentXp(0);
        c.setXpNeeded(25 * level);
        c.setEffects(new ArrayList<>());
        c.setResistances(new ArrayList<>());
        c.setWeaknesses(new ArrayList<>());
        
        if(name.equalsIgnoreCase("Uniru")){
            c.setEvolutionLevel(25);
            c.setType("Water");
            c.addToResistances("Mind");
            c.addToWeaknesses("Lightning");
            
            // in this case, 40 is the minimum health
            c.setHealthPerLevel(1);
            c.setHealth(32 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(65);
            c.setPhysicalDef(10);
            c.setSpecialDef(20);
            c.setPhysicalAtk(30);
            c.setSpecialAtk(30);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_UNIRU);
            
            Move m1 = mc.makeMove("Confuse");
            Move m2 = mc.makeMove("Stab");
            
            c.getMoveset().add(m2);
            c.getMoveset().add(m1);
            
        } else if(name.equalsIgnoreCase("Irax")){
            c.setEvolutionLevel(32);
            c.setType("Metal");
            c.addToResistances("Physical");
            c.addToWeaknesses("Mind");
            
            // in this case, 40 is the minimum health
            c.setHealthPerLevel(3);
            c.setHealth(50 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(30);
            c.setPhysicalDef(40);
            c.setSpecialDef(5);
            c.setPhysicalAtk(25);
            c.setSpecialAtk(10);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_IRAX);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Harden");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Mowl")){
            c.setEvolutionLevel(32);
            c.setType("Physical");
            c.addToResistances("Grass");
            c.addToWeaknesses("Physical");
            
            // in this case, 40 is the minimum health
            c.setHealthPerLevel(1);
            c.setHealth(30 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(90);
            c.setPhysicalDef(10);
            c.setSpecialDef(10);
            c.setPhysicalAtk(20);
            c.setSpecialAtk(15);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_MOWL);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Quick attack");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Girapod")){
            c.setEvolutionLevel(28);
            c.setType("Grass");
            c.addToResistances("Grass");
            c.addToWeaknesses("Fire");
            
            // in this case, 40 is the minimum health
            c.setHealthPerLevel(1);
            c.setHealth(35 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(85);
            c.setPhysicalDef(15);
            c.setSpecialDef(20);
            c.setPhysicalAtk(10);
            c.setSpecialAtk(25);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_GIRAPOD);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Heal");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Gnuke")){
            c.setEvolutionLevel(35);
            c.setType("Water");
            c.addToResistances("Water");
            c.addToWeaknesses("Lightning");
            
            // in this case, 40 is the minimum health
            c.setHealthPerLevel(2);
            c.setHealth(41 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(55);
            c.setPhysicalDef(17);
            c.setSpecialDef(25);
            c.setPhysicalAtk(22);
            c.setSpecialAtk(22);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_GNUKE);
            
            Move m1 = mc.makeMove("Water gun");
            Move m2 = mc.makeMove("Water cannon");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }
        
        return c;
    }
    
}
