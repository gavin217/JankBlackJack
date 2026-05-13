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
