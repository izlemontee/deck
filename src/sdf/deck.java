package sdf;

import java.util.*;
import java.io.Console;

public class deck {
    private static final String[] suits = {"Spades","Diamonds","Hearts","Clubs"};
    private static final String[] names = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private static final int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10};
    //public boolean hasJoker = false;
    private List<card> deckList;
    private List<String> cardNames;



    public deck(){ //deck CONSTRUCTOR, where it makes a new deck
        deckList = new LinkedList<>();
        cardNames = new LinkedList<>();
        for (String s:suits){
            for (int i = 0;i<names.length;i++){
                card c = new card(s,names[i],values[i]);
                deckList.add(c);
            }
        }
        for(card c:deckList){
            String cardName = c.getCardName();
            cardNames.add(cardName);
        }
        System.out.println("card list built.");
        /*
        if(hasJoker == true){ //add in joker (optional)
            card c = new card("Joker");
            deckList.add(c);
            deckList.add(c);
        }
        */
    }

    public card draw(){ //draws a CARD OBJECT from the deckList, which is a linkedlist
        if(deckList.size()>0){
            card c = deckList.get(0);
            deckList.remove(0);
            cardNames.remove(0);
            return c;
        }

        else{
            System.out.println("Deck is empty.");
            card c = null;
            return c;
        }

    }

    public List<card> shuffle(List<card> deckList){
        if(deckList.size()>0){
            Collections.shuffle(deckList);
            System.out.println(" Deck shuffled.");
            cardNames.clear();
            for(card c:deckList){
                String cardName = c.getCardName();
                cardNames.add(cardName);
            }
        }
        else{
            System.out.println("There is no deck. Create a new one.");
        }



        return deckList;
    }

    public deck newDeck(){
        boolean hasJoker = false;//give the user an option if they want a joker
        boolean hasError = true;
        Console cons = System.console();
        /*
        while(hasError){
            String input = cons.readLine(">>>Include joker? (Y/N)");
            Scanner s = new Scanner(input);
            String cmd = s.next();
            cmd = cmd.toUpperCase();
            switch(cmd){
                case "Y":
                hasJoker = true;
                hasError = false;
                break;

                case "N":
                hasJoker = false;
                hasError = false;
                break;

                default:
                System.out.println("Invalid option.");
            }
            s.close();
        }
        */
      
        deck d = new deck(); //takes in arg on whether it has a joker
        System.out.println("New deck created.");
        return d;
    }
    public List<card> getDeck(){
        return deckList;
    }
    public List<String> getCardNames(){
        return cardNames;
    }
    public void showCards(){
        System.out.println(cardNames);
    }
}
