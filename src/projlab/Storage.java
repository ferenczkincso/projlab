package projlab;
abstract public class Storage extends Field{
    protected int tickCount = 0;

    public Storage(int id) {
        super(id);
    }
    //itt nincsenek megvalósítva

    public abstract void Collect(Virologist v);

    public abstract void DestroyMaterial();

    @Override
    public void Tick(){
        //üres
    }
}
