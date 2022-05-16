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
                if (game.getCurrentVirologist().isBear()==true) break;
                if((int)game.getCurrentVirologist().getCurrent_field().GetFieldId() / 10 == 1) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() - 10) {
                            if (f.GetVirologist().size()<2) {
                                game.getCurrentVirologist().Move(f);
                                game.nextVirologist();
                                break;
                            }else break;
                        }
                    }
                }
                break;
            case KeyEvent.VK_DOWN :
                System.out.println("Down");
                if (game.getCurrentVirologist().isBear()==true) break;
                if((int)(game.getCurrentVirologist().getCurrent_field().GetFieldId() / 10) == 4) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() + 10) {
                            if (f.GetVirologist().size()<2) {
                                game.getCurrentVirologist().Move(f);
                                game.nextVirologist();
                                break;
                            }else break;
                        }
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                if (game.getCurrentVirologist().isBear()==true) break;
                if(game.getCurrentVirologist().getCurrent_field().GetFieldId() % 10 == 4) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() + 1) {
                            if (f.GetVirologist().size()<2) {
                                game.getCurrentVirologist().Move(f);
                                game.nextVirologist();
                                break;
                            }else break;
                        }
                    }
                }
                break;
            case KeyEvent.VK_LEFT :
                System.out.println("Left");
                if (game.getCurrentVirologist().isBear()==true) break;
                if(game.getCurrentVirologist().getCurrent_field().GetFieldId() % 10 == 1) break;
                else {
                    for(Field f : game.getFields()) {
                        if(f.GetFieldId() == game.getCurrentVirologist().getCurrent_field().GetFieldId() - 1) {
                            if (f.GetVirologist().size()<2) {
                                game.getCurrentVirologist().Move(f);
                                game.nextVirologist();
                                break;
                            }else break;
                        }
                    }
                }
                break;
            case KeyEvent.VK_V:  //protection felvétele
                System.out.println("P");
                if (game.getCurrentVirologist().isBear()==true) break;
                if(game.getCurrentVirologist().getCurrent_field().getType().equals("Shelter")){
                    Shelter s = (Shelter)game.getCurrentVirologist().getCurrent_field();
                    if(s.getProtection() != null){
                        game.getCurrentVirologist().GetItem();
                    }
                }
                break;
            case KeyEvent.VK_C :  //anyag felvétele
                System.out.println("C");
                if (game.getCurrentVirologist().isBear()==true) break;
                if(game.getCurrentVirologist().getCurrent_field().getType().equals("Aminoacid_storage")){
                    game.getCurrentVirologist().CollectMaterial();
                }else if(game.getCurrentVirologist().getCurrent_field().getType().equals("Nukleotid_storage")){
                    game.getCurrentVirologist().CollectMaterial();
                }
                break;

            case KeyEvent.VK_G :  //genetic code tapogatas
                System.out.println("G");
                if (game.getCurrentVirologist().isBear()==true) break;
                if (game.getCurrentVirologist().getCurrent_field().getType().equals("Lab")){
                    Lab l = (Lab)game.getCurrentVirologist().getCurrent_field();
                    l.Collect(game.getCurrentVirologist());
                }
                break;
            case KeyEvent.VK_P :  //Paralyze ágens létrehozása
                System.out.println("P");
                for(GeneticCode gc : game.getCurrentVirologist().GetGenetic_codes()){
                    if(gc.getType().equals("Paralyze")){
                        gc.CreateAgent(game.getCurrentVirologist());
                    }
                }
                break;
            case KeyEvent.VK_I :  //Immunity ágens létrehozása
                System.out.println("I");
                for(GeneticCode gc : game.getCurrentVirologist().GetGenetic_codes()) {
                    if (gc.getType().equals("Immunity")) {
                        gc.CreateAgent(game.getCurrentVirologist());
                    }
                }
                break;
            case KeyEvent.VK_U :  //Uncontrollable ágens létrehozása
                System.out.println("U");
                for(GeneticCode gc : game.getCurrentVirologist().GetGenetic_codes()) {
                    if (gc.getType().equals("Uncontrollable")) {
                        gc.CreateAgent(game.getCurrentVirologist());
                    }
                }
                break;
            case KeyEvent.VK_F :  //forgetteing ágens létrehozása
                System.out.println("F");
                for(GeneticCode gc : game.getCurrentVirologist().GetGenetic_codes()) {
                    if (gc.getType().equals("Forgetting")) {
                        gc.CreateAgent(game.getCurrentVirologist());
                    }
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
