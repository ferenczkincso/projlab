import java.util.List;

public class Field {
    protected int fieldID;
    private List<Field> neighbours;

    public List<Field> GetNeighbours(){
        System.out.println("GetNeighbours");
        return neighbours;
    }
    public Virologist GetVirologistNearby(){}
    public void Accept(Virologist v){
        System.out.println("Accept");
    }
    public void Remove(Virologist v){
        System.out.println("Remove");
    }
    public void Collect(Virologist v){}

}