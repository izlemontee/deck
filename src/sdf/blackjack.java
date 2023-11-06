package sdf;

import java.util.Scanner;
import java.io.Console;
import java.util.*;

public class blackjack {
    
    int handSize = 0;
    int handValue = 0;
    boolean stopDrawing = false;

    public void game(hand h, deck d){
        d = d.newDeck();
        List<card> deckList = d.getDeck();
        deckList = d.shuffle(deckList);
        h.discard();
        CardPrediction cp = new CardPrediction();
        for (int i = 0; i < 2; i ++){ //every player starts with 2 cards in hand
            card c = d.draw();
            h.addCard(c);
        }
        Console cons = System.console();
   
        while(true){
            handSize = h.getHandSize();
            handValue = h.getHandValue();
            h.showHand();
            System.out.printf("Current hand value: %d\n",handValue);
            

            cp.prediction(h,d);

            if((handSize >= 5)||(handValue>21)||(stopDrawing)){
                break;
            }
            String input = cons.readLine(">>>Draw? (Y/N)");
            Scanner s = new Scanner(input);
            String cmd = s.next();
            cmd = cmd.toUpperCase();

            switch(cmd){
                case "Y":
                card c = d.draw();
                h.addCard(c);
                break;

                case "N":
                stopDrawing = true;
                break;

                default:
                System.out.println("Invalid option.");
            }
            s.close();


        }
        if(handValue > 21){
            System.out.println("You overshot.");
        }
        else{
            System.out.printf("Your hand had a value of %d.\n",handValue);
        }
    }
}
