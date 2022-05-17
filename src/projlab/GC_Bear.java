package projlab;

public class GC_Bear extends GeneticCode{

    /**
     * A bear ágens elkészítése
     * @param v - A virológus, akire kifejti a hatást
     */
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
