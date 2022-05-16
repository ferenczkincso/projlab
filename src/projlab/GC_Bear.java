package projlab;

public class GC_Bear extends GeneticCode{

    public void CreateAgent(Virologist v) {
            Bear b = new Bear();
            v.AddAgent(b);
            b.Effect(v);
    }

    @Override
    public String getType() {
        return "Bear";
    }
}
