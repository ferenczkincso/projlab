package projlab;
public class GC_Immunity extends GeneticCode{
    /**
     * Feladata a Immunity ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     * @param v - A virológus, akire kifejti a hatást
     */

    public void CreateAgent(Virologist v){
        System.out.println("Create Immunity: CreateAgent(Virologist v)");
        Immunity i = new Immunity();
        System.out.println("Add Immunity: ");
        v.AddAgent(i);
    }
}
