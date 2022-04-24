package projlab;

public class Ax extends Protection {
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
