
package davemon;

import java.util.ArrayList;


public class Player {
    
    private String name;
    private ArrayList<Creature> davemon;
    private ArrayList<Creature> activeDavemon; // using in fights, max size here is 4
    private Integer money;
    private String location;
    private ArrayList<Integer> gymBattlesCleared;
    
    // items
    private Integer daveballs;
    private Integer healthPotions;

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
    
    /**
     * 
     * @param creature obj to add to the player's creature list
     */
    public void addToDavemon(Creature creature){
        this.davemon.add(creature);
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Creature> getActiveDavemon() {
        return activeDavemon;
    }

    public void setActiveDavemon(ArrayList<Creature> activeDavemon) {
        this.activeDavemon = activeDavemon;
    }
    
    public void addToActiveDavemon(Creature c){
        this.activeDavemon.add(c);
    }

    public Integer getDaveballs() {
        return daveballs;
    }

    public void setDaveballs(Integer daveballs) {
        this.daveballs = daveballs;
    }
    
    
    
}
