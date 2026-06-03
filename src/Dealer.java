public class Dealer {
    public boolean isOver16;
    public int cardTotal;
    public boolean isBust;
    public Card[] hand;
    public Card[] dHelper;
    public int round;


    public Dealer(){
isOver16=false;
cardTotal=0;
round=2;
isBust=false;
hand=new Card[2];


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


        }

    }
    public void printInfo(){
        System.out.println("dealer's turn");
        System.out.println(cardTotal);
        for(int x=0;x< hand.length;x++){
            hand[x].printInfo();
        }
        if (isBust==true){
            System.out.println("dealer loses");
        }

    }
    public void dHit(){
        round=round+1;
    dHelper=hand;
    hand=new Card[round];
        for(int x=0;x< dHelper.length;x++){
            hand[x]=dHelper[x];
        }
    }
    public void dStand(){
        if(isBust==true){
            System.out.println("you win");
        }
    }

}
