
package davemon;

import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Creature {
    
    private String name;
    private Integer level;
    private Integer currentXp;
    private Integer xpNeeded;
    private ArrayList<Move> moveset; // max size 4
    private ArrayList<Effect> effects; // active effects. can be cleared by doc.
    
    private ArrayList<String> resistances;
    private ArrayList<String> weaknesses;
  
    private ImageIcon image;
    private Integer health;
    private Integer maxHealth;
    private Integer healthPerLevel;
    private Integer physicalDef;
    private Integer specialDef;
    private Integer speed;
    private Integer physicalAtk;
    private Integer specialAtk;
    
    private String type; // like grass/fire/dark etc
    private Integer evolutionLevel; // level needed to evolve
    
    private Integer tempMaxHealth;
    private Integer tempPhysicalDef;
    private Integer tempSpecialDef;
    private Integer tempSpeed;
    private Integer tempPhysicalAtk;
    private Integer tempSpecialAtk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Move> getMoveset() {
        return moveset;
    }

    public void setMoveset(ArrayList<Move> moveset) {
        this.moveset = moveset;
    }

    public ArrayList<Effect> getEffects() {
        return effects;
    }

    public void setEffects(ArrayList<Effect> effects) {
        this.effects = effects;
    }

    public Integer getCurrentXp() {
        return currentXp;
    }

    public void setCurrentXp(Integer currentXp) {
        this.currentXp = currentXp;
    }

    public Integer getXpNeeded() {
        return xpNeeded;
    }

    public void setXpNeeded(Integer xpNeeded) {
        this.xpNeeded = xpNeeded;
    }
    
    public void addEffect(Effect e){
        this.effects.add(e);
    }
    
    public void addMove(Move m){
        this.moveset.add(m);
    }

    public Integer getEvolutionLevel() {
        return evolutionLevel;
    }

    public void setEvolutionLevel(Integer evolutionLevel) {
        this.evolutionLevel = evolutionLevel;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Integer maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Integer getHealthPerLevel() {
        return healthPerLevel;
    }

    public void setHealthPerLevel(Integer healthPerLevel) {
        this.healthPerLevel = healthPerLevel;
    }

    public Integer getPhysicalDef() {
        return physicalDef;
    }

    public void setPhysicalDef(Integer physicalDef) {
        this.physicalDef = physicalDef;
    }

    public Integer getSpecialDef() {
        return specialDef;
    }

    public void setSpecialDef(Integer specialDef) {
        this.specialDef = specialDef;
    }

    public Integer getTempMaxHealth() {
        return tempMaxHealth;
    }

    public void setTempMaxHealth(Integer tempMaxHealth) {
        this.tempMaxHealth = tempMaxHealth;
    }

    public Integer getTempPhysicalDef() {
        return tempPhysicalDef;
    }

    public void setTempPhysicalDef(Integer tempPhysicalDef) {
        this.tempPhysicalDef = tempPhysicalDef;
    }

    public Integer getTempSpecialDef() {
        return tempSpecialDef;
    }

    public void setTempSpecialDef(Integer tempSpecialDef) {
        this.tempSpecialDef = tempSpecialDef;
    }

    public Integer getTempSpeed() {
        return tempSpeed;
    }

    public void setTempSpeed(Integer tempSpeed) {
        this.tempSpeed = tempSpeed;
    }

    public Integer getPhysicalAtk() {
        return physicalAtk;
    }

    public void setPhysicalAtk(Integer physicalAtk) {
        this.physicalAtk = physicalAtk;
    }

    public Integer getSpecialAtk() {
        return specialAtk;
    }

    public void setSpecialAtk(Integer specialAtk) {
        this.specialAtk = specialAtk;
    }

    public Integer getTempPhysicalAtk() {
        return tempPhysicalAtk;
    }

    public void setTempPhysicalAtk(Integer tempPhysicalAtk) {
        this.tempPhysicalAtk = tempPhysicalAtk;
    }

    public Integer getTempSpecialAtk() {
        return tempSpecialAtk;
    }

    public void setTempSpecialAtk(Integer tempSpecialAtk) {
        this.tempSpecialAtk = tempSpecialAtk;
    }

    public ArrayList<String> getResistances() {
        return resistances;
    }

    public void setResistances(ArrayList<String> resistances) {
        this.resistances = resistances;
    }

    public ArrayList<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(ArrayList<String> weaknesses) {
        this.weaknesses = weaknesses;
    }
    
    public void addToResistances(String str){
        this.resistances.add(str);
    }
    
    public void addToWeaknesses(String str){
        this.weaknesses.add(str);
    }
    
}
