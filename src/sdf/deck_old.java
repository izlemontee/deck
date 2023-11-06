package sdf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Console;
import java.util.*;

public class deck_old{
//model a deck
//be able to draw a card
//shuffle the deck
//create a new deck

    final static String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    final static String[] suits = {"Spade","Diamond","Heart","Club"};
    final static String[] jokers = {"Joker","Joker"};
    //constructor
    public deck_old(){
        List<String> deckList = new ArrayList<String> ();
        for (String suit:suits){
            for (String value:values){
                String cardName = value + " " + suit;
                //card cardName = new card(suit,value);
                deckList.add(cardName);
            }
        }
        System.out.println(deckList);

    }

    public static void main(String args[]){
        //deck deck1 = new deck();
        List<String> deck = new ArrayList<>();
        Console cons = System.console();
        boolean stop = false;
        System.out.println("Welcome to your deck generator");
        System.out.println("Type 'help' for list of functions");
        while(!stop){
            String input = cons.readLine(">");
            Scanner inputScanner = new Scanner(input);
            String cmd = inputScanner.next();
            switch(cmd){
                case "stop":
                stop = true;
                break;

                case "draw":
                draw(deck);
                break;

                case "shuffle":
                shuffle(deck);
                break;

                case "new":
                deck = newDeck(suits,values,inputScanner);
                break;

                case "deck":
                showDeck(deck);
                break;

                case "help":
                help();
                break;

                default:
                System.out.println("Invalid command.");
            }
            inputScanner.close();

        }
        System.out.println("bye");
    }
    static void draw(List<String> deck){
        if(deck.size()>0){
            System.out.println(deck.get(0));
            deck.remove(0);
        }
        else{
            System.out.println("There is no deck. Create a new one.");
        }
        //return deck;

    }
    static void shuffle(List<String> deck){
        if(deck.size()>0){
            Collections.shuffle(deck);
            System.out.println(" Deck shuffled.");
        }
        else{
            System.out.println("There is no deck. Create a new one.");
        }
        //return deck;

    }

    static List<String> newDeck(String[] suits, String[] values,Scanner inputScanner){
        List<String> deckList = new ArrayList<String> ();
        for (String suit:suits){
        for (String value:values){
            String cardName = value + " " + suit;
                //card cardName = new card(suit,value);
                deckList.add(cardName);
            }
        }
        if(inputScanner.hasNext()){
            if(inputScanner.next()=="joker"){
                deckList.add("Joker");
                deckList.add("Joker");
            }
            else{
                System.out.println("Invalid card. Default deck created.");
            }
        }

        System.out.println("New deck created.");
        return deckList;


    }

    static void showDeck(List<String> deck){
        System.out.println(deck);
    }

    static void help(){
        System.out.println("new: creates a new deck");
        System.out.println("draw: draws a card and discards");
        System.out.println("shuffle: shuffles the deck");
        System.out.println("deck: shows the cards in the deck");

    }
}