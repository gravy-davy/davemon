
package davemon;

import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Trainer {
    
    private String name;
    private ArrayList<Creature> activeDavemon;
    private ImageIcon image;

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

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public void addToActiveDavemon(Creature c){
        this.activeDavemon.add(c);
    }
    
    
    
}
