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
}
