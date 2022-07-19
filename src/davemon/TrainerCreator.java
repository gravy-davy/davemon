
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
            trainer.setDefeatText("Aw man, you got me. Take this Girapod I have, and put him to good use!");
            trainer.setIntroText("Hey, how's it going? I'm Cater.");

            Random rando = new Random();
            Creature c1;
            c1 = cc.getCreature("Girapod", rando.nextInt(3)+1);
            trainer.addToActiveDavemon(c1);
            Creature c2;
            c2 = cc.getCreature("Gnuke", rando.nextInt(3)+1);
            trainer.addToActiveDavemon(c2);
            
            trainer.setRewardCreature(c1);
            trainer.setRewardMoney(50);
        }else if(name.equalsIgnoreCase("Lil Punk #1")){
            trainer = new Trainer();
            trainer.setActiveDavemon(new ArrayList<>());
            trainer.setName("Lil Punk #1");
            trainer.setId(2);
            trainer.setFullLogo(Constant.TRAINER_PUNK_KID_1);
            trainer.setLogo(Constant.TRAINER_PUNK_KID_1_LOGO);
            trainer.setVictoryText("Told you geezer");
            trainer.setDefeatText("Aw man, you got me. Take this Girapod I have, and put him to good use!");
            trainer.setIntroText("Yo oldhead, I will mess you up no cap on a stack on god you heard? My lizards go hard! ");

            Random rando = new Random();
            Creature c3;
            c3 = cc.getCreature("Cidron", rando.nextInt(3)+1);
            trainer.addToActiveDavemon(c3);
            Creature c2;
            c2 = cc.getCreature("Kinetile", rando.nextInt(3)+1);
            trainer.addToActiveDavemon(c2);
            Creature c1;
            c1 = cc.getCreature("Cryzard", rando.nextInt(3)+1);
            trainer.addToActiveDavemon(c1);
            
            trainer.setRewardCreature(c2);
            trainer.setRewardMoney(50);
        }
        
        return trainer;
    }
    
}
