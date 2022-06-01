
package davemon;


public class Move {
    
    private String name;
    private String id; // determines what it does . creature level determines damage
    private Integer baseAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Integer baseAmount) {
        this.baseAmount = baseAmount;
    }
    
    
    
}
