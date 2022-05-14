package projlab;

public class Observable {

    protected Observer fieldObserver;
    protected Observer inventoryObserver;

    Observable(Observer f, Observer i){
        fieldObserver = f;
        inventoryObserver = i;
    }
    public Observer getInventoryObserver(){return inventoryObserver;}
}
