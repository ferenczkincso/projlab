package projlab;
public class GC_Uncontrollable extends GeneticCode{
    /**
     * Feladata a Uncontrollable ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     * @param v - A virológus, akire kifejti a hatást
     */
    public void CreateAgent(Virologist v){
        System.out.println("Create Uncontrollable: CreateAgent(Virologist v)");
        Uncontrollable u = new Uncontrollable();
        System.out.println("Add Uncotrollable: ");
        v.AddAgent(u);
    }
}
