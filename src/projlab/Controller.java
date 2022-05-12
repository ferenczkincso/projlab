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
        switch(e.getKeyChar()){
            case KeyEvent.VK_UP :
                if(game.getCurrentVirologist().getCurrent_field().GetFieldId() / 10 == 1) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() - 10) {
                            game.getCurrentVirologist().Move(f);
                            game.nextVirologist();
                        }
                    }
                }
                break;
            case KeyEvent.VK_DOWN :
                if((int)(game.getCurrentVirologist().getCurrent_field().GetFieldId() / 10) == 4) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() + 10) {
                            game.getCurrentVirologist().Move(f);
                            game.nextVirologist();
                        }
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(game.getCurrentVirologist().getCurrent_field().GetFieldId() % 10 == 4) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() + 1) {
                            game.getCurrentVirologist().Move(f);
                            game.nextVirologist();
                        }
                    }
                }
                break;
            case KeyEvent.VK_LEFT :
                if(game.getCurrentVirologist().getCurrent_field().GetFieldId() % 10 == 1) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() - 1) {
                            game.getCurrentVirologist().Move(f);
                            game.nextVirologist();
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
