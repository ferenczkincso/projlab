package projlab;
abstract class Protection {
    /**
     * Az adott védőfelszerelés kifejti a hatását az adott
     * virológuson
     * @param v - A virológus, akire kifejti a hatást
     */
    public abstract void Effect(Virologist v);

    /**
     * Az adott védeőfelszerelés hatása lekerül a virológusról,
     * mikor az már nincsen a birtokában
     * @param v - A virológus, akire kifejti a hatást
     */
    public abstract void ReverseEffect(Virologist v);

    public abstract String GetType();
}
