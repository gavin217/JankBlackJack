import java.util.Scanner;

public class BasicGameApp {
    public Card[] deck;
    public boolean gameOn;
    public Player p1;
    public Dealer d1;


    public static void main(String[] args) {
BasicGameApp a= new BasicGameApp();
    }
    public BasicGameApp(){
        System.out.println("welcome to blackjack");
        p1= new Player();
        d1=new Dealer();
        deck=new Card[52];
        int cardIndex=0;
        for(int x=0;x<4;x++) {


            for (int i=0; i < 13; i++) {
                deck[cardIndex] = new Card(x, 10, i);
                cardIndex++;

            }
        }
        shuffleCards();
        printDeck();

        p1.hand[0]=deck[0];//give the player cards
        p1.hand[1]=deck[1];
        d1.hand[0]=deck[2];
        d1.hand[1]=deck[3];







        Scanner s = new Scanner(System.in);
        System.out.println("what is your name");
        String aName = s.nextLine();
        System.out.println(aName);
        p1.name=aName;
        p1.printInfo();
        p1.calculateTotal();

        System.out.println("hit or stay");
        String aDecision=s.nextLine();
        System.out.println(aDecision);
        if(aDecision.equals("hit")){
            int x=1;
            x=x+1;
            int y=3;
            y=y+1;
            Card[] helper = p1.hand;

            p1.hand=new Card[3];


            p1.hand[x]= deck[y];
            p1.calculateTotal();
            p1.printInfo();
        }
        else if(aDecision.equals("stand")){
            d1.calculateTotal();
            d1.printInfo();
        }








    }
    public void shuffleCards(){
        for(int a=0;a<deck.length;a++){
            int randy= (int)(Math.random()*52);
            Card helper=deck[randy];
            deck[randy]=deck[a];
            deck[a]=helper;
        }
    }
    public void printDeck(){
        for (int x=0;x<deck.length;x++){

            deck[x].printInfo();

        }
    }
}
