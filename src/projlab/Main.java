package projlab;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        ArrayList<Ticker> ticks = new ArrayList<Ticker>();
        ticks.addAll(game.getVirologists());
        ticks.addAll(game.getFields());
        Thread timer = new Thread(new Timer(ticks));
        timer.start();
        game.startGame();
        boolean isGame = true;
        boolean allBear = false;
        while (isGame && !allBear){
            allBear = true;
            for(Virologist v : game.getVirologists()){
                if(v.GetGenetic_codes().size() == 4) isGame = false;
            }
            for(Virologist v1 : game.getVirologists()){
                if(!v1.isBear()) allBear = false;
            }
        }
        System.out.println("VÉGE");
        timer.stop();
        timer.join();
        game.endGame();
    }



}