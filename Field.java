import java.util.ArrayList;
import java.util.List;

public class Field {
    protected int fieldID;
    private List<Field> neighbours;

    public List<Field> GetNeighbours(){ return new ArrayList<Field>(); }

    public Virologist GetVirologistNearby()
    {
        System.out.println("f.GetVirologistNearby()");
        return new Virologist();
    }

    public void Accept(Virologist v){}
    public void Remove(Virologist v){}
    public void Collect(Virologist v){}

}