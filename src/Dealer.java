public class Dealer {
    public boolean isOver16;
    public int cardTotal;
    public boolean isBust;
    public Card[] hand;


    public Dealer(){
isOver16=false;
cardTotal=0;
isBust=false;
hand=new Card[6];


    }
    public void calculateTotal(){
        int addValue=0;
        for(int x=0;x< hand.length;x++){
            addValue=addValue+hand[x].value;
            cardTotal=addValue;
            if(cardTotal<17){//fix this so that it stops making cards at 17 but if goes over 21 its a bust
                isOver16=false;
            } else if (cardTotal>17) {
                isOver16=true;

            }
            if (cardTotal<=21){
                isBust=false;
            } else if (cardTotal>21) {
                isBust=true;
            }
            if (isBust==true){
                System.out.println("dealer loses");
            }

        }

    }
    public void printInfo(){
        System.out.println(cardTotal);
        System.out.println(isBust);
        System.out.println(isOver16);
        for(int x=0;x< hand.length;x++){
            hand[x].printInfo();
        }

    }

}
