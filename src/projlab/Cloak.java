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
        int randomInt = randomGenerator.nextInt() % 1000 + 1;
        if (randomInt <= 823 && v.GetImmuneTime()==0) //823 ezrelék = 82.3 százalék. Ha ezt az értéket nem lépi túl, akkor az adont ágens felkenési próbájánál immunitás lesz.
        {
            v.SetImmuneTime(5); //lehet, hogy ide csak ennyi kell
        }
        return;

    }

    /**
     * A ReverseEffect feladata, hogy a Cloak hatása lekerüljön
     * a virológusról, amikor az már nincs a birtokában, és
     * ezáltal már nem immunis 82.3%-ban.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void ReverseEffect(Virologist v) {
        return; //esetleg immuneTime-5 sec 82.3% eséllyel
    }

    @Override
    public String GetType() {
        return "Cloak";
    }
}
