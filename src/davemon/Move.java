
package davemon;


public class Move {
    
    private String name;        // determines what it does
    private Integer baseAmount; // damage / effect / other amount. ex: 50 for 50 damage
    private Integer accuracy;   // flat percent chance of a move hitting. like 20% for a giant hit, for ex.
    private String type;        // type of effect, like fire for damage
    
    // effect stuff
    private Integer duration;
    private Integer effectChance;
    private Integer effectAmount;
    private String effectName;
    
    // maybe wont be used, will probably just be annoying.
    private Integer maxUses;
    private Integer timesUsed;

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Integer baseAmount) {
        this.baseAmount = baseAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMaxUses() {
        return maxUses;
    }

    public void setMaxUses(Integer maxUses) {
        this.maxUses = maxUses;
    }

    public Integer getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(Integer timesUsed) {
        this.timesUsed = timesUsed;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getEffectChance() {
        return effectChance;
    }

    public void setEffectChance(Integer effectChance) {
        this.effectChance = effectChance;
    }

    public Integer getEffectAmount() {
        return effectAmount;
    }

    public void setEffectAmount(Integer effectAmount) {
        this.effectAmount = effectAmount;
    }

    public String getEffectName() {
        return effectName;
    }

    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }
    
    
    
}
