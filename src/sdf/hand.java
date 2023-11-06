package sdf;

import java.util.LinkedList;
import java.util.*;

public class hand {

    private List<card> handList = new LinkedList<>(); //list of cards in your hand
    private List<String> nameList = new LinkedList<>();
    private List<String> suitList = new LinkedList<>();
    private int handValue = 0;
    private int handSize = 0;

    public hand(){ 
        //this.handList = handList;
        //check why i don't need to declare handList inside the constructor, yet when i have
        //2 instances of the hand object, they won't affect each other

    }

    public void addCard(card c){
        handList.add(c);
        nameList.add(c.getCardName());
        suitList.add(c.getSuit());
        handValue += c.getValue();
        handSize = handList.size();
        System.out.printf("You have %d cards in your hand.\n",handSize);
    }

    public void showHand(){
        System.out.println(nameList);
    }

    public void discard(){ //this doesn't work. you need to clear the list above
        handList = new LinkedList<>();
        nameList = new LinkedList<>();
        suitList = new LinkedList<>();
        handValue = 0;
        handSize = 0;
        System.out.println("Hand discarded.");

    }

    public int getHandValue(){
        return handValue;
    }
    public int getHandSize(){
        return handSize;
    }


}
