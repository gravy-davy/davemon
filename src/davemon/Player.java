
package davemon;

import java.util.ArrayList;


public class Player {
    
    private String name;
    private ArrayList<Creature> davemon;
    private Integer money;
    
    private ArrayList<Integer> gymBattlesCleared;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Creature> getDavemon() {
        return davemon;
    }

    public void setDavemon(ArrayList<Creature> davemon) {
        this.davemon = davemon;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public ArrayList<Integer> getGymBattlesCleared() {
        return gymBattlesCleared;
    }

    public void setGymBattlesCleared(ArrayList<Integer> gymBattlesCleared) {
        this.gymBattlesCleared = gymBattlesCleared;
    }
    
    /**
     * 
     * @param id of the gym battle cleared 
     */
    public void addToGymBattlesCleared(int id){
        this.gymBattlesCleared.add(id);
    }
    
}
