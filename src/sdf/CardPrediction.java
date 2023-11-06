package sdf;
import java.util.*;

public class CardPrediction {

    //private static final int[] values = {1,2,3,4,5,6,7,8,9,10};
    private static final int BLACKJACK = 21;
    private int oneCount = 0;
    private int twoCount = 0;
    private int threeCount = 0;
    private int fourCount = 0;
    private int fiveCount = 0;
    private int sixCount = 0;
    private int sevenCount = 0;
    private int eightCount = 0;
    private int nineCount = 0;
    private int tenCount = 0;
    //private int[] COUNT_LIST = {oneCount,twoCount,threeCount,fourCount,fiveCount,sixCount,sevenCount,eightCount,nineCount,tenCount};
    int lowerProb = 0;
    int higherProb = 0;
    int equalProb = 0;

    public CardPrediction(){
        int[] COUNT_LIST = {oneCount,twoCount,threeCount,fourCount,fiveCount,sixCount,sevenCount,eightCount,nineCount,tenCount};  
    }
    public void clear(){
        lowerProb = 0;
        higherProb = 0;
        equalProb = 0;
        oneCount = 0;
        twoCount = 0;
        threeCount = 0;
        fourCount = 0;
        fiveCount = 0;
        sixCount = 0;
        sevenCount = 0;
        eightCount = 0;
        nineCount = 0;
        tenCount = 0;
    }
    public void prediction(hand h, deck d){ 
        clear();
        List<card> deckList = d.getDeck();
        int handValue = h.getHandValue();
        int toWin = BLACKJACK - handValue; //check the difference to see how much is needed to win
        System.out.printf("%d needed to win.\n",toWin);
        for(card c:deckList){
            int cardValue = c.getValue();
            //System.out.printf(" Card value: %d",cardValue);
            switch(cardValue){
                    case 1:
                    oneCount++;
                    break;
                    case 2:
                    twoCount++;
                    break;
                    case 3:
                    threeCount++;
                    break;
                    case 4:
                    fourCount++;
                    break;
                    case 5:
                    fiveCount++;
                    break;
                    case 6:
                    sixCount++;
                    break;
                    case 7:
                    sevenCount++;
                    break;
                    case 8:
                    eightCount++;
                    break;
                    case 9:
                    nineCount++;
                    break;
                    case 10:
                    tenCount++;
                    break;
                    
                }
        
        }   
        int[] COUNT_LIST = {oneCount,twoCount,threeCount,fourCount,fiveCount,sixCount,sevenCount,eightCount,nineCount,tenCount};  
        for (int i = 0; i<COUNT_LIST.length;i++){ //iterate through the remaining deck and count the cards whose values have the same value
            System.out.printf("Count: %d\n",i);
                if((i+1) < toWin){ //if the value of i, e.g 1 2 3 is less than the value needed to win
                    lowerProb += COUNT_LIST[i];
                    System.out.printf("Lower, %d.\n",COUNT_LIST[i]);
                }
                else if ((i+1) == toWin){
                    equalProb += COUNT_LIST[i];
                    System.out.printf("Equal, %d.\n",COUNT_LIST[i]);
                }
                else if ((i+1) > toWin){
                    higherProb += COUNT_LIST[i];
                    System.out.printf("Higher, %d.\n",COUNT_LIST[i]);
                } 
            }
        
        System.out.printf("Onecount: %d\n",oneCount);//it works, it displayed a number
        System.out.printf("twocount: %d\n",twoCount);//it works, it displayed a number
        System.out.printf("threecount: %d\n",threeCount);//it works, it displayed a number
        System.out.printf("fourcount: %d\n",fourCount);//it works, it displayed a number
        System.out.printf("fivecount: %d\n",fiveCount);//it works, it displayed a number
        System.out.printf("sixcount: %d\n",sixCount);//it works, it displayed a number
        System.out.printf("sevencount: %d\n",sevenCount);//it works, it displayed a number
        System.out.printf("eightcount: %d\n",eightCount);//it works, it displayed a number
        System.out.printf("ninecount: %d\n",nineCount);//it works, it displayed a number
        System.out.printf("tencount: %d\n",tenCount);//it works, it displayed a number
        int cardCount = deckList.size();
        System.out.printf("Remaining cards: %d\n",cardCount);
        System.out.printf("Lower prob count: %d\n",lowerProb);
        System.out.printf("Higher prob count: %d\n",higherProb);
        System.out.printf("Equal prob count: %d\n",equalProb);

        lowerProb = lowerProb*100/cardCount;
        higherProb = higherProb*100/cardCount;
        equalProb = equalProb*100/cardCount;
        System.out.printf("Lower chance: %d\n Higher chance: %d\nChance to hit 21: %d\n", lowerProb, higherProb, equalProb);
	//from here, to predict the next word, just take the word with the highest count and predict the next word for that, maybe do that x number of times depending on user
    }


}
    

