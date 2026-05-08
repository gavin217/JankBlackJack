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
        for (int x=0;x<13;x++){
            deck[x]=new Card("hearts",10,x);
            deck[x].printInfo();

        }
    }
}
