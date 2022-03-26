import java.util.List;

public class Field {
    protected int fieldID;
    private List<Field> neighbours;

    public List<Field> GetNeighbours(){}
    public Virologist GetVirologistNearby(){}
    public void Accept(Virologist v){}
    public void Remove(Virologist v){}
    public void Collect(Virologist v){}

}