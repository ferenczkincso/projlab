package projlab;
public class GC_Immunity extends GeneticCode{
    public GC_Immunity(){
        super(4,4);
    }
    /**
     * Feladata a Immunity ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     * @param v - A virológus, akire kifejti a hatást
     */

    public void AgentType(Virologist v) {
        System.out.println("Add Immunity: ");
        Immunity i = new Immunity();
        v.AddAgent(i);
    }
}
