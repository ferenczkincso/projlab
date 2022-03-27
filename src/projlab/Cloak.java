package projlab;
public class Cloak extends Protection{
    /**
     * Az Effect feladata, hogy az adott virológusra
     * kifejtse a Cloak hatását, azaz 82.3%-os védelmet
     * nyújtson az ágensek ellen.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Effect(Virologist v) {
        System.out.println("Cloak: Effect(v)");
    }

    /**
     * A ReverseEffect feladata, hogy a Bag hatása lekerüljön
     * a vriológusról, amikor az már nincs a birtokában, és
     * ezáltal megfelezi a virológus anyaggyűjtő képességét.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void ReverseEffect(Virologist v) {
        System.out.println("ReverseEffect(v)");
    }
}
