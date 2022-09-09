
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
        }else if(name.equalsIgnoreCase("Elazar")){
            c.setEvolutionLevel(41);
            c.setType("Dark");
            c.addToResistances("Dark");
            c.addToWeaknesses("Light");
            
            c.setHealthPerLevel(1);
            c.setHealth(47 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(95);
            c.setPhysicalDef(27);
            c.setSpecialDef(30);
            c.setPhysicalAtk(37);
            c.setSpecialAtk(32);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_ELAZAR);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Execute");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Vultzel")){
            c.setEvolutionLevel(41);
            c.setType("Dark");
            c.addToResistances("Dark");
            c.addToWeaknesses("Light");
            
            c.setHealthPerLevel(1);
            c.setHealth(36 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(145);
            c.setPhysicalDef(23);
            c.setSpecialDef(25);
            c.setPhysicalAtk(40);
            c.setSpecialAtk(40);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_VULTZEL);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Absorb life");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Vulf")){
            c.setEvolutionLevel(44);
            c.setType("Lightning");
            c.addToResistances("Lightning");
            c.addToWeaknesses("Metal");
            
            c.setHealthPerLevel(2);
            c.setHealth(40 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(100);
            c.setPhysicalDef(19);
            c.setSpecialDef(28);
            c.setPhysicalAtk(30);
            c.setSpecialAtk(43);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_VULF);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Insane bolt");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Cryzard")){
            c.setEvolutionLevel(32);
            c.setType("Metal");
            c.addToResistances("Metal");
            c.addToWeaknesses("Fire");
            
            c.setHealthPerLevel(2);
            c.setHealth(37 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(120);
            c.setPhysicalDef(24);
            c.setSpecialDef(28);
            c.setPhysicalAtk(25);
            c.setSpecialAtk(25);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_CRYZARD);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Shatter");
            Move m3 = mc.makeMove("Harden");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
            c.getMoveset().add(m3);
        }else if(name.equalsIgnoreCase("Kinetile")){
            c.setEvolutionLevel(32);
            c.setType("Grass");
            c.addToResistances("Grass");
            c.addToResistances("Water");
            c.addToWeaknesses("Fire");
            
            c.setHealthPerLevel(1);
            c.setHealth(33 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(105);
            c.setPhysicalDef(32);
            c.setSpecialDef(22);
            c.setPhysicalAtk(31);
            c.setSpecialAtk(38);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_KINETILE);
            
            Move m1 = mc.makeMove("Bite");
            Move m2 = mc.makeMove("Water gun");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Cidron")){
            c.setEvolutionLevel(45);
            c.setType("Poison");
            c.addToResistances("Poison");
            c.addToWeaknesses("Light");
            
            c.setHealthPerLevel(2);
            c.setHealth(40 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(80);
            c.setPhysicalDef(30);
            c.setSpecialDef(32);
            c.setPhysicalAtk(27);
            c.setSpecialAtk(24);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_KINETILE);
            
            Move m1 = mc.makeMove("Poisonous bite");
            Move m2 = mc.makeMove("Bite");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Fasp")){
            c.setEvolutionLevel(40);
            c.setType("Fire");
            c.addToResistances("Poison");
            c.addToResistances("Fire");
            c.addToWeaknesses("Water");
            
            c.setHealthPerLevel(1);
            c.setHealth(25 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(140);
            c.setPhysicalDef(15);
            c.setSpecialDef(15);
            c.setPhysicalAtk(45);
            c.setSpecialAtk(45);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_FASP);
            
            Move m1 = mc.makeMove("Poisonous bite");
            Move m2 = mc.makeMove("Fire claw");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }else if(name.equalsIgnoreCase("Tortoros")){
            c.setEvolutionLevel(40);
            c.setType("Water");
            c.addToResistances("Water");
            c.addToResistances("Light");
            c.addToWeaknesses("Dark");
            
            c.setHealthPerLevel(5);
            c.setHealth(75 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(40);
            c.setPhysicalDef(75);
            c.setSpecialDef(75);
            c.setPhysicalAtk(40);
            c.setSpecialAtk(40);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_TORTOROS);
            
            Move m1 = mc.makeMove("Water cannon");
            Move m2 = mc.makeMove("Thorns");
            Move m3 = mc.makeMove("Aegis");
            Move m4 = mc.makeMove("Heal");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
            c.getMoveset().add(m3);
            c.getMoveset().add(m4);
        }else if(name.equalsIgnoreCase("Doomopus")){
            c.setEvolutionLevel(40);
            c.setType("Water");
            c.addToResistances("Water");
            c.addToResistances("Dark");
            c.addToWeaknesses("Light");
            
            c.setHealthPerLevel(2);
            c.setHealth(50 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(80);
            c.setPhysicalDef(35);
            c.setSpecialDef(50);
            c.setPhysicalAtk(60);
            c.setSpecialAtk(70);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_DOOMOPUS);
            
            Move m1 = mc.makeMove("Dark matter");
            Move m2 = mc.makeMove("Ink");
            Move m3 = mc.makeMove("Entangle");
            Move m4 = mc.makeMove("Tentacle slap");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
            c.getMoveset().add(m3);
            c.getMoveset().add(m4);
        }else if(name.equalsIgnoreCase("Gnivia")){
            c.setEvolutionLevel(40);
            c.setType("Ice");
            c.addToResistances("Water");
            c.addToResistances("Ice");
            c.addToWeaknesses("Fire");
            
            c.setHealthPerLevel(1);
            c.setHealth(42 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(112);
            c.setPhysicalDef(31);
            c.setSpecialDef(38);
            c.setPhysicalAtk(30);
            c.setSpecialAtk(45);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_GNIVIA);
            
            Move m1 = mc.makeMove("Wet");
            Move m2 = mc.makeMove("Ice shard");
            Move m3 = mc.makeMove("Crystallize"); 
            Move m4 = mc.makeMove("Chilling gust");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
            c.getMoveset().add(m3);
            c.getMoveset().add(m4);
        }else if(name.equalsIgnoreCase("Karate Kat")){
            c.setEvolutionLevel(40);
            c.setType("Physical");
            c.addToResistances("Flying");
            c.addToResistances("Mind");
            c.addToWeaknesses("Water");
            
            c.setHealthPerLevel(1);
            c.setHealth(47 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(165);
            c.setPhysicalDef(40);
            c.setSpecialDef(22);
            c.setPhysicalAtk(58);
            c.setSpecialAtk(22);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_KARATE_KAT);
            
            Move m1 = mc.makeMove("Wild claw");
            Move m2 = mc.makeMove("Paralyzing blow");
            Move m3 = mc.makeMove("Karate kick"); 
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
            c.getMoveset().add(m3);
        }else if(name.equalsIgnoreCase("Quackzilla")){
            c.setEvolutionLevel(40);
            c.setType("Flying");
            c.addToResistances("Flying");
            c.addToWeaknesses("Metal");
            
            c.setHealthPerLevel(2);
            c.setHealth(60 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(120);
            c.setPhysicalDef(47);
            c.setSpecialDef(53);
            c.setPhysicalAtk(48);
            c.setSpecialAtk(40);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_QUACKZILLA);
            
            Move m1 = mc.makeMove("Wing slice");
            Move m2 = mc.makeMove("Screech");
            Move m3 = mc.makeMove("Beak bite"); 
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
            c.getMoveset().add(m3);
        }else if(name.equalsIgnoreCase("Giant eel")){
            c.setEvolutionLevel(40);
            c.setType("Water");
            c.addToResistances("Water");
            c.addToResistances("Lightning");
            c.addToWeaknesses("Ice");
            
            c.setHealthPerLevel(4);
            c.setHealth(70 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(110);
            c.setPhysicalDef(60);
            c.setSpecialDef(60);
            c.setPhysicalAtk(60);
            c.setSpecialAtk(60);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_GIANT_EEL);
            
            Move m1 = mc.makeMove("Voltage overload");
            Move m2 = mc.makeMove("Lightning lord's current");
            Move m3 = mc.makeMove("Tail slap"); 
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
            c.getMoveset().add(m3);
        }else if(name.equalsIgnoreCase("Snugglewomp")){
            c.setEvolutionLevel(40);
            c.setType("Flying");
            c.addToResistances("Flying");
            c.addToResistances("Light");
            c.addToWeaknesses("Lightning");
            
            c.setHealthPerLevel(1);
            c.setHealth(35 + (level*c.getHealthPerLevel()));
            c.setMaxHealth(c.getHealth());
            c.setSpeed(94);
            c.setPhysicalDef(10);
            c.setSpecialDef(20);
            c.setPhysicalAtk(15);
            c.setSpecialAtk(25);
            
            c.setTempSpecialAtk(c.getSpecialAtk());
            c.setTempPhysicalAtk(c.getPhysicalAtk());
            c.setTempMaxHealth(c.getMaxHealth());
            c.setTempPhysicalDef(c.getPhysicalDef());
            c.setTempSpecialDef(c.getSpecialDef());
            c.setTempSpeed(c.getSpeed());
            
            c.setImage(Constant.CREATURE_SNUGGLEWOMP);
            
            Move m1 = mc.makeMove("Tongue flick");
            Move m2 = mc.makeMove("Pollen gust");
            
            c.getMoveset().add(m1);
            c.getMoveset().add(m2);
        }
        
        return c;
    }
    
}
