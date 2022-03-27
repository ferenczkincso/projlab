package src;
public class GC_Immunity extends GeneticCode{
    public void CreateAgent(Virologist v){
        System.out.println("Create Immunity: CreateAgent(Virologist v)");
        Immunity i = new Immunity();
        System.out.println("Add Immunity: ");
        v.AddAgent(i);
    }
}
