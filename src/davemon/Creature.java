
package davemon;

import java.util.ArrayList;


public class Creature {
    
    private String name;
    private Integer health;
    private Integer speed;
    private Integer level;
    private ArrayList<Move[]> moveset; // max size 4
    private String type;

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

    public ArrayList<Move[]> getMoveset() {
        return moveset;
    }

    public void setMoveset(ArrayList<Move[]> moveset) {
        this.moveset = moveset;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
