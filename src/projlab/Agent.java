package projlab;
public abstract class Agent {
    /**
     * Az Effect függvény feladata, hogy az adott virológuson,
     * az adott ágens kifejtse hatását.
     * @param v - A virológus, akire kifejti a hatást
     */

    public void Effect(Virologist v) {
        System.out.println("a.Effect(src.Virologist v)");
    }

    /**
     * A ReverseEffect feladata, hogy az adott virológusról
     * az adott ágens hatását levegye.
     * @param v - A virológus, akire kifejti a hatást
     */

    public void ReverseEffect(Virologist v) {
        System.out.println("ReverseEffect(src.Virologist v)");
    }
}
