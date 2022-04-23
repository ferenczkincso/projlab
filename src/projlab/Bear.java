package projlab;

public class Bear extends Agent{

    public void Effect(Virologist v) {
        v.Forgetting_codes();
        v.RemoveNukleotid(v.GetNukleotid().size());
        v.RemoveAminoacid(v.GetAminoacid().size());
        //v.SetIsBear(true) lehet kell
        v.SetImmuneTime(1000);//nem jo igy konretan vegtelen kell legyen
        v.setUncontrollabeTime(1000); // same
        v.GetProtections().clear();
        //picit at kell gondolni
    }

    @Override
    public void Tick() {

    }
}
