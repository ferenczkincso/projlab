import java.util.List;
package src;
public class Field {
    protected int fieldID;
    private List<Field> neighbours;
    private Virologist virologist;

    public List<Field> GetNeighbours(){
        System.out.println("f.GetNeighbours()");
        return neighbours;
    }
    public Virologist GetVirologistNearby(){
        virologist = new Virologist();
        return virologist;
    }
    public void Accept(Virologist v){
        System.out.println("Accept(v)");
    }
    public void Remove(Virologist v){
        System.out.println("Remove(v)");
    }
    public void Collect(Virologist v){System.out.println("Collect(v)");}

}