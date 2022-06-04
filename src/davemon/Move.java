
package davemon;


public class Move {
    
    private String name;        // determines what it does
    private Integer baseAmount; // damage / effect / other amount
    private String type;        // type of effect, like fire for damage
    
    private Integer maxUses;
    private Integer timesUsed;

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
    
    
    
}
