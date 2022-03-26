public class Field {
    protected int fieldID;

    public Field[] GetNeighbours();
    public Virologist GetVirologistNearby();
    public void Accept(Virologist v);
    public void Remove(Virologist v);
    public void Collect(Virologist v);

}