package projlab;
public class GC_Uncontrollable extends GeneticCode{
    public GC_Uncontrollable(){
        super(3,3);
    }
    /**
     * Feladata a Uncontrollable ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     //* @param v - A virológus, akire kifejti a hatást
     */
    public void AgentType(Virologist v) {
        System.out.println("Add Uncontrollable: ");
        Uncontrollable u = new Uncontrollable();
        v.AddAgent(u);
    }
}
