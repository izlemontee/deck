package sdf;

public class card_old {

    private String suit;
    private String value;

    public card_old(String suit, String value){
        this.suit = suit;
        this.value = value;
    }

    public String getSuit(){
        return suit;
    }
    public void setSuit(String suit){
        this.suit = suit; //remember the this keyword applies to the ARG taken in, not the instance variable on top
    }
    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }
    
}
