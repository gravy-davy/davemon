
package davemon;

import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Trainer {
    
    private String name;
    private ArrayList<Creature> activeDavemon;
    private ImageIcon logo; // logo during battles
    private ImageIcon fullLogo; // logo for dialog
    private Integer id; // used to see if player has beaten this trainer already
    
    private String introText;
    private String victoryText;
    private String defeatText;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ImageIcon getLogo() {
        return logo;
    }

    public void setLogo(ImageIcon logo) {
        this.logo = logo;
    }

    public ImageIcon getFullLogo() {
        return fullLogo;
    }

    public void setFullLogo(ImageIcon fullLogo) {
        this.fullLogo = fullLogo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntroText() {
        return introText;
    }

    public void setIntroText(String introText) {
        this.introText = introText;
    }

    public String getVictoryText() {
        return victoryText;
    }

    public void setVictoryText(String victoryText) {
        this.victoryText = victoryText;
    }

    public String getDefeatText() {
        return defeatText;
    }

    public void setDefeatText(String defeatText) {
        this.defeatText = defeatText;
    }
    
    
    
}
