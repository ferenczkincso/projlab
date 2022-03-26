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
    private Field current_field;

    public void Tick(){
        System.out.println("Tick");
        while (immuneTime != 0)
            ReduceImmuneTime();
        while (paralyzedTime != 0)
            ReduceParalyzedTime();
        while (uncontrollabeTime != 0)
            ReduceUncontrollableTime();
    }
    public void Move(Field f){
        System.out.println("Move");
        List<Field> fields = current_field.GetNeighbours();
        for (Field field : fields){
            if (f.fieldID==field.fieldID){
                current_field.Remove(this);
                f.Accept(this);
            }
        }
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

    }
    public void ReduceImmuneTime(){
        System.out.println("ReduceImmuneTime");
    }
    public void ReduceParalyzedTime(){
        System.out.println("ReduceParalyzedTime");
    }
    public void ReduceUncontrollableTime(){
        System.out.println("ReduceUncontrollableTime");
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

