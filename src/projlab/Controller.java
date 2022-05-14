package projlab;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    private Game game;
    Controller(Game g){
        game = g;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP :
                System.out.println("up");
                if((int)game.getCurrentVirologist().getCurrent_field().GetFieldId() / 10 == 1) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() - 10) {
                            game.getCurrentVirologist().Move(f);
                            game.nextVirologist();
                            break;
                        }
                    }
                }
                break;
            case KeyEvent.VK_DOWN :
                System.out.println("Down");
                if((int)(game.getCurrentVirologist().getCurrent_field().GetFieldId() / 10) == 4) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() + 10) {
                            game.getCurrentVirologist().Move(f);
                            game.nextVirologist();
                            break;
                        }
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                if(game.getCurrentVirologist().getCurrent_field().GetFieldId() % 10 == 4) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() + 1) {
                            game.getCurrentVirologist().Move(f);
                            game.nextVirologist();
                            break;
                        }
                    }
                }
                break;
            case KeyEvent.VK_LEFT :
                System.out.println("Left");
                if(game.getCurrentVirologist().getCurrent_field().GetFieldId() % 10 == 1) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() - 1) {
                            game.getCurrentVirologist().Move(f);
                            game.nextVirologist();
                            break;
                        }
                    }
                }
                break;
            case KeyEvent.VK_P :  //protection felvétele
                System.out.println("P");
                if(game.getCurrentVirologist().getCurrent_field().getType().equals("Shelter")){
                    Shelter s = (Shelter)game.getCurrentVirologist().getCurrent_field();
                    if(s.getProtection() != null){
                        game.getCurrentVirologist().GetItem();
                    }
                }
                break;
            case KeyEvent.VK_C :  //anyag felvétele
                System.out.println("C");
                if(game.getCurrentVirologist().getCurrent_field().getType().equals("Aminoacid_Storage")){
                    game.getCurrentVirologist().CollectMaterial();
                }else if(game.getCurrentVirologist().getCurrent_field().getType().equals("Nukleotid_Storage")){
                    game.getCurrentVirologist().CollectMaterial();
                }
                break;
            case KeyEvent.VK_A :  //ágens kenése
                System.out.println("A");

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
