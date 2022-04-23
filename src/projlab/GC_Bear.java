package projlab;

public class GC_Bear extends GeneticCode{
    public GC_Bear(){
        super(0,0);
    }
    public void AgentType(Virologist v){
        Bear b = new Bear();
        v.AddAgent(b);
    }
}
