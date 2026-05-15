public class Dealer {
    public boolean isOver16;
    public int cardTotal;
    public boolean isBust;
    public Card[] hand;

    public Dealer(){
isOver16=false;
cardTotal=0;
isBust=false;
hand=new Card[2];

    }
    public void printInfo(){
        System.out.println(cardTotal);
        System.out.println(isBust);
        System.out.println(isOver16);
        for(int x=0;x>2;x++){
            System.out.println(hand[x]);
        }
    }
}
