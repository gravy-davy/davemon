
package davemon;

import java.util.ArrayList;
import java.util.Random;


public class TrainerCreator {
    
    public Trainer createTrainer(String name){
        CreatureCreator cc = new CreatureCreator();
        
        Trainer trainer = null;
        
        if(name.equalsIgnoreCase("Cater")){
            trainer = new Trainer();
            trainer.setActiveDavemon(new ArrayList<>());
            trainer.setName("Cater");
            trainer.setId(1);
            trainer.setFullLogo(Constant.TRAINER_CATER_FULL);
            trainer.setLogo(Constant.TRAINER_CATER_LOGO);
            trainer.setVictoryText("You'll get them next time!");
            trainer.setDefeatText("Aw man, you got me.");
            trainer.setIntroText("Hey, how's it going? I'm Cater.");

            Random rando = new Random();
            Creature c1;
            c1 = cc.getCreature("Girapod", rando.nextInt(3)+1);
            trainer.addToActiveDavemon(c1);
            Creature c2;
            c2 = cc.getCreature("Gnuke", rando.nextInt(3)+1);
            trainer.addToActiveDavemon(c2);
        }
        
        return trainer;
    }
    
}
