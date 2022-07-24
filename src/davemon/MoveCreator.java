
package davemon;


public class MoveCreator {
    
    public Move makeMove(String moveName){
        
        Move move = new Move();
        // creatures set types themselves. like setting a fireball to water type, for ex.
        
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
            move.setName("Bite"); 
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
            move.setEffectChance(70);
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
        }else if(moveName.equalsIgnoreCase("Psych out")){
            move.setName("Psych out");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10); 
            move.setType("Mind");
            move.setAccuracy(70);
        }else if(moveName.equalsIgnoreCase("Enrage")){
            move.setName("Enrage");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10); 
            move.setType("Physical");
            move.setAccuracy(90);
        }else if(moveName.equalsIgnoreCase("Fireball")){
            move.setName("Fireball");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(40);
            move.setType("Fire");
            move.setAccuracy(60);
        }else if(moveName.equalsIgnoreCase("Execute")){
            move.setName("Execute");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(25);
            move.setType("Dark");
            move.setAccuracy(50);
        }else if(moveName.equalsIgnoreCase("Absorb life")){
            move.setName("Absorb life");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(35);
            move.setType("Dark");
            move.setAccuracy(65);
        }else if(moveName.equalsIgnoreCase("Shatter")){ // needs test. low damage pierce attack.
            move.setName("Shatter");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10);
            move.setType("Metal");
            move.setAccuracy(72);
        }else if(moveName.equalsIgnoreCase("Insane bolt")){
            move.setName("Insane bolt");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(200);
            move.setType("Lightning");
            move.setAccuracy(20);
        }else if(moveName.equalsIgnoreCase("Clear mind")){ // needs test, 20% heal
            move.setName("Clear mind");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(20);
            move.setType("Mind");
            move.setAccuracy(80);
        }else if(moveName.equalsIgnoreCase("Psywave")){ // needs test, just a special mind hit
            move.setName("Psywave");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10);
            move.setType("Mind");
            move.setAccuracy(70);
        }else if(moveName.equalsIgnoreCase("Venom fang")){ // needs test. basically poison chance hit with a dot as well.
            move.setName("Venom fang");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(38);
            move.setType("Poison");
            move.setAccuracy(60);
            move.setDuration(5);
            move.setEffectChance(60);
            move.setEffectAmount(10);
            move.setEffectName("Venom");
        }else if(moveName.equalsIgnoreCase("Blood curl")){ // needs test, doubles dmg if enemy has bleed effect
            move.setName("Blood curl");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(30);
            move.setType("Dark");
            move.setAccuracy(65);
        }else if(moveName.equalsIgnoreCase("Electric current")){ // needs test. basically special lightning hit with chance to shock
            move.setName("Electric current");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(30);
            move.setType("Lightning");
            move.setAccuracy(60);
            move.setDuration(5);
            move.setEffectChance(60);
            move.setEffectAmount(10);
            move.setEffectName("Shock");
        }else if(moveName.equalsIgnoreCase("Voltage overload")){ // needs test. basically special lightning hit with 20% chance to do 10 damage to self.
            move.setName("Voltage overload");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(50);
            move.setType("Lightning");
            move.setAccuracy(65);
        }else if(moveName.equalsIgnoreCase("Agility")){ // needs test. basically just increases speed.
            move.setName("Agility");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(40);
            move.setType("Physical");
            move.setAccuracy(80);
        }else if(moveName.equalsIgnoreCase("Wing slice")){ // needs test. basically flying attack with chance to pierce.
            move.setName("Wing slice");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(30);
            move.setType("Flying");
            move.setAccuracy(73);
        }else if(moveName.equalsIgnoreCase("Fracture")){ // needs test. basically lowers enemy physical def by half dmg done.
            move.setName("Fracture");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(20);
            move.setType("Ice");
            move.setAccuracy(70);
        }else if(moveName.equalsIgnoreCase("Thorns")){ // verified.
            move.setName("Thorns");
            move.setTimesUsed(0);
            move.setMaxUses(10);
            move.setBaseAmount(20); // maximum reflect amount. reflects half.
            move.setType("Physical");
            move.setAccuracy(90);
            move.setDuration(3); // effect moves need duration
        }else if(moveName.equalsIgnoreCase("Aegis")){ // verified.
            move.setName("Aegis");
            move.setTimesUsed(0);
            move.setMaxUses(10);
            move.setBaseAmount(40);
            move.setType("Physical");
            move.setAccuracy(90);
            move.setDuration(3); // effect moves need duration
        }else if(moveName.equalsIgnoreCase("Ink")){ // needs test, reduces accuracy.
            move.setName("Ink");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(40);
            move.setType("Water");
            move.setAccuracy(75);
            move.setDuration(7);
        }else if(moveName.equalsIgnoreCase("Entangle")){ // needs test, reduces stuns enemy. SHOULD have a move that breaks entangles.
            move.setName("Entangle");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10);
            move.setType("Physical");
            move.setAccuracy(60);
            move.setDuration(2);
        }else if(moveName.equalsIgnoreCase("Tentacle slap")){ // needs test, just a physical attack.
            move.setName("Tentacle slap"); 
            move.setTimesUsed(0);
            move.setMaxUses(25);
            move.setBaseAmount(50);
            move.setType("Physical");
            move.setAccuracy(78);
        }else if(moveName.equalsIgnoreCase("Dark matter")){ // damage.
            move.setName("Dark matter");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(60);
            move.setType("Dark");
            move.setAccuracy(60);
        }else if(moveName.equalsIgnoreCase("Wet")){ // needs test, effect that reduces accuracy.
            move.setName("Wet");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10);
            move.setType("Water");
            move.setAccuracy(80);
            move.setDuration(4);
        }else if(moveName.equalsIgnoreCase("Ice shard")){ // needs test. triples damage if enemy is wet.
            move.setName("Ice shard");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(25);
            move.setType("Ice");
            move.setAccuracy(75);
        }else if(moveName.equalsIgnoreCase("Crystallize")){ // verified stun. just doesnt print anything to flavor text if no wet effect.
            move.setName("Crystallize");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10);
            move.setType("Ice");
            move.setAccuracy(70);
            move.setDuration(1);
        }else if(moveName.equalsIgnoreCase("Chilling gust")){ // verified
            move.setName("Chilling gust");
            move.setTimesUsed(0);
            move.setMaxUses(20);
            move.setBaseAmount(10);
            move.setType("Ice");
            move.setAccuracy(75);
            move.setDuration(5);
            move.setEffectChance(50);
            move.setEffectAmount(5);
            move.setEffectName("Chill");
        }
     
        return move;
        
    }
    
}
