import java.util.List;

public class Virologist implements Ticker {
    private int capacity;
    private List<Nukleotid> nukleotid;
    private List<Aminoacid> aminoacid;
    private int immuneTime;
    private int paralyzedTime;
    private int uncontrollabeTime;
    private List<Protection> protections;
    private List<GeneticCode> genetic_codes;
    private List<Agent> agent;

    public void Tick(){
        System.out.println("Tick\n");
        while (immuneTime != 0)
            ReduceImmuneTime();
        while (paralyzedTime != 0)
            ReduceParalyzedTime();
        while (uncontrollabeTime != 0)
            ReduceUncontrollableTime();
    }
    public void Move(Field f){

    }
    public void Forgetting_codes(){

    }
    public void GetItem(){

    }
    public void CollectMaterial(){

    }
    public void LoseItem(Protection p){

    }
    public void ApplyItem(Protection p){

    }
    public void StealItem(){

    }
    public void LookAround(){

        Field f = new Field();
        Agent a = new Immunity();

        System.out.println("v1.LookAround()");
        System.out.print("\t");

        Virologist v2 = f.GetVirologistNearby();

        System.out.print("\t");
        a.Effect(v2);


    }
    public void ReduceImmuneTime(){
        System.out.println("ReduceImmuneTime\n");
    }
    public void ReduceParalyzedTime(){
        System.out.println("ReduceParalyzedTime\n");
    }
    public void ReduceUncontrollableTime(){
        System.out.println("ReduceUncontrollableTime\n");
    }
    public void StealNukleotid(){

    }
    public void StealAminoacid(){

    }
    public void UseGeneticCode(GeneticCode gc){

    }
    public void AddAgent(Agent a){

    }
    public void AddAminoacid(Aminoacid a){

    }
    public void AddNukleotid(Nukleotid n){

    }
}

