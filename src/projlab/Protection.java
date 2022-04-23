package projlab;
abstract class Protection {
    /**
     * Az adott védőfelszerelés kifejti a hatását az adott
     * virológuson
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Effect(Virologist v) {
        System.out.println("p.Effect(v)");
    }

    /**
     * Az adott védeőfelszerelés hatása lekerül a virológusról,
     * mikor az már nincsen a birtokában
     * @param v - A virológus, akire kifejti a hatást
     */
    public void ReverseEffect(Virologist v) {
        System.out.println("ReverseEffect(v)");
    }

    public abstract String GetType();
}
