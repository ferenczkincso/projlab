package projlab;
public class Bag extends Protection{
    /**
     *Az Effect feladata, hogy az adott virológusra
     * kifejtse a Bag hatást, tehát az anyaggyűjtő
     * képességét megnövelje a kétszeresére.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Effect(Virologist v) {
        System.out.println("Bag: Effect(v)");
    }

    /**
     * A ReverseEffect feladata, hogy a Bag hatása
     * lekerüljön a virológusról.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void ReverseEffect(Virologist v) {
        System.out.println("ReverseEffect(v)");
    }
}
