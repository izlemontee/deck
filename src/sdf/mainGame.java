package sdf;

import java.util.*;
import java.io.Console;

public class mainGame {
    public static void main(String args[]){
        //newdeck has to be static in order to call the method. 
        //but once that is done, just use d.draw.getCardName without static as the objet has alr been created
        boolean stopped = false;
        Console cons = System.console();
        System.out.println("Welcome to your game. Creating new deck first...");
        deck d = new deck();
        d = d.newDeck(); //create a new deck
        hand h = new hand(); //doesn't need to be static because it's a constructor not a method
        //hand h2 = new hand();
        while(!stopped){
            String input = cons.readLine(">>> Input command (type 'help' for list of commands): ");
            Scanner s = new Scanner(input);
            String cmd = s.next();
            cmd = cmd.toLowerCase();
            
            //taking user input
            switch(cmd){

                case "stop":
                stopped = true;
                break;

                case "new":
                d = d.newDeck();
                break;

                case "draw":
                List<card> deckList = d.getDeck();
                card c = d.draw();
                //String cardName = c.getCardName();
                h.addCard(c);
                h.showHand();
                //h2.showHand();
                //System.out.println(cardName);
                break;

                case"discard":
                h.discard();
                h.showHand();
                //h2.showHand();
                break;

                case "shuffle":
                deckList = d.getDeck();
                deckList = d.shuffle(deckList);
                break;

                case "blackjack":
                blackjack b = new blackjack();
                b.game(h,d);
                break;

                case"help":
                help();
                break;

                case"show":
                d.showCards();
                break;

                default:
                System.out.println("Invalid command.");
            }
            s.close();
        }
        System.out.println("Thank you for playing.");
        
        
        //System.out.println("New deck.");
        //System.out.println(d.draw().getCardName());
        //System.out.println(d.draw().getCardName());
        //d.shuffle();
        //System.out.println(d.draw().getCardName());
    }

    public static void help(){
        System.out.println("new: creates new deck.");
        System.out.println("draw: draws a card.");
        System.out.println("shuffle: shuffles the deck.");
        System.out.println("stop: stops the game.");
    }
    
}
