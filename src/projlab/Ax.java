package projlab;

public class Ax extends Protection {

    /**
     * Az Effect a balta hatását fejti ki, azaz eltávolítja
     * a medvevírussal megfertőződött virológust a mezőjéről,
     * amelyen jelenleg áll, és ezáltal számára véget ér a játék
     * @param v - A virológus, akire kifejti a hatást
     */
    @Override
    public void Effect(Virologist v) {
        v.getCurrent_field().Remove(v);
    }

    @Override
    public void ReverseEffect(Virologist v) {

    }

    @Override
    public String GetType() {
        return "Ax";
    }
}
