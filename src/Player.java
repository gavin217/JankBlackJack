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
        name="me";
    }
    public void printInfo(){
        System.out.println(name);
        System.out.println(CardTotal);
        System.out.println(isBust);
        System.out.println(isHit);
        for(int x=0;x< 3;x++){
            hand[x].printInfo();
        }
    }
    public void calculateTotal(){
        int addValue=0;
        for(int x=0;x< hand.length;x++){
            addValue=addValue+hand[x].value;
        }
       CardTotal=addValue;
    }
}
