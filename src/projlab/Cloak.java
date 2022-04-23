package projlab;

import java.util.Random;

public class Cloak extends Protection{
    /**
     * Az Effect feladata, hogy az adott virológusra
     * kifejtse a Cloak hatását, azaz 82.3%-os védelmet
     * nyújtson az ágensek ellen.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Effect(Virologist v)
    {
        Random randomGenerator = new Random(System.currentTimeMillis());
        int randomInt = randomGenerator.nextInt(0,1000);
        if (randomInt <= 823) //823 ezrelék = 82.3 százalék. Ha ezt az értéket nem lépi túl, akkor az adont ágens felkenési próbájánál immunitás lesz.
        {
            v.SetImmuneTime(v.GetImmuneTime()+5); //lehet, hogy ide csak ennyi kell
        }
        return;

    }

    /**
     * A ReverseEffect feladata, hogy a Bag hatása lekerüljön
     * a vriológusról, amikor az már nincs a birtokában, és
     * ezáltal megfelezi a virológus anyaggyűjtő képességét.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void ReverseEffect(Virologist v) {
        return; //esetleg immuneTime-5 sec 82.3% eséllyel
    }
}
