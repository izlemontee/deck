package sdf;

public class card {
    private String suit;
    private String name;
    private String CardName;
    private int value;

    public card(String suit,String name, int value){ //constructor for a new card, taking in the suit, name, and value
        this.suit = suit;
        this.name = name;
        this.value = value;
        this.CardName = name + " " + suit;
    }

    public card(String name){
        this.name = name;
        this.CardName = name;
    }

    public String getSuit(){ //gets the suit name
        return suit;
    }

    public String getName(){ //gets the name
        return name;
    }
    public int getValue(){ //gets the value
        return value;
    }
    public String getCardName(){ //gets the card name
        return CardName;
    }

}
