package projlab;

public class Bear extends Agent{

    public void Effect(Virologist v) {
        v.Forgetting_codes();
        v.RemoveNukleotid(v.GetNukleotid().size());
        v.RemoveAminoacid(v.GetAminoacid().size());
        v.setBear(true);
        v.SetImmuneTime(100);
        v.GetProtections().clear();
    }
}
