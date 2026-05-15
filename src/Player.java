public class Player {
    public int CardTotal;
    public boolean isBust;
    public Card[] hand;
    public boolean isHit;
    public String name;



    public Player(){
        CardTotal=0;
        isBust=false;
        hand=new Card[2];
        isHit=false;
    }
    public void printInfo(){
        System.out.println(CardTotal);
        System.out.println(isBust);
        System.out.println(isHit);
        for(int x=0;x>2;x++){
            System.out.println(hand[x]);
        }
    }
}
