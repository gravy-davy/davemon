
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
        }else if(name.equalsIgnoreCase("Griffin")){
            c.setEvolutionLevel(45);
            c.setType("Flying");
            c.addToResistances("Light");
            c.addToResistances("Flying");
            c.addToWeaknesses("Dark");
            
            c.setHealthPerLevel(2);
            c.setHealth(45 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(100);
            c.setPhysicalDef(20);
            c.setSpecialDef(35);
            c.setPhysicalAtk(15);
            c.setSpecialAtk(30);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_GRIFFIN);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Light beam");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Hyeros")){
            c.setEvolutionLevel(47);
            c.setType("Lightning");
            c.addToResistances("Lightning");
            c.addToWeaknesses("Metal");
            
            c.setHealthPerLevel(2);
            c.setHealth(37 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(132);
            c.setPhysicalDef(16);
            c.setSpecialDef(20);
            c.setPhysicalAtk(18);
            c.setSpecialAtk(50);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_HYEROS);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Shock");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Infernapaws")){
            c.setEvolutionLevel(36);
            c.setType("Fire");
            c.addToResistances("Fire");
            c.addToWeaknesses("Water");
            
            c.setHealthPerLevel(2);
            c.setHealth(36 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(126);
            c.setPhysicalDef(20);
            c.setSpecialDef(27);
            c.setPhysicalAtk(25);
            c.setSpecialAtk(35);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_INFERNAPAWS);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Fire claw");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Tartulix")){
            c.setEvolutionLevel(33);
            c.setType("Lightning");
            c.addToResistances("Lightning");
            c.addToResistances("Poison");
            c.addToWeaknesses("Metal");
            
            c.setHealthPerLevel(1);
            c.setHealth(31 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(77);
            c.setPhysicalDef(10);
            c.setSpecialDef(13);
            c.setPhysicalAtk(15);
            c.setSpecialAtk(40);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_TARTULIX);
            
            Move m1 = mc.makeMove("Poisonous Bite");
            Move m2 = mc.makeMove("Spark");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Shardol")){
            c.setEvolutionLevel(45);
            c.setType("Water");
            c.addToResistances("Water");
            c.addToResistances("Fire");
            c.addToWeaknesses("Lightning");
            
            c.setHealthPerLevel(3);
            c.setHealth(42 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(70);
            c.setPhysicalDef(30);
            c.setSpecialDef(24);
            c.setPhysicalAtk(21);
            c.setSpecialAtk(19);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_SHARDOL);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Apex predator");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Lumipie")){
            c.setEvolutionLevel(27);
            c.setType("Light");
            c.addToResistances("Light");
            c.addToResistances("Mind");
            c.addToWeaknesses("Dark");
            
            c.setHealthPerLevel(1);
            c.setHealth(28 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(65);
            c.setPhysicalDef(17);
            c.setSpecialDef(30);
            c.setPhysicalAtk(14);
            c.setSpecialAtk(26);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_LUMIPIE);
            
            Move m1 = mc.makeMove("Light beam");
            Move m2 = mc.makeMove("Lunar tribute");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Specacle")){
            c.setEvolutionLevel(27);
            c.setType("Mind");
            c.addToResistances("Mind");
            c.addToWeaknesses("Dark");
            
            c.setHealthPerLevel(1);
            c.setHealth(34 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(109);
            c.setPhysicalDef(23);
            c.setSpecialDef(26);
            c.setPhysicalAtk(20);
            c.setSpecialAtk(23);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_SPECACLE);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Psych out");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }
        
        return c;
    }
    
}
